import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {ProjectTemplateDto} from 'src/app/controller/model/template/ProjectTemplate.model';
import {ProjectTemplateCriteria} from 'src/app/controller/criteria/template/ProjectTemplateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ProjectTemplateAdminService extends AbstractService<ProjectTemplateDto, ProjectTemplateCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/projectTemplate/');
    }

    public constrcutDto(): ProjectTemplateDto {
        return new ProjectTemplateDto();
    }

    public constrcutCriteria(): ProjectTemplateCriteria {
        return new ProjectTemplateCriteria();
    }
}
