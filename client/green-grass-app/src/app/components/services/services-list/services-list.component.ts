import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-services-list',
  templateUrl: './services-list.component.html',
  styleUrls: ['./services-list.component.css']
})
export class ServicesListComponent {
  @Input() services: string[] = ['Landscaping', 'Plumbing', 'Household', 'Painting'];


}
