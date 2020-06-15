import { Usuario } from './Usuario';

export class ShoppingCart {
    usuario: Usuario
    esUsuarioVip: boolean;
    esDescuento4: boolean;
    esDescuentoComun10: boolean;
    esDescuentoEspecial10: boolean;
    esDescuentoVip10: boolean;
    descuento25: number;
    descuentoVip: number;
    total: number;
    totalConDescuento: number;
}