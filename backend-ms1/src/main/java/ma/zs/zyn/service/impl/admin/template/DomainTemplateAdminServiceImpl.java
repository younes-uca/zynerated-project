package ma.zs.zyn.service.impl.admin.template;


import ma.zs.zyn.bean.core.template.DomainTemplate;
import ma.zs.zyn.dao.criteria.core.template.DomainTemplateCriteria;
import ma.zs.zyn.dao.facade.core.template.DomainTemplateDao;
import ma.zs.zyn.dao.specification.core.template.DomainTemplateSpecification;
import ma.zs.zyn.service.facade.admin.template.DomainTemplateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class DomainTemplateAdminServiceImpl extends AbstractServiceImpl<DomainTemplate, DomainTemplateCriteria, DomainTemplateDao> implements DomainTemplateAdminService {








    public List<DomainTemplate> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(DomainTemplate.class, DomainTemplateSpecification.class);
    }



    public DomainTemplateAdminServiceImpl(DomainTemplateDao dao) {
        super(dao);
    }

}
