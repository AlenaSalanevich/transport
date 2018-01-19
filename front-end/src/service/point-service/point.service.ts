import {Injectable} from '@angular/core';
import {SecurityService} from "../security-service/security.service";
import {Http, RequestOptionsArgs} from "@angular/http";
import {PointEntity} from "../../model/point/poit-entity";
import {PointParams} from "../../model/point/point-params";
import {Utils} from "../../utils/utils";

@Injectable()
export class PointService {
  private static readonly PAGE_POINTS_URL = '/api/points';

  constructor(private readonly http: Http, private readonly security: SecurityService) {
  }

  public loadPoints(chars: string): Promise<PointEntity[]> {
    return this.http.get(PointService.PAGE_POINTS_URL+chars)
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
    this.http.post(PointService.PAGE_POINTS_URL, params)
      .toPromise()
      .then(response => handler(null, true))
      .catch(error=>Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }

 public deletePoint(point: PointEntity, handler: (message: string, result: boolean)=>void): void{
    this.http.delete(PointService.PAGE_POINTS_URL+'/'+point.id).toPromise().then(response=>handler(null, true))
      .catch(error=>Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }
  public updatePoint(point: PointEntity, handler: (message: string, result: boolean)=>void): void{
    this.http.put(PointService.PAGE_POINTS_URL+ '/' + point.id, point).toPromise().then(response=>handler(null, true))
      .catch(error=>Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }
}
