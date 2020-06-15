import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  API_URI = 'http://localhost:8080/api/admin';
 

  constructor(private http: HttpClient) { }

  getProductos():  Observable<any> {

    return this.http.get(`${this.API_URI}/productos`);
  }

  getProducto(id: string|number) : Observable<any>{
    return this.http.get(`${this.API_URI}/producto/${id}`);
  }
}
