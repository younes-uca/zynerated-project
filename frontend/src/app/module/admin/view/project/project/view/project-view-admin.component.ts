import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProjectAdminService} from 'src/app/controller/service/admin/project/ProjectAdmin.service';
import {ProjectDto} from 'src/app/controller/model/project/Project.model';
import {ProjectCriteria} from 'src/app/controller/criteria/project/ProjectCriteria.model';

import {ProjectStateDto} from 'src/app/controller/model/project/ProjectState.model';
import {ProjectStateAdminService} from 'src/app/controller/service/admin/project/ProjectStateAdmin.service';
import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberAdminService} from 'src/app/controller/service/admin/collaborator/MemberAdmin.service';
@Component({
  selector: 'app-project-view-admin',
  templateUrl: './project-view-admin.component.html'
})
export class ProjectViewAdminComponent extends AbstractViewController<ProjectDto, ProjectCriteria, ProjectAdminService> implements OnInit {


    constructor(private projectService: ProjectAdminService, private projectStateService: ProjectStateAdminService, private memberService: MemberAdminService){
        super(projectService);
    }

    ngOnInit(): void {
    }


    get owner(): MemberDto {
       return this.memberService.item;
    }
    set owner(value: MemberDto) {
        this.memberService.item = value;
    }
    get owners(): Array<MemberDto> {
       return this.memberService.items;
    }
    set owners(value: Array<MemberDto>) {
        this.memberService.items = value;
    }
    get projectState(): ProjectStateDto {
       return this.projectStateService.item;
    }
    set projectState(value: ProjectStateDto) {
        this.projectStateService.item = value;
    }
    get projectStates(): Array<ProjectStateDto> {
       return this.projectStateService.items;
    }
    set projectStates(value: Array<ProjectStateDto>) {
        this.projectStateService.items = value;
    }


}
