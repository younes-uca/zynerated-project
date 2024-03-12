import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProjectTemplateAdminService} from 'src/app/controller/service/admin/template/ProjectTemplateAdmin.service';
import {ProjectTemplateDto} from 'src/app/controller/model/template/ProjectTemplate.model';
import {ProjectTemplateCriteria} from 'src/app/controller/criteria/template/ProjectTemplateCriteria.model';


import {SubDomainTemplateDto} from 'src/app/controller/model/template/SubDomainTemplate.model';
import {SubDomainTemplateAdminService} from 'src/app/controller/service/admin/template/SubDomainTemplateAdmin.service';
import {CategoryProjectTemplateDto} from 'src/app/controller/model/template/CategoryProjectTemplate.model';
import {CategoryProjectTemplateAdminService} from 'src/app/controller/service/admin/template/CategoryProjectTemplateAdmin.service';

@Component({
  selector: 'app-project-template-edit-admin',
  templateUrl: './project-template-edit-admin.component.html'
})
export class ProjectTemplateEditAdminComponent extends AbstractEditController<ProjectTemplateDto, ProjectTemplateCriteria, ProjectTemplateAdminService>   implements OnInit {


    private _validProjectTemplateCode = true;

    private _validCategoryProjectTemplateCode = true;
    private _validCategoryProjectTemplateName = true;
    private _validSubDomainTemplateCode = true;
    private _validSubDomainTemplateName = true;



    constructor( private projectTemplateService: ProjectTemplateAdminService , private subDomainTemplateService: SubDomainTemplateAdminService, private categoryProjectTemplateService: CategoryProjectTemplateAdminService) {
        super(projectTemplateService);
    }

    ngOnInit(): void {
        this.categoryProjectTemplate = new CategoryProjectTemplateDto();
        this.categoryProjectTemplateService.findAll().subscribe((data) => this.categoryProjectTemplates = data);
        this.subDomainTemplate = new SubDomainTemplateDto();
        this.subDomainTemplateService.findAll().subscribe((data) => this.subDomainTemplates = data);
    }
    public override prepareEdit() {
        this.item.addingDate = this.projectTemplateService.format(this.item.addingDate);
        this.item.lastUpdateDate = this.projectTemplateService.format(this.item.lastUpdateDate);
    }



    public override setValidation(value: boolean){
        this.validProjectTemplateCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProjectTemplateCode();
    }
    public validateProjectTemplateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validProjectTemplateCode = false;
        } else {
            this.validProjectTemplateCode = true;
        }
    }



   public async openCreateSubDomainTemplate(subDomainTemplate: string) {
        const isPermistted = await this.roleService.isPermitted('SubDomainTemplate', 'edit');
        if (isPermistted) {
             this.subDomainTemplate = new SubDomainTemplateDto();
             this.createSubDomainTemplateDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateCategoryProjectTemplate(categoryProjectTemplate: string) {
        const isPermistted = await this.roleService.isPermitted('CategoryProjectTemplate', 'edit');
        if (isPermistted) {
             this.categoryProjectTemplate = new CategoryProjectTemplateDto();
             this.createCategoryProjectTemplateDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
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
   get createSubDomainTemplateDialog(): boolean {
       return this.subDomainTemplateService.createDialog;
   }
  set createSubDomainTemplateDialog(value: boolean) {
       this.subDomainTemplateService.createDialog= value;
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
   get createCategoryProjectTemplateDialog(): boolean {
       return this.categoryProjectTemplateService.createDialog;
   }
  set createCategoryProjectTemplateDialog(value: boolean) {
       this.categoryProjectTemplateService.createDialog= value;
   }


    get validProjectTemplateCode(): boolean {
        return this._validProjectTemplateCode;
    }
    set validProjectTemplateCode(value: boolean) {
        this._validProjectTemplateCode = value;
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
    get validSubDomainTemplateCode(): boolean {
        return this._validSubDomainTemplateCode;
    }
    set validSubDomainTemplateCode(value: boolean) {
        this._validSubDomainTemplateCode = value;
    }
    get validSubDomainTemplateName(): boolean {
        return this._validSubDomainTemplateName;
    }
    set validSubDomainTemplateName(value: boolean) {
        this._validSubDomainTemplateName = value;
    }
}
