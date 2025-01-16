import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent {
  private baseUrl = 'http://localhost:8080';
  documentContent = '';
  documentTitle = '';

  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  saveDocument() {
    const payload = {
      title: this.documentTitle,
      content: this.documentContent,
      lastUpdatedBy: localStorage.getItem('userEmail'),
      owner: localStorage.getItem('userEmail')
    };

    this.http.post(`${this.baseUrl}/document`, payload).subscribe(
      (response) => {
        alert('Document saved successfully!');
      },
      (error) => {
        console.error('Error saving document:', error);
        alert('Failed to save document.');
      }
    );
  }

  logout() {
    // Logic for logging out (e.g., clearing authentication tokens)
    localStorage.removeItem('userEmail');
    localStorage.removeItem('authToken');  // Example: Remove token from localStorage (if used)
    this.router.navigate(['/auth/login']);  // Navigate to login page after logout
  }
}
