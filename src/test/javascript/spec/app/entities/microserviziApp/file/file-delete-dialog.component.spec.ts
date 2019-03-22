/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProjectsFrontEndTestModule } from '../../../../test.module';
import { FileDeleteDialogComponent } from 'app/entities/microserviziApp/file/file-delete-dialog.component';
import { FileService } from 'app/entities/microserviziApp/file/file.service';

describe('Component Tests', () => {
    describe('File Management Delete Component', () => {
        let comp: FileDeleteDialogComponent;
        let fixture: ComponentFixture<FileDeleteDialogComponent>;
        let service: FileService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProjectsFrontEndTestModule],
                declarations: [FileDeleteDialogComponent]
            })
                .overrideTemplate(FileDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(FileDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FileService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
