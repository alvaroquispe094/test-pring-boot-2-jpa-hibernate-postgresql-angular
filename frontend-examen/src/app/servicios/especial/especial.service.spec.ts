import { TestBed } from '@angular/core/testing';

import { EspecialService } from './especial.service';

describe('EspecialService', () => {
  let service: EspecialService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EspecialService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
