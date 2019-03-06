import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderInsertComponent } from './order-insert.component';

describe('OrderInsertComponent', () => {
  let component: OrderInsertComponent;
  let fixture: ComponentFixture<OrderInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
