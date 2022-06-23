import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-topnav',
  templateUrl: './topnav.component.html',
  styleUrls: ['./topnav.component.css']
})
export class TopnavComponent implements OnInit {

  category:string;

  @Output() searchEventEmitter = new EventEmitter<string>();
  constructor(private router:Router) { }
  
  ngOnInit(): void {
  }

  logout(){
    localStorage.removeItem('email');
    this.router.navigate(['/login']);
  }

  search(category:string){
    console.log('search called');
    this.category=category;
    this.searchEventEmitter.emit(category);
    
  }

}
