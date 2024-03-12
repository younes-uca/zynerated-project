import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { LayoutService } from './service/app.layout.service';
import {RoleService} from "../zynerator/security/controller/service/Role.service";
import {AppComponent} from "../app.component";
import {AuthService} from "../zynerator/security/controller/service/Auth.service";
import {Router} from "@angular/router";
import {AppLayoutComponent} from "./app.layout.component";

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html'
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelanonymous: any[];
    modelAdmin: any[];
constructor(public layoutService: LayoutService, public app: AppComponent, public appMain: AppLayoutComponent, private roleService: RoleService, private authService: AuthService, private router: Router) { }
  ngOnInit() {
    this.modelAdmin =
      [

				{
                    label: 'Pages',
                    icon: 'pi pi-fw pi-briefcase',
                    items: [
					  {
						label: 'Coupon',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste coupon',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/coupon/coupon/list']
								  },
								  {
									label: 'Liste influencer',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/coupon/influencer/list']
								  },
						]
					  },
					  {
						label: 'Project',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste paiment collaborator state',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/project/paiment-collaborator-state/list']
								  },
								  {
									label: 'Liste project',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/project/project/list']
								  },
								  {
									label: 'Liste project state',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/project/project-state/list']
								  },
								  {
									label: 'Liste paiment influencer state',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/project/paiment-influencer-state/list']
								  },
						]
					  },
					  {
						label: 'Collaborator',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste collaborator',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/collaborator/collaborator/list']
								  },
						]
					  },
					  {
						label: 'Category',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste category packaging',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/category/category-packaging/list']
								  },
						]
					  },
					  {
						label: 'Inscription',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste inscription collaborator',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/inscription/inscription-collaborator/list']
								  },
								  {
									label: 'Liste inscription state',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/inscription/inscription-state/list']
								  },
						]
					  },
					  {
						label: 'Paiment',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste paiment influencer',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/paiment/paiment-influencer/list']
								  },
								  {
									label: 'Liste paiment collaborator',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/paiment/paiment-collaborator/list']
								  },
						]
					  },
					  {
						label: 'Packaging',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste packaging',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/packaging/packaging/list']
								  },
						]
					  },
					  {
						label: 'Member',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste member',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/collaborator/member/list']
								  },
						]
					  },
					  {
						label: 'Template',
						icon: 'pi pi-wallet',
						items: [
								  {
									label: 'Liste sub domain template',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/template/sub-domain-template/list']
								  },
								  {
									label: 'Liste category project template',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/template/category-project-template/list']
								  },
								  {
									label: 'Liste domain template',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/template/domain-template/list']
								  },
								  {
									label: 'Liste project template',
									icon: 'pi pi-fw pi-plus-circle',
									routerLink: ['/app/admin/template/project-template/list']
								  },
						]
					  },

				   {
					  label: 'Security Management',
					  icon: 'pi pi-wallet',
					  items: [
						  {
							  label: 'List User',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/user/list']
						  },
						  {
							  label: 'List Model',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/model-permission/list']
						  },
						  {
							  label: 'List Action Permission',
							  icon: 'pi pi-fw pi-plus-circle',
							  routerLink: ['/app/admin/security/action-permission/list']
						  },
					  ]
				  }
			]
	    }
    ];
        if (this.authService.authenticated) {
            if (this.authService.authenticatedUser.roleUsers) {
              this.authService.authenticatedUser.roleUsers.forEach(role => {
                  const roleName: string = this.getRole(role.role.authority);
                  this.roleService._role.next(roleName.toUpperCase());
                  eval('this.model = this.model' + this.getRole(role.role.authority));
              })
            }
        }
  }

    getRole(text){
        const [role, ...rest] = text.split('_');
        return this.upperCaseFirstLetter(rest.join(''));
    }

    upperCaseFirstLetter(word: string) {
      if (!word) { return word; }
      return word[0].toUpperCase() + word.substr(1).toLowerCase();
    }

    onMenuClick(event) {
        this.appMain.onMenuClick(event);
    }
}
