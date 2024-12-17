import { Component } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AuthService } from '../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss'],
})
export class AuthComponent {
  authForm: FormGroup;
  signUpForm: FormGroup;
  isSignUpMode = false;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.authForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
    this.signUpForm = this.fb.group({
      userName: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  ngOnInit(): void {
    // Update `isSignUpMode` based on the route parameter
    this.route.paramMap.subscribe((params) => {
      const mode = params.get('mode');
      this.isSignUpMode = mode === 'signup';
    });
  }

  toggleMode() {
    const newMode = this.isSignUpMode ? 'login' : 'signup';
    this.isSignUpMode = newMode === 'signup'; // Update the mode immediately
    this.router.navigate([`/auth/${newMode}`]);
  }

  onSubmit() {
    const formValues = this.isSignUpMode ? this.signUpForm.value : this.authForm.value;
    const authObservable = this.isSignUpMode
      ? this.authService.signUp(formValues)
      : this.authService.signIn(formValues);

    authObservable.subscribe(
      (response) => {
        if(!this.isSignUpMode){
            console.log("shivam login success " + response.response.token);
            localStorage.setItem('authToken', response.response.token);
            this.router.navigate(['/dashboard']);
        } else {
            console.log("skumar in else ");
            this.router.navigate(['/auth/login']);
        }
        
      },
      (error) => {
        alert('Authentication failed. Please try again.');
      }
    );
  }
}
