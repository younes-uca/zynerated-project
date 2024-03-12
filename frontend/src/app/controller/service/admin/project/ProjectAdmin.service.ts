import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {ProjectDto} from 'src/app/controller/model/project/Project.model';
import {ProjectCriteria} from 'src/app/controller/criteria/project/ProjectCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ProjectAdminService extends AbstractService<ProjectDto, ProjectCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/project/');
    }

    public constrcutDto(): ProjectDto {
        return new ProjectDto();
    }

    public constrcutCriteria(): ProjectCriteria {
        return new ProjectCriteria();
    }
}
