import { Usuario } from './Usuario';

export class CompraComercio {
    id: number|string;
    usuario: Usuario;
    fecha: Date;
    total: number;
    activo: boolean;
}