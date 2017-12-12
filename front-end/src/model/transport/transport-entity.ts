export class TransportEntity {

  private _id: number;

  private _transportType: string;

  private _registrationNumber: string;

  private _noFunctionally: boolean;

  constructor(id: number, transportType: string, registrationNumber: string, noFunctionally: boolean) {
    this._id = id;
    this._transportType = transportType;
    this._registrationNumber = registrationNumber;
    this._noFunctionally = noFunctionally;
  }


  get id(): number {
    return this._id;
  }

  get transportType(): string {
    return this._transportType;
  }

  get registrationNumber(): string {
    return this._registrationNumber;
  }

  get noFunctionally(): boolean {
    return this._noFunctionally;
  }
}
