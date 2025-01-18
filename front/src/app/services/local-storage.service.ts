import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LocalStorageService {
  public getItem(key: string): string | null | any[] | any {
    return localStorage.getItem(key);
  }

  public setItem(key: string, value: string | any[] | any): void {
    return localStorage.setItem(key, value);
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
    localStorage.setItem(key, JSON.stringify(value));
  }

  public removeItem(key: string): void {
    localStorage.removeItem(key);
  }
}
