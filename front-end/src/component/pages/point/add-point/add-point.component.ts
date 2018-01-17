import {Component} from '@angular/core';
import {PageComponent} from "../../../page.component";
import {PointParams} from "../../../../model/point/point-params";
import {PointService} from "../../../../service/point-service/point.service";
import {PointDataSource} from "../../../../service/point-service/point-data-source";
import {Router} from "@angular/router";
import {RouteList} from "../../../../utils/route-list";
import {PointComponent} from "../point.component";

@Component({
  selector: 'app-add-point',
  templateUrl: './add-point.component.html',
  styleUrls: ['./add-point.component.css'],
  providers: [PointDataSource, PointService]
})
export class AddPointComponent extends PageComponent {

   private _pointInfo: PointParams;

  private _error: string;

  constructor(private readonly pointService: PointService,
              private readonly router: Router, private readonly pointComponent: PointComponent) {
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
        this.pointService.loadPoints();
        this.redirectToPoints();
        this.pointService.loadPoints();
      }
      else {
        this._error = message;
      }
      this.pointService.loadPoints();
    })
  }

  redirectToPoints() {
        this.router.navigateByUrl('/' + RouteList.PAGE_POINT);
    this.pointComponent.ngOnInit();

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
