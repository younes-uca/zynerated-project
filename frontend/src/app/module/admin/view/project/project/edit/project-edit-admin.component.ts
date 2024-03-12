import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProjectAdminService} from 'src/app/controller/service/admin/project/ProjectAdmin.service';
import {ProjectDto} from 'src/app/controller/model/project/Project.model';
import {ProjectCriteria} from 'src/app/controller/criteria/project/ProjectCriteria.model';


import {ProjectStateDto} from 'src/app/controller/model/project/ProjectState.model';
import {ProjectStateAdminService} from 'src/app/controller/service/admin/project/ProjectStateAdmin.service';
import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberAdminService} from 'src/app/controller/service/admin/collaborator/MemberAdmin.service';

@Component({
  selector: 'app-project-edit-admin',
  templateUrl: './project-edit-admin.component.html'
})
export class ProjectEditAdminComponent extends AbstractEditController<ProjectDto, ProjectCriteria, ProjectAdminService>   implements OnInit {


    private _validProjectCode = true;

    private _validProjectStateCode = true;



    constructor( private projectService: ProjectAdminService , private projectStateService: ProjectStateAdminService, private memberService: MemberAdminService) {
        super(projectService);
    }

    ngOnInit(): void {
        this.owner = new MemberDto();
        this.memberService.findAll().subscribe((data) => this.owners = data);
        this.projectState = new ProjectStateDto();
        this.projectStateService.findAll().subscribe((data) => this.projectStates = data);
    }
    public override prepareEdit() {
        this.item.generatedDate = this.projectService.format(this.item.generatedDate);
    }



    public override setValidation(value: boolean){
        this.validProjectCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProjectCode();
    }
    public validateProjectCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validProjectCode = false;
        } else {
            this.validProjectCode = true;
        }
    }



   public async openCreateProjectState(projectState: string) {
        const isPermistted = await this.roleService.isPermitted('ProjectState', 'edit');
        if (isPermistted) {
             this.projectState = new ProjectStateDto();
             this.createProjectStateDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get owner(): MemberDto {
       return this.memberService.item;
   }
  set owner(value: MemberDto) {
        this.memberService.item = value;
   }
   get owners(): Array<MemberDto> {
        return this.memberService.items;
   }
   set owners(value: Array<MemberDto>) {
        this.memberService.items = value;
   }
   get createOwnerDialog(): boolean {
       return this.memberService.createDialog;
   }
  set createOwnerDialog(value: boolean) {
       this.memberService.createDialog= value;
   }
   get projectState(): ProjectStateDto {
       return this.projectStateService.item;
   }
  set projectState(value: ProjectStateDto) {
        this.projectStateService.item = value;
   }
   get projectStates(): Array<ProjectStateDto> {
        return this.projectStateService.items;
   }
   set projectStates(value: Array<ProjectStateDto>) {
        this.projectStateService.items = value;
   }
   get createProjectStateDialog(): boolean {
       return this.projectStateService.createDialog;
   }
  set createProjectStateDialog(value: boolean) {
       this.projectStateService.createDialog= value;
   }


    get validProjectCode(): boolean {
        return this._validProjectCode;
    }
    set validProjectCode(value: boolean) {
        this._validProjectCode = value;
    }

    get validProjectStateCode(): boolean {
        return this._validProjectStateCode;
    }
    set validProjectStateCode(value: boolean) {
        this._validProjectStateCode = value;
    }
}
