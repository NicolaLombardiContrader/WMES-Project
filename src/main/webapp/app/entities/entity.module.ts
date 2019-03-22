import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ProjectsFrontEndProjectModule as MicroserviziAppProjectModule } from './microserviziApp/project/project.module';
import { ProjectsFrontEndTaskModule as MicroserviziAppTaskModule } from './microserviziApp/task/task.module';
import { ProjectsFrontEndFileModule as MicroserviziAppFileModule } from './microserviziApp/file/file.module';
import { ProjectsFrontEndPersonModule as MicroserviziAppPersonModule } from './microserviziApp/person/person.module';
import { ProjectsFrontEndProgramModule as MicroserviziAppProgramModule } from './microserviziApp/program/program.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        MicroserviziAppProjectModule,
        MicroserviziAppTaskModule,
        MicroserviziAppFileModule,
        MicroserviziAppPersonModule,
        MicroserviziAppProgramModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProjectsFrontEndEntityModule {}
