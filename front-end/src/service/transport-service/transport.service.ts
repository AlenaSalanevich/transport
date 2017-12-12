import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {SecurityService} from "../security-service/security.service";
import {TransportEntity} from "../../model/transport/transport-entity";


@Injectable()
export class TransportService {

  private static readonly LOAD_TRANSPORTS_URL = '/api/transports';

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
}
