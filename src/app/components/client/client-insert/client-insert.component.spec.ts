import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientInsertComponent } from './client-insert.component';

describe('ClientInsertComponent', () => {
  let component: ClientInsertComponent;
  let fixture: ComponentFixture<ClientInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
