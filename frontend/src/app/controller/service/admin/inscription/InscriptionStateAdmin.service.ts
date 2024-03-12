import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {InscriptionStateDto} from 'src/app/controller/model/inscription/InscriptionState.model';
import {InscriptionStateCriteria} from 'src/app/controller/criteria/inscription/InscriptionStateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class InscriptionStateAdminService extends AbstractService<InscriptionStateDto, InscriptionStateCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/inscriptionState/');
    }

    public constrcutDto(): InscriptionStateDto {
        return new InscriptionStateDto();
    }

    public constrcutCriteria(): InscriptionStateCriteria {
        return new InscriptionStateCriteria();
    }
}
