import {Component, ViewEncapsulation} from '@angular/core';
import {PageComponent} from "../../page.component";
import {PointDataSource} from "../../../service/point-service/point-data-source";
import {PointEntity} from "../../../model/point/poit-entity";
import 'rxjs/add/observable/of';
import {Router} from "@angular/router";
import {PointService} from "../../../service/point-service/point.service";
import {RouteList} from "../../../utils/route-list";
import {TransportService} from "../../../service/transport-service/transport.service";

@Component({
  selector: 'app-point',
  templateUrl: './point.component.html',
  styleUrls: ['./point.component.css'],
  encapsulation: ViewEncapsulation.Emulated,
  preserveWhitespaces: true,
  providers: [PointDataSource]

})
export class PointComponent extends PageComponent {

  private _deleteSelectedPoint: PointEntity;

  private _editSelectedPoint: PointEntity;

  private _pointInfo: PointEntity;

  private _error: string;

  private _length: number;

  private _points: PointEntity[];

  private _likeChars: string;

  constructor(private readonly pointService: PointService,
              private readonly router: Router) {
    super()
    this.tryLoadPoints();
  }

  ngOnInit() {
    this.tryLoadPoints();
    this._likeChars = '';
  }

  public tryLoadPoints(): void {
    console.log(this.likeChars);
    this.setLikeChars();
    this.pointService.loadPoints(this.likeChars)
      .then(value => this._points = value);
    this.likeChars = '';
  }


  tryDeletePoint() {
    this.pointService.deletePoint(this._pointInfo, (message, result) => {
      if (result) {
        this.pointService.loadPoints(this.likeChars);
        this.ngOnInit();
      }
      else {
        this._error = message;
      }
      this.tryLoadPoints();
    })
  }

  public tryUpdatePoint() {

    this.pointService.updatePoint(this._pointInfo, (message, result) => {
        if (result) {
          this.likeChars = '';
          this.pointService.loadPoints(this.likeChars);
          this.redirectToPoints();
        }
        else {
          this._error = message;
        }
        this.likeChars = '';
        this.pointService.loadPoints(this.likeChars);
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


  get likeChars(): string {
    return this._likeChars;
  }


  set likeChars(value: string) {
    this._likeChars = value;
  }

  setLikeChars() {
    switch (this._likeChars) {
      case '': {
        break;
      }
      default: {
        this._likeChars = '?likeChars=' + this._likeChars;
        break;
      }
    }
  }


  get length(): number {
    return this._length;
  }

  private

  setLength() {
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
