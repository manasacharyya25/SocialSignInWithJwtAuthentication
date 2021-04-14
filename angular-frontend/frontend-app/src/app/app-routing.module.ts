import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LandingPageComponent } from './landing-page/landing-page.component'
import { ProfileComponent } from './profile/profile.component';
import { AuthenticationGuard } from './authenticationGuard';


const routes: Routes = [
  {
    path: '',
    component: LandingPageComponent,
    pathMatch: 'full',
  },
  {
    path: 'profile',
    component: ProfileComponent,
    pathMatch: 'full',
    canActivate: [AuthenticationGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
