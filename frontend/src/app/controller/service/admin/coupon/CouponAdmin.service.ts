import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CouponDto} from 'src/app/controller/model/coupon/Coupon.model';
import {CouponCriteria} from 'src/app/controller/criteria/coupon/CouponCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CouponAdminService extends AbstractService<CouponDto, CouponCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/coupon/');
    }

    public constrcutDto(): CouponDto {
        return new CouponDto();
    }

    public constrcutCriteria(): CouponCriteria {
        return new CouponCriteria();
    }
}
