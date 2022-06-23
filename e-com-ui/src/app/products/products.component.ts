import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { ProductsService } from '../common/products.service';
import { PageInformation, Product } from '../common/types';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products:Product[]=[];
  pageInfo:PageInformation;
  @Output() pageInfoEmitter = new EventEmitter<PageInformation>();
  page=0;
  records=2;
  category:string='';
  productName='';
  email='';
  constructor(private productsService:ProductsService) { 
    this.email= localStorage.getItem('email');
  }

  ngOnInit(): void {
    this.loadInitialData();
  }
  loadInitialData(){

    console.log('loading products');
    let observable=this.productsService.getProductsByQuery(this.page,this.records,this.category,this.productName);
    this.load(observable);
  }

  load(observable:any){
    observable.subscribe(
      (data:any)=>{
        this.products=[];
        this.products=data['products'];
        this.pageInfo=data['pageDetails'];
        console.log(this.products);
      },
      (error:any)=>{
        console.log(error);
      },()=>{
        this.checkData();
        this.pageInfoEmitter.emit(this.pageInfo);
      });
  }
  checkData(){
    console.log(this.pageInfo);
  }

  getNextPage(){
    let observable=this.productsService.getProductsByQuery(this.pageInfo.currentPage,this.records,this.category, this.productName);
    this.load(observable);
  }

  getPrevPage(){
    let observable=this.productsService.getProductsByQuery(this.pageInfo.currentPage-2,this.records,this.category,this.productName);
    this.load(observable);
  }

  search(category:string){
    this.productName='';
    console.log('search called');
    this.category=category;
    let observable=this.productsService.getProductsByQuery(this.page, this.records,category);
    this.load(observable);
  }

  searchProduct(){
    console.log('Search product called');
    if(!this.productName)
    {
      this.loadInitialData();
      return;
    }
    console.log('this.productName: '+this.productName)
    let observable= this.productsService.getProductsByQuery(this.page, this.records,this.category,this.productName);
    this.load(observable);
    //this.productName='';
  }

  addToCart(product:Product){
    console.log('product');
    console.log(product);
    this.productsService.addToCart(product.id,this.email).subscribe(
      (data)=>{
        console.log('Product added successfully');
    },(error)=>{
        console.log(error);
    });
  }


}
