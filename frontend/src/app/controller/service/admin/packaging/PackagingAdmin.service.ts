import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {PackagingDto} from 'src/app/controller/model/packaging/Packaging.model';
import {PackagingCriteria} from 'src/app/controller/criteria/packaging/PackagingCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PackagingAdminService extends AbstractService<PackagingDto, PackagingCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/packaging/');
    }

    public constrcutDto(): PackagingDto {
        return new PackagingDto();
    }

    public constrcutCriteria(): PackagingCriteria {
        return new PackagingCriteria();
    }
}
