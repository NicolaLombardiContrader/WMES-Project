import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IFile } from 'app/shared/model/microserviziApp/file.model';

type EntityResponseType = HttpResponse<IFile>;
type EntityArrayResponseType = HttpResponse<IFile[]>;

@Injectable({ providedIn: 'root' })
export class FileService {
    private resourceUrl = SERVER_API_URL + 'microserviziApp/api/files';

    constructor(private http: HttpClient) {}

    create(file: IFile): Observable<EntityResponseType> {
        return this.http.post<IFile>(this.resourceUrl, file, { observe: 'response' });
    }

    update(file: IFile): Observable<EntityResponseType> {
        return this.http.put<IFile>(this.resourceUrl, file, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IFile>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IFile[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
