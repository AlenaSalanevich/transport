import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LandingStore {
  private readonly _loading = new BehaviorSubject<boolean>(true);
  private readonly _error = new BehaviorSubject<string | null>(null);

  // Public observables
  readonly loading$ = this._loading.asObservable();
  readonly error$ = this._error.asObservable();

  setLoading(loading: boolean) {
    this._loading.next(loading);
  }

  setError(error: string | null) {
    this._error.next(error);
  }

  reset() {
    this._loading.next(false);
    this._error.next(null);
  }
}