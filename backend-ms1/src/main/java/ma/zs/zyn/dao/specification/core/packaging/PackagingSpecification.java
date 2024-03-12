package  ma.zs.zyn.dao.specification.core.packaging;

import ma.zs.zyn.dao.criteria.core.packaging.PackagingCriteria;
import ma.zs.zyn.bean.core.packaging.Packaging;
import ma.zs.zyn.zynerator.specification.AbstractSpecification;


public class PackagingSpecification extends  AbstractSpecification<PackagingCriteria, Packaging>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateBigDecimal("price", criteria.getPrice(), criteria.getPriceMin(), criteria.getPriceMax());
        addPredicateBigDecimal("maxProject", criteria.getMaxProject(), criteria.getMaxProjectMin(), criteria.getMaxProjectMax());
        addPredicateFk("categoryPackaging","id", criteria.getCategoryPackaging()==null?null:criteria.getCategoryPackaging().getId());
        addPredicateFk("categoryPackaging","id", criteria.getCategoryPackagings());
    }

    public PackagingSpecification(PackagingCriteria criteria) {
        super(criteria);
    }

    public PackagingSpecification(PackagingCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
