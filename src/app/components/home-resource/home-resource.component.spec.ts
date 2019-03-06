import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeResourceComponent } from './home-resource.component';

describe('HomeResourceComponent', () => {
  let component: HomeResourceComponent;
  let fixture: ComponentFixture<HomeResourceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeResourceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeResourceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
