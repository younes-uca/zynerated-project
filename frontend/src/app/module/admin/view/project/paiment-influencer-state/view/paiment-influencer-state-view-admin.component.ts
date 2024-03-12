import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaimentInfluencerStateAdminService} from 'src/app/controller/service/admin/project/PaimentInfluencerStateAdmin.service';
import {PaimentInfluencerStateDto} from 'src/app/controller/model/project/PaimentInfluencerState.model';
import {PaimentInfluencerStateCriteria} from 'src/app/controller/criteria/project/PaimentInfluencerStateCriteria.model';

@Component({
  selector: 'app-paiment-influencer-state-view-admin',
  templateUrl: './paiment-influencer-state-view-admin.component.html'
})
export class PaimentInfluencerStateViewAdminComponent extends AbstractViewController<PaimentInfluencerStateDto, PaimentInfluencerStateCriteria, PaimentInfluencerStateAdminService> implements OnInit {


    constructor(private paimentInfluencerStateService: PaimentInfluencerStateAdminService){
        super(paimentInfluencerStateService);
    }

    ngOnInit(): void {
    }




}
