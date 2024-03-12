import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ProjectStateAdminService} from 'src/app/controller/service/admin/project/ProjectStateAdmin.service';
import {ProjectStateDto} from 'src/app/controller/model/project/ProjectState.model';
import {ProjectStateCriteria} from 'src/app/controller/criteria/project/ProjectStateCriteria.model';
@Component({
  selector: 'app-project-state-create-admin',
  templateUrl: './project-state-create-admin.component.html'
})
export class ProjectStateCreateAdminComponent extends AbstractCreateController<ProjectStateDto, ProjectStateCriteria, ProjectStateAdminService>  implements OnInit {



   private _validProjectStateCode = true;

    constructor( private projectStateService: ProjectStateAdminService ) {
        super(projectStateService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validProjectStateCode = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProjectStateCode();
    }

    public validateProjectStateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validProjectStateCode = false;
        } else {
            this.validProjectStateCode = true;
        }
    }






    get validProjectStateCode(): boolean {
        return this._validProjectStateCode;
    }

    set validProjectStateCode(value: boolean) {
         this._validProjectStateCode = value;
    }



}
