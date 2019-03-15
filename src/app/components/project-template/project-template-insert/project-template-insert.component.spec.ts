import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectTemplateInsertComponent } from './project-template-insert.component';

describe('ProjectTemplateInsertComponent', () => {
  let component: ProjectTemplateInsertComponent;
  let fixture: ComponentFixture<ProjectTemplateInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectTemplateInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectTemplateInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
