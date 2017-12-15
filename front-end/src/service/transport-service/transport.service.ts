import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {SecurityService} from "../security-service/security.service";
import {TransportEntity} from "../../model/transport/transport-entity";
import {TransportParams} from "../../model/transport/transport-params";
import {Utils} from "../../utils/utils";


@Injectable()
export class TransportService {

  private static readonly LOAD_TRANSPORTS_URL = '/api/transports';
  private static readonly ADD_TRANSPORT_URL ='api/transports/add';
  public static readonly  TRANSPORT_TYPE_BUS = "BUS";
  public static readonly  TRANSPORT_TYPE_TRAM = "TRAM";
  public static readonly  TRANSPORT_TYPE_TROLLEYBUS = "TROLLEYBUS";
  public static readonly  TRANSPORT_FUNCTIONALITY_BROKEN= "BROKEN";
  public  static readonly TRANSPORT_FUNCTIONALITY_WORKING= "WORKING";

  constructor(private readonly http: Http, private readonly security: SecurityService) {
  }

  public loadTransports(): Promise<TransportEntity[]> {
    return this.http.get(TransportService.LOAD_TRANSPORTS_URL)
      .toPromise().then(response => {
        let body = response.json();
        return body;
      })
      .catch(this.hadnlerError);
  }

  private hadnlerError(error: Response | any) {
    return Promise.reject(error.message || error)
  }

  public createTransport(params: TransportParams, handler: (message: string, result: boolean) => void): void {
  this.http.post(TransportService.ADD_TRANSPORT_URL, params)
.toPromise()
.then(response => handler(null, true))
.catch(error=>Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
}
}
