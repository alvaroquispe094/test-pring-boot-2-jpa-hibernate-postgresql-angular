import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CompraComercio } from 'src/app/models/compraComercio';
import { ShoppingCart } from 'src/app/models/shoppingCart';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  API_URI = 'http://localhost:8080/api/admin';

  constructor(private http: HttpClient) { }

  saveCheckout(shoppingcart: ShoppingCart) {
    
    const url: string = this.API_URI+'/cart/checkout/guardar/';
    debugger;
    return this.http.put(url, shoppingcart);
  }

  checkout(usuarioId: string|number) : Observable<any> {
    // const url: string = this.API_URI+'/cart/checkout/'+usuarioId;
    var lista = JSON.parse(localStorage.getItem('carrito'));
    debugger;
    return this.http.put(`${this.API_URI}/cart/checkout/${usuarioId}`, lista);
  }
}
