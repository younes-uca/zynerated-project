import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {MemberAdminService} from 'src/app/controller/service/admin/collaborator/MemberAdmin.service';
import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberCriteria} from 'src/app/controller/criteria/collaborator/MemberCriteria.model';


import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';

@Component({
  selector: 'app-member-edit-admin',
  templateUrl: './member-edit-admin.component.html'
})
export class MemberEditAdminComponent extends AbstractEditController<MemberDto, MemberCriteria, MemberAdminService>   implements OnInit {



    private _validCollaboratorName = true;
    private _validCollaboratorCode = true;



    constructor( private memberService: MemberAdminService , private collaboratorService: CollaboratorAdminService) {
        super(memberService);
    }

    ngOnInit(): void {
        this.collaborator = new CollaboratorDto();
        this.collaboratorService.findAll().subscribe((data) => this.collaborators = data);
    }


    public override setValidation(value: boolean){
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateCollaborator(collaborator: string) {
        const isPermistted = await this.roleService.isPermitted('Collaborator', 'edit');
        if (isPermistted) {
             this.collaborator = new CollaboratorDto();
             this.createCollaboratorDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
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
}
