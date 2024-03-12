import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaimentInfluencerAdminService} from 'src/app/controller/service/admin/paiment/PaimentInfluencerAdmin.service';
import {PaimentInfluencerDto} from 'src/app/controller/model/paiment/PaimentInfluencer.model';
import {PaimentInfluencerCriteria} from 'src/app/controller/criteria/paiment/PaimentInfluencerCriteria.model';
import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponAdminService} from 'src/app/controller/service/admin/coupon/CouponAdmin.service';
import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerAdminService} from 'src/app/controller/service/admin/coupon/InfluencerAdmin.service';
import {PaimentInfluencerStateDto} from 'src/app/controller/model/project/PaimentInfluencerState.model';
import {PaimentInfluencerStateAdminService} from 'src/app/controller/service/admin/project/PaimentInfluencerStateAdmin.service';
@Component({
  selector: 'app-paiment-influencer-create-admin',
  templateUrl: './paiment-influencer-create-admin.component.html'
})
export class PaimentInfluencerCreateAdminComponent extends AbstractCreateController<PaimentInfluencerDto, PaimentInfluencerCriteria, PaimentInfluencerAdminService>  implements OnInit {



   private _validPaimentInfluencerName = true;
   private _validPaimentInfluencerCode = true;
    private _validInfluencerNickName = true;
    private _validCouponCode = true;
    private _validCouponName = true;
    private _validPaimentInfluencerStateCode = true;

    constructor( private paimentInfluencerService: PaimentInfluencerAdminService , private couponService: CouponAdminService, private influencerService: InfluencerAdminService, private paimentInfluencerStateService: PaimentInfluencerStateAdminService) {
        super(paimentInfluencerService);
    }

    ngOnInit(): void {
        this.influencer = new InfluencerDto();
        this.influencerService.findAll().subscribe((data) => this.influencers = data);
        this.coupon = new CouponDto();
        this.couponService.findAll().subscribe((data) => this.coupons = data);
        this.paimentInfluencerState = new PaimentInfluencerStateDto();
        this.paimentInfluencerStateService.findAll().subscribe((data) => this.paimentInfluencerStates = data);
    }





    public override setValidation(value: boolean){
        this.validPaimentInfluencerName = value;
        this.validPaimentInfluencerCode = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaimentInfluencerName();
        this.validatePaimentInfluencerCode();
    }

    public validatePaimentInfluencerName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
        this.errorMessages.push('Name non valide');
        this.validPaimentInfluencerName = false;
        } else {
            this.validPaimentInfluencerName = true;
        }
    }
    public validatePaimentInfluencerCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validPaimentInfluencerCode = false;
        } else {
            this.validPaimentInfluencerCode = true;
        }
    }



    get influencer(): InfluencerDto {
        return this.influencerService.item;
    }
    set influencer(value: InfluencerDto) {
        this.influencerService.item = value;
    }
    get influencers(): Array<InfluencerDto> {
        return this.influencerService.items;
    }
    set influencers(value: Array<InfluencerDto>) {
        this.influencerService.items = value;
    }
    get createInfluencerDialog(): boolean {
       return this.influencerService.createDialog;
    }
    set createInfluencerDialog(value: boolean) {
        this.influencerService.createDialog= value;
    }
    get paimentInfluencerState(): PaimentInfluencerStateDto {
        return this.paimentInfluencerStateService.item;
    }
    set paimentInfluencerState(value: PaimentInfluencerStateDto) {
        this.paimentInfluencerStateService.item = value;
    }
    get paimentInfluencerStates(): Array<PaimentInfluencerStateDto> {
        return this.paimentInfluencerStateService.items;
    }
    set paimentInfluencerStates(value: Array<PaimentInfluencerStateDto>) {
        this.paimentInfluencerStateService.items = value;
    }
    get createPaimentInfluencerStateDialog(): boolean {
       return this.paimentInfluencerStateService.createDialog;
    }
    set createPaimentInfluencerStateDialog(value: boolean) {
        this.paimentInfluencerStateService.createDialog= value;
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



    get validPaimentInfluencerName(): boolean {
        return this._validPaimentInfluencerName;
    }

    set validPaimentInfluencerName(value: boolean) {
         this._validPaimentInfluencerName = value;
    }
    get validPaimentInfluencerCode(): boolean {
        return this._validPaimentInfluencerCode;
    }

    set validPaimentInfluencerCode(value: boolean) {
         this._validPaimentInfluencerCode = value;
    }

    get validInfluencerNickName(): boolean {
        return this._validInfluencerNickName;
    }
    set validInfluencerNickName(value: boolean) {
        this._validInfluencerNickName = value;
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
    get validPaimentInfluencerStateCode(): boolean {
        return this._validPaimentInfluencerStateCode;
    }
    set validPaimentInfluencerStateCode(value: boolean) {
        this._validPaimentInfluencerStateCode = value;
    }


}
