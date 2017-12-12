import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {PointComponent} from './component/pages/point/point.component';
import {TransportComponent} from './component/pages/transport/transport.component';
import {RouteComponent} from './component/pages/route/route.component';
import {ScheduleComponent} from './component/pages/schedule/schedule.component';
import {LoginComponent} from './component/pages/login/login.component';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  MatButtonModule,
  MatIconModule,
  MatInputModule,
  MatMenuModule,
  MatPaginatorModule,
  MatSidenavModule,
  MatTableModule,
  MatToolbarModule,
  MatListModule,
  MatGridListModule,
  MatCardModule,
  MatFormFieldModule,
  MatSelectModule,
  MatTabsModule,
  MatTooltipModule
} from "@angular/material";
import {SecurityService} from "./service/security-service/security.service";
import {TransportDataSource} from "./service/transport-service/transport-data-source";
import {TransportService} from "./service/transport-service/transport.service";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {PointDataSource} from "./service/point-service/point-data-source";
import {PointService} from "./service/point-service/point.service";
import { AddPointComponent } from './component/pages/point/add-point/add-point.component';
import { AddTransportComponent } from './component/pages/transport/add-transport/add-transport.component';

@NgModule({
  declarations: [
    AppComponent,
    PointComponent,
    TransportComponent,
    RouteComponent,
    ScheduleComponent,
    LoginComponent,
    AddPointComponent,
    AddTransportComponent,

  ],
  imports: [
    FormsModule,
    HttpModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatToolbarModule,
    MatMenuModule,
    MatPaginatorModule,
    MatSidenavModule,
    MatListModule,
    MatGridListModule,
    MatFormFieldModule,
    MatSelectModule,
    RouterModule,
    MatTabsModule,
    MatTableModule,
    HttpClientModule,
    MatCardModule,
    MatTooltipModule,
  ],
  providers: [SecurityService, TransportDataSource, TransportService, PointDataSource, PointService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
