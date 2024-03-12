import {Component, OnInit} from '@angular/core';
import {CategoryPackagingAdminService} from 'src/app/controller/service/admin/category/CategoryPackagingAdmin.service';
import {CategoryPackagingDto} from 'src/app/controller/model/category/CategoryPackaging.model';
import {CategoryPackagingCriteria} from 'src/app/controller/criteria/category/CategoryPackagingCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-category-packaging-list-admin',
  templateUrl: './category-packaging-list-admin.component.html'
})
export class CategoryPackagingListAdminComponent extends AbstractListController<CategoryPackagingDto, CategoryPackagingCriteria, CategoryPackagingAdminService>  implements OnInit {

    override fileName = 'CategoryPackaging';




    constructor( private categoryPackagingService: CategoryPackagingAdminService  ) {
        super(categoryPackagingService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('CategoryPackaging').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'name', header: 'Name'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Name': e.name ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
        }];
      }
}
