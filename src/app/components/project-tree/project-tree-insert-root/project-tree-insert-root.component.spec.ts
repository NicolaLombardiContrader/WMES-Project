import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectTreeInsertRootComponent } from './project-tree-insert-root.component';

describe('ProjectTreeInsertRootComponent', () => {
  let component: ProjectTreeInsertRootComponent;
  let fixture: ComponentFixture<ProjectTreeInsertRootComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectTreeInsertRootComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectTreeInsertRootComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
