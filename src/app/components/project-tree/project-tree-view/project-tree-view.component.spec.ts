import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectTreeViewComponent } from './project-tree-view.component';

describe('ProjectTreeViewComponent', () => {
  let component: ProjectTreeViewComponent;
  let fixture: ComponentFixture<ProjectTreeViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectTreeViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectTreeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
