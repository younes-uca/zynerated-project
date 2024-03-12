import {Component, OnInit} from '@angular/core';
import {ProjectStateAdminService} from 'src/app/controller/service/admin/project/ProjectStateAdmin.service';
import {ProjectStateDto} from 'src/app/controller/model/project/ProjectState.model';
import {ProjectStateCriteria} from 'src/app/controller/criteria/project/ProjectStateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-project-state-list-admin',
  templateUrl: './project-state-list-admin.component.html'
})
export class ProjectStateListAdminComponent extends AbstractListController<ProjectStateDto, ProjectStateCriteria, ProjectStateAdminService>  implements OnInit {

    override fileName = 'ProjectState';




    constructor( private projectStateService: ProjectStateAdminService  ) {
        super(projectStateService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('ProjectState').subscribe(() => {
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
