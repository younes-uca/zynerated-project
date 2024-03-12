import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-inscription-collaborator-edit-admin',
  templateUrl: './inscription-collaborator-edit-admin.component.html'
})
export class InscriptionCollaboratorEditAdminComponent extends AbstractEditController<InscriptionCollaboratorDto, InscriptionCollaboratorCriteria, InscriptionCollaboratorAdminService>   implements OnInit {



    private _validPackagingCode = true;
    private _validCollaboratorName = true;
    private _validCollaboratorCode = true;
    private _validInscriptionStateCode = true;
    private _validInscriptionStateName = true;



    constructor( private inscriptionCollaboratorService: InscriptionCollaboratorAdminService , private collaboratorService: CollaboratorAdminService, private packagingService: PackagingAdminService, private inscriptionStateService: InscriptionStateAdminService) {
        super(inscriptionCollaboratorService);
    }

    ngOnInit(): void {
        this.packaging = new PackagingDto();
        this.packagingService.findAll().subscribe((data) => this.packagings = data);
        this.collaborator = new CollaboratorDto();
        this.collaboratorService.findAll().subscribe((data) => this.collaborators = data);
        this.inscriptionState = new InscriptionStateDto();
        this.inscriptionStateService.findAll().subscribe((data) => this.inscriptionStates = data);
    }
    public override prepareEdit() {
        this.item.inscriptionDate = this.inscriptionCollaboratorService.format(this.item.inscriptionDate);
        this.item.renewDate = this.inscriptionCollaboratorService.format(this.item.renewDate);
    }



    public override setValidation(value: boolean){
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateInscriptionState(inscriptionState: string) {
        const isPermistted = await this.roleService.isPermitted('InscriptionState', 'edit');
        if (isPermistted) {
             this.inscriptionState = new InscriptionStateDto();
             this.createInscriptionStateDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
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
   get createInscriptionStateDialog(): boolean {
       return this.inscriptionStateService.createDialog;
   }
  set createInscriptionStateDialog(value: boolean) {
       this.inscriptionStateService.createDialog= value;
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
   get createCollaboratorDialog(): boolean {
       return this.collaboratorService.createDialog;
   }
  set createCollaboratorDialog(value: boolean) {
       this.collaboratorService.createDialog= value;
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
   get createPackagingDialog(): boolean {
       return this.packagingService.createDialog;
   }
  set createPackagingDialog(value: boolean) {
       this.packagingService.createDialog= value;
   }



    get validPackagingCode(): boolean {
        return this._validPackagingCode;
    }
    set validPackagingCode(value: boolean) {
        this._validPackagingCode = value;
    }
    get validCollaboratorName(): boolean {
        return this._validCollaboratorName;
    }
    set validCollaboratorName(value: boolean) {
        this._validCollaboratorName = value;
    }
    get validCollaboratorCode(): boolean {
        return this._validCollaboratorCode;
    }
    set validCollaboratorCode(value: boolean) {
        this._validCollaboratorCode = value;
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
