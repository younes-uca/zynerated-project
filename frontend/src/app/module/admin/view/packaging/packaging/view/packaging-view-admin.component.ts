import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingCriteria} from 'src/app/controller/criteria/packaging/PackagingCriteria.model';

import {CategoryPackagingDto} from 'src/app/controller/model/category/CategoryPackaging.model';
import {CategoryPackagingAdminService} from 'src/app/controller/service/admin/category/CategoryPackagingAdmin.service';
@Component({
  selector: 'app-packaging-view-admin',
  templateUrl: './packaging-view-admin.component.html'
})
export class PackagingViewAdminComponent extends AbstractViewController<PackagingDto, PackagingCriteria, PackagingAdminService> implements OnInit {


    constructor(private packagingService: PackagingAdminService, private categoryPackagingService: CategoryPackagingAdminService){
        super(packagingService);
    }

    ngOnInit(): void {
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


}
