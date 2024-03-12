import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CollaboratorCriteria} from '../collaborator/CollaboratorCriteria.model';
import {PackagingCriteria} from '../packaging/PackagingCriteria.model';
import {InscriptionStateCriteria} from './InscriptionStateCriteria.model';

export class InscriptionCollaboratorCriteria  extends BaseCriteria  {

    public id: number;
    public inscriptionDate: Date;
    public inscriptionDateFrom: Date;
    public inscriptionDateTo: Date;
    public renewDate: Date;
    public renewDateFrom: Date;
    public renewDateTo: Date;

}
