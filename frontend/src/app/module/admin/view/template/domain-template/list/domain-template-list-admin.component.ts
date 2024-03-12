import {Component, OnInit} from '@angular/core';
import {DomainTemplateAdminService} from 'src/app/controller/service/admin/template/DomainTemplateAdmin.service';
import {DomainTemplateDto} from 'src/app/controller/model/template/DomainTemplate.model';
import {DomainTemplateCriteria} from 'src/app/controller/criteria/template/DomainTemplateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-domain-template-list-admin',
  templateUrl: './domain-template-list-admin.component.html'
})
export class DomainTemplateListAdminComponent extends AbstractListController<DomainTemplateDto, DomainTemplateCriteria, DomainTemplateAdminService>  implements OnInit {

    override fileName = 'DomainTemplate';




    constructor( private domainTemplateService: DomainTemplateAdminService  ) {
        super(domainTemplateService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('DomainTemplate').subscribe(() => {
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
