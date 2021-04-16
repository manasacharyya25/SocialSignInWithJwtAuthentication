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

    handleGoogleLogin(response) {
        var username = response.name;
        var email = response.email;
        var photoUrl = response.photoUrl;

        localStorage.setItem("isLoggedIn", "true");

        localStorage.setItem("user_name", username);
        localStorage.setItem("email", email);
        localStorage.setItem("photo_url", photoUrl);

        this.httpClient.post(
            "http://localhost:8080/users/signup",
            { username: username, email: email, photoUrl: photoUrl }
        ).subscribe(response => localStorage.setItem("user_id", response.toString()))

        this.router.navigate(['/profile']);
    }

    signOut(): void {
        this.authService.signOut();
    }
}