import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { IProject } from 'app/shared/model/microserviziApp/project.model';
import { ProjectService } from './project.service';
import { IFile } from 'app/shared/model/microserviziApp/file.model';
import { FileService } from 'app/entities/microserviziApp/file';
import { IProgram } from 'app/shared/model/microserviziApp/program.model';
import { ProgramService } from 'app/entities/microserviziApp/program';
import { IPerson } from 'app/shared/model/microserviziApp/person.model';
import { PersonService } from 'app/entities/microserviziApp/person';
import { ITask } from 'app/shared/model/microserviziApp/task.model';
import { TaskService } from 'app/entities/microserviziApp/task';

@Component({
    selector: 'jhi-project-update',
    templateUrl: './project-update.component.html'
})
export class ProjectUpdateComponent implements OnInit {
    private _project: IProject;
    isSaving: boolean;

    files: IFile[];

    programs: IProgram[];

    people: IPerson[];

    currenttasks: ITask[];
    endDate: string;
    nextCriticalDate: string;

    constructor(
        private jhiAlertService: JhiAlertService,
        private projectService: ProjectService,
        private fileService: FileService,
        private programService: ProgramService,
        private personService: PersonService,
        private taskService: TaskService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ project }) => {
            this.project = project;
        });
        this.fileService.query().subscribe(
            (res: HttpResponse<IFile[]>) => {
                this.files = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.programService.query().subscribe(
            (res: HttpResponse<IProgram[]>) => {
                this.programs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.personService.query().subscribe(
            (res: HttpResponse<IPerson[]>) => {
                this.people = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.taskService.query({ filter: 'project-is-null' }).subscribe(
            (res: HttpResponse<ITask[]>) => {
                if (!this.project.currentTaskId) {
                    this.currenttasks = res.body;
                } else {
                    this.taskService.find(this.project.currentTaskId).subscribe(
                        (subRes: HttpResponse<ITask>) => {
                            this.currenttasks = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.project.endDate = moment(this.endDate, DATE_TIME_FORMAT);
        this.project.nextCriticalDate = moment(this.nextCriticalDate, DATE_TIME_FORMAT);
        if (this.project.id !== undefined) {
            this.subscribeToSaveResponse(this.projectService.update(this.project));
        } else {
            this.subscribeToSaveResponse(this.projectService.create(this.project));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IProject>>) {
        result.subscribe((res: HttpResponse<IProject>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackFileById(index: number, item: IFile) {
        return item.id;
    }

    trackProgramById(index: number, item: IProgram) {
        return item.id;
    }

    trackPersonById(index: number, item: IPerson) {
        return item.id;
    }

    trackTaskById(index: number, item: ITask) {
        return item.id;
    }
    get project() {
        return this._project;
    }

    set project(project: IProject) {
        this._project = project;
        this.endDate = moment(project.endDate).format(DATE_TIME_FORMAT);
        this.nextCriticalDate = moment(project.nextCriticalDate).format(DATE_TIME_FORMAT);
    }
}
