import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DomainTemplateAdminService} from 'src/app/controller/service/admin/template/DomainTemplateAdmin.service';
import {DomainTemplateDto} from 'src/app/controller/model/template/DomainTemplate.model';
import {DomainTemplateCriteria} from 'src/app/controller/criteria/template/DomainTemplateCriteria.model';

@Component({
  selector: 'app-domain-template-view-admin',
  templateUrl: './domain-template-view-admin.component.html'
})
export class DomainTemplateViewAdminComponent extends AbstractViewController<DomainTemplateDto, DomainTemplateCriteria, DomainTemplateAdminService> implements OnInit {


    constructor(private domainTemplateService: DomainTemplateAdminService){
        super(domainTemplateService);
    }

    ngOnInit(): void {
    }




}
