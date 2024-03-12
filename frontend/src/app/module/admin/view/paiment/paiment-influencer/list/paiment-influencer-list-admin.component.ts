import {Component, OnInit} from '@angular/core';
import {PaimentInfluencerAdminService} from 'src/app/controller/service/admin/paiment/PaimentInfluencerAdmin.service';
import {PaimentInfluencerDto} from 'src/app/controller/model/paiment/PaimentInfluencer.model';
import {PaimentInfluencerCriteria} from 'src/app/controller/criteria/paiment/PaimentInfluencerCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponAdminService} from 'src/app/controller/service/admin/coupon/CouponAdmin.service';
import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerAdminService} from 'src/app/controller/service/admin/coupon/InfluencerAdmin.service';
import {PaimentInfluencerStateDto} from 'src/app/controller/model/project/PaimentInfluencerState.model';
import {PaimentInfluencerStateAdminService} from 'src/app/controller/service/admin/project/PaimentInfluencerStateAdmin.service';


@Component({
  selector: 'app-paiment-influencer-list-admin',
  templateUrl: './paiment-influencer-list-admin.component.html'
})
export class PaimentInfluencerListAdminComponent extends AbstractListController<PaimentInfluencerDto, PaimentInfluencerCriteria, PaimentInfluencerAdminService>  implements OnInit {

    override fileName = 'PaimentInfluencer';


    influencers: Array<InfluencerDto>;
    coupons: Array<CouponDto>;
    paimentInfluencerStates: Array<PaimentInfluencerStateDto>;


    constructor( private paimentInfluencerService: PaimentInfluencerAdminService  , private couponService: CouponAdminService, private influencerService: InfluencerAdminService, private paimentInfluencerStateService: PaimentInfluencerStateAdminService) {
        super(paimentInfluencerService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('PaimentInfluencer').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadInfluencer();
                this.loadCoupon();
                this.loadPaimentInfluencerState();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'name', header: 'Name'},
            {field: 'code', header: 'Code'},
            {field: 'influencer?.id', header: 'Influencer'},
            {field: 'coupon?.name', header: 'Coupon'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'paimentInfluencerState?.code', header: 'Paiment influencer state'},
        ];
    }


    public async loadInfluencer(){
       this.influencerService.findAll().subscribe(influencers => this.influencers = influencers, error => console.log(error))
    }
    public async loadCoupon(){
       this.couponService.findAllOptimized().subscribe(coupons => this.coupons = coupons, error => console.log(error))
    }
    public async loadPaimentInfluencerState(){
       this.paimentInfluencerStateService.findAllOptimized().subscribe(paimentInfluencerStates => this.paimentInfluencerStates = paimentInfluencerStates, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Name': e.name ,
                 'Description': e.description ,
                 'Code': e.code ,
                'Influencer': e.influencer?.id ,
                'Coupon': e.coupon?.name ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                'Paiment influencer state': e.paimentInfluencerState?.code ,
            }
        });

        this.criteriaData = [{
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Influencer': this.criteria.influencer?.id ? this.criteria.influencer?.id : environment.emptyForExport ,
        //'Coupon': this.criteria.coupon?.name ? this.criteria.coupon?.name : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
        //'Paiment influencer state': this.criteria.paimentInfluencerState?.code ? this.criteria.paimentInfluencerState?.code : environment.emptyForExport ,
        }];
      }
}
