import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CouponAdminService} from 'src/app/controller/service/admin/coupon/CouponAdmin.service';
import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponCriteria} from 'src/app/controller/criteria/coupon/CouponCriteria.model';

import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerAdminService} from 'src/app/controller/service/admin/coupon/InfluencerAdmin.service';
import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
@Component({
  selector: 'app-coupon-view-admin',
  templateUrl: './coupon-view-admin.component.html'
})
export class CouponViewAdminComponent extends AbstractViewController<CouponDto, CouponCriteria, CouponAdminService> implements OnInit {


    constructor(private couponService: CouponAdminService, private influencerService: InfluencerAdminService, private packagingService: PackagingAdminService){
        super(couponService);
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
    get packaging(): PackagingDto {
       return this.packagingService.item;
    }
    set packaging(value: PackagingDto) {
        this.packagingService.item = value;
    }
    get packagings(): Array<PackagingDto> {
       return this.packagingService.items;
    }
    set packagings(value: Array<PackagingDto>) {
        this.packagingService.items = value;
    }


}
