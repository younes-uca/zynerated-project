import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {DomainTemplateDto} from 'src/app/controller/model/template/DomainTemplate.model';
import {DomainTemplateCriteria} from 'src/app/controller/criteria/template/DomainTemplateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class DomainTemplateAdminService extends AbstractService<DomainTemplateDto, DomainTemplateCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/domainTemplate/');
    }

    public constrcutDto(): DomainTemplateDto {
        return new DomainTemplateDto();
    }

    public constrcutCriteria(): DomainTemplateCriteria {
        return new DomainTemplateCriteria();
    }
}
