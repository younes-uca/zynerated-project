import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategoryProjectTemplateAdminService} from 'src/app/controller/service/admin/template/CategoryProjectTemplateAdmin.service';
import {CategoryProjectTemplateDto} from 'src/app/controller/model/template/CategoryProjectTemplate.model';
import {CategoryProjectTemplateCriteria} from 'src/app/controller/criteria/template/CategoryProjectTemplateCriteria.model';

@Component({
  selector: 'app-category-project-template-view-admin',
  templateUrl: './category-project-template-view-admin.component.html'
})
export class CategoryProjectTemplateViewAdminComponent extends AbstractViewController<CategoryProjectTemplateDto, CategoryProjectTemplateCriteria, CategoryProjectTemplateAdminService> implements OnInit {


    constructor(private categoryProjectTemplateService: CategoryProjectTemplateAdminService){
        super(categoryProjectTemplateService);
    }

    ngOnInit(): void {
    }




}
