import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanoDeFundo } from './plano-de-fundo';

describe('PlanoDeFundo', () => {
  let component: PlanoDeFundo;
  let fixture: ComponentFixture<PlanoDeFundo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlanoDeFundo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlanoDeFundo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
