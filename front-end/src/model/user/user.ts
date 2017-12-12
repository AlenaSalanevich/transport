export class User {

  private _name: string;

  private _role: string;

  private _accessToken: string;

  constructor(name: string, role: string, accessToken: string) {
    this._name = name;
    this._role = role;
    this._accessToken = accessToken;
  }


  get name(): string {
    return this._name;
  }

  get role(): string {
    return this._role;
  }

  get accessToken(): string {
    return this._accessToken;
  }
}
