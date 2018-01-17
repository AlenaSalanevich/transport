import {Component, ViewEncapsulation} from '@angular/core';
import {PageComponent} from "../../page.component";
import {PointDataSource} from "../../../service/point-service/point-data-source";
import {PointEntity} from "../../../model/point/poit-entity";
import 'rxjs/add/observable/of';
import {Router} from "@angular/router";
import {PointService} from "../../../service/point-service/point.service";

@Component({
  selector: 'app-point',
  templateUrl: './point.component.html',
  styleUrls: ['./point.component.css'],
  encapsulation: ViewEncapsulation.Emulated,
  preserveWhitespaces: true,
  providers: [PointDataSource]

})
export class PointComponent extends PageComponent {

  points: PointEntity[];

  constructor(private readonly pointService: PointService,
              private readonly router: Router) {
    super()
    this.loadPoints();
  }

  ngOnInit() {
    this.loadPoints();
  }

  public loadPoints(): void {
    this.pointService.loadPoints()
      .then(value => this.points = value)
  }

}
