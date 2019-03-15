import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskModelUpdateComponent } from './task-model-update.component';

describe('TaskModelUpdateComponent', () => {
  let component: TaskModelUpdateComponent;
  let fixture: ComponentFixture<TaskModelUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskModelUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskModelUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
