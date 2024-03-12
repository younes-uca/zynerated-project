import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {InscriptionStateAdminService} from 'src/app/controller/service/admin/inscription/InscriptionStateAdmin.service';
import {InscriptionStateDto} from 'src/app/controller/model/inscription/InscriptionState.model';
import {InscriptionStateCriteria} from 'src/app/controller/criteria/inscription/InscriptionStateCriteria.model';



@Component({
  selector: 'app-inscription-state-edit-admin',
  templateUrl: './inscription-state-edit-admin.component.html'
})
export class InscriptionStateEditAdminComponent extends AbstractEditController<InscriptionStateDto, InscriptionStateCriteria, InscriptionStateAdminService>   implements OnInit {


    private _validInscriptionStateCode = true;
    private _validInscriptionStateName = true;




    constructor( private inscriptionStateService: InscriptionStateAdminService ) {
        super(inscriptionStateService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validInscriptionStateCode = value;
        this.validInscriptionStateName = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInscriptionStateCode();
        this.validateInscriptionStateName();
    }
    public validateInscriptionStateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validInscriptionStateCode = false;
        } else {
            this.validInscriptionStateCode = true;
        }
    }
    public validateInscriptionStateName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
            this.errorMessages.push('Name non valide');
            this.validInscriptionStateName = false;
        } else {
            this.validInscriptionStateName = true;
        }
    }






    get validInscriptionStateCode(): boolean {
        return this._validInscriptionStateCode;
    }
    set validInscriptionStateCode(value: boolean) {
        this._validInscriptionStateCode = value;
    }
    get validInscriptionStateName(): boolean {
        return this._validInscriptionStateName;
    }
    set validInscriptionStateName(value: boolean) {
        this._validInscriptionStateName = value;
    }

}
