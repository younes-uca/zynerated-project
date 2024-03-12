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

import { InscriptionCollaboratorCreateAdminComponent } from './inscription-collaborator/create/inscription-collaborator-create-admin.component';
import { InscriptionCollaboratorEditAdminComponent } from './inscription-collaborator/edit/inscription-collaborator-edit-admin.component';
import { InscriptionCollaboratorViewAdminComponent } from './inscription-collaborator/view/inscription-collaborator-view-admin.component';
import { InscriptionCollaboratorListAdminComponent } from './inscription-collaborator/list/inscription-collaborator-list-admin.component';
import { InscriptionStateCreateAdminComponent } from './inscription-state/create/inscription-state-create-admin.component';
import { InscriptionStateEditAdminComponent } from './inscription-state/edit/inscription-state-edit-admin.component';
import { InscriptionStateViewAdminComponent } from './inscription-state/view/inscription-state-view-admin.component';
import { InscriptionStateListAdminComponent } from './inscription-state/list/inscription-state-list-admin.component';

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

    InscriptionCollaboratorCreateAdminComponent,
    InscriptionCollaboratorListAdminComponent,
    InscriptionCollaboratorViewAdminComponent,
    InscriptionCollaboratorEditAdminComponent,
    InscriptionStateCreateAdminComponent,
    InscriptionStateListAdminComponent,
    InscriptionStateViewAdminComponent,
    InscriptionStateEditAdminComponent,
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
  InscriptionCollaboratorCreateAdminComponent,
  InscriptionCollaboratorListAdminComponent,
  InscriptionCollaboratorViewAdminComponent,
  InscriptionCollaboratorEditAdminComponent,
  InscriptionStateCreateAdminComponent,
  InscriptionStateListAdminComponent,
  InscriptionStateViewAdminComponent,
  InscriptionStateEditAdminComponent,
  ],
})
export class InscriptionAdminModule { }
