import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  jwtToken: String;

  constructor(private router: Router,
    private authService: SocialAuthenticationService,
    private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.username = localStorage.getItem("user_name");
    this.email = localStorage.getItem("email");
    this.photoUrl = localStorage.getItem("photo_url");
    this.jwtToken = localStorage.getItem("jwtToken");
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

  accessSecureResource(): void {

    var httpHeader = new HttpHeaders({
      "Content-Type": "text/plain; charset=utf-8",
      "Authorization": "Bearer " + localStorage.getItem("jwtToken")
    });

    this.httpClient.get("http://localhost:8080/secureresource", { headers: httpHeader, responseType: 'text' })
      .subscribe(response => { window.alert(response) })
  }

}
