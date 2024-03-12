import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaimentInfluencerStateAdminService} from 'src/app/controller/service/admin/project/PaimentInfluencerStateAdmin.service';
import {PaimentInfluencerStateDto} from 'src/app/controller/model/project/PaimentInfluencerState.model';
import {PaimentInfluencerStateCriteria} from 'src/app/controller/criteria/project/PaimentInfluencerStateCriteria.model';



@Component({
  selector: 'app-paiment-influencer-state-edit-admin',
  templateUrl: './paiment-influencer-state-edit-admin.component.html'
})
export class PaimentInfluencerStateEditAdminComponent extends AbstractEditController<PaimentInfluencerStateDto, PaimentInfluencerStateCriteria, PaimentInfluencerStateAdminService>   implements OnInit {


    private _validPaimentInfluencerStateCode = true;




    constructor( private paimentInfluencerStateService: PaimentInfluencerStateAdminService ) {
        super(paimentInfluencerStateService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validPaimentInfluencerStateCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaimentInfluencerStateCode();
    }
    public validatePaimentInfluencerStateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validPaimentInfluencerStateCode = false;
        } else {
            this.validPaimentInfluencerStateCode = true;
        }
    }






    get validPaimentInfluencerStateCode(): boolean {
        return this._validPaimentInfluencerStateCode;
    }
    set validPaimentInfluencerStateCode(value: boolean) {
        this._validPaimentInfluencerStateCode = value;
    }

}
