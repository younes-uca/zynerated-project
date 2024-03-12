import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProjectStateDto} from './ProjectState.model';
import {MemberDto} from '../collaborator/Member.model';

export class ProjectDto extends BaseDto{

    public code: string;

    public name: string;

   public generatedDate: Date;

    public yaml: string;

    public owner: MemberDto ;
    public projectState: ProjectStateDto ;
    

    constructor() {
        super();

        this.code = '';
        this.name = '';
        this.generatedDate = null;
        this.yaml = '';

        }

}
