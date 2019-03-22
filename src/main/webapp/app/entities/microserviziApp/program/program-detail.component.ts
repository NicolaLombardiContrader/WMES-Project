import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IProgram } from 'app/shared/model/microserviziApp/program.model';

@Component({
    selector: 'jhi-program-detail',
    templateUrl: './program-detail.component.html'
})
export class ProgramDetailComponent implements OnInit {
    program: IProgram;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ program }) => {
            this.program = program;
        });
    }

    previousState() {
        window.history.back();
    }
}
