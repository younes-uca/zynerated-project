import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CategoryProjectTemplateAdminService} from 'src/app/controller/service/admin/template/CategoryProjectTemplateAdmin.service';
import {CategoryProjectTemplateDto} from 'src/app/controller/model/template/CategoryProjectTemplate.model';
import {CategoryProjectTemplateCriteria} from 'src/app/controller/criteria/template/CategoryProjectTemplateCriteria.model';
@Component({
  selector: 'app-category-project-template-create-admin',
  templateUrl: './category-project-template-create-admin.component.html'
})
export class CategoryProjectTemplateCreateAdminComponent extends AbstractCreateController<CategoryProjectTemplateDto, CategoryProjectTemplateCriteria, CategoryProjectTemplateAdminService>  implements OnInit {



   private _validCategoryProjectTemplateCode = true;
   private _validCategoryProjectTemplateName = true;

    constructor( private categoryProjectTemplateService: CategoryProjectTemplateAdminService ) {
        super(categoryProjectTemplateService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validCategoryProjectTemplateCode = value;
        this.validCategoryProjectTemplateName = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategoryProjectTemplateCode();
        this.validateCategoryProjectTemplateName();
    }

    public validateCategoryProjectTemplateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validCategoryProjectTemplateCode = false;
        } else {
            this.validCategoryProjectTemplateCode = true;
        }
    }
    public validateCategoryProjectTemplateName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
        this.errorMessages.push('Name non valide');
        this.validCategoryProjectTemplateName = false;
        } else {
            this.validCategoryProjectTemplateName = true;
        }
    }






    get validCategoryProjectTemplateCode(): boolean {
        return this._validCategoryProjectTemplateCode;
    }

    set validCategoryProjectTemplateCode(value: boolean) {
         this._validCategoryProjectTemplateCode = value;
    }
    get validCategoryProjectTemplateName(): boolean {
        return this._validCategoryProjectTemplateName;
    }

    set validCategoryProjectTemplateName(value: boolean) {
         this._validCategoryProjectTemplateName = value;
    }



}
