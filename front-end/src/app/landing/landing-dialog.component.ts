import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing-dialog',
  template: `
    <h2 mat-dialog-title>Welcome to Pet Transport!</h2>
    <mat-dialog-content>
      <p>What would you like to do?</p>
      <div class="dialog-actions">
        <button mat-raised-button color="primary" (click)="navigate('/schedule')">
          <mat-icon>schedule</mat-icon>
          Schedule Transport
        </button>
        <button mat-raised-button color="accent" (click)="navigate('/points')">
          <mat-icon>map</mat-icon>
          View Routes
        </button>
      </div>
    </mat-dialog-content>
    <mat-dialog-actions align="end">
      <button mat-button (click)="close()">Maybe Later</button>
    </mat-dialog-actions>
  `,
  styles: [`
    .dialog-actions {
      display: flex;
      flex-direction: column;
      gap: 16px;
      margin: 24px 0;
    }
    
    button {
      width: 100%;
    }
    
    mat-icon {
      margin-right: 8px;
    }
  `]
})
export class LandingDialogComponent {
  constructor(
    private dialogRef: MatDialogRef<LandingDialogComponent>,
    private router: Router
  ) {}

  navigate(route: string): void {
    this.dialogRef.close();
    this.router.navigate([route]);
  }

  close(): void {
    this.dialogRef.close();
  }
}