import { Component, OnInit, HostBinding } from '@angular/core';
import { ProductoService } from 'src/app/servicios/producto/producto.service';
import { takeUntil } from 'rxjs/operators';
import { Subject, Observable } from 'rxjs';
import { Producto } from 'src/app/models/producto';
import { identifierModuleUrl } from '@angular/compiler';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
   
  private destroy$: Subject<void> = new Subject<void>();
  @HostBinding('class') classes = 'row';
  
  lista: Observable<Producto[]>;
  productos: Observable<Producto[]>
  carrito: any; // lia de items del carrito
  // carrito: any[] = {}; // lia de items del carrito
  constructor(private productoService: ProductoService) { 
  }

  ngOnInit() {
    this.getProductos();
    // this.carrito = this.initCart();
    debugger;
    // if(this.carrito == null ){
    
    // }
  }

  agregarAlCarrito(id:number){
    // this.producto = new Producto();
    this.productoService.getProducto(id)
    .pipe(takeUntil(this.destroy$))
    .subscribe(res => this.addLocalStorage(res) , // add products to cart
    err => console.error("error getProductos(): " +err) // muestra el error si falla
    );  
    // this.carrito.add(this.producto);
  }
  
  addLocalStorage(producto: Producto){
    var control = false;
    // this.lista = localStorage.getItem('carrito');
    this.carrito = new Array<Producto>();
    var lista = JSON.parse(localStorage.getItem('carrito'));
    debugger;

    if(lista != null){      
      for (let i = 0; i <Object.keys(lista).length ; i++) {
        producto.cantidad = lista[i].cantidad + 1;
        this.carrito.push (lista[i]);
        if(lista[i].id == producto.id){
          control = true;
        }
        
      }
    }
    debugger;

    if(control == false){
      producto.cantidad = 0;
      producto.cantidad = 1; 
      this.carrito.push(producto);   
    }
    console.log("Cantidad de items agregados: "+this.carrito.length);
    localStorage.setItem('carrito', JSON.stringify(this.carrito));
  }
  
  initCart() {   
    return localStorage.getItem('carrito');
  }
  
  getProductos() {
    this.productoService.getProductos()
    .pipe(takeUntil(this.destroy$))
    .subscribe(res => this.productos = res, // add products to list
               err => console.error("error getProductos(): " +err) // muestra el error si falla
               );  
  }
  // agregarItems(){
    //   this.role = this.authenticationService.leerRol();
    //   // this.MENU_ITEMS= [];
    //   this.cleanItems();
    //   // debugger;
    //     this.authenticationService.getOperaciones(this.role)
    //       .subscribe(
      //        res => {
        //           console.log("res: " +res)
        //              debugger;
        //              for (let i = 0; i <Object.keys(res).length ; i++) {
          //                 // debugger;
          //                 if(Object.keys(res[i].childrens).length != 0){
            //                   // debugger;
            
            //                   this.childrenItems = [];
            //                   for (let j = 0; j < Object.keys(res[i].childrens).length; j++) {
  //                     // debugger;
  //                     this.childrenItem = {
  //                       'title' :  res[i].childrens[j].operacion.title,                       
  //                       'link' :  res[i].childrens[j].operacion.link,                    
  //                      };
  //                      this.childrenItems.push(this.childrenItem);
  //                     //  debugger;
  //                      this.childrenItem = null;
  //                   }
  //                   // debugger;
  //                 }
 
  //               //  debugger;
  //                this.nbMenuItem = {
  //                 'title' :  res[i].operacion.title,
  //                 'icon' :  res[i].operacion.icon,
  //                 'link' :  res[i].operacion.link,
  //                 'home': res[i].operacion.home,
  //                 'group': res[i].operacion.group,
  //                 'children': this.childrenItems,


  //                };
  //                MENU_ITEMS.push(this.nbMenuItem); //setea las operaciones juntos a sus operaciones hijos
  //               //  debugger;
  //                this.nbMenuItem = null;
  //                this.childrenItems =null
  //              }  
  //        }
  //      );
  // } 

  // private guardarToken(token: string) {
  //   this.userToken = token;

  //   localStorage.setItem('token', token);

  //   let hoy = new Date();

  //   hoy.setSeconds(3600);

  //   localStorage.setItem('expira', hoy.getTime.toString());
  // }

  // leerToken() {
  //   if (localStorage.getItem('token')) {
  //     return localStorage.getItem('token');
  //   } else {
  //     return '';
  //   }
    
  //   return this.userToken;
  // }

  // leerRol() {
  //   // debugger;
  //   if (localStorage.getItem('role')) {
  //     return  localStorage.getItem('role');
  //   } else {
  //     return '';
  //   }
  //   // debugger;
  //   // return this.userToken;
  // }

  // leerUsuario() {
  //   // debugger;
  //   if (localStorage.getItem('usuario')) {
  //     return  localStorage.getItem('usuario');
  //   } else {
  //     debugger;
  //     return '';
  //   }

}
