import {Component, OnInit} from '@angular/core';
import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';
import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorCriteria} from 'src/app/controller/criteria/collaborator/CollaboratorCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberAdminService} from 'src/app/controller/service/admin/collaborator/MemberAdmin.service';


@Component({
  selector: 'app-collaborator-list-admin',
  templateUrl: './collaborator-list-admin.component.html'
})
export class CollaboratorListAdminComponent extends AbstractListController<CollaboratorDto, CollaboratorCriteria, CollaboratorAdminService>  implements OnInit {

    override fileName = 'Collaborator';


     yesOrNoCredentialsNonExpired: any[] = [];
     yesOrNoEnabled: any[] = [];
     yesOrNoAccountNonExpired: any[] = [];
     yesOrNoAccountNonLocked: any[] = [];
     yesOrNoPasswordChanged: any[] = [];
    packagings: Array<PackagingDto>;
    members: Array<MemberDto>;


    constructor( private collaboratorService: CollaboratorAdminService  , private packagingService: PackagingAdminService, private memberService: MemberAdminService) {
        super(collaboratorService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Collaborator').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadPackaging();
                this.loadMember();
                this.yesOrNoCredentialsNonExpired =  [{label: 'CredentialsNonExpired', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
                this.yesOrNoEnabled =  [{label: 'Enabled', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
                this.yesOrNoAccountNonExpired =  [{label: 'AccountNonExpired', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
                this.yesOrNoAccountNonLocked =  [{label: 'AccountNonLocked', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
                this.yesOrNoPasswordChanged =  [{label: 'PasswordChanged', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'name', header: 'Name'},
            {field: 'code', header: 'Code'},
            {field: 'packaging?.id', header: 'Packaging'},
            {field: 'member?.id', header: 'Member'},
            {field: 'credentialsNonExpired', header: 'Credentials non expired'},
            {field: 'enabled', header: 'Enabled'},
            {field: 'accountNonExpired', header: 'Account non expired'},
            {field: 'accountNonLocked', header: 'Account non locked'},
            {field: 'passwordChanged', header: 'Password changed'},
            {field: 'username', header: 'Username'},
            {field: 'password', header: 'Password'},
        ];
    }


    public async loadPackaging(){
       this.packagingService.findAll().subscribe(packagings => this.packagings = packagings, error => console.log(error))
    }
    public async loadMember(){
       this.memberService.findAll().subscribe(members => this.members = members, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Name': e.name ,
                 'Code': e.code ,
                'Packaging': e.packaging?.id ,
                'Member': e.member?.id ,
                'Credentials non expired': e.credentialsNonExpired? 'Vrai' : 'Faux' ,
                'Enabled': e.enabled? 'Vrai' : 'Faux' ,
                'Account non expired': e.accountNonExpired? 'Vrai' : 'Faux' ,
                'Account non locked': e.accountNonLocked? 'Vrai' : 'Faux' ,
                'Password changed': e.passwordChanged? 'Vrai' : 'Faux' ,
                 'Username': e.username ,
                 'Password': e.password ,
            }
        });

        this.criteriaData = [{
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Packaging': this.criteria.packaging?.id ? this.criteria.packaging?.id : environment.emptyForExport ,
        //'Member': this.criteria.member?.id ? this.criteria.member?.id : environment.emptyForExport ,
            'Credentials non expired': this.criteria.credentialsNonExpired ? (this.criteria.credentialsNonExpired ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Enabled': this.criteria.enabled ? (this.criteria.enabled ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Account non expired': this.criteria.accountNonExpired ? (this.criteria.accountNonExpired ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Account non locked': this.criteria.accountNonLocked ? (this.criteria.accountNonLocked ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Password changed': this.criteria.passwordChanged ? (this.criteria.passwordChanged ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Username': this.criteria.username ? this.criteria.username : environment.emptyForExport ,
            'Password': this.criteria.password ? this.criteria.password : environment.emptyForExport ,
        }];
      }
}
