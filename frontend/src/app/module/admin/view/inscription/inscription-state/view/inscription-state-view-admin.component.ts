import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {InscriptionStateAdminService} from 'src/app/controller/service/admin/inscription/InscriptionStateAdmin.service';
import {InscriptionStateDto} from 'src/app/controller/model/inscription/InscriptionState.model';
import {InscriptionStateCriteria} from 'src/app/controller/criteria/inscription/InscriptionStateCriteria.model';

@Component({
  selector: 'app-inscription-state-view-admin',
  templateUrl: './inscription-state-view-admin.component.html'
})
export class InscriptionStateViewAdminComponent extends AbstractViewController<InscriptionStateDto, InscriptionStateCriteria, InscriptionStateAdminService> implements OnInit {


    constructor(private inscriptionStateService: InscriptionStateAdminService){
        super(inscriptionStateService);
    }

    ngOnInit(): void {
    }




}
