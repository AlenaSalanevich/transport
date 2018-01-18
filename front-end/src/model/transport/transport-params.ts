export class TransportParams {

  transportType: string;

  registrationNumber: string;

  functionality: boolean;

  constructor(transportType: string, registrationNumber: string, functionality: boolean) {
    this.transportType = transportType;
    this.registrationNumber = registrationNumber;
    this.functionality = functionality;
  }
}
