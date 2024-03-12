import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {ProjectStateDto} from 'src/app/controller/model/project/ProjectState.model';
import {ProjectStateCriteria} from 'src/app/controller/criteria/project/ProjectStateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ProjectStateAdminService extends AbstractService<ProjectStateDto, ProjectStateCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/projectState/');
    }

    public constrcutDto(): ProjectStateDto {
        return new ProjectStateDto();
    }

    public constrcutCriteria(): ProjectStateCriteria {
        return new ProjectStateCriteria();
    }
}
