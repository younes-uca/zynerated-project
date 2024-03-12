import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {InfluencerDto} from './Influencer.model';
import {PackagingDto} from '../packaging/Packaging.model';

export class CouponDto extends BaseDto{

    public code: string;

   public dateDebut: Date;

   public dateFin: Date;

    public name: string;

    public pourcentageCoupon: null | number;

    public pourcentageInfluencer: null | number;

    public usingNumber: null | number;

    public packaging: PackagingDto ;
    public influencer: InfluencerDto ;
    

    constructor() {
        super();

        this.code = '';
        this.dateDebut = null;
        this.dateFin = null;
        this.name = '';
        this.pourcentageCoupon = null;
        this.pourcentageInfluencer = null;
        this.usingNumber = null;
        this.packaging = new PackagingDto() ;

        }

}
