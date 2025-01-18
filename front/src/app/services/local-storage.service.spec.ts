import { TestBed } from '@angular/core/testing';
import { LocalStorageService } from './local-storage.service';

fdescribe('LocalStorageService', () => {
  let service: LocalStorageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LocalStorageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('getItem', () => {
    it('should retrieve an item from localStorage', () => {
      spyOn(localStorage, 'getItem').and.returnValue('test value');
      const result = service.getItem('testKey');
      expect(localStorage.getItem).toHaveBeenCalledWith('testKey');
      expect(result).toBe('test value');
    });
  });

  describe('setItem', () => {
    it('should set an item in localStorage', () => {
      spyOn(localStorage, 'setItem');
      service.setItem('testKey', 'test value');
      expect(localStorage.setItem).toHaveBeenCalledWith('testKey', 'test value');
    });
  });

  describe('getObject', () => {
    it('should retrieve and parse a JSON object from localStorage', () => {
      const testObj = { name: 'Test', value: 123 };
      spyOn(localStorage, 'getItem').and.returnValue(JSON.stringify(testObj));
      const result = service.getObject('testKey');
      expect(localStorage.getItem).toHaveBeenCalledWith('testKey');
      expect(result).toEqual(testObj);
    });

    it('should return undefined and log error if JSON is invalid', () => {
      spyOn(localStorage, 'getItem').and.returnValue('invalid JSON');
      spyOn(console, 'error');
      const result = service.getObject('testKey');
      expect(localStorage.getItem).toHaveBeenCalledWith('testKey');
      expect(result).toBeUndefined();
      expect(console.error).toHaveBeenCalled();
    });
  });

  describe('setObject', () => {
    it('should stringify and set an object in localStorage', () => {
      const testObj = { name: 'Test', value: 123 };
      spyOn(localStorage, 'setItem');
      service.setObject('testKey', testObj);
      expect(localStorage.setItem).toHaveBeenCalledWith('testKey', JSON.stringify(testObj));
    });
  });

  describe('removeItem', () => {
    it('should remove an item from localStorage', () => {
      spyOn(localStorage, 'removeItem');
      service.removeItem('testKey');
      expect(localStorage.removeItem).toHaveBeenCalledWith('testKey');
    });
  });
});
