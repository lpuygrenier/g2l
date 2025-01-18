import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SessionStorageService {
  public getItem(key: string): string | null | any[] | any {
    return sessionStorage.getItem(key);
  }

  public setItem(key: string, value: string | any[] | any): void {
    return sessionStorage.setItem(key, value);
  }

  public getObject(key: string): any {
    let obj;
    try {
      obj = JSON.parse(this.getItem(key) as string);
    } catch (e) {
      console.error('Error parsing JSON : ', e);
    }
    return obj;
  }

  public setObject(key: string, value: any): void {
    sessionStorage.setItem(key, JSON.stringify(value));
  }

  public removeItem(key: string): void {
    sessionStorage.removeItem(key);
  }
}
