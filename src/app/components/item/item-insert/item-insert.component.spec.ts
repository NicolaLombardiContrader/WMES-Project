import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemInsertComponent } from './item-insert.component';

describe('ItemInsertComponent', () => {
  let component: ItemInsertComponent;
  let fixture: ComponentFixture<ItemInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
