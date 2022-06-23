import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private httpClient:HttpClient) { }

  getProducts(page:number=0, records:number=4){
    return this.httpClient.get(environment.productService+'get-by-page?page='+page+'&records='+records);
  }

  getProductsByCategory(page:number=0, records:number=4,category:string=''){
    return this.httpClient.get(environment.productService+'get-by-category?page='+page+'&records='+records+'&category='+category);
  }

  searchProduct(page:number=0, records:number=4,productName:string=''){
    return this.httpClient.get(environment.productService+'search?page='+page+'&records='+records+'&keyword='+productName);
  }

  getProductsByQuery(page:number=0, records:number=4,category:string='',keyword=''){
    return this.httpClient.get(environment.productService+'search-all?page='+page+'&records='+records+'&category='+category+'&keyword='+keyword);
  }
  addToCart(productId:string,email:string){
    return this.httpClient.post(environment.cartService,{productId:productId,email:email});
  }
  getCart(email:string){
    return this.httpClient.post(environment.cartService+'get',email);
  }

  emptyCart(email:string){
    return this.httpClient.post(environment.cartService+'empty-cart',email);
  }
}