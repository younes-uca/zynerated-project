package ma.zs.zyn.service.impl.admin.template;


import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import ma.zs.zyn.dao.criteria.core.template.SubDomainTemplateCriteria;
import ma.zs.zyn.dao.facade.core.template.SubDomainTemplateDao;
import ma.zs.zyn.dao.specification.core.template.SubDomainTemplateSpecification;
import ma.zs.zyn.service.facade.admin.template.SubDomainTemplateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.template.DomainTemplateAdminService ;
import ma.zs.zyn.bean.core.template.DomainTemplate ;

import java.util.List;
@Service
public class SubDomainTemplateAdminServiceImpl extends AbstractServiceImpl<SubDomainTemplate, SubDomainTemplateCriteria, SubDomainTemplateDao> implements SubDomainTemplateAdminService {






    public void findOrSaveAssociatedObject(SubDomainTemplate t){
        if( t != null) {
            t.setDomainTemplate(domainTemplateService.findOrSave(t.getDomainTemplate()));
        }
    }

    public List<SubDomainTemplate> findByDomainTemplateId(Long id){
        return dao.findByDomainTemplateId(id);
    }
    public int deleteByDomainTemplateId(Long id){
        return dao.deleteByDomainTemplateId(id);
    }
    public long countByDomainTemplateId(Long id){
        return dao.countByDomainTemplateId(id);
    }

    public List<SubDomainTemplate> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(SubDomainTemplate.class, SubDomainTemplateSpecification.class);
    }


    @Autowired
    private DomainTemplateAdminService domainTemplateService ;

    public SubDomainTemplateAdminServiceImpl(SubDomainTemplateDao dao) {
        super(dao);
    }

}
