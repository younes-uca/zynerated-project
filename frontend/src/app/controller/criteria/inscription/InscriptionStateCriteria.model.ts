import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class InscriptionStateCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public name: string;
    public nameLike: string;

}
