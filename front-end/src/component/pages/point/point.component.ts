import {Component, ViewEncapsulation} from '@angular/core';
import {PageComponent} from "../../page.component";
import {PointDataSource} from "../../../service/point-service/point-data-source";
import {PointEntity} from "../../../model/point/poit-entity";
import {DataSource} from "@angular/cdk/collections";
import 'rxjs/add/observable/of';

@Component({
  selector: 'app-point',
  templateUrl: './point.component.html',
  styleUrls: ['./point.component.css'],
  encapsulation: ViewEncapsulation.Emulated,
  preserveWhitespaces: true,
  providers: [PointDataSource]

})
export class PointComponent extends PageComponent {

  displayedColumns = ['name'];

  dataSource: DataSource<PointEntity>;

  constructor(private readonly pointDataSource: PointDataSource) {
    super()
    this.dataSource = pointDataSource;
  }

  ngOnInit() {
    this.pointDataSource.refresh();
  }
}