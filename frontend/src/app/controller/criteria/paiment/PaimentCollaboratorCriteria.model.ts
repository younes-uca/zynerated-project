import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CollaboratorCriteria} from '../collaborator/CollaboratorCriteria.model';
import {CouponCriteria} from '../coupon/CouponCriteria.model';
import {PaimentCollaboratorStateCriteria} from '../project/PaimentCollaboratorStateCriteria.model';

export class PaimentCollaboratorCriteria  extends BaseCriteria  {

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
  public collaborator: CollaboratorCriteria ;
  public collaborators: Array<CollaboratorCriteria> ;
  public coupon: CouponCriteria ;
  public coupons: Array<CouponCriteria> ;
  public paimentCollaboratorState: PaimentCollaboratorStateCriteria ;
  public paimentCollaboratorStates: Array<PaimentCollaboratorStateCriteria> ;

}
