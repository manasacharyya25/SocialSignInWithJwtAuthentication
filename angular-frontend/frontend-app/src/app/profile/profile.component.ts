import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SocialAuthenticationService } from '../social_authentication.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  username: String;
  email: String;
  photoUrl: String;

  constructor(private router: Router,
    private authService: SocialAuthenticationService) { }

  ngOnInit(): void {
    this.username = localStorage.getItem("user_name");
    this.email = localStorage.getItem("email");
    this.photoUrl = localStorage.getItem("photo_url");
  }

  logout(): void {
    localStorage.setItem("isLoggedIn", "false");
    localStorage.removeItem("user_name");
    localStorage.removeItem("email");
    localStorage.removeItem("photo_url");

    console.log("Logging Out");
    this.authService.signOut();
    this.router.navigate(['/']);
  }

}
