import {Injectable} from '@angular/core';
import {Http, Response} from "@angular/http";
import {SecurityService} from "../security-service/security.service";
import {TransportEntity} from "../../model/transport/transport-entity";
import {TransportParams} from "../../model/transport/transport-params";
import {Utils} from "../../utils/utils";
import {PointService} from "../point-service/point.service";
import {PointEntity} from "../../model/point/poit-entity";
import {Observable, throwError} from 'rxjs';
import {catchError, map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TransportService {

  private static readonly TRANSPORTS_URL: string = '/api/transports';

  public static readonly TRANSPORT_TYPE_BUS: string = "BUS";
  public static readonly TRANSPORT_TYPE_TRAM: string = "TRAM";
  public static readonly TRANSPORT_TYPE_TROLLEYBUS: string = "TROLLEYBUS";

  public static readonly TRANSPORT_FUNCTIONALITY_BROKEN: string = "BROKEN";
  public static readonly TRANSPORT_FUNCTIONALITY_WORKING: string = "WORKING";

  constructor(
    private readonly http: Http,
    private readonly security: SecurityService
  ) {}

  public async loadTransports(): Promise<TransportEntity[]> {
    try {
      const response: Response = await this.http.get(TransportService.TRANSPORTS_URL).toPromise();
      return response.json() as TransportEntity[];
    } catch (error) {
      this.handleError('Failed to load transports', error);
      return [];
    }
  }

  public async createTransport(params: TransportParams): Promise<{ message: string | null; success: boolean }> {
    try {
      await this.http.post(TransportService.TRANSPORTS_URL, params).toPromise();
      return { message: null, success: true };
    } catch (error) {
      const errorMessage = await this.extractErrorMessage(error);
      return { message: errorMessage, success: false };
    }
  }

  public async updateTransport(transport: TransportEntity): Promise<{ message: string | null; success: boolean }> {
    try {
      if (!transport?.id) {
        throw new Error('Transport ID is required');
      }
      await this.http.put(`${TransportService.TRANSPORTS_URL}/${transport.id}`, transport).toPromise();
      return { message: null, success: true };
    } catch (error) {
      const errorMessage = await this.extractErrorMessage(error);
      return { message: errorMessage, success: false };
    }
  }

  public async deleteTransport(transport: TransportEntity): Promise<{ message: string | null; success: boolean }> {
    try {
      if (!transport?.id) {
        throw new Error('Transport ID is required');
      }
      await this.http.delete(`${TransportService.TRANSPORTS_URL}/${transport.id}`).toPromise();
      return { message: null, success: true };
    } catch (error) {
      const errorMessage = await this.extractErrorMessage(error);
      return { message: errorMessage, success: false };
    }
  }

  private async extractErrorMessage(error: any): Promise<string> {
    try {
      if (error.json) {
        const errorBody = await error.json();
        return errorBody.message || 'An unexpected error occurred';
      }
      return error.message || 'An unexpected error occurred';
    } catch {
      return 'An unexpected error occurred';
    }
  }

  private handleError(operation: string, error: any): void {
    console.error(`${operation}: `, error);
    throw error;
  }
}