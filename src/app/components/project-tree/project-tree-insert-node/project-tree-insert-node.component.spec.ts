import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectTreeInsertNodeComponent } from './project-tree-insert-node.component';

describe('ProjectTreeInsertNodeComponent', () => {
  let component: ProjectTreeInsertNodeComponent;
  let fixture: ComponentFixture<ProjectTreeInsertNodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectTreeInsertNodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectTreeInsertNodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
