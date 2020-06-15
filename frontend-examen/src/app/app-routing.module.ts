import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './componentes/product-list/product-list.component';
import { CartComponent } from './componentes/cart/cart.component';
import { CheckoutComponent } from './componentes/checkout/checkout.component';
import { SuccessComponent } from './componentes/success/success.component';
import { VipListComponent } from './componentes/vip-list/vip-list.component';


const routes: Routes = [
 
  {
    path: 'productos',
    component: ProductListComponent
  },
  {
     path: 'cart',
     component: CartComponent
  },
  {
    path: 'checkout',
    component: CheckoutComponent
  },
  {
    path: 'success',
    component: SuccessComponent
  },
  {
    path: 'usuariosVip',
    component: VipListComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
