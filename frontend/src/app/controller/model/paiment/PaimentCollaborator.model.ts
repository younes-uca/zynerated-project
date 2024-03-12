import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CollaboratorDto} from '../collaborator/Collaborator.model';
import {CouponDto} from '../coupon/Coupon.model';
import {PaimentCollaboratorStateDto} from '../project/PaimentCollaboratorState.model';

export class PaimentCollaboratorDto extends BaseDto{

    public name: string;

    public description: string;

    public code: string;

   public datePaiement: Date;

    public collaborator: CollaboratorDto ;
    public coupon: CouponDto ;
    public paimentCollaboratorState: PaimentCollaboratorStateDto ;
    

    constructor() {
        super();

        this.name = '';
        this.description = '';
        this.code = '';
        this.datePaiement = null;
        this.collaborator = new CollaboratorDto() ;
        this.coupon = new CouponDto() ;
        this.paimentCollaboratorState = new PaimentCollaboratorStateDto() ;

        }

}
