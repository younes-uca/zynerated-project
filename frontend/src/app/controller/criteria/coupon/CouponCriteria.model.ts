import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {InfluencerCriteria} from './InfluencerCriteria.model';
import {PackagingCriteria} from '../packaging/PackagingCriteria.model';

export class CouponCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public dateDebut: Date;
    public dateDebutFrom: Date;
    public dateDebutTo: Date;
    public dateFin: Date;
    public dateFinFrom: Date;
    public dateFinTo: Date;
    public name: string;
    public nameLike: string;
     public pourcentageCoupon: number;
     public pourcentageCouponMin: number;
     public pourcentageCouponMax: number;
     public pourcentageInfluencer: number;
     public pourcentageInfluencerMin: number;
     public pourcentageInfluencerMax: number;
     public usingNumber: number;
     public usingNumberMin: number;
     public usingNumberMax: number;
  public packaging: PackagingCriteria ;
  public packagings: Array<PackagingCriteria> ;

}
