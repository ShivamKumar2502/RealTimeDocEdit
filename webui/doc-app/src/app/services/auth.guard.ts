// auth.guard.ts
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';  // Adjust the path to your AuthService

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | Promise<boolean> | boolean {
    // Check if the JWT token exists and is valid
    if (typeof window !== 'undefined' && window.localStorage) {
        console.log("shivam inside localStorage 1 " + localStorage.getItem('authToken'));
        const token = localStorage.getItem('authToken');  // Adjust if you store the token elsewhere
        if (token && this.authService.isValidToken(token)) {
          console.log("shivam inside localStorage");
          return true;  // Token is valid, allow access
        }
    }
    // Token is invalid or not present, redirect to login
    this.router.navigate(['/auth/login']);
    return false;

  }
}
