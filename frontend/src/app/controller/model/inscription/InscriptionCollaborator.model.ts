import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CollaboratorDto} from '../collaborator/Collaborator.model';
import {PackagingDto} from '../packaging/Packaging.model';
import {InscriptionStateDto} from './InscriptionState.model';

export class InscriptionCollaboratorDto extends BaseDto{

   public inscriptionDate: Date;

   public renewDate: Date;

    public packaging: PackagingDto ;
    public collaborator: CollaboratorDto ;
    public inscriptionState: InscriptionStateDto ;
    

    constructor() {
        super();

        this.inscriptionDate = null;
        this.renewDate = null;

        }

}
