import { Component, OnInit } from '@angular/core';
import { SocialAuthenticationService } from '../social_authentication.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor(private authService: SocialAuthenticationService) { }

  ngOnInit(): void {
  }



  GoogleLogin(): void {
    this.authService.googleSignIn();
  }

  FbLogin(): void {
    //this.authService.signIn(FacebookLoginProvider.PROVIDER_ID);
  }



}
