import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {InscriptionCollaboratorDto} from 'src/app/controller/model/inscription/InscriptionCollaborator.model';
import {InscriptionCollaboratorCriteria} from 'src/app/controller/criteria/inscription/InscriptionCollaboratorCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class InscriptionCollaboratorAdminService extends AbstractService<InscriptionCollaboratorDto, InscriptionCollaboratorCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/inscriptionCollaborator/');
    }

    public constrcutDto(): InscriptionCollaboratorDto {
        return new InscriptionCollaboratorDto();
    }

    public constrcutCriteria(): InscriptionCollaboratorCriteria {
        return new InscriptionCollaboratorCriteria();
    }
}
