import {Component, ViewEncapsulation} from '@angular/core';
import {PageComponent} from "../../page.component";
import {TransportDataSource} from "../../../service/transport-service/transport-data-source";
import {TransportEntity} from "../../../model/transport/transport-entity";
import {DataSource} from "@angular/cdk/collections";

@Component({
  selector: 'app-transport',
  templateUrl: './transport.component.html',
  styleUrls: ['./transport.component.css'],
  encapsulation: ViewEncapsulation.Emulated,
  preserveWhitespaces: true,
  providers: [TransportDataSource]

})
export class TransportComponent extends PageComponent {

  displayedColumns = ['registrationNumber', 'transportType'/*, 'noFunctionally'*/];

  dataSource: DataSource<TransportEntity>;

  constructor(private readonly transportDataSource: TransportDataSource) {
    super()
    this.dataSource = this.transportDataSource;
  }

  ngOnInit() {
    this.transportDataSource.refresh();
  }

}
