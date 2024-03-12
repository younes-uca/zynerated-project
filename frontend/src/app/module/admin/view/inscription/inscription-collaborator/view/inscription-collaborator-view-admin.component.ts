import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {InscriptionCollaboratorAdminService} from 'src/app/controller/service/admin/inscription/InscriptionCollaboratorAdmin.service';
import {InscriptionCollaboratorDto} from 'src/app/controller/model/inscription/InscriptionCollaborator.model';
import {InscriptionCollaboratorCriteria} from 'src/app/controller/criteria/inscription/InscriptionCollaboratorCriteria.model';

import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';
import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
import {InscriptionStateDto} from 'src/app/controller/model/inscription/InscriptionState.model';
import {InscriptionStateAdminService} from 'src/app/controller/service/admin/inscription/InscriptionStateAdmin.service';
@Component({
  selector: 'app-inscription-collaborator-view-admin',
  templateUrl: './inscription-collaborator-view-admin.component.html'
})
export class InscriptionCollaboratorViewAdminComponent extends AbstractViewController<InscriptionCollaboratorDto, InscriptionCollaboratorCriteria, InscriptionCollaboratorAdminService> implements OnInit {


    constructor(private inscriptionCollaboratorService: InscriptionCollaboratorAdminService, private collaboratorService: CollaboratorAdminService, private packagingService: PackagingAdminService, private inscriptionStateService: InscriptionStateAdminService){
        super(inscriptionCollaboratorService);
    }

    ngOnInit(): void {
    }


    get inscriptionState(): InscriptionStateDto {
       return this.inscriptionStateService.item;
    }
    set inscriptionState(value: InscriptionStateDto) {
        this.inscriptionStateService.item = value;
    }
    get inscriptionStates(): Array<InscriptionStateDto> {
       return this.inscriptionStateService.items;
    }
    set inscriptionStates(value: Array<InscriptionStateDto>) {
        this.inscriptionStateService.items = value;
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
