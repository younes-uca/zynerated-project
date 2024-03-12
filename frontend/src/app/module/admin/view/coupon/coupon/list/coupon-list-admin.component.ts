import {Component, OnInit} from '@angular/core';
import {CouponAdminService} from 'src/app/controller/service/admin/coupon/CouponAdmin.service';
import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponCriteria} from 'src/app/controller/criteria/coupon/CouponCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerAdminService} from 'src/app/controller/service/admin/coupon/InfluencerAdmin.service';
import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';


@Component({
  selector: 'app-coupon-list-admin',
  templateUrl: './coupon-list-admin.component.html'
})
export class CouponListAdminComponent extends AbstractListController<CouponDto, CouponCriteria, CouponAdminService>  implements OnInit {

    override fileName = 'Coupon';


    packagings: Array<PackagingDto>;
    influencers: Array<InfluencerDto>;


    constructor( private couponService: CouponAdminService  , private influencerService: InfluencerAdminService, private packagingService: PackagingAdminService) {
        super(couponService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Coupon').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadPackaging();
                this.loadInfluencer();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'dateDebut', header: 'Date debut'},
            {field: 'dateFin', header: 'Date fin'},
            {field: 'name', header: 'Name'},
            {field: 'packaging?.id', header: 'Packaging'},
            {field: 'influencer?.id', header: 'Influencer'},
            {field: 'pourcentageCoupon', header: 'Pourcentage coupon'},
            {field: 'pourcentageInfluencer', header: 'Pourcentage influencer'},
            {field: 'usingNumber', header: 'Using number'},
        ];
    }


    public async loadPackaging(){
       this.packagingService.findAll().subscribe(packagings => this.packagings = packagings, error => console.log(error))
    }
    public async loadInfluencer(){
       this.influencerService.findAll().subscribe(influencers => this.influencers = influencers, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Date debut': this.datePipe.transform(e.dateDebut , 'dd/MM/yyyy hh:mm'),
                'Date fin': this.datePipe.transform(e.dateFin , 'dd/MM/yyyy hh:mm'),
                 'Name': e.name ,
                'Packaging': e.packaging?.id ,
                'Influencer': e.influencer?.id ,
                 'Pourcentage coupon': e.pourcentageCoupon ,
                 'Pourcentage influencer': e.pourcentageInfluencer ,
                 'Using number': e.usingNumber ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Date debut Min': this.criteria.dateDebutFrom ? this.datePipe.transform(this.criteria.dateDebutFrom , this.dateFormat) : environment.emptyForExport ,
            'Date debut Max': this.criteria.dateDebutTo ? this.datePipe.transform(this.criteria.dateDebutTo , this.dateFormat) : environment.emptyForExport ,
            'Date fin Min': this.criteria.dateFinFrom ? this.datePipe.transform(this.criteria.dateFinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date fin Max': this.criteria.dateFinTo ? this.datePipe.transform(this.criteria.dateFinTo , this.dateFormat) : environment.emptyForExport ,
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
        //'Packaging': this.criteria.packaging?.id ? this.criteria.packaging?.id : environment.emptyForExport ,
        //'Influencer': this.criteria.influencer?.id ? this.criteria.influencer?.id : environment.emptyForExport ,
            'Pourcentage coupon Min': this.criteria.pourcentageCouponMin ? this.criteria.pourcentageCouponMin : environment.emptyForExport ,
            'Pourcentage coupon Max': this.criteria.pourcentageCouponMax ? this.criteria.pourcentageCouponMax : environment.emptyForExport ,
            'Pourcentage influencer Min': this.criteria.pourcentageInfluencerMin ? this.criteria.pourcentageInfluencerMin : environment.emptyForExport ,
            'Pourcentage influencer Max': this.criteria.pourcentageInfluencerMax ? this.criteria.pourcentageInfluencerMax : environment.emptyForExport ,
            'Using number Min': this.criteria.usingNumberMin ? this.criteria.usingNumberMin : environment.emptyForExport ,
            'Using number Max': this.criteria.usingNumberMax ? this.criteria.usingNumberMax : environment.emptyForExport ,
        }];
      }
}
