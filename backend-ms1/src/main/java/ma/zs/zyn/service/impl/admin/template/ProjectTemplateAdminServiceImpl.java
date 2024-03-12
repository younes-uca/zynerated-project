package ma.zs.zyn.service.impl.admin.template;


import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.ProjectTemplateCriteria;
import ma.zs.zyn.dao.facade.core.template.ProjectTemplateDao;
import ma.zs.zyn.dao.specification.core.template.ProjectTemplateSpecification;
import ma.zs.zyn.service.facade.admin.template.ProjectTemplateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.template.SubDomainTemplateAdminService ;
import ma.zs.zyn.bean.core.template.SubDomainTemplate ;
import ma.zs.zyn.service.facade.admin.template.CategoryProjectTemplateAdminService ;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate ;

import java.util.List;
@Service
public class ProjectTemplateAdminServiceImpl extends AbstractServiceImpl<ProjectTemplate, ProjectTemplateCriteria, ProjectTemplateDao> implements ProjectTemplateAdminService {






    public ProjectTemplate findByReferenceEntity(ProjectTemplate t){
        return  dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(ProjectTemplate t){
        if( t != null) {
            t.setCategoryProjectTemplate(categoryProjectTemplateService.findOrSave(t.getCategoryProjectTemplate()));
            t.setSubDomainTemplate(subDomainTemplateService.findOrSave(t.getSubDomainTemplate()));
        }
    }

    public List<ProjectTemplate> findByCategoryProjectTemplateId(Long id){
        return dao.findByCategoryProjectTemplateId(id);
    }
    public int deleteByCategoryProjectTemplateId(Long id){
        return dao.deleteByCategoryProjectTemplateId(id);
    }
    public long countByCategoryProjectTemplateId(Long id){
        return dao.countByCategoryProjectTemplateId(id);
    }
    public List<ProjectTemplate> findBySubDomainTemplateId(Long id){
        return dao.findBySubDomainTemplateId(id);
    }
    public int deleteBySubDomainTemplateId(Long id){
        return dao.deleteBySubDomainTemplateId(id);
    }
    public long countBySubDomainTemplateId(Long id){
        return dao.countBySubDomainTemplateId(id);
    }

    public List<ProjectTemplate> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ProjectTemplate.class, ProjectTemplateSpecification.class);
    }


    @Autowired
    private SubDomainTemplateAdminService subDomainTemplateService ;
    @Autowired
    private CategoryProjectTemplateAdminService categoryProjectTemplateService ;

    public ProjectTemplateAdminServiceImpl(ProjectTemplateDao dao) {
        super(dao);
    }

}
