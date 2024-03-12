import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CouponCriteria} from '../coupon/CouponCriteria.model';
import {InfluencerCriteria} from '../coupon/InfluencerCriteria.model';
import {PaimentInfluencerStateCriteria} from '../project/PaimentInfluencerStateCriteria.model';

export class PaimentInfluencerCriteria  extends BaseCriteria  {

    public id: number;
    public name: string;
    public nameLike: string;
    public description: string;
    public descriptionLike: string;
    public code: string;
    public codeLike: string;
    public datePaiement: Date;
    public datePaiementFrom: Date;
    public datePaiementTo: Date;

}
