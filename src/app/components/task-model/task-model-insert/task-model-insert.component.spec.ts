import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskModelInsertComponent } from './task-model-insert.component';

describe('TaskModelInsertComponent', () => {
  let component: TaskModelInsertComponent;
  let fixture: ComponentFixture<TaskModelInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskModelInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskModelInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
