
// const root = environment.rootAppUrl;



import {UserListComponent} from 'src/app/module/security/user/list/user-list.component';
import {ModelPermissionListComponent} from 'src/app/module/security/model-permission/list/model-permission-list.component';
import {ActionPermissionListComponent} from 'src/app/module/security/action-permission/list/action-permission-list.component';
import {ModelPermissionUserListComponent} from 'src/app/module/security/model-permission-utilisateur/list/model-permission-user-list.component';
import {RoleListComponent} from 'src/app/module/security/role/list/role-list.component';



import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {AuthGuard} from 'src/app/zynerator/security/guards/auth.guard';



import { SubDomainTemplateListAdminComponent } from './sub-domain-template/list/sub-domain-template-list-admin.component';
import { CategoryProjectTemplateListAdminComponent } from './category-project-template/list/category-project-template-list-admin.component';
import { DomainTemplateListAdminComponent } from './domain-template/list/domain-template-list-admin.component';
import { ProjectTemplateListAdminComponent } from './project-template/list/project-template-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {

                            path: 'action-permission',
                            children: [
                                {
                                    path: 'list',
                                    component: ActionPermissionListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'model-permission-user',
                            children: [
                                {
                                    path: 'list',
                                    component: ModelPermissionUserListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },
                        {

                            path: 'role',
                            children: [
                                {
                                    path: 'list',
                                    component: RoleListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },
                        {

                            path: 'user',
                            children: [
                                {
                                    path: 'list',
                                    component: UserListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'model-permission',
                            children: [
                                {
                                    path: 'list',
                                    component: ModelPermissionListComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },


                        {

                            path: 'sub-domain-template',
                            children: [
                                {
                                    path: 'list',
                                    component: SubDomainTemplateListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'category-project-template',
                            children: [
                                {
                                    path: 'list',
                                    component: CategoryProjectTemplateListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'domain-template',
                            children: [
                                {
                                    path: 'list',
                                    component: DomainTemplateListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'project-template',
                            children: [
                                {
                                    path: 'list',
                                    component: ProjectTemplateListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class TemplateAdminRoutingModule { }
