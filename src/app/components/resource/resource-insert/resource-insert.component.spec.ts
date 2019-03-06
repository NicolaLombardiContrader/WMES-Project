import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceInsertComponent } from './resource-insert.component';

describe('ResourceInsertComponent', () => {
  let component: ResourceInsertComponent;
  let fixture: ComponentFixture<ResourceInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResourceInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResourceInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
