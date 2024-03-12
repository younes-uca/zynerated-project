package  ma.zs.zyn.dao.specification.core.template;

import ma.zs.zyn.dao.criteria.core.template.SubDomainTemplateCriteria;
import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import ma.zs.zyn.zynerator.specification.AbstractSpecification;


public class SubDomainTemplateSpecification extends  AbstractSpecification<SubDomainTemplateCriteria, SubDomainTemplate>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicateFk("domainTemplate","id", criteria.getDomainTemplate()==null?null:criteria.getDomainTemplate().getId());
        addPredicateFk("domainTemplate","id", criteria.getDomainTemplates());
    }

    public SubDomainTemplateSpecification(SubDomainTemplateCriteria criteria) {
        super(criteria);
    }

    public SubDomainTemplateSpecification(SubDomainTemplateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
