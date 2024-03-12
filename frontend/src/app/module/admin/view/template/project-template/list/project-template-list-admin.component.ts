import {Component, OnInit} from '@angular/core';
import {ProjectTemplateAdminService} from 'src/app/controller/service/admin/template/ProjectTemplateAdmin.service';
import {ProjectTemplateDto} from 'src/app/controller/model/template/ProjectTemplate.model';
import {ProjectTemplateCriteria} from 'src/app/controller/criteria/template/ProjectTemplateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {SubDomainTemplateDto} from 'src/app/controller/model/template/SubDomainTemplate.model';
import {SubDomainTemplateAdminService} from 'src/app/controller/service/admin/template/SubDomainTemplateAdmin.service';
import {CategoryProjectTemplateDto} from 'src/app/controller/model/template/CategoryProjectTemplate.model';
import {CategoryProjectTemplateAdminService} from 'src/app/controller/service/admin/template/CategoryProjectTemplateAdmin.service';


@Component({
  selector: 'app-project-template-list-admin',
  templateUrl: './project-template-list-admin.component.html'
})
export class ProjectTemplateListAdminComponent extends AbstractListController<ProjectTemplateDto, ProjectTemplateCriteria, ProjectTemplateAdminService>  implements OnInit {

    override fileName = 'ProjectTemplate';


    categoryProjectTemplates: Array<CategoryProjectTemplateDto>;
    subDomainTemplates: Array<SubDomainTemplateDto>;


    constructor( private projectTemplateService: ProjectTemplateAdminService  , private subDomainTemplateService: SubDomainTemplateAdminService, private categoryProjectTemplateService: CategoryProjectTemplateAdminService) {
        super(projectTemplateService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('ProjectTemplate').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadCategoryProjectTemplate();
                this.loadSubDomainTemplate();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'name', header: 'Name'},
            {field: 'addingDate', header: 'Adding date'},
            {field: 'lastUpdateDate', header: 'Last update date'},
            {field: 'categoryProjectTemplate?.name', header: 'Category project template'},
            {field: 'projectTemplateTags', header: 'Project template tags'},
            {field: 'subDomainTemplate?.name', header: 'Sub domain template'},
            {field: 'price', header: 'Price'},
        ];
    }


    public async loadCategoryProjectTemplate(){
       this.categoryProjectTemplateService.findAllOptimized().subscribe(categoryProjectTemplates => this.categoryProjectTemplates = categoryProjectTemplates, error => console.log(error))
    }
    public async loadSubDomainTemplate(){
       this.subDomainTemplateService.findAllOptimized().subscribe(subDomainTemplates => this.subDomainTemplates = subDomainTemplates, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Name': e.name ,
                'Adding date': this.datePipe.transform(e.addingDate , 'dd/MM/yyyy hh:mm'),
                'Last update date': this.datePipe.transform(e.lastUpdateDate , 'dd/MM/yyyy hh:mm'),
                'Category project template': e.categoryProjectTemplate?.name ,
                 'Project template tags': e.projectTemplateTags ,
                'Sub domain template': e.subDomainTemplate?.name ,
                 'Price': e.price ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Adding date Min': this.criteria.addingDateFrom ? this.datePipe.transform(this.criteria.addingDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Adding date Max': this.criteria.addingDateTo ? this.datePipe.transform(this.criteria.addingDateTo , this.dateFormat) : environment.emptyForExport ,
            'Last update date Min': this.criteria.lastUpdateDateFrom ? this.datePipe.transform(this.criteria.lastUpdateDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Last update date Max': this.criteria.lastUpdateDateTo ? this.datePipe.transform(this.criteria.lastUpdateDateTo , this.dateFormat) : environment.emptyForExport ,
        //'Category project template': this.criteria.categoryProjectTemplate?.name ? this.criteria.categoryProjectTemplate?.name : environment.emptyForExport ,
            'Project template tags': this.criteria.projectTemplateTags ? this.criteria.projectTemplateTags : environment.emptyForExport ,
        //'Sub domain template': this.criteria.subDomainTemplate?.name ? this.criteria.subDomainTemplate?.name : environment.emptyForExport ,
            'Price Min': this.criteria.priceMin ? this.criteria.priceMin : environment.emptyForExport ,
            'Price Max': this.criteria.priceMax ? this.criteria.priceMax : environment.emptyForExport ,
        }];
      }
}
