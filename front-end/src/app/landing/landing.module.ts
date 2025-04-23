import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';

import { LandingComponent } from './landing.component';
import { LandingDialogComponent } from './landing-dialog.component';
import { ErrorBoundaryComponent } from './error-boundary.component';

@NgModule({
  declarations: [
    LandingComponent,
    LandingDialogComponent,
    ErrorBoundaryComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild([
      { path: '', component: LandingComponent }
    ]),
    MatButtonModule,
    MatCardModule,
    MatProgressBarModule,
    MatIconModule,
    MatDialogModule
  ]
})
export class LandingModule { }