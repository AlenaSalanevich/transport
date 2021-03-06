import {Injectable} from '@angular/core';
import {Http, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import 'rxjs/add/operator/toPromise';
import {Utils} from "../../utils/utils";
import {UserCredentials} from "../../model/user/user-credentials";
import {User} from "../../model/user/user";

@Injectable()
export class SecurityService {

  public static readonly ROLE_ADMIN = 'ADMIN';
  public static readonly ROLE_USER = 'USER';

  /**
   * The url of auth endpoint.
   *
   * @type {string}
   */
  private static readonly AUTH_URL = '/?/authenticate';


  /**
   * The name of access token header.
   *
   * @type {string}
   */
  private static readonly ACCESS_TOKEN_HEADER = 'X-Access-Token';

  /**
   * The current user.
   */
  private _user: User;

  /**
   * The property to listen the auth flag.
   */
  private readonly _authProperty: BehaviorSubject<boolean>;

  constructor(private readonly http: Http) {
    this._authProperty = new BehaviorSubject(false);
  }

  /**
   * The function to auth a user in the system.
   *
   * @param credentials the credentials.
   * @param handler to handle result of authentication.
   */
  public auth(credentials: UserCredentials, handler: (message: string, result: boolean) => void): void {
    const username = credentials.login;
    this.http.post(SecurityService.AUTH_URL, credentials)
      .toPromise()
      .then(response => {
        const body = response.json();
        this._user = new User(username, body.token, body.role);
        this._authProperty.next(true);
        handler(null, true);
      })
      .catch(error => Utils.handleErrorMessage(error, (ex: string) => handler(ex, false)));
  }

  /**
   * Add an access token to header of the request options.
   *
   * @param requestOptions the request options.
   */
  public addAccessToken(requestOptions: RequestOptions): void {
    const accessToken = this.accessToken;
    if (accessToken != null) {
      requestOptions.headers.append(SecurityService.ACCESS_TOKEN_HEADER, accessToken);
    }
  }

  /**
   * The function to logout from the system.
   */
  logout() {
    this._user = null;
    this._authProperty.next(false);
  }

  /**
   * Get the auth property.
   *
   * @returns {Observable<boolean>} the auth property.
   */
  get authProperty() {
    return this._authProperty;
  }

  /**
   * Get the current user.
   *
   * @returns {User} the current user.
   */
  get user(): User {
    return this._user;
  }

  /**
   * Get the current access token.
   *
   * @returns {string} the current access token.
   */
  get accessToken(): string {

    const currentUser = this._user;

    if (currentUser == null) {
      return null;
    }

    return currentUser.accessToken;
  }

  /**
   * Check the role in the current user.
   *
   * @param {string} toCheck the role to check.
   * @returns {boolean} true if the current user has the role.
   */
  hasRole(toCheck: string): boolean {

    const currentUser = this._user;

    if (currentUser == null) {
      return false;
    }

    const role = currentUser.role;

    if (role === toCheck) {
      return true;
    }

    return false;
  }
}
