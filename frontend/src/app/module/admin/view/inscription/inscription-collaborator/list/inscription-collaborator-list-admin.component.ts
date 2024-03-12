import {Component, OnInit} from '@angular/core';
import {InscriptionCollaboratorAdminService} from 'src/app/controller/service/admin/inscription/InscriptionCollaboratorAdmin.service';
import {InscriptionCollaboratorDto} from 'src/app/controller/model/inscription/InscriptionCollaborator.model';
import {InscriptionCollaboratorCriteria} from 'src/app/controller/criteria/inscription/InscriptionCollaboratorCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';
import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
import {InscriptionStateDto} from 'src/app/controller/model/inscription/InscriptionState.model';
import {InscriptionStateAdminService} from 'src/app/controller/service/admin/inscription/InscriptionStateAdmin.service';


@Component({
  selector: 'app-inscription-collaborator-list-admin',
  templateUrl: './inscription-collaborator-list-admin.component.html'
})
export class InscriptionCollaboratorListAdminComponent extends AbstractListController<InscriptionCollaboratorDto, InscriptionCollaboratorCriteria, InscriptionCollaboratorAdminService>  implements OnInit {

    override fileName = 'InscriptionCollaborator';


    packagings: Array<PackagingDto>;
    collaborators: Array<CollaboratorDto>;
    inscriptionStates: Array<InscriptionStateDto>;


    constructor( private inscriptionCollaboratorService: InscriptionCollaboratorAdminService  , private collaboratorService: CollaboratorAdminService, private packagingService: PackagingAdminService, private inscriptionStateService: InscriptionStateAdminService) {
        super(inscriptionCollaboratorService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('InscriptionCollaborator').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadPackaging();
                this.loadCollaborator();
                this.loadInscriptionState();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'inscriptionDate', header: 'Inscription date'},
            {field: 'renewDate', header: 'Renew date'},
            {field: 'packaging?.id', header: 'Packaging'},
            {field: 'collaborator?.name', header: 'Collaborator'},
            {field: 'inscriptionState?.name', header: 'Inscription state'},
        ];
    }


    public async loadPackaging(){
       this.packagingService.findAll().subscribe(packagings => this.packagings = packagings, error => console.log(error))
    }
    public async loadCollaborator(){
       this.collaboratorService.findAllOptimized().subscribe(collaborators => this.collaborators = collaborators, error => console.log(error))
    }
    public async loadInscriptionState(){
       this.inscriptionStateService.findAllOptimized().subscribe(inscriptionStates => this.inscriptionStates = inscriptionStates, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Inscription date': this.datePipe.transform(e.inscriptionDate , 'dd/MM/yyyy hh:mm'),
                'Renew date': this.datePipe.transform(e.renewDate , 'dd/MM/yyyy hh:mm'),
                'Packaging': e.packaging?.id ,
                'Collaborator': e.collaborator?.name ,
                'Inscription state': e.inscriptionState?.name ,
            }
        });

        this.criteriaData = [{
            'Inscription date Min': this.criteria.inscriptionDateFrom ? this.datePipe.transform(this.criteria.inscriptionDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Inscription date Max': this.criteria.inscriptionDateTo ? this.datePipe.transform(this.criteria.inscriptionDateTo , this.dateFormat) : environment.emptyForExport ,
            'Renew date Min': this.criteria.renewDateFrom ? this.datePipe.transform(this.criteria.renewDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Renew date Max': this.criteria.renewDateTo ? this.datePipe.transform(this.criteria.renewDateTo , this.dateFormat) : environment.emptyForExport ,
        //'Packaging': this.criteria.packaging?.id ? this.criteria.packaging?.id : environment.emptyForExport ,
        //'Collaborator': this.criteria.collaborator?.name ? this.criteria.collaborator?.name : environment.emptyForExport ,
        //'Inscription state': this.criteria.inscriptionState?.name ? this.criteria.inscriptionState?.name : environment.emptyForExport ,
        }];
      }
}
