import {Component} from '@angular/core';
import {TransportDataSource} from "../../../../service/transport-service/transport-data-source";
import {TransportService} from "../../../../service/transport-service/transport.service";
import {PageComponent} from "../../../page.component";
import {TransportParams} from "../../../../model/transport/transport-params";
import {Router} from "@angular/router";
import {RouteList} from "../../../../utils/route-list";
import {FormControl, Validators} from "@angular/forms";
import {TransportComponent} from "../transport.component";

@Component({
  selector: 'app-add-transport',
  templateUrl: './add-transport.component.html',
  styleUrls: ['./add-transport.component.css'],
  providers: [TransportDataSource, TransportService]
})
export class AddTransportComponent extends PageComponent {

  private _transportInfo: TransportParams;

  private _error: string;

  private _selectedTransportType: string;
  private _selectedTransportFunctionality: string;

  transportTypeControl = new FormControl('', [Validators.required]);

  private _availableTransportTypes = [
    {value: TransportService.TRANSPORT_TYPE_BUS, viewValue: 'BUS'},
    {value: TransportService.TRANSPORT_TYPE_TRAM, viewValue: 'TRAM'},
    {value: TransportService.TRANSPORT_TYPE_TROLLEYBUS, viewValue: 'TROLLEYBUS'}
  ];
  _availableTransportFunctionality = [
    {value: TransportService.TRANSPORT_FUNCTIONALITY_WORKING, viewValue: "FUNCTIONALLY"},
    {value: TransportService.TRANSPORT_FUNCTIONALITY_BROKEN, viewValue: "NO FUNCTIONALLY"}
  ]

  constructor(private readonly transportService: TransportService, private readonly router: Router,private readonly transportComponent: TransportComponent) {
    super()
    this._transportInfo = new TransportParams('', '', true);
    this._error = '';
  }

  tryCreateTransport() {
    this.setTransportType();
    this.setTransportFunctionality();
    this.transportService.createTransport(this._transportInfo, (message, result) => {
        if (result) {
          let transportInfo = this.transportInfo;
          transportInfo.registrationNumber = '';
         this.transportService.loadTransports();
          this.redirectToTransports();
        }
        else {
          this._error = message;
        }
      this.transportService.loadTransports();
      }
    )
  }

  ngOnInit() {
  }

  public redirectToTransports() {
    this.router.navigateByUrl('/' + RouteList.PAGE_TRANSPORT);
   this.transportComponent.ngOnInit();
  }

  get transportInfo(): TransportParams {
    return this._transportInfo;
  }

  set transportInfo(value: TransportParams) {
    this._transportInfo = value;
  }

  get error(): string {
    return this._error;
  }

  set error(value: string) {
    this._error = value;
  }

  get selectedTransportType(): string {
    return this._selectedTransportType;
  }

  set selectedTransportType(value: string) {
    this._selectedTransportType = value;
  }

  get availableTransportTypes(): ({ value: string; viewValue: string } | { value: string; viewValue: string } | { value: string; viewValue: string })[] {
    return this._availableTransportTypes;
  }

  set availableTransportTypes(value: ({ value: string; viewValue: string } | { value: string; viewValue: string } | { value: string; viewValue: string })[]) {
    this._availableTransportTypes = value;
  }

  get selectedTransportFunctionality(): string {
    return this._selectedTransportFunctionality;
  }

  set selectedTransportFunctionality(value: string) {
    this._selectedTransportFunctionality = value;
  }

  private setTransportType() {
    switch (this._selectedTransportType) {
      case TransportService.TRANSPORT_TYPE_TRAM: {
        this._transportInfo.transportType = TransportService.TRANSPORT_TYPE_TRAM;
        break;
      }
      case TransportService.TRANSPORT_TYPE_TROLLEYBUS: {
        this._transportInfo.transportType = TransportService.TRANSPORT_TYPE_TROLLEYBUS;
        break;
      }
      case TransportService.TRANSPORT_TYPE_BUS: {
        this._transportInfo.transportType = TransportService.TRANSPORT_TYPE_BUS;
        break;
      }
    }
  }

  private setTransportFunctionality() {
    switch (this._selectedTransportFunctionality) {
      case TransportService.TRANSPORT_FUNCTIONALITY_BROKEN: {
        this._transportInfo.noFunctionally = true;
        break;
      }
      default: {
        this._transportInfo.noFunctionally = false;
        ;
        break;
      }
    }
  }

}
