import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  @Input() menuState: boolean = false;
  @Output() menuClosed: EventEmitter<boolean> = new EventEmitter();

  closeMenu(): void {
    this.menuState = false;
    this.menuClosed.emit(this.menuState);
  }

}
