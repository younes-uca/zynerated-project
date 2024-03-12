import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {SubDomainTemplateCriteria} from './SubDomainTemplateCriteria.model';
import {CategoryProjectTemplateCriteria} from './CategoryProjectTemplateCriteria.model';

export class ProjectTemplateCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public name: string;
    public nameLike: string;
    public addingDate: Date;
    public addingDateFrom: Date;
    public addingDateTo: Date;
    public lastUpdateDate: Date;
    public lastUpdateDateFrom: Date;
    public lastUpdateDateTo: Date;
    public projectTemplateTags: string;
    public projectTemplateTagsLike: string;
     public price: number;
     public priceMin: number;
     public priceMax: number;
  public categoryProjectTemplate: CategoryProjectTemplateCriteria ;
  public categoryProjectTemplates: Array<CategoryProjectTemplateCriteria> ;
  public subDomainTemplate: SubDomainTemplateCriteria ;
  public subDomainTemplates: Array<SubDomainTemplateCriteria> ;

}
