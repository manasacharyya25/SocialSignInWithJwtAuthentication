import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { SocialAuthService } from "angularx-social-login";
import { GoogleLoginProvider, FacebookLoginProvider } from "angularx-social-login";


@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor(private authService: SocialAuthService, private router: Router) { }

  ngOnInit(): void {
    this.authService.authState.subscribe(response => {
      if (response != null) {
        if (response.provider === 'GOOGLE') {
          this.handleGoogleLogin(response);
        }
      }
    })
  }

  handleGoogleLogin(response) {
    localStorage.setItem("isLoggedIn", "true");

    localStorage.setItem("user_name", response.name);
    localStorage.setItem("email", response.email);
    localStorage.setItem("photo_url", response.photoUrl);

    this.router.navigate(['/profile']);
  }

  GoogleLogin(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID);
  }

  FbLogin(): void {
    //this.authService.signIn(FacebookLoginProvider.PROVIDER_ID);
  }

  signOut(): void {
    this.authService.signOut();
  }

}
