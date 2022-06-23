import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerComponent } from './accounts/customer/customer.component';
import { LoginComponent } from './accounts/login/login.component';
import { SignupComponent } from './accounts/signup/signup.component';
import { AuthGuard } from './auth.guard';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  
  {
    path:'login',
    component: LoginComponent,
    children: [
      {path:'customer',component:CustomerComponent}
    ]
  },
  {
    path: 'signup',
    component: SignupComponent,
    children: [
      {path:'customer',component:CustomerComponent}
    ]
  },
  {
    path:'cart',
    component: CartComponent,
    canActivate:[AuthGuard]
  },
  {
    path: '',
    component: HomeComponent,
    canActivate:[AuthGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


 }
