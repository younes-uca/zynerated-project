import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DomainTemplateDto} from './DomainTemplate.model';

export class SubDomainTemplateDto extends BaseDto{

    public code: string;

    public name: string;

    public domainTemplate: DomainTemplateDto ;
    

    constructor() {
        super();

        this.code = '';
        this.name = '';

        }

}
