import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';
import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorCriteria} from 'src/app/controller/criteria/collaborator/CollaboratorCriteria.model';

import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberAdminService} from 'src/app/controller/service/admin/collaborator/MemberAdmin.service';
@Component({
  selector: 'app-collaborator-view-admin',
  templateUrl: './collaborator-view-admin.component.html'
})
export class CollaboratorViewAdminComponent extends AbstractViewController<CollaboratorDto, CollaboratorCriteria, CollaboratorAdminService> implements OnInit {


    constructor(private collaboratorService: CollaboratorAdminService, private packagingService: PackagingAdminService, private memberService: MemberAdminService){
        super(collaboratorService);
    }

    ngOnInit(): void {
    }


    get member(): MemberDto {
       return this.memberService.item;
    }
    set member(value: MemberDto) {
        this.memberService.item = value;
    }
    get members(): Array<MemberDto> {
       return this.memberService.items;
    }
    set members(value: Array<MemberDto>) {
        this.memberService.items = value;
    }
    get packaging(): PackagingDto {
       return this.packagingService.item;
    }
    set packaging(value: PackagingDto) {
        this.packagingService.item = value;
    }
    get packagings(): Array<PackagingDto> {
       return this.packagingService.items;
    }
    set packagings(value: Array<PackagingDto>) {
        this.packagingService.items = value;
    }


}
