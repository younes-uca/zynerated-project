import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {PaimentCollaboratorDto} from 'src/app/controller/model/paiment/PaimentCollaborator.model';
import {PaimentCollaboratorCriteria} from 'src/app/controller/criteria/paiment/PaimentCollaboratorCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PaimentCollaboratorAdminService extends AbstractService<PaimentCollaboratorDto, PaimentCollaboratorCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paimentCollaborator/');
    }

    public constrcutDto(): PaimentCollaboratorDto {
        return new PaimentCollaboratorDto();
    }

    public constrcutCriteria(): PaimentCollaboratorCriteria {
        return new PaimentCollaboratorCriteria();
    }
}
