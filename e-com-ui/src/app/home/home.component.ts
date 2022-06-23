import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { PageInformation } from '../common/types';
import { ProductsComponent } from '../products/products.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  pageInfo:PageInformation;
  constructor() { }
  @ViewChild(ProductsComponent) productsCmp:ProductsComponent;
  ngOnInit(): void {
  }

  getPageInfo($event:PageInformation){
    console.log("in home");
    this.pageInfo=$event;
    console.log($event);
  }
  search($event:string){
    this.productsCmp.search($event);
  }

  
 

}
