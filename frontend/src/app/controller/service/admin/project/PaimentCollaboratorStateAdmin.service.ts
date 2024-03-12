import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {PaimentCollaboratorStateDto} from 'src/app/controller/model/project/PaimentCollaboratorState.model';
import {PaimentCollaboratorStateCriteria} from 'src/app/controller/criteria/project/PaimentCollaboratorStateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PaimentCollaboratorStateAdminService extends AbstractService<PaimentCollaboratorStateDto, PaimentCollaboratorStateCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paimentCollaboratorState/');
    }

    public constrcutDto(): PaimentCollaboratorStateDto {
        return new PaimentCollaboratorStateDto();
    }

    public constrcutCriteria(): PaimentCollaboratorStateCriteria {
        return new PaimentCollaboratorStateCriteria();
    }
}
