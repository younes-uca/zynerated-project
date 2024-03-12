import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProjectStateAdminService} from 'src/app/controller/service/admin/project/ProjectStateAdmin.service';
import {ProjectStateDto} from 'src/app/controller/model/project/ProjectState.model';
import {ProjectStateCriteria} from 'src/app/controller/criteria/project/ProjectStateCriteria.model';

@Component({
  selector: 'app-project-state-view-admin',
  templateUrl: './project-state-view-admin.component.html'
})
export class ProjectStateViewAdminComponent extends AbstractViewController<ProjectStateDto, ProjectStateCriteria, ProjectStateAdminService> implements OnInit {


    constructor(private projectStateService: ProjectStateAdminService){
        super(projectStateService);
    }

    ngOnInit(): void {
    }




}
