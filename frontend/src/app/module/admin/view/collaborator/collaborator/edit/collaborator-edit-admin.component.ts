import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';
import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorCriteria} from 'src/app/controller/criteria/collaborator/CollaboratorCriteria.model';


import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberAdminService} from 'src/app/controller/service/admin/collaborator/MemberAdmin.service';

@Component({
  selector: 'app-collaborator-edit-admin',
  templateUrl: './collaborator-edit-admin.component.html'
})
export class CollaboratorEditAdminComponent extends AbstractEditController<CollaboratorDto, CollaboratorCriteria, CollaboratorAdminService>   implements OnInit {


    private _validCollaboratorName = true;
    private _validCollaboratorCode = true;

    private _validPackagingCode = true;



    constructor( private collaboratorService: CollaboratorAdminService , private packagingService: PackagingAdminService, private memberService: MemberAdminService) {
        super(collaboratorService);
    }

    ngOnInit(): void {
        this.packaging = new PackagingDto();
        this.packagingService.findAll().subscribe((data) => this.packagings = data);
        this.member = new MemberDto();
        this.memberService.findAll().subscribe((data) => this.members = data);
    }


    public override setValidation(value: boolean){
        this.validCollaboratorName = value;
        this.validCollaboratorCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCollaboratorName();
        this.validateCollaboratorCode();
    }
    public validateCollaboratorName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
            this.errorMessages.push('Name non valide');
            this.validCollaboratorName = false;
        } else {
            this.validCollaboratorName = true;
        }
    }
    public validateCollaboratorCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validCollaboratorCode = false;
        } else {
            this.validCollaboratorCode = true;
        }
    }



   public async openCreateMember(member: string) {
        const isPermistted = await this.roleService.isPermitted('Member', 'edit');
        if (isPermistted) {
             this.member = new MemberDto();
             this.createMemberDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
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
   get createMemberDialog(): boolean {
       return this.memberService.createDialog;
   }
  set createMemberDialog(value: boolean) {
       this.memberService.createDialog= value;
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

    get validPackagingCode(): boolean {
        return this._validPackagingCode;
    }
    set validPackagingCode(value: boolean) {
        this._validPackagingCode = value;
    }
}
