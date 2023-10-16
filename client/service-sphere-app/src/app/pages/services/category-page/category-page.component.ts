import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.css']
})
export class CategoryPageComponent implements OnInit {

  protected category: string = '';
  constructor(private router: Router) {
  }

  ngOnInit() {
    this.category = history.state['category'] || '';
  }
}
