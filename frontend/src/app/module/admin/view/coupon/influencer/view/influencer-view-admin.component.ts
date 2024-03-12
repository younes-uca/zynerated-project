import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {InfluencerAdminService} from 'src/app/controller/service/admin/coupon/InfluencerAdmin.service';
import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerCriteria} from 'src/app/controller/criteria/coupon/InfluencerCriteria.model';

@Component({
  selector: 'app-influencer-view-admin',
  templateUrl: './influencer-view-admin.component.html'
})
export class InfluencerViewAdminComponent extends AbstractViewController<InfluencerDto, InfluencerCriteria, InfluencerAdminService> implements OnInit {


    constructor(private influencerService: InfluencerAdminService){
        super(influencerService);
    }

    ngOnInit(): void {
    }




}
