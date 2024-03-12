package ma.zs.zyn.service.impl.admin.category;


import ma.zs.zyn.bean.core.category.CategoryPackaging;
import ma.zs.zyn.dao.criteria.core.category.CategoryPackagingCriteria;
import ma.zs.zyn.dao.facade.core.category.CategoryPackagingDao;
import ma.zs.zyn.dao.specification.core.category.CategoryPackagingSpecification;
import ma.zs.zyn.service.facade.admin.category.CategoryPackagingAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategoryPackagingAdminServiceImpl extends AbstractServiceImpl<CategoryPackaging, CategoryPackagingCriteria, CategoryPackagingDao> implements CategoryPackagingAdminService {








    public List<CategoryPackaging> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategoryPackaging.class, CategoryPackagingSpecification.class);
    }



    public CategoryPackagingAdminServiceImpl(CategoryPackagingDao dao) {
        super(dao);
    }

}
