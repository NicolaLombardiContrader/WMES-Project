import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectTemplateManagementComponent } from './project-template-management.component';

describe('ProjectTemplateManagementComponent', () => {
  let component: ProjectTemplateManagementComponent;
  let fixture: ComponentFixture<ProjectTemplateManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectTemplateManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectTemplateManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
