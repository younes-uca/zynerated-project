import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategoryPackagingAdminService} from 'src/app/controller/service/admin/category/CategoryPackagingAdmin.service';
import {CategoryPackagingDto} from 'src/app/controller/model/category/CategoryPackaging.model';
import {CategoryPackagingCriteria} from 'src/app/controller/criteria/category/CategoryPackagingCriteria.model';

@Component({
  selector: 'app-category-packaging-view-admin',
  templateUrl: './category-packaging-view-admin.component.html'
})
export class CategoryPackagingViewAdminComponent extends AbstractViewController<CategoryPackagingDto, CategoryPackagingCriteria, CategoryPackagingAdminService> implements OnInit {


    constructor(private categoryPackagingService: CategoryPackagingAdminService){
        super(categoryPackagingService);
    }

    ngOnInit(): void {
    }




}
