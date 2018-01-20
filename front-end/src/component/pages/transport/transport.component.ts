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

  private _transportFilter: string;

  private _availableFilters = [
    'All transports',
    'Buses',
    'Trams',
    'Trolleybuses',
  ];

  private _availableTransportTypes = [
    {value: TransportService.TRANSPORT_TYPE_BUS, viewValue: 'BUS'},
    {value: TransportService.TRANSPORT_TYPE_TRAM, viewValue: 'TRAM'},
    {value: TransportService.TRANSPORT_TYPE_TROLLEYBUS, viewValue: 'TROLLEYBUS'}
  ];
  private _availableTransportFunctionality = [
    {value: TransportService.TRANSPORT_FUNCTIONALITY_WORKING, viewValue: "FUNCTIONALLY"},
    {value: TransportService.TRANSPORT_FUNCTIONALITY_BROKEN, viewValue: "NO FUNCTIONALLY"}
  ]

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


  public get selectedTransportType(): string {
    return this._selectedTransportType;
  }

  public set selectedTransportType(value: string) {
    this._selectedTransportType = value;
  }

  public get selectedTransportFunctionality(): string {
    return this._selectedTransportFunctionality;
  }

  public set selectedTransportFunctionality(value: string) {
    this._selectedTransportFunctionality = value;
  }

  public get editSelectedTransport(): TransportEntity {
    return this._editSelectedTransport;
  }

  public set editSelectedTransport(value: TransportEntity) {
    this._editSelectedTransport = value;
  }

  public get deleteSelectedTransport(): TransportEntity {
    return this._deleteSelectedTransport;
  }

  public set deleteSelectedTransport(value: TransportEntity) {
    this._deleteSelectedTransport = value;
  }

  public get transports(): TransportEntity[] {
    return this._transports;
  }

  public set transports(value: TransportEntity[]) {
    this._transports = value;
  }


  public get availableTransportTypes(): { value: string; viewValue: string }[] {
    return this._availableTransportTypes;
  }

  public set availableTransportTypes(value: { value: string; viewValue: string }[]) {
    this._availableTransportTypes = value;
  }

  public get availableTransportFunctionality(): { value: string; viewValue: string }[] {
    return this._availableTransportFunctionality;
  }

  public set availableTransportFunctionality(value: { value: string; viewValue: string }[]) {
    this._availableTransportFunctionality = value;
  }

  public get error(): string {
    return this._error;
  }

  public set error(value: string) {
    this._error = value;
  }

  public get transportInfo(): TransportEntity {
    return this._transportInfo;
  }

  public set transportInfo(value: TransportEntity) {
    this._transportInfo = value;
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
      default:
        this._transportInfo.transportType =  this._editSelectedTransport.transportType;
        break;
    }
  }

  private setTransportFunctionality() {
    switch (this._selectedTransportFunctionality) {
      case TransportService.TRANSPORT_FUNCTIONALITY_BROKEN: {
        this._transportInfo.functionality = true;
        break;
      }
      case TransportService.TRANSPORT_FUNCTIONALITY_WORKING: {
        this._transportInfo.functionality = false;
        break;
      }
      default: {
        this._transportInfo.functionality = this._editSelectedTransport.functionality;
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


  get transportFilter(): string {
    return this._transportFilter;
  }

  set transportFilter(value: string) {
    this._transportFilter = value;
  }

  get availableFilters(): string[] {
    return this._availableFilters;
  }

  set availableFilters(value: string[]) {
    this._availableFilters = value;
  }
}
