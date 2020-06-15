import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EspecialService {

  API_URI = 'http://localhost:8080/api/admin';
 

  constructor(private http: HttpClient) { }

  getEspeciales():  Observable<any> {

    return this.http.get(`${this.API_URI}/especiales`);
  }

  getEspecial(id: string|number) : Observable<any>{
    return this.http.get(`${this.API_URI}/especial/${id}`);
  }
  
}
