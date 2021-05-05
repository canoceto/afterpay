import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferStepsComponent } from './transfer-steps.component';

describe('TransferStepsComponent', () => {
  let component: TransferStepsComponent;
  let fixture: ComponentFixture<TransferStepsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransferStepsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransferStepsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
