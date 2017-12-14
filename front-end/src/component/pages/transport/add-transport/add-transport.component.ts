import {Component, OnInit} from '@angular/core';
import {TransportDataSource} from "../../../../service/transport-service/transport-data-source";
import {TransportService} from "../../../../service/transport-service/transport.service";
import {PageComponent} from "../../../page.component";
import {TransportParams} from "../../../../model/transport/transport-params";
import {Router} from "@angular/router";
import {RouteList} from "../../../../utils/route-list";

@Component({
  selector: 'app-add-transport',
  templateUrl: './add-transport.component.html',
  styleUrls: ['./add-transport.component.css'],
  providers: [TransportDataSource, TransportService]
})
export class AddTransportComponent extends PageComponent {

  private _transportInfo: TransportParams;

  private _error: string;

  constructor(private readonly transportService: TransportService, private readonly transportDataSource: TransportDataSource, private readonly router: Router) {
    super()
    this._transportInfo = new TransportParams('', '', false);
    this._error = '';
  }

  tryCreateTransport() {
    this.transportService.createTransport(this._transportInfo, (message, result) => {
        if (result) {
          let transportInfo = this.transportInfo;
          transportInfo.registrationNumber = '';
          transportInfo.transportType = '';
          transportInfo.noFunctionally = true;
          this.redirectToTransports();
          this.transportDataSource.refresh();
        }
        else {
          this._error = message;
        }
      }
    )
  }

  ngOnInit() {
  }

  public redirectToTransports() {
    this.router.navigateByUrl('/' + RouteList.PAGE_TRANSPORT)
  }

  get transportInfo(): TransportParams {
    return this._transportInfo;
  }

  get error(): string {
    return this._error;
  }
}
