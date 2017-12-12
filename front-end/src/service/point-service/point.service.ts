import {Injectable} from '@angular/core';
import {SecurityService} from "../security-service/security.service";
import {Http} from "@angular/http";
import {PointEntity} from "../../model/point/poit-entity";
import {PointParams} from "../../model/point/point-params";
import {Utils} from "../../utils/utils";
import {error} from "util";

@Injectable()
export class PointService {
  private static readonly LOAD_POINTS_URL = '/api/points';
  private static readonly ADD_POINT_URL = '/api/points/add'

  constructor(private readonly http: Http, private readonly security: SecurityService) {
  }

  public loadPoints(): Promise<PointEntity[]> {
    return this.http.get(PointService.LOAD_POINTS_URL)
      .toPromise()
      .then(response => {
        let body = response.json();
        return body;
      })
      .catch(this.hadnlerError)
  }

  private hadnlerError(error: Response | any) {
    return Promise.reject(error.message || error)
  }

  public createPoint(params: PointParams, handler: (message: string, result: boolean) => void): void {
    this.http.post(PointService.ADD_POINT_URL, params)
      .toPromise()
      .then(response => handler(null, true))
      .catch(error=>Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }
}
