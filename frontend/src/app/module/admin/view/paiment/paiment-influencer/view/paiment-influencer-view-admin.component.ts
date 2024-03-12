import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaimentInfluencerAdminService} from 'src/app/controller/service/admin/paiment/PaimentInfluencerAdmin.service';
import {PaimentInfluencerDto} from 'src/app/controller/model/paiment/PaimentInfluencer.model';
import {PaimentInfluencerCriteria} from 'src/app/controller/criteria/paiment/PaimentInfluencerCriteria.model';

import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponAdminService} from 'src/app/controller/service/admin/coupon/CouponAdmin.service';
import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerAdminService} from 'src/app/controller/service/admin/coupon/InfluencerAdmin.service';
import {PaimentInfluencerStateDto} from 'src/app/controller/model/project/PaimentInfluencerState.model';
import {PaimentInfluencerStateAdminService} from 'src/app/controller/service/admin/project/PaimentInfluencerStateAdmin.service';
@Component({
  selector: 'app-paiment-influencer-view-admin',
  templateUrl: './paiment-influencer-view-admin.component.html'
})
export class PaimentInfluencerViewAdminComponent extends AbstractViewController<PaimentInfluencerDto, PaimentInfluencerCriteria, PaimentInfluencerAdminService> implements OnInit {


    constructor(private paimentInfluencerService: PaimentInfluencerAdminService, private couponService: CouponAdminService, private influencerService: InfluencerAdminService, private paimentInfluencerStateService: PaimentInfluencerStateAdminService){
        super(paimentInfluencerService);
    }

    ngOnInit(): void {
    }


    get influencer(): InfluencerDto {
       return this.influencerService.item;
    }
    set influencer(value: InfluencerDto) {
        this.influencerService.item = value;
    }
    get influencers(): Array<InfluencerDto> {
       return this.influencerService.items;
    }
    set influencers(value: Array<InfluencerDto>) {
        this.influencerService.items = value;
    }
    get paimentInfluencerState(): PaimentInfluencerStateDto {
       return this.paimentInfluencerStateService.item;
    }
    set paimentInfluencerState(value: PaimentInfluencerStateDto) {
        this.paimentInfluencerStateService.item = value;
    }
    get paimentInfluencerStates(): Array<PaimentInfluencerStateDto> {
       return this.paimentInfluencerStateService.items;
    }
    set paimentInfluencerStates(value: Array<PaimentInfluencerStateDto>) {
        this.paimentInfluencerStateService.items = value;
    }
    get coupon(): CouponDto {
       return this.couponService.item;
    }
    set coupon(value: CouponDto) {
        this.couponService.item = value;
    }
    get coupons(): Array<CouponDto> {
       return this.couponService.items;
    }
    set coupons(value: Array<CouponDto>) {
        this.couponService.items = value;
    }


}
