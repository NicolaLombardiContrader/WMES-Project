import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskModelManagementComponent } from './task-model-management.component';

describe('TaskModelManagementComponent', () => {
  let component: TaskModelManagementComponent;
  let fixture: ComponentFixture<TaskModelManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskModelManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskModelManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
