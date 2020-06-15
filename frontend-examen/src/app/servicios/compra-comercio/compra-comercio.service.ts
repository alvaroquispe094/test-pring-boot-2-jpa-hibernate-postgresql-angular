import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CompraComercio } from 'src/app/models/compraComercio';

@Injectable({
  providedIn: 'root'
})
export class CompraComercioService {

  API_URI = 'http://localhost:8080/api/admin';

  constructor(private http: HttpClient) { }

  getUsuarios():  Observable<any> {

    return this.http.get(`${this.API_URI}/usuarios`);
  }

  getUsuario(id: string|number) : Observable<any>{
    return this.http.get(`${this.API_URI}/usuario/${id}`);
  }

  saveUsuario(compraComercio: CompraComercio) {
    const url: string = this.API_URI+'/compraComercio/add/';
    debugger;
    return this.http.post(url, compraComercio);
  }

}
