import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {DomainTemplateAdminService} from 'src/app/controller/service/admin/template/DomainTemplateAdmin.service';
import {DomainTemplateDto} from 'src/app/controller/model/template/DomainTemplate.model';
import {DomainTemplateCriteria} from 'src/app/controller/criteria/template/DomainTemplateCriteria.model';
@Component({
  selector: 'app-domain-template-create-admin',
  templateUrl: './domain-template-create-admin.component.html'
})
export class DomainTemplateCreateAdminComponent extends AbstractCreateController<DomainTemplateDto, DomainTemplateCriteria, DomainTemplateAdminService>  implements OnInit {



   private _validDomainTemplateCode = true;
   private _validDomainTemplateName = true;

    constructor( private domainTemplateService: DomainTemplateAdminService ) {
        super(domainTemplateService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validDomainTemplateCode = value;
        this.validDomainTemplateName = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateDomainTemplateCode();
        this.validateDomainTemplateName();
    }

    public validateDomainTemplateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validDomainTemplateCode = false;
        } else {
            this.validDomainTemplateCode = true;
        }
    }
    public validateDomainTemplateName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
        this.errorMessages.push('Name non valide');
        this.validDomainTemplateName = false;
        } else {
            this.validDomainTemplateName = true;
        }
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
