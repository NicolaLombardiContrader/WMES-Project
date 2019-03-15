import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceUpdateComponent } from './resource-update.component';

describe('ResourceUpdateComponent', () => {
  let component: ResourceUpdateComponent;
  let fixture: ComponentFixture<ResourceUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResourceUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResourceUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
