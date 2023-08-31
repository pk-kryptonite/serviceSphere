import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {
  menuState: boolean = false;

  protected showMenu(bool: boolean = true){
    this.menuState = bool;
  }
}
