import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {SecurityService} from "../security-service/security.service";
import {PointEntity} from "../../model/point/poit-entity";
import {Utils} from "../../utils/utils";
import {RouteParams} from "../../model/route/route-params";
import {RouteEntity} from "../../model/route/route-entity";

@Injectable()
export class RouteService {

  private static readonly PAGE_ROUTES_URL = '/api/routes';

  constructor(private readonly http: Http, private readonly security: SecurityService) {
  }

  public loadRoutes(): Promise<RouteEntity[]> {
    return this.http.get(RouteService.PAGE_ROUTES_URL)
      .toPromise()
      .then(response => {
        let body = response.json();
        return body;
      })
      .catch(Utils.handleError)
  }

  public createRoute(params: RouteParams, handler: (message: string, result: boolean) => void): void {
    this.http.post(RouteService.PAGE_ROUTES_URL, params)
      .toPromise()
      .then(response => handler(null, true))
      .catch(error => Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }

  public deleteRoute(route: RouteEntity, handler: (message: string, result: boolean) => void): void {
    this.http.delete(RouteService.PAGE_ROUTES_URL + '/' + route.id).toPromise().then(response => handler(null, true))
      .catch(error => Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }
  public updateRoute(route: RouteEntity, handler: (message: string, result: boolean) => void): void {
    this.http.put(RouteService.PAGE_ROUTES_URL + '/' + route.id, route).toPromise().then(response => handler(null, true))
      .catch(error => Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }

  /*public deletePoint(route: RouteEntity, point: PointEntity, handler: (message: string, result: boolean) => void): void {
    this.http.delete(RouteService.PAGE_ROUTES_URL + '/' + route.id + point.id).toPromise().then(response => handler(null, true))
      .catch(error => Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }

  public addPoint(point: PointEntity, handler: (message: string, result: boolean) => void): void {
    this.http.put(RouteService.PAGE_ROUTES_URL + '/' + route.id, point).toPromise().then(response => handler(null, true))
      .catch(error => Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }
  public insertPoint(point: PointEntity, handler: (message: string, result: boolean) => void): void {
    this.http.put(RouteService.PAGE_ROUTES_URL + '/' + route.id, point).toPromise().then(response => handler(null, true))
      .catch(error => Utils.handleErrorMessageJson(error, (ex: string) => handler(ex, false)));
  }*/
}
