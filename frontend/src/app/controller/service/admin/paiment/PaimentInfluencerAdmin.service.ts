import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {PaimentInfluencerDto} from 'src/app/controller/model/paiment/PaimentInfluencer.model';
import {PaimentInfluencerCriteria} from 'src/app/controller/criteria/paiment/PaimentInfluencerCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PaimentInfluencerAdminService extends AbstractService<PaimentInfluencerDto, PaimentInfluencerCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paimentInfluencer/');
    }

    public constrcutDto(): PaimentInfluencerDto {
        return new PaimentInfluencerDto();
    }

    public constrcutCriteria(): PaimentInfluencerCriteria {
        return new PaimentInfluencerCriteria();
    }
}
