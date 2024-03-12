import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaimentCollaboratorStateAdminService} from 'src/app/controller/service/admin/project/PaimentCollaboratorStateAdmin.service';
import {PaimentCollaboratorStateDto} from 'src/app/controller/model/project/PaimentCollaboratorState.model';
import {PaimentCollaboratorStateCriteria} from 'src/app/controller/criteria/project/PaimentCollaboratorStateCriteria.model';

@Component({
  selector: 'app-paiment-collaborator-state-view-admin',
  templateUrl: './paiment-collaborator-state-view-admin.component.html'
})
export class PaimentCollaboratorStateViewAdminComponent extends AbstractViewController<PaimentCollaboratorStateDto, PaimentCollaboratorStateCriteria, PaimentCollaboratorStateAdminService> implements OnInit {


    constructor(private paimentCollaboratorStateService: PaimentCollaboratorStateAdminService){
        super(paimentCollaboratorStateService);
    }

    ngOnInit(): void {
    }




}
