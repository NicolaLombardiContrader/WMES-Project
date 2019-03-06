import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeBoComponent } from './home-bo.component';

describe('HomeBoComponent', () => {
  let component: HomeBoComponent;
  let fixture: ComponentFixture<HomeBoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeBoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeBoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
