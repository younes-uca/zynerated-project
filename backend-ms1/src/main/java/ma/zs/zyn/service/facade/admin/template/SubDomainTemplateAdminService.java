package ma.zs.zyn.service.facade.admin.template;

import java.util.List;
import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import ma.zs.zyn.dao.criteria.core.template.SubDomainTemplateCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface SubDomainTemplateAdminService extends  IService<SubDomainTemplate,SubDomainTemplateCriteria>  {

    List<SubDomainTemplate> findByDomainTemplateId(Long id);
    int deleteByDomainTemplateId(Long id);
    long countByDomainTemplateId(Long id);




}
