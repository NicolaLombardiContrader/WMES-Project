import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskInsertComponent } from './task-insert.component';

describe('TaskInsertComponent', () => {
  let component: TaskInsertComponent;
  let fixture: ComponentFixture<TaskInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskInsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
