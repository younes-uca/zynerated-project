import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CategoryProjectTemplateDto} from 'src/app/controller/model/template/CategoryProjectTemplate.model';
import {CategoryProjectTemplateCriteria} from 'src/app/controller/criteria/template/CategoryProjectTemplateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategoryProjectTemplateAdminService extends AbstractService<CategoryProjectTemplateDto, CategoryProjectTemplateCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/categoryProjectTemplate/');
    }

    public constrcutDto(): CategoryProjectTemplateDto {
        return new CategoryProjectTemplateDto();
    }

    public constrcutCriteria(): CategoryProjectTemplateCriteria {
        return new CategoryProjectTemplateCriteria();
    }
}
