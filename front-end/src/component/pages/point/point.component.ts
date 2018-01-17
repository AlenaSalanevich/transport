import {Component, ViewEncapsulation} from '@angular/core';
import {PageComponent} from "../../page.component";
import {PointDataSource} from "../../../service/point-service/point-data-source";
import {PointEntity} from "../../../model/point/poit-entity";
import 'rxjs/add/observable/of';
import {Router} from "@angular/router";
import {PointService} from "../../../service/point-service/point.service";
import {PointParams} from "../../../model/point/point-params";
import {TransportEntity} from "../../../model/transport/transport-entity";
import {RouteList} from "../../../utils/route-list";

@Component({
  selector: 'app-point',
  templateUrl: './point.component.html',
  styleUrls: ['./point.component.css'],
  encapsulation: ViewEncapsulation.Emulated,
  preserveWhitespaces: true,
  providers: [PointDataSource]

})
export class PointComponent extends PageComponent {

 private  _deleteSelectedPoint: PointEntity;

 private _editSelectedPoint: PointEntity;

  private _pointInfo: PointEntity;

  private _error: string;

  private  _length: number;

  private _points: PointEntity[];

  constructor(private readonly pointService: PointService,
              private readonly router: Router) {
    super()
    this.loadPoints();
    this.setLength();
  }

  ngOnInit() {
    this.loadPoints();
    this.setLength();

  }

  public loadPoints(): void {
    this.pointService.loadPoints()
      .then(value => this._points = value)
  }


  tryDeletePoint() {
    this.pointService.deletePoint(this._pointInfo, (message, result) => {
      if (result) {
        this.pointService.loadPoints();
        this.ngOnInit();
      }
      else {
        this._error = message;
      }
      this.loadPoints();
    })
  }

  public tryUpdatePoint() {
        this.pointService.updatePoint(this._pointInfo, (message, result) => {
        if (result) {
          this.pointService.loadPoints();
          this.redirectToPoints();
        }
        else {
          this._error = message;
        }
        this.pointService.loadPoints();
      }
    )
  }

  public redirectToPoints() {
    this.router.navigateByUrl('/' + RouteList.PAGE_POINT);
    this.ngOnInit();
  }

  public onEditSelect(point: PointEntity): void {
    this._editSelectedPoint = point;
    this._pointInfo = this._editSelectedPoint;
    this._error = '';
  }

  public onDeleteSelect(point: PointEntity): void {
    this._deleteSelectedPoint = point;
    this._pointInfo = this._deleteSelectedPoint;
    this._error = '';
  }


  get length(): number {
    return this._length;
  }

  private setLength() {
   this._length=30;
  }

  get deleteSelectedPoint(): PointEntity {
    return this._deleteSelectedPoint;
  }

  set deleteSelectedPoint(value: PointEntity) {
    this._deleteSelectedPoint = value;
  }

  get editSelectedPoint(): PointEntity {
    return this._editSelectedPoint;
  }

  set editSelectedPoint(value: PointEntity) {
    this._editSelectedPoint = value;
  }

  get pointInfo(): PointEntity {
    return this._pointInfo;
  }

  set pointInfo(value: PointEntity) {
    this._pointInfo = value;
  }

  get error(): string {
    return this._error;
  }

  set error(value: string) {
    this._error = value;
  }

  get points(): PointEntity[] {
    return this._points;
  }

  set points(value: PointEntity[]) {
    this._points = value;
  }
}
