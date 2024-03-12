import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SubDomainTemplateDto} from './SubDomainTemplate.model';
import {CategoryProjectTemplateDto} from './CategoryProjectTemplate.model';

export class ProjectTemplateDto extends BaseDto{

    public code: string;

    public name: string;

   public addingDate: Date;

   public lastUpdateDate: Date;

    public projectTemplateTags: string;

    public price: null | number;

    public categoryProjectTemplate: CategoryProjectTemplateDto ;
    public subDomainTemplate: SubDomainTemplateDto ;
    

    constructor() {
        super();

        this.code = '';
        this.name = '';
        this.addingDate = null;
        this.lastUpdateDate = null;
        this.projectTemplateTags = '';
        this.price = null;
        this.categoryProjectTemplate = new CategoryProjectTemplateDto() ;
        this.subDomainTemplate = new SubDomainTemplateDto() ;

        }

}
