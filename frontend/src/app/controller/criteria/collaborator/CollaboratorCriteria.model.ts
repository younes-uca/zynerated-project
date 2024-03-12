import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {PackagingCriteria} from '../packaging/PackagingCriteria.model';
import {MemberCriteria} from './MemberCriteria.model';

export class CollaboratorCriteria  extends BaseCriteria  {

    public name: string;
    public nameLike: string;
    public code: string;
    public codeLike: string;
    public credentialsNonExpired: null | boolean;
    public enabled: null | boolean;
    public accountNonExpired: null | boolean;
    public accountNonLocked: null | boolean;
    public passwordChanged: null | boolean;
    public username: string;
    public usernameLike: string;
    public password: string;
    public passwordLike: string;
  public packaging: PackagingCriteria ;
  public packagings: Array<PackagingCriteria> ;
  public member: MemberCriteria ;
  public members: Array<MemberCriteria> ;

}
