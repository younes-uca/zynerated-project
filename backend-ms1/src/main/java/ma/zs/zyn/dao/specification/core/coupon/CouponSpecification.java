package  ma.zs.zyn.dao.specification.core.coupon;

import ma.zs.zyn.dao.criteria.core.coupon.CouponCriteria;
import ma.zs.zyn.bean.core.coupon.Coupon;
import ma.zs.zyn.zynerator.specification.AbstractSpecification;


public class CouponSpecification extends  AbstractSpecification<CouponCriteria, Coupon>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicateBigDecimal("pourcentageCoupon", criteria.getPourcentageCoupon(), criteria.getPourcentageCouponMin(), criteria.getPourcentageCouponMax());
        addPredicateBigDecimal("pourcentageInfluencer", criteria.getPourcentageInfluencer(), criteria.getPourcentageInfluencerMin(), criteria.getPourcentageInfluencerMax());
        addPredicateBigDecimal("usingNumber", criteria.getUsingNumber(), criteria.getUsingNumberMin(), criteria.getUsingNumberMax());
        addPredicateFk("packaging","id", criteria.getPackaging()==null?null:criteria.getPackaging().getId());
        addPredicateFk("packaging","id", criteria.getPackagings());
        addPredicateFk("influencer","id", criteria.getInfluencer()==null?null:criteria.getInfluencer().getId());
        addPredicateFk("influencer","id", criteria.getInfluencers());
    }

    public CouponSpecification(CouponCriteria criteria) {
        super(criteria);
    }

    public CouponSpecification(CouponCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
