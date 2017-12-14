export class TransportParams {

  transportType: string;

  registrationNumber: string;

  noFunctionally: boolean;

  constructor(transportType: string, registrationNumber: string, noFunctionally: boolean) {
    this.transportType = transportType;
    this.registrationNumber = registrationNumber;
    this.noFunctionally = noFunctionally;
  }
}
