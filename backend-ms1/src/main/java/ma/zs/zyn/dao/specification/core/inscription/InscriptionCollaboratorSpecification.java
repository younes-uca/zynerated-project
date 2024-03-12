package  ma.zs.zyn.dao.specification.core.inscription;

import ma.zs.zyn.dao.criteria.core.inscription.InscriptionCollaboratorCriteria;
import ma.zs.zyn.bean.core.inscription.InscriptionCollaborator;
import ma.zs.zyn.zynerator.specification.AbstractSpecification;


public class InscriptionCollaboratorSpecification extends  AbstractSpecification<InscriptionCollaboratorCriteria, InscriptionCollaborator>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("inscriptionDate", criteria.getInscriptionDate(), criteria.getInscriptionDateFrom(), criteria.getInscriptionDateTo());
        addPredicate("renewDate", criteria.getRenewDate(), criteria.getRenewDateFrom(), criteria.getRenewDateTo());
        addPredicateFk("packaging","id", criteria.getPackaging()==null?null:criteria.getPackaging().getId());
        addPredicateFk("packaging","id", criteria.getPackagings());
        addPredicateFk("collaborator","id", criteria.getCollaborator()==null?null:criteria.getCollaborator().getId());
        addPredicateFk("collaborator","id", criteria.getCollaborators());
        addPredicateFk("inscriptionState","id", criteria.getInscriptionState()==null?null:criteria.getInscriptionState().getId());
        addPredicateFk("inscriptionState","id", criteria.getInscriptionStates());
    }

    public InscriptionCollaboratorSpecification(InscriptionCollaboratorCriteria criteria) {
        super(criteria);
    }

    public InscriptionCollaboratorSpecification(InscriptionCollaboratorCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
