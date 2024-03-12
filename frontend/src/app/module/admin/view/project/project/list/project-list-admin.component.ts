import {Component, OnInit} from '@angular/core';
import {ProjectAdminService} from 'src/app/controller/service/admin/project/ProjectAdmin.service';
import {ProjectDto} from 'src/app/controller/model/project/Project.model';
import {ProjectCriteria} from 'src/app/controller/criteria/project/ProjectCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ProjectStateDto} from 'src/app/controller/model/project/ProjectState.model';
import {ProjectStateAdminService} from 'src/app/controller/service/admin/project/ProjectStateAdmin.service';
import {MemberDto} from 'src/app/controller/model/collaborator/Member.model';
import {MemberAdminService} from 'src/app/controller/service/admin/collaborator/MemberAdmin.service';


@Component({
  selector: 'app-project-list-admin',
  templateUrl: './project-list-admin.component.html'
})
export class ProjectListAdminComponent extends AbstractListController<ProjectDto, ProjectCriteria, ProjectAdminService>  implements OnInit {

    override fileName = 'Project';


    owners: Array<MemberDto>;
    projectStates: Array<ProjectStateDto>;


    constructor( private projectService: ProjectAdminService  , private projectStateService: ProjectStateAdminService, private memberService: MemberAdminService) {
        super(projectService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Project').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadOwner();
                this.loadProjectState();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'name', header: 'Name'},
            {field: 'generatedDate', header: 'Generated date'},
            {field: 'owner?.id', header: 'Owner'},
            {field: 'projectState?.code', header: 'Project state'},
        ];
    }


    public async loadOwner(){
       this.memberService.findAll().subscribe(owners => this.owners = owners, error => console.log(error))
    }
    public async loadProjectState(){
       this.projectStateService.findAllOptimized().subscribe(projectStates => this.projectStates = projectStates, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Name': e.name ,
                'Generated date': this.datePipe.transform(e.generatedDate , 'dd/MM/yyyy hh:mm'),
                 'Yaml': e.yaml ,
                'Owner': e.owner?.id ,
                'Project state': e.projectState?.code ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Generated date Min': this.criteria.generatedDateFrom ? this.datePipe.transform(this.criteria.generatedDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Generated date Max': this.criteria.generatedDateTo ? this.datePipe.transform(this.criteria.generatedDateTo , this.dateFormat) : environment.emptyForExport ,
            'Yaml': this.criteria.yaml ? this.criteria.yaml : environment.emptyForExport ,
        //'Owner': this.criteria.owner?.id ? this.criteria.owner?.id : environment.emptyForExport ,
        //'Project state': this.criteria.projectState?.code ? this.criteria.projectState?.code : environment.emptyForExport ,
        }];
      }
}
