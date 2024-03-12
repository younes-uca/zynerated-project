package ma.zs.zyn.service.impl.admin.template;


import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.CategoryProjectTemplateCriteria;
import ma.zs.zyn.dao.facade.core.template.CategoryProjectTemplateDao;
import ma.zs.zyn.dao.specification.core.template.CategoryProjectTemplateSpecification;
import ma.zs.zyn.service.facade.admin.template.CategoryProjectTemplateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategoryProjectTemplateAdminServiceImpl extends AbstractServiceImpl<CategoryProjectTemplate, CategoryProjectTemplateCriteria, CategoryProjectTemplateDao> implements CategoryProjectTemplateAdminService {








    public List<CategoryProjectTemplate> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategoryProjectTemplate.class, CategoryProjectTemplateSpecification.class);
    }



    public CategoryProjectTemplateAdminServiceImpl(CategoryProjectTemplateDao dao) {
        super(dao);
    }

}
