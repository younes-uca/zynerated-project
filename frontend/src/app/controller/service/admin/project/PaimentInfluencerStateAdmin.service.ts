import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {PaimentInfluencerStateDto} from 'src/app/controller/model/project/PaimentInfluencerState.model';
import {PaimentInfluencerStateCriteria} from 'src/app/controller/criteria/project/PaimentInfluencerStateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PaimentInfluencerStateAdminService extends AbstractService<PaimentInfluencerStateDto, PaimentInfluencerStateCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paimentInfluencerState/');
    }

    public constrcutDto(): PaimentInfluencerStateDto {
        return new PaimentInfluencerStateDto();
    }

    public constrcutCriteria(): PaimentInfluencerStateCriteria {
        return new PaimentInfluencerStateCriteria();
    }
}
