import {Component, OnInit} from '@angular/core';
import {PageComponent} from "../../../page.component";
import {PointParams} from "../../../../model/point/point-params";
import {PointService} from "../../../../service/point-service/point.service";
import {PointDataSource} from "../../../../service/point-service/point-data-source";
import {Router} from "@angular/router";
import {RouteList} from "../../../../utils/route-list";

@Component({
  selector: 'app-add-point',
  templateUrl: './add-point.component.html',
  styleUrls: ['./add-point.component.css'],
  providers: [PointDataSource, PointService]
})
export class AddPointComponent extends PageComponent {

  private _pointInfo: PointParams;

  private _error: string;

  transportType = [
    {value: 'BUS', viewValue: 'Bus'},
    {value: 'TRAM', viewValue: 'Tram'},
    {value: 'TROLLEYBUS', viewValue: 'Trolleybus'}
  ];


  constructor(private readonly pointService: PointService,
              private readonly dataSource: PointDataSource,
              private readonly router: Router) {
    super()
    this._pointInfo = new PointParams('');
    this._error = '';
  }

  tryCreatePoint() {
    this.pointService.createPoint(this._pointInfo, (message, result) => {
      if (result) {
        let pointInfo = this.pointInfo;
        pointInfo.name = '';
        this._error = '';
        this.dataSource.refresh();
        this.redirectToPoints();
      }
      else {
        this._error = message;
      }
    })
  }

  redirectToPoints() {
    this.router.navigateByUrl('/' + RouteList.PAGE_POINT);
    this.dataSource.refresh()
  }

  get pointInfo(): PointParams {
    return this._pointInfo;
  }

  get error(): string {
    return this._error;
  }

  set pointInfo(value: PointParams) {
    this._pointInfo = value;
  }

  set error(value: string) {
    this._error = value;
  }

}
