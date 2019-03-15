import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarBoComponent } from './sidebar-bo.component';

describe('SidebarBoComponent', () => {
  let component: SidebarBoComponent;
  let fixture: ComponentFixture<SidebarBoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarBoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarBoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
