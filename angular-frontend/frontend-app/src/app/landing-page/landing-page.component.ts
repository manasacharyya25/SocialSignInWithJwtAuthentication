import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  GoogleLogin(): void {
    window.alert("Login with Google");
  }

  FbLogin(): void {
    window.alert("Login with Facebook");
  }

}
