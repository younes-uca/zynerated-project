import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CouponAdminService} from 'src/app/controller/service/admin/coupon/CouponAdmin.service';
import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponCriteria} from 'src/app/controller/criteria/coupon/CouponCriteria.model';
import {InfluencerDto} from 'src/app/controller/model/coupon/Influencer.model';
import {InfluencerAdminService} from 'src/app/controller/service/admin/coupon/InfluencerAdmin.service';
import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingAdminService} from 'src/app/controller/service/admin/packaging/PackagingAdmin.service';
@Component({
  selector: 'app-coupon-create-admin',
  templateUrl: './coupon-create-admin.component.html'
})
export class CouponCreateAdminComponent extends AbstractCreateController<CouponDto, CouponCriteria, CouponAdminService>  implements OnInit {



   private _validCouponCode = true;
   private _validCouponName = true;
    private _validPackagingCode = true;
    private _validInfluencerNickName = true;

    constructor( private couponService: CouponAdminService , private influencerService: InfluencerAdminService, private packagingService: PackagingAdminService) {
        super(couponService);
    }

    ngOnInit(): void {
        this.packaging = new PackagingDto();
        this.packagingService.findAll().subscribe((data) => this.packagings = data);
        this.influencer = new InfluencerDto();
        this.influencerService.findAll().subscribe((data) => this.influencers = data);
    }





    public override setValidation(value: boolean){
        this.validCouponCode = value;
        this.validCouponName = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCouponCode();
        this.validateCouponName();
    }

    public validateCouponCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validCouponCode = false;
        } else {
            this.validCouponCode = true;
        }
    }
    public validateCouponName(){
        if (this.stringUtilService.isEmpty(this.item.name)) {
        this.errorMessages.push('Name non valide');
        this.validCouponName = false;
        } else {
            this.validCouponName = true;
        }
    }


    public async openCreateInfluencer(influencer: string) {
    const isPermistted = await this.roleService.isPermitted('Influencer', 'add');
    if(isPermistted) {
         this.influencer = new InfluencerDto();
         this.createInfluencerDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
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
    get packaging(): PackagingDto {
        return this.packagingService.item;
    }
    set packaging(value: PackagingDto) {
        this.packagingService.item = value;
    }
    get packagings(): Array<PackagingDto> {
        return this.packagingService.items;
    }
    set packagings(value: Array<PackagingDto>) {
        this.packagingService.items = value;
    }
    get createPackagingDialog(): boolean {
       return this.packagingService.createDialog;
    }
    set createPackagingDialog(value: boolean) {
        this.packagingService.createDialog= value;
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

    get validPackagingCode(): boolean {
        return this._validPackagingCode;
    }
    set validPackagingCode(value: boolean) {
        this._validPackagingCode = value;
    }
    get validInfluencerNickName(): boolean {
        return this._validInfluencerNickName;
    }
    set validInfluencerNickName(value: boolean) {
        this._validInfluencerNickName = value;
    }


}
