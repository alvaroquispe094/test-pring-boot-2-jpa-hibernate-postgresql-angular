import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/Usuario';
import { Observable, Subject } from 'rxjs';
import { UsuarioService } from 'src/app/servicios/usuario/usuario.service';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-vip-list',
  templateUrl: './vip-list.component.html',
  styleUrls: ['./vip-list.component.scss']
})
export class VipListComponent implements OnInit {

  private destroy$: Subject<void> = new Subject<void>();
  usuarios: Observable<Usuario[]>

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.getUsuariosVip();
  }

  getUsuariosVip() {
    var usuarioId: number = 1;
    this.usuarioService.getUsuariosVip(usuarioId)
    .pipe(takeUntil(this.destroy$))
    .subscribe(res => this.usuarios = res, // add products to list
               err => console.error("error getProductos(): " +err) // muestra el error si falla
               );  
  }

}
