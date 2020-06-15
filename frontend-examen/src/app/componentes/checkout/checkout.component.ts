import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from 'src/app/servicios/shoppingCart/shopping-cart.service';
import { Subject, Observable } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { ShoppingCart } from 'src/app/models/shoppingCart';
import { Producto } from 'src/app/models/producto';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {

  private destroy$: Subject<void> = new Subject<void>();
  usuarioId: number = 1;
  shoppingCart: ShoppingCart;
  carrito: any;
  productos: Observable<Producto[]>

  constructor(private shoppingCartService: ShoppingCartService,protected router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.realizarCheckout();
  }

  realizarCheckout(){
    var lista = JSON.parse(localStorage.getItem('carrito'));
    this.carrito = new Array<Producto>();
    var lista = JSON.parse(localStorage.getItem('carrito'));
    
    if(lista != null){
      for (let i = 0; i <Object.keys(lista).length ; i++) {
        this.carrito.push (lista[i]);
      }
    }else{
      this.carrito = [];
    }

    this.shoppingCartService.checkout(this.usuarioId)
    .pipe(takeUntil(this.destroy$))
    .subscribe(res => this.shoppingCart = res , // add products to cart
    err => console.error("error getProductos(): " +err) // muestra el error si falla
    );  
  }

  finalizarCompra(){
    debugger;
    this.shoppingCartService.saveCheckout(this.shoppingCart)
    .pipe(takeUntil(this.destroy$))
    .subscribe(res => res , // add products to cart
    err => console.error("error getProductos(): " +err)); // muestra el error si falla 
    
    localStorage.clear();
    this.router.navigate(['/success'], { relativeTo: this.activatedRoute });
    debugger;
  }

}
