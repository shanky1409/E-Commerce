import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:any;
  password:any;
  message:string;
  constructor(private authService:AuthService, private router:Router) {
   }

  ngOnInit(): void {
    if(localStorage.getItem('email')){
      this.router.navigate(['/']);
    }
  }

  login(){
    
    this.authService.login({'email': this.username, 'password':this.password}).subscribe(
      (data:any)=>{
        if(data === true){
          localStorage.setItem('email',this.username);
          this.router.navigate(['']);
        }
        else
        this.message='Invalid username or password!!';
    },(error:any)=>{
        this.message='Invalid username or password!!';
        console.log(error);
    });
  }
  onReset(){
    this.username='';
    this.password='';
    this.message='';
  }


}
