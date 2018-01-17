import {Component, ViewEncapsulation} from '@angular/core';
import {PageComponent} from "../../page.component";
import {TransportDataSource} from "../../../service/transport-service/transport-data-source";
import {TransportEntity} from "../../../model/transport/transport-entity";
import {TransportService} from "../../../service/transport-service/transport.service";
import {FormControl, Validators} from "@angular/forms";
import {TransportParams} from "../../../model/transport/transport-params";
import {RouteList} from "../../../utils/route-list";
import {Router} from "@angular/router";

@Component({
  selector: 'app-transport',
  templateUrl: './transport.component.html',
  styleUrls: ['./transport.component.css'],
  encapsulation: ViewEncapsulation.Emulated,
  preserveWhitespaces: true,
  providers: [TransportDataSource]

})
export class TransportComponent extends PageComponent {

  private _transportInfo: TransportEntity;

  private _error: string;

  private _selectedTransportType: string;

  private _selectedTransportFunctionality: string;

  private _editSelectedTransport: TransportEntity;

  private _deleteSelectedTransport: TransportEntity;

  private _transports: TransportEntity[];

  transportTypeControl = new FormControl('', [Validators.required]);


  constructor(private readonly transportService: TransportService, private readonly router: Router) {
    super()
    this.loadTransports();

  }

  ngOnInit() {
    this.loadTransports();
  }

  public loadTransports(): void {

    this.transportService.loadTransports()
      .then(value => this._transports = value)
  }

  public onEditSelect(transport: TransportEntity): void {
    this._editSelectedTransport = transport;
    this._transportInfo = this._editSelectedTransport;
    this._error = '';
  }

  public onDeleteSelect(transport: TransportEntity): void {
    this._deleteSelectedTransport = transport;
    this._transportInfo = this._deleteSelectedTransport;
    this._error = '';
  }


  get selectedTransportType(): string {
    return this._selectedTransportType;
  }

  set selectedTransportType(value: string) {
    this._selectedTransportType = value;
  }

  get selectedTransportFunctionality(): string {
    return this._selectedTransportFunctionality;
  }

  set selectedTransportFunctionality(value: string) {
    this._selectedTransportFunctionality = value;
  }

  get editSelectedTransport(): TransportEntity {
    return this._editSelectedTransport;
  }

  set editSelectedTransport(value: TransportEntity) {
    this._editSelectedTransport = value;
  }

  get deleteSelectedTransport(): TransportEntity {
    return this._deleteSelectedTransport;
  }

  set deleteSelectedTransport(value: TransportEntity) {
    this._deleteSelectedTransport = value;
  }

  get transports(): TransportEntity[] {
    return this._transports;
  }

  set transports(value: TransportEntity[]) {
    this._transports = value;
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

  public tryUpdateTransport() {
    this.setTransportType();
    this.setTransportFunctionality();
    this.transportService.updateTransport(this._transportInfo, (message, result) => {
        if (result) {
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

  public redirectToTransports() {
    this.router.navigateByUrl('/' + RouteList.PAGE_TRANSPORT);
    this.ngOnInit();
  }

  public tryDeleteTransport() {
    this.transportService.deleteTransport(this._transportInfo, (message, result) => {
        if (result) {
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
}
