import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiModule } from '@generated/api.module';
import { LoginComponent } from "./core/components/login/login.component";
import { DashboardComponent } from './components/dashboard/dashboard.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ApiModule, LoginComponent, DashboardComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'g2l';
}
