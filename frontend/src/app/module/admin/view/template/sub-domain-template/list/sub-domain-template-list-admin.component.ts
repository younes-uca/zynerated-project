import {Component, OnInit} from '@angular/core';
import {SubDomainTemplateAdminService} from 'src/app/controller/service/admin/template/SubDomainTemplateAdmin.service';
import {SubDomainTemplateDto} from 'src/app/controller/model/template/SubDomainTemplate.model';
import {SubDomainTemplateCriteria} from 'src/app/controller/criteria/template/SubDomainTemplateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DomainTemplateDto} from 'src/app/controller/model/template/DomainTemplate.model';
import {DomainTemplateAdminService} from 'src/app/controller/service/admin/template/DomainTemplateAdmin.service';


@Component({
  selector: 'app-sub-domain-template-list-admin',
  templateUrl: './sub-domain-template-list-admin.component.html'
})
export class SubDomainTemplateListAdminComponent extends AbstractListController<SubDomainTemplateDto, SubDomainTemplateCriteria, SubDomainTemplateAdminService>  implements OnInit {

    override fileName = 'SubDomainTemplate';


    domainTemplates: Array<DomainTemplateDto>;


    constructor( private subDomainTemplateService: SubDomainTemplateAdminService  , private domainTemplateService: DomainTemplateAdminService) {
        super(subDomainTemplateService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('SubDomainTemplate').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadDomainTemplate();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'name', header: 'Name'},
            {field: 'domainTemplate?.name', header: 'Domain template'},
        ];
    }


    public async loadDomainTemplate(){
       this.domainTemplateService.findAllOptimized().subscribe(domainTemplates => this.domainTemplates = domainTemplates, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Name': e.name ,
                'Domain template': e.domainTemplate?.name ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
        //'Domain template': this.criteria.domainTemplate?.name ? this.criteria.domainTemplate?.name : environment.emptyForExport ,
        }];
      }
}
