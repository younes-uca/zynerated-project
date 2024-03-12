import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CategoryPackagingCriteria} from '../category/CategoryPackagingCriteria.model';

export class PackagingCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public description: string;
    public descriptionLike: string;
    public dateDebut: Date;
    public dateDebutFrom: Date;
    public dateDebutTo: Date;
    public dateFin: Date;
    public dateFinFrom: Date;
    public dateFinTo: Date;
     public price: number;
     public priceMin: number;
     public priceMax: number;
     public maxProject: number;
     public maxProjectMin: number;
     public maxProjectMax: number;

}
