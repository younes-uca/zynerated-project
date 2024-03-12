package  ma.zs.zyn.dao.specification.core.inscription;

import ma.zs.zyn.dao.criteria.core.inscription.InscriptionStateCriteria;
import ma.zs.zyn.bean.core.inscription.InscriptionState;
import ma.zs.zyn.zynerator.specification.AbstractSpecification;


public class InscriptionStateSpecification extends  AbstractSpecification<InscriptionStateCriteria, InscriptionState>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
    }

    public InscriptionStateSpecification(InscriptionStateCriteria criteria) {
        super(criteria);
    }

    public InscriptionStateSpecification(InscriptionStateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
