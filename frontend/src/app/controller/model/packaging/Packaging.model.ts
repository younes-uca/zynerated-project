import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CategoryPackagingDto} from '../category/CategoryPackaging.model';

export class PackagingDto extends BaseDto{

    public code: string;

    public description: string;

   public dateDebut: Date;

   public dateFin: Date;

    public price: null | number;

    public maxProject: null | number;

    public categoryPackaging: CategoryPackagingDto ;
    

    constructor() {
        super();

        this.code = '';
        this.description = '';
        this.dateDebut = null;
        this.dateFin = null;
        this.price = null;
        this.maxProject = null;

        }

}
