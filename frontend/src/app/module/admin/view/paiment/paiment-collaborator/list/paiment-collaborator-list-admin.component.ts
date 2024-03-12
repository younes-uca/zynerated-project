import {Component, OnInit} from '@angular/core';
import {PaimentCollaboratorAdminService} from 'src/app/controller/service/admin/paiment/PaimentCollaboratorAdmin.service';
import {PaimentCollaboratorDto} from 'src/app/controller/model/paiment/PaimentCollaborator.model';
import {PaimentCollaboratorCriteria} from 'src/app/controller/criteria/paiment/PaimentCollaboratorCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';
import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponAdminService} from 'src/app/controller/service/admin/coupon/CouponAdmin.service';
import {PaimentCollaboratorStateDto} from 'src/app/controller/model/project/PaimentCollaboratorState.model';
import {PaimentCollaboratorStateAdminService} from 'src/app/controller/service/admin/project/PaimentCollaboratorStateAdmin.service';


@Component({
  selector: 'app-paiment-collaborator-list-admin',
  templateUrl: './paiment-collaborator-list-admin.component.html'
})
export class PaimentCollaboratorListAdminComponent extends AbstractListController<PaimentCollaboratorDto, PaimentCollaboratorCriteria, PaimentCollaboratorAdminService>  implements OnInit {

    override fileName = 'PaimentCollaborator';


    collaborators: Array<CollaboratorDto>;
    coupons: Array<CouponDto>;
    paimentCollaboratorStates: Array<PaimentCollaboratorStateDto>;


    constructor( private paimentCollaboratorService: PaimentCollaboratorAdminService  , private collaboratorService: CollaboratorAdminService, private couponService: CouponAdminService, private paimentCollaboratorStateService: PaimentCollaboratorStateAdminService) {
        super(paimentCollaboratorService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('PaimentCollaborator').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadCollaborator();
                this.loadCoupon();
                this.loadPaimentCollaboratorState();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'name', header: 'Name'},
            {field: 'code', header: 'Code'},
            {field: 'collaborator?.name', header: 'Collaborator'},
            {field: 'coupon?.name', header: 'Coupon'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'paimentCollaboratorState?.code', header: 'Paiment collaborator state'},
        ];
    }


    public async loadCollaborator(){
       this.collaboratorService.findAllOptimized().subscribe(collaborators => this.collaborators = collaborators, error => console.log(error))
    }
    public async loadCoupon(){
       this.couponService.findAllOptimized().subscribe(coupons => this.coupons = coupons, error => console.log(error))
    }
    public async loadPaimentCollaboratorState(){
       this.paimentCollaboratorStateService.findAllOptimized().subscribe(paimentCollaboratorStates => this.paimentCollaboratorStates = paimentCollaboratorStates, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Name': e.name ,
                 'Description': e.description ,
                 'Code': e.code ,
                'Collaborator': e.collaborator?.name ,
                'Coupon': e.coupon?.name ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                'Paiment collaborator state': e.paimentCollaboratorState?.code ,
            }
        });

        this.criteriaData = [{
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Collaborator': this.criteria.collaborator?.name ? this.criteria.collaborator?.name : environment.emptyForExport ,
        //'Coupon': this.criteria.coupon?.name ? this.criteria.coupon?.name : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
        //'Paiment collaborator state': this.criteria.paimentCollaboratorState?.code ? this.criteria.paimentCollaboratorState?.code : environment.emptyForExport ,
        }];
      }
}
