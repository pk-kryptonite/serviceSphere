import { Component } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Service } from 'src/app/model/service/service';
import { ServicePage } from 'src/app/model/service/service-page';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent {

  protected servicePage$: Observable<ServicePage> = new Observable();

  constructor() {
    let page: ServicePage = {
      first: true,
      last: true,
      number: 0,
      totalPages: 4,
      sizes: 3,
      empty: false,
      totalElements: 4,
      numberOfElements: 5,
      content: ['hello', 'hello'] as Service[]
    } as ServicePage;
    this.servicePage$ = new Observable(ob => { ob.next(page) });
  }

  protected arrayRange(current: number = 0, max: number): number[] {
    const result = [];
    let maxEvenPages = current - (current % 2 === 0 ? 6 : 5);
    maxEvenPages = Math.max(maxEvenPages, 0);
    for (let i = maxEvenPages; i < max; i += 1) {
      result.push(i + 1);
      if (result.length === 5) break;
    }

    return result;
  }
  protected goToPage(page: number): void {

  }
}
