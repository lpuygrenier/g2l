import { Injectable } from '@angular/core';
import { map, Observable, tap } from 'rxjs';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { TOKEN_KEY, USER_KEY } from './authentication.constants';
import { HttpClient } from '@angular/common/http';
import { API_BASE_URL } from 'src/app/shared/constants/api-constants';
import { AuthenticationResponse } from '@generated/index';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private readonly http: HttpClient,
    private readonly localStorageService: LocalStorageService
  ) {
  }

  login(username: string, password: string): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${API_BASE_URL}/login`, { email:username, password })
      .pipe(
        map(resp => {
          if (resp?.accessToken) {
            this.localStorageService.setItem(TOKEN_KEY, resp.accessToken);
            this.localStorageService.setItem(USER_KEY, username);
          }
          return resp;
        }));
  }

  public logout() {
    this.localStorageService.removeItem(TOKEN_KEY);
    this.localStorageService.removeItem(USER_KEY);
  }

  public getAuthorizingToken(): string {
    return this.localStorageService.getItem(TOKEN_KEY) || '';
  }

  public isAuthenticated(): boolean {
    return !!this.getAuthorizingToken();
  }
}
