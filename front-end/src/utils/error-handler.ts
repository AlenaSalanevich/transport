import { HttpErrorResponse } from '@angular/http';
import { Observable, throwError } from 'rxjs';

export class ErrorHandler {
  /**
   * Handles HTTP errors and provides consistent error handling across the application
   * @param error The HTTP error response
   * @returns Observable with error message
   */
  public static handleError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = 'An unknown error occurred!';
    
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side error
      errorMessage = this.getServerErrorMessage(error);
    }
    
    console.error(errorMessage);
    return throwError(errorMessage);
  }

  /**
   * Handles JSON error messages from the server
   * @param error The error response
   * @param handler Callback handler for error processing
   */
  public static handleErrorMessageJson(error: any, handler: (message: string) => void): void {
    try {
      const body = error.json();
      handler(body.message || 'Unknown error occurred');
    } catch (e) {
      handler('Server error occurred');
    }
  }

  private static getServerErrorMessage(error: HttpErrorResponse): string {
    switch (error.status) {
      case 404: return `Resource not found: ${error.message}`;
      case 403: return `Access denied: ${error.message}`;
      case 500: return `Internal server error: ${error.message}`;
      default: return `Server returned code ${error.status}, message was: ${error.message}`;
    }
  }
}