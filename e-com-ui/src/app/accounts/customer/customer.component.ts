import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address, Customer } from 'src/app/common/types';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  @Input() email:string;
  firstname:string;
  lastname:string;
  phoneNumber:string;

  addressLine1 = '';
  addressLine2 = '';
  city = '';
  state = '';
  zipCode = '';

  constructor(private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  onFormReset(){}

  customerForm(){
    let address = new Address();
    address.addressLine1=this.addressLine1;
    address.addressLine2=this.addressLine2;
    address.city=this.city;
    address.state=this.state;
    address.zipCode=this.zipCode;

    let customer = new Customer();
    customer.firstName=this.firstname;
    customer.lastName=this.lastname;
    customer.phoneNumber= this.phoneNumber;
    customer.address=address;
    customer.email = this.email;

    this.authService.submitCustomer(customer).subscribe(
      (data:any)=>{
        console.log(data);
        if(data){
          //console.log(data['email']);
          localStorage.setItem('email',data['email']);
          this.router.navigate(['/']);
        }
    },
    (error)=>{
      console.log(error);
    });

  }

}
