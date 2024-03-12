import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {MemberAdminService} from 'src/app/controller/service/admin/collaborator/MemberAdmin.service';
import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberCriteria} from 'src/app/controller/criteria/collaborator/MemberCriteria.model';

import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';
@Component({
  selector: 'app-member-view-admin',
  templateUrl: './member-view-admin.component.html'
})
export class MemberViewAdminComponent extends AbstractViewController<MemberDto, MemberCriteria, MemberAdminService> implements OnInit {


    constructor(private memberService: MemberAdminService, private collaboratorService: CollaboratorAdminService){
        super(memberService);
    }

    ngOnInit(): void {
    }


    get collaborator(): CollaboratorDto {
       return this.collaboratorService.item;
    }
    set collaborator(value: CollaboratorDto) {
        this.collaboratorService.item = value;
    }
    get collaborators(): Array<CollaboratorDto> {
       return this.collaboratorService.items;
    }
    set collaborators(value: Array<CollaboratorDto>) {
        this.collaboratorService.items = value;
    }


}
