import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/authentication/services/authentication.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  loginForm = new FormGroup({
    mail: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  error: boolean = false;
  
  readonly loginError: string = "Email ou mot de passe incorrect.";
  
  constructor(
    private readonly authService: AuthenticationService,
    private readonly router: Router,
    private readonly route: ActivatedRoute,
  ) { }

  onSubmit() {
    this.authService.login(this.loginForm.value.mail!, this.loginForm.value.password!).subscribe({
      next: resp => {
        if (resp?.accessToken) {
          this.redirect();
        }
      }
    });
  }

  private redirect() {
    this.router.navigate(['/dashboard']);
  }

}
