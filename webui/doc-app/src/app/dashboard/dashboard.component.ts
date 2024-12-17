import { Component } from '@angular/core';
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
  documentContent = '';

  constructor(
    private router: Router
  ) {}

  saveDocument() {
    // Logic to save document content via backend API
    alert('Document saved successfully!');
  }

  logout() {
    // Logic for logging out (e.g., clearing authentication tokens)
    localStorage.removeItem('authToken');  // Example: Remove token from localStorage (if used)
    this.router.navigate(['/auth/login']);  // Navigate to login page after logout
  }
}
