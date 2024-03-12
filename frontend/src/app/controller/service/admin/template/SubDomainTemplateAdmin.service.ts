import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {SubDomainTemplateDto} from 'src/app/controller/model/template/SubDomainTemplate.model';
import {SubDomainTemplateCriteria} from 'src/app/controller/criteria/template/SubDomainTemplateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class SubDomainTemplateAdminService extends AbstractService<SubDomainTemplateDto, SubDomainTemplateCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/subDomainTemplate/');
    }

    public constrcutDto(): SubDomainTemplateDto {
        return new SubDomainTemplateDto();
    }

    public constrcutCriteria(): SubDomainTemplateCriteria {
        return new SubDomainTemplateCriteria();
    }
}
