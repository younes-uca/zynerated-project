import {Component, OnInit} from '@angular/core';
import {InscriptionStateAdminService} from 'src/app/controller/service/admin/inscription/InscriptionStateAdmin.service';
import {InscriptionStateDto} from 'src/app/controller/model/inscription/InscriptionState.model';
import {InscriptionStateCriteria} from 'src/app/controller/criteria/inscription/InscriptionStateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-inscription-state-list-admin',
  templateUrl: './inscription-state-list-admin.component.html'
})
export class InscriptionStateListAdminComponent extends AbstractListController<InscriptionStateDto, InscriptionStateCriteria, InscriptionStateAdminService>  implements OnInit {

    override fileName = 'InscriptionState';




    constructor( private inscriptionStateService: InscriptionStateAdminService  ) {
        super(inscriptionStateService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('InscriptionState').subscribe(() => {
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
