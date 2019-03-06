import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskUpdateResourceComponent } from './task-update-resource.component';

describe('TaskUpdateResourceComponent', () => {
  let component: TaskUpdateResourceComponent;
  let fixture: ComponentFixture<TaskUpdateResourceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskUpdateResourceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskUpdateResourceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
