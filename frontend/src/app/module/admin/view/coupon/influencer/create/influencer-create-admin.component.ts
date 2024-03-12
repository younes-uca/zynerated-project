import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {InfluencerAdminService} from 'src/app/controller/service/admin/coupon/InfluencerAdmin.service';
import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerCriteria} from 'src/app/controller/criteria/coupon/InfluencerCriteria.model';
@Component({
  selector: 'app-influencer-create-admin',
  templateUrl: './influencer-create-admin.component.html'
})
export class InfluencerCreateAdminComponent extends AbstractCreateController<InfluencerDto, InfluencerCriteria, InfluencerAdminService>  implements OnInit {



   private _validInfluencerNickName = true;

    constructor( private influencerService: InfluencerAdminService ) {
        super(influencerService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validInfluencerNickName = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInfluencerNickName();
    }

    public validateInfluencerNickName(){
        if (this.stringUtilService.isEmpty(this.item.nickName)) {
        this.errorMessages.push('Nick name non valide');
        this.validInfluencerNickName = false;
        } else {
            this.validInfluencerNickName = true;
        }
    }






    get validInfluencerNickName(): boolean {
        return this._validInfluencerNickName;
    }

    set validInfluencerNickName(value: boolean) {
         this._validInfluencerNickName = value;
    }



}
