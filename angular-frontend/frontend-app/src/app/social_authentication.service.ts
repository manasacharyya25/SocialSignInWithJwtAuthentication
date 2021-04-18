import { Injectable } from "@angular/core";
import { GoogleLoginProvider, SocialAuthService } from "angularx-social-login";
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class SocialAuthenticationService {

    constructor(private authService: SocialAuthService,
        private router: Router,
        private httpClient: HttpClient) {
        this.authService.authState.subscribe((response) => {
            console.log(response);
            if (response != null) {
                if (response.provider === 'GOOGLE') {
                    this.handleGoogleLogin(response);
                }
            }
        })
    }

    googleSignIn(): void {
        this.authService.signIn(GoogleLoginProvider.PROVIDER_ID);
    }

    async handleGoogleLogin(response) {
        var username = response.name;
        var email = response.email;
        var photoUrl = response.photoUrl;

        localStorage.setItem("isLoggedIn", "true");

        localStorage.setItem("user_name", username);
        localStorage.setItem("email", email);
        localStorage.setItem("photo_url", photoUrl);

        await this.httpClient.post(
            "http://localhost:8080/users/signup",
            { username: username, email: email, password: response.idToken, photoUrl: photoUrl }
        ).toPromise().then(authResponse => {
            this.handleAuthResponse(authResponse);
        });

        this.router.navigate(['/profile']);
    }

    handleAuthResponse(authResponse): void {
        var userId = authResponse.userid;
        var jwtToken = authResponse.jwtToken;

        localStorage.setItem("user_id", userId);
        localStorage.setItem("jwtToken", jwtToken);
    }

    signOut(): void {
        this.authService.signOut();
    }
}