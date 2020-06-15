import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './componentes/navigation/navigation.component';
import { ProductListComponent } from './componentes/product-list/product-list.component';
import { CartComponent } from './componentes/cart/cart.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductoService } from './servicios/producto/producto.service';
import { CheckoutComponent } from './componentes/checkout/checkout.component';
import { ShoppingCartService } from './servicios/shoppingCart/shopping-cart.service';
import { SuccessComponent } from './componentes/success/success.component';
import { VipListComponent } from './componentes/vip-list/vip-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    ProductListComponent,
    CartComponent,
    CheckoutComponent,
    SuccessComponent,
    VipListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    ProductoService,
    ShoppingCartService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
