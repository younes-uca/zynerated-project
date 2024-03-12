package  ma.zs.zyn.dao.specification.core.paiment;

import ma.zs.zyn.dao.criteria.core.paiment.PaimentCollaboratorCriteria;
import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import ma.zs.zyn.zynerator.specification.AbstractSpecification;


public class PaimentCollaboratorSpecification extends  AbstractSpecification<PaimentCollaboratorCriteria, PaimentCollaborator>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateFk("collaborator","id", criteria.getCollaborator()==null?null:criteria.getCollaborator().getId());
        addPredicateFk("collaborator","id", criteria.getCollaborators());
        addPredicateFk("coupon","id", criteria.getCoupon()==null?null:criteria.getCoupon().getId());
        addPredicateFk("coupon","id", criteria.getCoupons());
        addPredicateFk("coupon","code", criteria.getCoupon()==null?null:criteria.getCoupon().getCode());
        addPredicateFk("paimentCollaboratorState","id", criteria.getPaimentCollaboratorState()==null?null:criteria.getPaimentCollaboratorState().getId());
        addPredicateFk("paimentCollaboratorState","id", criteria.getPaimentCollaboratorStates());
        addPredicateFk("paimentCollaboratorState","code", criteria.getPaimentCollaboratorState()==null?null:criteria.getPaimentCollaboratorState().getCode());
    }

    public PaimentCollaboratorSpecification(PaimentCollaboratorCriteria criteria) {
        super(criteria);
    }

    public PaimentCollaboratorSpecification(PaimentCollaboratorCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
