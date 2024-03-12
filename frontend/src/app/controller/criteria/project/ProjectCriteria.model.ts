import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ProjectStateCriteria} from './ProjectStateCriteria.model';
import {MemberCriteria} from '../collaborator/MemberCriteria.model';

export class ProjectCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public name: string;
    public nameLike: string;
    public generatedDate: Date;
    public generatedDateFrom: Date;
    public generatedDateTo: Date;
    public yaml: string;
    public yamlLike: string;

}
