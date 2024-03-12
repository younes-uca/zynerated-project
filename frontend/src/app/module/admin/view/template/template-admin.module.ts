import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';
import {CardModule} from "primeng/card";

import { SubDomainTemplateCreateAdminComponent } from './sub-domain-template/create/sub-domain-template-create-admin.component';
import { SubDomainTemplateEditAdminComponent } from './sub-domain-template/edit/sub-domain-template-edit-admin.component';
import { SubDomainTemplateViewAdminComponent } from './sub-domain-template/view/sub-domain-template-view-admin.component';
import { SubDomainTemplateListAdminComponent } from './sub-domain-template/list/sub-domain-template-list-admin.component';
import { CategoryProjectTemplateCreateAdminComponent } from './category-project-template/create/category-project-template-create-admin.component';
import { CategoryProjectTemplateEditAdminComponent } from './category-project-template/edit/category-project-template-edit-admin.component';
import { CategoryProjectTemplateViewAdminComponent } from './category-project-template/view/category-project-template-view-admin.component';
import { CategoryProjectTemplateListAdminComponent } from './category-project-template/list/category-project-template-list-admin.component';
import { DomainTemplateCreateAdminComponent } from './domain-template/create/domain-template-create-admin.component';
import { DomainTemplateEditAdminComponent } from './domain-template/edit/domain-template-edit-admin.component';
import { DomainTemplateViewAdminComponent } from './domain-template/view/domain-template-view-admin.component';
import { DomainTemplateListAdminComponent } from './domain-template/list/domain-template-list-admin.component';
import { ProjectTemplateCreateAdminComponent } from './project-template/create/project-template-create-admin.component';
import { ProjectTemplateEditAdminComponent } from './project-template/edit/project-template-edit-admin.component';
import { ProjectTemplateViewAdminComponent } from './project-template/view/project-template-view-admin.component';
import { ProjectTemplateListAdminComponent } from './project-template/list/project-template-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    SubDomainTemplateCreateAdminComponent,
    SubDomainTemplateListAdminComponent,
    SubDomainTemplateViewAdminComponent,
    SubDomainTemplateEditAdminComponent,
    CategoryProjectTemplateCreateAdminComponent,
    CategoryProjectTemplateListAdminComponent,
    CategoryProjectTemplateViewAdminComponent,
    CategoryProjectTemplateEditAdminComponent,
    DomainTemplateCreateAdminComponent,
    DomainTemplateListAdminComponent,
    DomainTemplateViewAdminComponent,
    DomainTemplateEditAdminComponent,
    ProjectTemplateCreateAdminComponent,
    ProjectTemplateListAdminComponent,
    ProjectTemplateViewAdminComponent,
    ProjectTemplateEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,
    CardModule,

  ],
  exports: [
  SubDomainTemplateCreateAdminComponent,
  SubDomainTemplateListAdminComponent,
  SubDomainTemplateViewAdminComponent,
  SubDomainTemplateEditAdminComponent,
  CategoryProjectTemplateCreateAdminComponent,
  CategoryProjectTemplateListAdminComponent,
  CategoryProjectTemplateViewAdminComponent,
  CategoryProjectTemplateEditAdminComponent,
  DomainTemplateCreateAdminComponent,
  DomainTemplateListAdminComponent,
  DomainTemplateViewAdminComponent,
  DomainTemplateEditAdminComponent,
  ProjectTemplateCreateAdminComponent,
  ProjectTemplateListAdminComponent,
  ProjectTemplateViewAdminComponent,
  ProjectTemplateEditAdminComponent,
  ],
})
export class TemplateAdminModule { }
