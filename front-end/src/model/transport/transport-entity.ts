export class TransportEntity {

  private _id: number;

  private _transportType: string;

  private _registrationNumber: string;

  private _functionality: boolean;

  constructor(id: number, transportType: string, registrationNumber: string, functionality: boolean) {
    this._id = id;
    this._transportType = transportType;
    this._registrationNumber = registrationNumber;
    this._functionality = functionality;
  }


  public get id(): number {
    return this._id;
  }

  public get transportType(): string {
    return this._transportType;
  }

  public get registrationNumber(): string {
    return this._registrationNumber;
  }

  public get functionality(): boolean {
    return this._functionality;
  }

  public set id(value: number) {
    this._id = value;
  }

  public set transportType(value: string) {
    this._transportType = value;
  }

  public set registrationNumber(value: string) {
    this._registrationNumber = value;
  }

  public set functionality(value: boolean) {
    this._functionality = value;
  }
}
