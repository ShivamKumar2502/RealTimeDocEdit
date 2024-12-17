import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/api/auth'; // Update this with your backend API base URL

  constructor(private http: HttpClient) {}

  signUp(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/signup`, data);
  }

  signIn(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/signin`, data);
  }

  isValidToken(token: string): boolean {
    try {
      const decodedToken = this.decodeToken(token);
      const expirationDate = decodedToken.exp * 1000;  // JWT expiration is in seconds, convert to ms
      return expirationDate > Date.now();
    } catch (error) {
      return false;
    }
  }

  // Decode JWT token (you can use a library like `jwt-decode` for this)
  decodeToken(token: string): any {
    const payload = token.split('.')[1];
    const decodedPayload = atob(payload);
    return JSON.parse(decodedPayload);
  }
}
