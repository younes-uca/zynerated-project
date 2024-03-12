import {Component, OnInit} from '@angular/core';
import {PaimentInfluencerStateAdminService} from 'src/app/controller/service/admin/project/PaimentInfluencerStateAdmin.service';
import {PaimentInfluencerStateDto} from 'src/app/controller/model/project/PaimentInfluencerState.model';
import {PaimentInfluencerStateCriteria} from 'src/app/controller/criteria/project/PaimentInfluencerStateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-paiment-influencer-state-list-admin',
  templateUrl: './paiment-influencer-state-list-admin.component.html'
})
export class PaimentInfluencerStateListAdminComponent extends AbstractListController<PaimentInfluencerStateDto, PaimentInfluencerStateCriteria, PaimentInfluencerStateAdminService>  implements OnInit {

    override fileName = 'PaimentInfluencerState';




    constructor( private paimentInfluencerStateService: PaimentInfluencerStateAdminService  ) {
        super(paimentInfluencerStateService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('PaimentInfluencerState').subscribe(() => {
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
