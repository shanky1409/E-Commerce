import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { PageInformation } from '../common/types';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  @Input() pageInfo:PageInformation;

  @Output() nextPageEvent = new EventEmitter<string>();
  @Output() prevPageEvent = new EventEmitter<string>();
  constructor() {

    console.log("Page info is");
    
   };

  ngOnInit(): void {
    console.log(this.pageInfo);
  }
  getNextPage(){
    console.log('Getting next page');
    this.nextPageEvent.emit();
  }
  getPreviousPage(){
    console.log('Getting previous page');
    this.prevPageEvent.emit();
  }

}
