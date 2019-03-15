import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectInsertComponent } from './project-insert.component';

describe('ProjectInsertComponent', () => {
  let component: ProjectInsertComponent;
  let fixture: ComponentFixture<ProjectInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
