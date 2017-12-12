import {Injectable} from "@angular/core";
import {PointEntity} from "../../model/point/poit-entity";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {PointService} from "./point.service";
import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {Observable} from "rxjs/Observable";


@Injectable()
export class PointDataSource extends DataSource<PointEntity> {

  private points: BehaviorSubject<PointEntity[]>;

  constructor(private readonly pointService: PointService) {
    super();
    let emptyArray: PointEntity[] = [];
    this.points = new BehaviorSubject(emptyArray);
  }

  ngOnInit() {
  }

  public refresh(){ this.pointService.loadPoints().then(value => {
    this.points.next(value);
  })
  }
  connect(): Observable<PointEntity[]> {
    return this.points;
  }

  disconnect(collectionViewer: CollectionViewer): void {
  }
}
