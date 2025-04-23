import { Component, ErrorHandler } from '@angular/core';

@Component({
  selector: 'app-error-boundary',
  template: `
    <div class="error-container" *ngIf="error">
      <mat-icon color="warn">error_outline</mat-icon>
      <h3>Something went wrong</h3>
      <p>{{ error }}</p>
      <button mat-raised-button color="primary" (click)="retry()">
        Try Again
      </button>
    </div>
    <ng-content *ngIf="!error"></ng-content>
  `,
  styles: [`
    .error-container {
      text-align: center;
      padding: 48px 24px;
      background: #fff;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }

    mat-icon {
      font-size: 48px;
      height: 48px;
      width: 48px;
      margin-bottom: 16px;
    }

    h3 {
      margin-bottom: 16px;
      color: var(--warn-color);
    }

    p {
      margin-bottom: 24px;
      color: rgba(0, 0, 0, 0.6);
    }
  `]
})
export class ErrorBoundaryComponent implements ErrorHandler {
  error: string | null = null;

  handleError(error: Error) {
    this.error = error.message;
    console.error('Error caught by boundary:', error);
  }

  retry() {
    this.error = null;
    window.location.reload();
  }
}