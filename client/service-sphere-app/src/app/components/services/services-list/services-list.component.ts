import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-services-list',
  templateUrl: './services-list.component.html',
  styleUrls: ['./services-list.component.css']
})
export class ServicesListComponent {
  @Input() services: string[] = ['Lawn Mowing', 'House Cleaning', 'Laundry Cleaning','Painting'];

  public constructor(private router : Router){
    
  }
  protected goToService(category: string): void {
    this.router.navigateByUrl('service/category',{state: {category}});
  }
}
