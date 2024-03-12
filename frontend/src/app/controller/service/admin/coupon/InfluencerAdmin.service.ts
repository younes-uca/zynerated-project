import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerCriteria} from 'src/app/controller/criteria/coupon/InfluencerCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class InfluencerAdminService extends AbstractService<InfluencerDto, InfluencerCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/influencer/');
    }

    public constrcutDto(): InfluencerDto {
        return new InfluencerDto();
    }

    public constrcutCriteria(): InfluencerCriteria {
        return new InfluencerCriteria();
    }
}
