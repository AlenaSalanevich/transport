import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {PointComponent} from './component/pages/point/point.component';
import {TransportComponent} from './component/pages/transport/transport.component';
import {RouteComponent} from './component/pages/route/route.component';
import {ScheduleComponent} from './component/pages/schedule/schedule.component';
import {LoginComponent} from './component/pages/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatSliderModule} from '@angular/material/slider';
import {MatRadioModule} from '@angular/material/radio';
import {MatChipsModule} from '@angular/material/chips';
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
  MatTooltipModule, MatCheckboxModule
} from "@angular/material";
import {SecurityService} from "./service/security-service/security.service";
import {TransportDataSource} from "./service/transport-service/transport-data-source";
import {TransportService} from "./service/transport-service/transport.service";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {PointDataSource} from "./service/point-service/point-data-source";
import {PointService} from "./service/point-service/point.service";
import {AddPointComponent} from './component/pages/point/add-point/add-point.component';
import {AddTransportComponent} from './component/pages/transport/add-transport/add-transport.component';
import {RouteService} from "./service/route-service/route.service";

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
    HttpClientModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatGridListModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatPaginatorModule,
    MatRadioModule,
    MatSidenavModule,
    MatSliderModule,
    MatTabsModule,
    MatTableModule,
    MatToolbarModule,
    MatTooltipModule,
    MatSelectModule,
    RouterModule,
   ReactiveFormsModule
  ],
  providers: [SecurityService, TransportDataSource, TransportService, PointDataSource, PointService, RouteService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
