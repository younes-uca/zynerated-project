import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PackagingDto} from '../packaging/Packaging.model';
import {MemberDto} from './Member.model';

export class CollaboratorDto extends BaseDto{

    public name: string;

    public code: string;

   public credentialsNonExpired: null | boolean;

   public enabled: null | boolean;

   public accountNonExpired: null | boolean;

   public accountNonLocked: null | boolean;

   public passwordChanged: null | boolean;

    public username: string;

    public password: string;

    public packaging: PackagingDto ;
    public member: MemberDto ;
    

    constructor() {
        super();

        this.name = '';
        this.code = '';
        this.credentialsNonExpired = null;
        this.enabled = null;
        this.accountNonExpired = null;
        this.accountNonLocked = null;
        this.passwordChanged = null;
        this.username = '';
        this.password = '';
        this.packaging = new PackagingDto() ;
        this.member = new MemberDto() ;

        }

}
