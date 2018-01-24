export class RouteEntity {

  private _id: number;
  private _number: string;
  private _description: string;
  constructor(id: number,number: string, description: string){
    this._id=id;
    this._number=number;
    this._description=description;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get number(): string {
    return this._number;
  }

  set number(value: string) {
    this._number = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }
}
