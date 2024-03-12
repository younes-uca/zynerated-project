import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaimentCollaboratorStateAdminService} from 'src/app/controller/service/admin/project/PaimentCollaboratorStateAdmin.service';
import {PaimentCollaboratorStateDto} from 'src/app/controller/model/project/PaimentCollaboratorState.model';
import {PaimentCollaboratorStateCriteria} from 'src/app/controller/criteria/project/PaimentCollaboratorStateCriteria.model';
@Component({
  selector: 'app-paiment-collaborator-state-create-admin',
  templateUrl: './paiment-collaborator-state-create-admin.component.html'
})
export class PaimentCollaboratorStateCreateAdminComponent extends AbstractCreateController<PaimentCollaboratorStateDto, PaimentCollaboratorStateCriteria, PaimentCollaboratorStateAdminService>  implements OnInit {



   private _validPaimentCollaboratorStateCode = true;

    constructor( private paimentCollaboratorStateService: PaimentCollaboratorStateAdminService ) {
        super(paimentCollaboratorStateService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validPaimentCollaboratorStateCode = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaimentCollaboratorStateCode();
    }

    public validatePaimentCollaboratorStateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validPaimentCollaboratorStateCode = false;
        } else {
            this.validPaimentCollaboratorStateCode = true;
        }
    }






    get validPaimentCollaboratorStateCode(): boolean {
        return this._validPaimentCollaboratorStateCode;
    }

    set validPaimentCollaboratorStateCode(value: boolean) {
         this._validPaimentCollaboratorStateCode = value;
    }



}
