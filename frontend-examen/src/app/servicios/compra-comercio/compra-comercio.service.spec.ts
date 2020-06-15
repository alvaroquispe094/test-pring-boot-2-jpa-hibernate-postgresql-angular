import { TestBed } from '@angular/core/testing';

import { CompraComercioService } from './compra-comercio.service';

describe('CompraComercioService', () => {
  let service: CompraComercioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompraComercioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
