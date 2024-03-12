import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CategoryPackagingAdminService} from 'src/app/controller/service/admin/category/CategoryPackagingAdmin.service';
import {CategoryPackagingDto} from 'src/app/controller/model/category/CategoryPackaging.model';
import {CategoryPackagingCriteria} from 'src/app/controller/criteria/category/CategoryPackagingCriteria.model';
@Component({
  selector: 'app-category-packaging-create-admin',
  templateUrl: './category-packaging-create-admin.component.html'
})
export class CategoryPackagingCreateAdminComponent extends AbstractCreateController<CategoryPackagingDto, CategoryPackagingCriteria, CategoryPackagingAdminService>  implements OnInit {



   private _validCategoryPackagingCode = true;
   private _validCategoryPackagingName = true;

    constructor( private categoryPackagingService: CategoryPackagingAdminService ) {
        super(categoryPackagingService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validCategoryPackagingCode = value;
        this.validCategoryPackagingName = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategoryPackagingCode();
        this.validateCategoryPackagingName();
    }

    public validateCategoryPackagingCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validCategoryPackagingCode = false;
        } else {
            this.validCategoryPackagingCode = true;
        }
    }
    public validateCategoryPackagingName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
        this.errorMessages.push('Name non valide');
        this.validCategoryPackagingName = false;
        } else {
            this.validCategoryPackagingName = true;
        }
    }






    get validCategoryPackagingCode(): boolean {
        return this._validCategoryPackagingCode;
    }

    set validCategoryPackagingCode(value: boolean) {
         this._validCategoryPackagingCode = value;
    }
    get validCategoryPackagingName(): boolean {
        return this._validCategoryPackagingName;
    }

    set validCategoryPackagingName(value: boolean) {
         this._validCategoryPackagingName = value;
    }



}
