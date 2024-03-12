import {Component, OnInit} from '@angular/core';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingCriteria} from 'src/app/controller/criteria/packaging/PackagingCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CategoryPackagingDto} from 'src/app/controller/model/category/CategoryPackaging.model';
import {CategoryPackagingAdminService} from 'src/app/controller/service/admin/category/CategoryPackagingAdmin.service';


@Component({
  selector: 'app-packaging-list-admin',
  templateUrl: './packaging-list-admin.component.html'
})
export class PackagingListAdminComponent extends AbstractListController<PackagingDto, PackagingCriteria, PackagingAdminService>  implements OnInit {

    override fileName = 'Packaging';


    categoryPackagings: Array<CategoryPackagingDto>;


    constructor( private packagingService: PackagingAdminService  , private categoryPackagingService: CategoryPackagingAdminService) {
        super(packagingService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Packaging').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadCategoryPackaging();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'dateDebut', header: 'Date debut'},
            {field: 'dateFin', header: 'Date fin'},
            {field: 'price', header: 'Price'},
            {field: 'maxProject', header: 'Max project'},
            {field: 'categoryPackaging?.name', header: 'Category packaging'},
        ];
    }


    public async loadCategoryPackaging(){
       this.categoryPackagingService.findAllOptimized().subscribe(categoryPackagings => this.categoryPackagings = categoryPackagings, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Description': e.description ,
                'Date debut': this.datePipe.transform(e.dateDebut , 'dd/MM/yyyy hh:mm'),
                'Date fin': this.datePipe.transform(e.dateFin , 'dd/MM/yyyy hh:mm'),
                 'Price': e.price ,
                 'Max project': e.maxProject ,
                'Category packaging': e.categoryPackaging?.name ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Date debut Min': this.criteria.dateDebutFrom ? this.datePipe.transform(this.criteria.dateDebutFrom , this.dateFormat) : environment.emptyForExport ,
            'Date debut Max': this.criteria.dateDebutTo ? this.datePipe.transform(this.criteria.dateDebutTo , this.dateFormat) : environment.emptyForExport ,
            'Date fin Min': this.criteria.dateFinFrom ? this.datePipe.transform(this.criteria.dateFinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date fin Max': this.criteria.dateFinTo ? this.datePipe.transform(this.criteria.dateFinTo , this.dateFormat) : environment.emptyForExport ,
            'Price Min': this.criteria.priceMin ? this.criteria.priceMin : environment.emptyForExport ,
            'Price Max': this.criteria.priceMax ? this.criteria.priceMax : environment.emptyForExport ,
            'Max project Min': this.criteria.maxProjectMin ? this.criteria.maxProjectMin : environment.emptyForExport ,
            'Max project Max': this.criteria.maxProjectMax ? this.criteria.maxProjectMax : environment.emptyForExport ,
        //'Category packaging': this.criteria.categoryPackaging?.name ? this.criteria.categoryPackaging?.name : environment.emptyForExport ,
        }];
      }
}
