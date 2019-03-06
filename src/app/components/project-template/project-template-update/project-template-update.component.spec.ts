import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectTemplateUpdateComponent } from './project-template-update.component';

describe('ProjectTemplateUpdateComponent', () => {
  let component: ProjectTemplateUpdateComponent;
  let fixture: ComponentFixture<ProjectTemplateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectTemplateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectTemplateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
