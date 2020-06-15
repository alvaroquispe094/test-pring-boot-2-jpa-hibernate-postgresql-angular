import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  carrito: any; // lia de items del carrito
  total: number;
  constructor() { }

  ngOnInit(): void {
    this.obtenerCarrito();
    this.total = 0;
    this.acumularTotal()
  }

  cleaCarrito() {
    localStorage.clear();
    this.carrito = null;
  }

  acumularTotal(){
    this.total=0;
    var lista = JSON.parse(localStorage.getItem('carrito'));
    
    if(lista != null){
      for (let i = 0; i <Object.keys(lista).length ; i++) {
        this.total = this.total + (lista[i].cantidad*lista[i].precio);
      }

    }
    debugger;
  }

  desAcumularTotal(){
    var lista = JSON.parse(localStorage.getItem('carrito'));
    

      for (let i = 0; i <Object.keys(lista).length ; i++) {
        this.total = this.total - (lista[i].cantidad*lista[i].precio);
      }
    debugger;
  }

  obtenerCarrito(){

    this.carrito = new Array<Producto>();
    var lista = JSON.parse(localStorage.getItem('carrito'));
    
    if(lista != null){
      for (let i = 0; i <Object.keys(lista).length ; i++) {
        this.carrito.push (lista[i]);
      }
    }else{
      this.carrito = [];
    }
    debugger;
  }

  sumar(id:number){
    debugger;
    this.carrito = new Array<Producto>();
    var lista = JSON.parse(localStorage.getItem('carrito'));
    
    if(lista != null){
      for (let i = 0; i <Object.keys(lista).length ; i++) {
        if(lista[i].id == id){
          console.log("cantidad:"+lista[i].cantidad);
          debugger
          lista[i].cantidad = lista[i].cantidad + 1;
          debugger;
        }
        this.carrito.push (lista[i]);
      }
    }else{
      this.carrito = [];
    }

    localStorage.setItem('carrito', JSON.stringify(this.carrito));
    this.acumularTotal();
    debugger;
  }

  restar(id:number){
    this.total=0;
    this.carrito = new Array<Producto>();
    var lista = JSON.parse(localStorage.getItem('carrito'));
    
    if(lista != null){
      for (let i = 0; i <Object.keys(lista).length ; i++) {
        if(lista[i].id == id){
          lista[i].cantidad = lista[i].cantidad - 1;
        }
        this.carrito.push (lista[i]);
      }
    }else{
      this.carrito = [];
    }
    localStorage.setItem('carrito', JSON.stringify(this.carrito));
    this.acumularTotal();
  }

  eliminar(id:number){
    this.total=0;
    this.carrito = new Array<Producto>();
    var lista = JSON.parse(localStorage.getItem('carrito'));
    
    if(lista != null){
      for (let i = 0; i <Object.keys(lista).length ; i++) {
        if(lista[i].id != id){
          this.carrito.push (lista[i]);
        }
      }
    }else{
      this.carrito = [];
    }
    localStorage.setItem('carrito', JSON.stringify(this.carrito));
    this.acumularTotal();
  }
}
