import {Component} from '@angular/core';
import {PageComponent} from "../../page.component";
import {RouteList} from "../../../utils/route-list";
import {Router} from "@angular/router";
import {RouteEntity} from "../../../model/route/route-entity";
import {RouteService} from "../../../service/route-service/route.service";
import { RouteHashMapModel } from '../../../model/route/route-hashmap.model';

@Component({
  selector: 'app-route',
  templateUrl: './route.component.html',
  styleUrls: ['./route.component.css']
})
export class RouteComponent extends PageComponent {

  private _routeInfo: RouteEntity;

  private _error: string;

  private _routes: RouteEntity[];

  constructor(private readonly routeService: RouteService,
              private readonly router: Router) {
    super()
    this.tryLoadRoutes();
  }

  ngOnInit() {
    this.tryLoadRoutes();
  }

  public tryLoadRoutes(): void {
        this.routeService.loadRoutes()
      .then(value => this._routes = value);
  }

  tryDeletePoint() {
    this.routeService.deleteRoute(this._routeInfo, (message, result) => {
      if (result) {
        this.routeService.loadRoutes()
        this.ngOnInit();
      }
      else {
        this._error = message;
      }
      this.tryLoadRoutes();
    })
  }

  public tryUpdatePoint() {
    this.routeService.updateRoute(this._routeInfo, (message, result) => {
        if (result) {
          this.routeService.loadRoutes()
        }
        else {
          this._error = message;
        }
          this.tryLoadRoutes();
      }
    )
  }

  public createRouteWithHashMap(): void {
    const routeData: RouteHashMapModel = {
        properties: {
            'number': '123',
            'description': 'Route created with HashMap'
        }
    };
    
    this.routeService.createRouteFromHashMap(routeData, (message, result) => {
        if (result) {
            this.routeService.loadRoutes();
            this.ngOnInit();
        } else {
            this._error = message;
        }
        this.tryLoadRoutes();
    });
  }

  public redirectToRoutes() {
    this.router.navigateByUrl('/' + RouteList.PAGE_ROUTE);
    this.ngOnInit();
  }

  public onEditSelect(route: RouteEntity): void {
     }

  public onDeleteSelect(route: RouteEntity): void {
  }

  get error(): string {
    return this._error;
  }

  set error(value: string) {
    this._error = value;
  }

  get routeInfo(): RouteEntity {
    return this._routeInfo;
  }

  set routeInfo(value: RouteEntity) {
    this._routeInfo = value;
  }

  get routes(): RouteEntity[] {
    return this._routes;
  }

  set routes(value: RouteEntity[]) {
    this._routes = value;
  }
}