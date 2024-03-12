import {Component, OnInit} from '@angular/core';
import {PaimentCollaboratorStateAdminService} from 'src/app/controller/service/admin/project/PaimentCollaboratorStateAdmin.service';
import {PaimentCollaboratorStateDto} from 'src/app/controller/model/project/PaimentCollaboratorState.model';
import {PaimentCollaboratorStateCriteria} from 'src/app/controller/criteria/project/PaimentCollaboratorStateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-paiment-collaborator-state-list-admin',
  templateUrl: './paiment-collaborator-state-list-admin.component.html'
})
export class PaimentCollaboratorStateListAdminComponent extends AbstractListController<PaimentCollaboratorStateDto, PaimentCollaboratorStateCriteria, PaimentCollaboratorStateAdminService>  implements OnInit {

    override fileName = 'PaimentCollaboratorState';




    constructor( private paimentCollaboratorStateService: PaimentCollaboratorStateAdminService  ) {
        super(paimentCollaboratorStateService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('PaimentCollaboratorState').subscribe(() => {
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
