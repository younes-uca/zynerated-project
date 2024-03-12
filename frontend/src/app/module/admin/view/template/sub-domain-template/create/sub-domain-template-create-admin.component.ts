import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SubDomainTemplateAdminService} from 'src/app/controller/service/admin/template/SubDomainTemplateAdmin.service';
import {SubDomainTemplateDto} from 'src/app/controller/model/template/SubDomainTemplate.model';
import {SubDomainTemplateCriteria} from 'src/app/controller/criteria/template/SubDomainTemplateCriteria.model';
import {DomainTemplateDto} from 'src/app/controller/model/template/DomainTemplate.model';
import {DomainTemplateAdminService} from 'src/app/controller/service/admin/template/DomainTemplateAdmin.service';
@Component({
  selector: 'app-sub-domain-template-create-admin',
  templateUrl: './sub-domain-template-create-admin.component.html'
})
export class SubDomainTemplateCreateAdminComponent extends AbstractCreateController<SubDomainTemplateDto, SubDomainTemplateCriteria, SubDomainTemplateAdminService>  implements OnInit {



   private _validSubDomainTemplateCode = true;
   private _validSubDomainTemplateName = true;
    private _validDomainTemplateCode = true;
    private _validDomainTemplateName = true;

    constructor( private subDomainTemplateService: SubDomainTemplateAdminService , private domainTemplateService: DomainTemplateAdminService) {
        super(subDomainTemplateService);
    }

    ngOnInit(): void {
        this.domainTemplate = new DomainTemplateDto();
        this.domainTemplateService.findAll().subscribe((data) => this.domainTemplates = data);
    }





    public override setValidation(value: boolean){
        this.validSubDomainTemplateCode = value;
        this.validSubDomainTemplateName = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSubDomainTemplateCode();
        this.validateSubDomainTemplateName();
    }

    public validateSubDomainTemplateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validSubDomainTemplateCode = false;
        } else {
            this.validSubDomainTemplateCode = true;
        }
    }
    public validateSubDomainTemplateName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
        this.errorMessages.push('Name non valide');
        this.validSubDomainTemplateName = false;
        } else {
            this.validSubDomainTemplateName = true;
        }
    }


    public async openCreateDomainTemplate(domainTemplate: string) {
    const isPermistted = await this.roleService.isPermitted('DomainTemplate', 'add');
    if(isPermistted) {
         this.domainTemplate = new DomainTemplateDto();
         this.createDomainTemplateDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get createDomainTemplateDialog(): boolean {
       return this.domainTemplateService.createDialog;
    }
    set createDomainTemplateDialog(value: boolean) {
        this.domainTemplateService.createDialog= value;
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

    get validDomainTemplateCode(): boolean {
        return this._validDomainTemplateCode;
    }
    set validDomainTemplateCode(value: boolean) {
        this._validDomainTemplateCode = value;
    }
    get validDomainTemplateName(): boolean {
        return this._validDomainTemplateName;
    }
    set validDomainTemplateName(value: boolean) {
        this._validDomainTemplateName = value;
    }


}
