import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProjectTemplateAdminService} from 'src/app/controller/service/admin/template/ProjectTemplateAdmin.service';
import {ProjectTemplateDto} from 'src/app/controller/model/template/ProjectTemplate.model';
import {ProjectTemplateCriteria} from 'src/app/controller/criteria/template/ProjectTemplateCriteria.model';

import {SubDomainTemplateDto} from 'src/app/controller/model/template/SubDomainTemplate.model';
import {SubDomainTemplateAdminService} from 'src/app/controller/service/admin/template/SubDomainTemplateAdmin.service';
import {CategoryProjectTemplateDto} from 'src/app/controller/model/template/CategoryProjectTemplate.model';
import {CategoryProjectTemplateAdminService} from 'src/app/controller/service/admin/template/CategoryProjectTemplateAdmin.service';
@Component({
  selector: 'app-project-template-view-admin',
  templateUrl: './project-template-view-admin.component.html'
})
export class ProjectTemplateViewAdminComponent extends AbstractViewController<ProjectTemplateDto, ProjectTemplateCriteria, ProjectTemplateAdminService> implements OnInit {


    constructor(private projectTemplateService: ProjectTemplateAdminService, private subDomainTemplateService: SubDomainTemplateAdminService, private categoryProjectTemplateService: CategoryProjectTemplateAdminService){
        super(projectTemplateService);
    }

    ngOnInit(): void {
    }


    get subDomainTemplate(): SubDomainTemplateDto {
       return this.subDomainTemplateService.item;
    }
    set subDomainTemplate(value: SubDomainTemplateDto) {
        this.subDomainTemplateService.item = value;
    }
    get subDomainTemplates(): Array<SubDomainTemplateDto> {
       return this.subDomainTemplateService.items;
    }
    set subDomainTemplates(value: Array<SubDomainTemplateDto>) {
        this.subDomainTemplateService.items = value;
    }
    get categoryProjectTemplate(): CategoryProjectTemplateDto {
       return this.categoryProjectTemplateService.item;
    }
    set categoryProjectTemplate(value: CategoryProjectTemplateDto) {
        this.categoryProjectTemplateService.item = value;
    }
    get categoryProjectTemplates(): Array<CategoryProjectTemplateDto> {
       return this.categoryProjectTemplateService.items;
    }
    set categoryProjectTemplates(value: Array<CategoryProjectTemplateDto>) {
        this.categoryProjectTemplateService.items = value;
    }


}
