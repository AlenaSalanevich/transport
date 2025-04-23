import { Component, OnInit } from '@angular/core';
import { Meta, Title } from '@angular/platform-browser';
import { MatDialog } from '@angular/material/dialog';
import { LandingDialogComponent } from './landing-dialog.component';
import { LandingStore } from './landing.store';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.scss']
})
export class LandingComponent implements OnInit {
  isContentLoaded = false;

  constructor(
    private meta: Meta,
    private titleService: Title,
    private dialog: MatDialog,
    public store: LandingStore
  ) {}

  ngOnInit() {
    this.titleService.setTitle('Welcome to Pet Transport App');
    this.meta.addTags([
      { name: 'description', content: 'Pet Transport Application - Your one-stop solution for pet transportation management' },
      { name: 'keywords', content: 'pets, transport, management, scheduling' }
    ]);

    // Simulate content loading
    setTimeout(() => {
      this.isContentLoaded = true;
      this.store.setLoading(false);
    }, 1000);

    // Show welcome dialog for new users
    if (!localStorage.getItem('welcomeShown')) {
      this.showWelcomeDialog();
      localStorage.setItem('welcomeShown', 'true');
    }
  }

  private showWelcomeDialog(): void {
    this.dialog.open(LandingDialogComponent, {
      width: '400px',
      disableClose: true
    });
  }
}