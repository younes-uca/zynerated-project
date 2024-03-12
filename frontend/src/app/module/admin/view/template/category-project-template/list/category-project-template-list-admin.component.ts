import {Component, OnInit} from '@angular/core';
import {CategoryProjectTemplateAdminService} from 'src/app/controller/service/admin/template/CategoryProjectTemplateAdmin.service';
import {CategoryProjectTemplateDto} from 'src/app/controller/model/template/CategoryProjectTemplate.model';
import {CategoryProjectTemplateCriteria} from 'src/app/controller/criteria/template/CategoryProjectTemplateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-category-project-template-list-admin',
  templateUrl: './category-project-template-list-admin.component.html'
})
export class CategoryProjectTemplateListAdminComponent extends AbstractListController<CategoryProjectTemplateDto, CategoryProjectTemplateCriteria, CategoryProjectTemplateAdminService>  implements OnInit {

    override fileName = 'CategoryProjectTemplate';




    constructor( private categoryProjectTemplateService: CategoryProjectTemplateAdminService  ) {
        super(categoryProjectTemplateService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('CategoryProjectTemplate').subscribe(() => {
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
