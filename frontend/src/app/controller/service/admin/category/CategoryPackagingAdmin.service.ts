import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CategoryPackagingDto} from 'src/app/controller/model/category/CategoryPackaging.model';
import {CategoryPackagingCriteria} from 'src/app/controller/criteria/category/CategoryPackagingCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategoryPackagingAdminService extends AbstractService<CategoryPackagingDto, CategoryPackagingCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/categoryPackaging/');
    }

    public constrcutDto(): CategoryPackagingDto {
        return new CategoryPackagingDto();
    }

    public constrcutCriteria(): CategoryPackagingCriteria {
        return new CategoryPackagingCriteria();
    }
}
