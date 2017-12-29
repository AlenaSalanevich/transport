import {Component} from '@angular/core';
import {SecurityService} from "./service/security-service/security.service";
import {PointDataSource} from "./service/point-service/point-data-source";
import {TransportDataSource} from "./service/transport-service/transport-data-source";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],

})
export class AppComponent {

  static readonly MIN_USERNAME_LENGTH = 3;
  static readonly MAX_USERNAME_LENGTH = 25;
  static readonly MIN_PASSWORD_LENGTH = 6;
  static readonly MAX_PASSWORD_LENGTH = 25;
  static readonly MIN_POINT_LENGTH = 3;
  static readonly MAX_POINT_LENGTH = 20;
  static readonly MIN_REGISTER_NUMBER_LENGTH = 9;
  static readonly MAX_REGISTER_NUMBER_LENGTH = 20;
  static readonly MIN_TRANSPORT_TYPE_LENGTH = 3;
  static readonly MAX_TRANSPORT_TYPE_LENGTH = 20;

  /**
   * The flag that the user is authed.
   */
  private _authed: boolean;

  constructor(private readonly security: SecurityService) {
    this._authed = false;
    this.security.authProperty.subscribe(result => this._authed = result)

  }

  logout() {
    this.security.logout();
  }

  /**
   * The flag that the user is authed.
   *
   * @returns {boolean}
   */
  get authed(): boolean {
    return this._authed;
  }
}
