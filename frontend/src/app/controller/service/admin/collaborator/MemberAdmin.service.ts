import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberCriteria} from 'src/app/controller/criteria/collaborator/MemberCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class MemberAdminService extends AbstractService<MemberDto, MemberCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/member/');
    }

    public constrcutDto(): MemberDto {
        return new MemberDto();
    }

    public constrcutCriteria(): MemberCriteria {
        return new MemberCriteria();
    }
}
