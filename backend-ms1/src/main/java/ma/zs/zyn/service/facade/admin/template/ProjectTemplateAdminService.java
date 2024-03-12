package ma.zs.zyn.service.facade.admin.template;

import java.util.List;
import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.ProjectTemplateCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface ProjectTemplateAdminService extends  IService<ProjectTemplate,ProjectTemplateCriteria>  {

    List<ProjectTemplate> findByCategoryProjectTemplateId(Long id);
    int deleteByCategoryProjectTemplateId(Long id);
    long countByCategoryProjectTemplateId(Long id);
    List<ProjectTemplate> findBySubDomainTemplateId(Long id);
    int deleteBySubDomainTemplateId(Long id);
    long countBySubDomainTemplateId(Long id);




}
