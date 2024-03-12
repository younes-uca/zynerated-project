import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SubDomainTemplateAdminService} from 'src/app/controller/service/admin/template/SubDomainTemplateAdmin.service';
import {SubDomainTemplateDto} from 'src/app/controller/model/template/SubDomainTemplate.model';
import {SubDomainTemplateCriteria} from 'src/app/controller/criteria/template/SubDomainTemplateCriteria.model';

import {DomainTemplateDto} from 'src/app/controller/model/template/DomainTemplate.model';
import {DomainTemplateAdminService} from 'src/app/controller/service/admin/template/DomainTemplateAdmin.service';
@Component({
  selector: 'app-sub-domain-template-view-admin',
  templateUrl: './sub-domain-template-view-admin.component.html'
})
export class SubDomainTemplateViewAdminComponent extends AbstractViewController<SubDomainTemplateDto, SubDomainTemplateCriteria, SubDomainTemplateAdminService> implements OnInit {


    constructor(private subDomainTemplateService: SubDomainTemplateAdminService, private domainTemplateService: DomainTemplateAdminService){
        super(subDomainTemplateService);
    }

    ngOnInit(): void {
    }


    get domainTemplate(): DomainTemplateDto {
       return this.domainTemplateService.item;
    }
    set domainTemplate(value: DomainTemplateDto) {
        this.domainTemplateService.item = value;
    }
    get domainTemplates(): Array<DomainTemplateDto> {
       return this.domainTemplateService.items;
    }
    set domainTemplates(value: Array<DomainTemplateDto>) {
        this.domainTemplateService.items = value;
    }


}
