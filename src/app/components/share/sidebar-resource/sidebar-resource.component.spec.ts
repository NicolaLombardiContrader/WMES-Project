import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarResourceComponent } from './sidebar-resource.component';

describe('SidebarResourceComponent', () => {
  let component: SidebarResourceComponent;
  let fixture: ComponentFixture<SidebarResourceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarResourceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarResourceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
