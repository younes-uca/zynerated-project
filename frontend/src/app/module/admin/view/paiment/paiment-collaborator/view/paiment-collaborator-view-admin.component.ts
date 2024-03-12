import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaimentCollaboratorAdminService} from 'src/app/controller/service/admin/paiment/PaimentCollaboratorAdmin.service';
import {PaimentCollaboratorDto} from 'src/app/controller/model/paiment/PaimentCollaborator.model';
import {PaimentCollaboratorCriteria} from 'src/app/controller/criteria/paiment/PaimentCollaboratorCriteria.model';

import {CollaboratorDto} from 'src/app/controller/model/collaborator/Collaborator.model';
import {CollaboratorAdminService} from 'src/app/controller/service/admin/collaborator/CollaboratorAdmin.service';
import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponAdminService} from 'src/app/controller/service/admin/coupon/CouponAdmin.service';
import {PaimentCollaboratorStateDto} from 'src/app/controller/model/project/PaimentCollaboratorState.model';
import {PaimentCollaboratorStateAdminService} from 'src/app/controller/service/admin/project/PaimentCollaboratorStateAdmin.service';
@Component({
  selector: 'app-paiment-collaborator-view-admin',
  templateUrl: './paiment-collaborator-view-admin.component.html'
})
export class PaimentCollaboratorViewAdminComponent extends AbstractViewController<PaimentCollaboratorDto, PaimentCollaboratorCriteria, PaimentCollaboratorAdminService> implements OnInit {


    constructor(private paimentCollaboratorService: PaimentCollaboratorAdminService, private collaboratorService: CollaboratorAdminService, private couponService: CouponAdminService, private paimentCollaboratorStateService: PaimentCollaboratorStateAdminService){
        super(paimentCollaboratorService);
    }

    ngOnInit(): void {
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
    get paimentCollaboratorState(): PaimentCollaboratorStateDto {
       return this.paimentCollaboratorStateService.item;
    }
    set paimentCollaboratorState(value: PaimentCollaboratorStateDto) {
        this.paimentCollaboratorStateService.item = value;
    }
    get paimentCollaboratorStates(): Array<PaimentCollaboratorStateDto> {
       return this.paimentCollaboratorStateService.items;
    }
    set paimentCollaboratorStates(value: Array<PaimentCollaboratorStateDto>) {
        this.paimentCollaboratorStateService.items = value;
    }
    get coupon(): CouponDto {
       return this.couponService.item;
    }
    set coupon(value: CouponDto) {
        this.couponService.item = value;
    }
    get coupons(): Array<CouponDto> {
       return this.couponService.items;
    }
    set coupons(value: Array<CouponDto>) {
        this.couponService.items = value;
    }


}
