import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingCriteria} from 'src/app/controller/criteria/packaging/PackagingCriteria.model';
import {CategoryPackagingDto} from 'src/app/controller/model/category/CategoryPackaging.model';
import {CategoryPackagingAdminService} from 'src/app/controller/service/admin/category/CategoryPackagingAdmin.service';
@Component({
  selector: 'app-packaging-create-admin',
  templateUrl: './packaging-create-admin.component.html'
})
export class PackagingCreateAdminComponent extends AbstractCreateController<PackagingDto, PackagingCriteria, PackagingAdminService>  implements OnInit {



   private _validPackagingCode = true;
    private _validCategoryPackagingCode = true;
    private _validCategoryPackagingName = true;

    constructor( private packagingService: PackagingAdminService , private categoryPackagingService: CategoryPackagingAdminService) {
        super(packagingService);
    }

    ngOnInit(): void {
        this.categoryPackaging = new CategoryPackagingDto();
        this.categoryPackagingService.findAll().subscribe((data) => this.categoryPackagings = data);
    }





    public override setValidation(value: boolean){
        this.validPackagingCode = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePackagingCode();
    }

    public validatePackagingCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validPackagingCode = false;
        } else {
            this.validPackagingCode = true;
        }
    }



    get categoryPackaging(): CategoryPackagingDto {
        return this.categoryPackagingService.item;
    }
    set categoryPackaging(value: CategoryPackagingDto) {
        this.categoryPackagingService.item = value;
    }
    get categoryPackagings(): Array<CategoryPackagingDto> {
        return this.categoryPackagingService.items;
    }
    set categoryPackagings(value: Array<CategoryPackagingDto>) {
        this.categoryPackagingService.items = value;
    }
    get createCategoryPackagingDialog(): boolean {
       return this.categoryPackagingService.createDialog;
    }
    set createCategoryPackagingDialog(value: boolean) {
        this.categoryPackagingService.createDialog= value;
    }



    get validPackagingCode(): boolean {
        return this._validPackagingCode;
    }

    set validPackagingCode(value: boolean) {
         this._validPackagingCode = value;
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
