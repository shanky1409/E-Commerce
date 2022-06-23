import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from 'src/app/common/types';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient:HttpClient) { }

  checkEmail(username:string){
    console.log('check mail auth service called');
    let observable = this.httpClient.post(environment.customerLoginBaseUrl+'verify', {'username': username});
    return observable;
  }

  login(creds:any){
    console.log('login function called');
    let observable = this.httpClient.post(environment.customerLoginBaseUrl+'login', creds);
    return observable;
  }

  signup(creds:any){
    console.log(creds);
    let observable = this.httpClient.post(environment.customerLoginBaseUrl+'signup', creds);
    return observable;
  }

  submitCustomer(customer:Customer){
    return this.httpClient.post(environment.customerBaseUrl,customer);
  }

}
