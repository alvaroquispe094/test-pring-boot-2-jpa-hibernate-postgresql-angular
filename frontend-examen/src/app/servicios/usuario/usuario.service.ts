import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  API_URI = 'http://localhost:8080/api/admin';
 
  constructor(private http: HttpClient) { }

  getUsuarios():  Observable<any> {

    return this.http.get(`${this.API_URI}/usuarios`);
  }

  getUsuario(id: string|number) : Observable<any>{
    return this.http.get(`${this.API_URI}/usuario/${id}`);
  }

  getUsuariosVip(id: string|number) : Observable<any>{
    return this.http.get(`${this.API_URI}/usuarios/vip`);
  }

}
