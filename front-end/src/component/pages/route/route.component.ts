import {Component, OnInit} from '@angular/core';
import {PageComponent} from "../../page.component";

@Component({
  selector: 'app-route',
  templateUrl: './route.component.html',
  styleUrls: ['./route.component.css']
})
export class RouteComponent extends PageComponent {

  constructor() {
    super()
  }
}
