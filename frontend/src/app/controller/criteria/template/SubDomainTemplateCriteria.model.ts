import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {DomainTemplateCriteria} from './DomainTemplateCriteria.model';

export class SubDomainTemplateCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public name: string;
    public nameLike: string;

}
