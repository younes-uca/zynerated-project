import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-paiment-collaborator-edit-admin',
  templateUrl: './paiment-collaborator-edit-admin.component.html'
})
export class PaimentCollaboratorEditAdminComponent extends AbstractEditController<PaimentCollaboratorDto, PaimentCollaboratorCriteria, PaimentCollaboratorAdminService>   implements OnInit {


    private _validPaimentCollaboratorName = true;
    private _validPaimentCollaboratorCode = true;

    private _validCollaboratorName = true;
    private _validCollaboratorCode = true;
    private _validCouponCode = true;
    private _validCouponName = true;
    private _validPaimentCollaboratorStateCode = true;



    constructor( private paimentCollaboratorService: PaimentCollaboratorAdminService , private collaboratorService: CollaboratorAdminService, private couponService: CouponAdminService, private paimentCollaboratorStateService: PaimentCollaboratorStateAdminService) {
        super(paimentCollaboratorService);
    }

    ngOnInit(): void {
        this.collaborator = new CollaboratorDto();
        this.collaboratorService.findAll().subscribe((data) => this.collaborators = data);
        this.coupon = new CouponDto();
        this.couponService.findAll().subscribe((data) => this.coupons = data);
        this.paimentCollaboratorState = new PaimentCollaboratorStateDto();
        this.paimentCollaboratorStateService.findAll().subscribe((data) => this.paimentCollaboratorStates = data);
    }
    public override prepareEdit() {
        this.item.datePaiement = this.paimentCollaboratorService.format(this.item.datePaiement);
    }



    public override setValidation(value: boolean){
        this.validPaimentCollaboratorName = value;
        this.validPaimentCollaboratorCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaimentCollaboratorName();
        this.validatePaimentCollaboratorCode();
    }
    public validatePaimentCollaboratorName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
            this.errorMessages.push('Name non valide');
            this.validPaimentCollaboratorName = false;
        } else {
            this.validPaimentCollaboratorName = true;
        }
    }
    public validatePaimentCollaboratorCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validPaimentCollaboratorCode = false;
        } else {
            this.validPaimentCollaboratorCode = true;
        }
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
   get createCollaboratorDialog(): boolean {
       return this.collaboratorService.createDialog;
   }
  set createCollaboratorDialog(value: boolean) {
       this.collaboratorService.createDialog= value;
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
   get createPaimentCollaboratorStateDialog(): boolean {
       return this.paimentCollaboratorStateService.createDialog;
   }
  set createPaimentCollaboratorStateDialog(value: boolean) {
       this.paimentCollaboratorStateService.createDialog= value;
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
   get createCouponDialog(): boolean {
       return this.couponService.createDialog;
   }
  set createCouponDialog(value: boolean) {
       this.couponService.createDialog= value;
   }


    get validPaimentCollaboratorName(): boolean {
        return this._validPaimentCollaboratorName;
    }
    set validPaimentCollaboratorName(value: boolean) {
        this._validPaimentCollaboratorName = value;
    }
    get validPaimentCollaboratorCode(): boolean {
        return this._validPaimentCollaboratorCode;
    }
    set validPaimentCollaboratorCode(value: boolean) {
        this._validPaimentCollaboratorCode = value;
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
    get validCouponCode(): boolean {
        return this._validCouponCode;
    }
    set validCouponCode(value: boolean) {
        this._validCouponCode = value;
    }
    get validCouponName(): boolean {
        return this._validCouponName;
    }
    set validCouponName(value: boolean) {
        this._validCouponName = value;
    }
    get validPaimentCollaboratorStateCode(): boolean {
        return this._validPaimentCollaboratorStateCode;
    }
    set validPaimentCollaboratorStateCode(value: boolean) {
        this._validPaimentCollaboratorStateCode = value;
    }
}
