import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorCriteria} from 'src/app/controller/criteria/collaborator/CollaboratorCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CollaboratorAdminService extends AbstractService<CollaboratorDto, CollaboratorCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/collaborator/');
    }

    public constrcutDto(): CollaboratorDto {
        return new CollaboratorDto();
    }

    public constrcutCriteria(): CollaboratorCriteria {
        return new CollaboratorCriteria();
    }
}
