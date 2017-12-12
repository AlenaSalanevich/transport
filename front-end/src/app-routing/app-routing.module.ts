import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ExtraOptions, RouterModule, Routes} from "@angular/router";
import {RouteList} from "../utils/route-list";
import {ScheduleComponent} from "../component/pages/schedule/schedule.component";
import {LoginComponent} from "../component/pages/login/login.component";
import {PointComponent} from "../component/pages/point/point.component";
import {RouteComponent} from "../component/pages/route/route.component";
import {TransportComponent} from "../component/pages/transport/transport.component";
import {AddPointComponent} from "../component/pages/point/add-point/add-point.component";
import {AddTransportComponent} from "../component/pages/transport/add-transport/add-transport.component";


const routes: Routes = [
  {path: '', redirectTo: '/' + RouteList.PAGE_SCHEDULE, pathMatch: 'full'},
  {path: RouteList.PAGE_SCHEDULE, component: ScheduleComponent},
  {path: RouteList.PAGE_LOGIN, component: LoginComponent},
  {
    path: RouteList.PAGE_POINT,
    component: PointComponent,
    children: [{path: RouteList.PAGE_ADD_POINT, component: AddPointComponent}]
  },
  {path: RouteList.PAGE_ROUTE, component: RouteComponent},
  {
    path: RouteList.PAGE_TRANSPORT,
    component: TransportComponent,
    children: [{path: RouteList.PAGE_ADD_TRANSPORT, component: AddTransportComponent}]
  }
];

/**
 * The configuration of the router module.
 */
const routerOptions: ExtraOptions = {
  useHash: true
};

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes, routerOptions)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
