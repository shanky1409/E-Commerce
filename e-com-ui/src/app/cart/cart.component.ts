import { Component, OnInit } from '@angular/core';
import {ProductsService} from '../common/products.service';
import { Product } from '../common/types';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  email: string='';
  products:any;
  isEmpty:boolean=true;
  cartSum=0;
  constructor(private productsService: ProductsService) { 
    this.email=localStorage.getItem('email');
    console.log('email: '+ this.email);
    this.productsService.getCart(this.email).subscribe(
      (data)=>{
        this.products=data;
        if(this.products.length>0){
          this.isEmpty=false;
          this.getCartSum();
        }
    });
  }

  ngOnInit(): void {
    console.log(this.products);
  }
  emptyCart(){
    this.productsService.emptyCart(this.email).subscribe(
      (data)=>{
        console.log('Items removed from cart');
        this.isEmpty=true;
      },
      (error)=>{

      });
  }
  getCartSum(){
    //let products=this.products as Product[];
    console.log(this.products[0].price)

    for(let product of this.products){
      this.cartSum+=product.price;
    }
    this.cartSum=Math.round((this.cartSum+Number.EPSILON)*100)/100;
  }

  

}
