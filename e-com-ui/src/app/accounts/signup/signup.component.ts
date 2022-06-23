import { Component, OnInit } from '@angular/core';
import { Address, Customer } from 'src/app/common/types';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  email:string;
  password:string;
  firstname:string;
  lastname:string;
  phone:string;
  message:string;
  isValidUsername:boolean = false;
  customer:Customer;

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
  }

  signup(){
    this.authService.signup({'email': this.email, 'password':this.password}).subscribe(
      (data:any)=>{
        if(!data)
        {
          this.message= 'Username already exist';
        }else{
          this.isValidUsername= true;
          console.log('Data added to DB successfully: '+data['email']);
          this.email = data['email'];
        }
      },
      (error:any)=>{
        this.message='error!!';
        this.isValidUsername= true;
      },()=>{

      });
  }
  customerForm(){
    // this.email
    // this.firstname
    // this.lastname
    // this.phone
  }
  onReset(){
    this.email='';
    this.password='';
  }

  onFormReset(){
    this.firstname='';
    this.lastname='';
    this.phone='';

  }

}
