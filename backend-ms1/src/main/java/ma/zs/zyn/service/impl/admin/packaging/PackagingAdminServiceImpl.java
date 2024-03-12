package ma.zs.zyn.service.impl.admin.packaging;


import ma.zs.zyn.bean.core.packaging.Packaging;
import ma.zs.zyn.dao.criteria.core.packaging.PackagingCriteria;
import ma.zs.zyn.dao.facade.core.packaging.PackagingDao;
import ma.zs.zyn.dao.specification.core.packaging.PackagingSpecification;
import ma.zs.zyn.service.facade.admin.packaging.PackagingAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.category.CategoryPackagingAdminService ;
import ma.zs.zyn.bean.core.category.CategoryPackaging ;

import java.util.List;
@Service
public class PackagingAdminServiceImpl extends AbstractServiceImpl<Packaging, PackagingCriteria, PackagingDao> implements PackagingAdminService {






    public void findOrSaveAssociatedObject(Packaging t){
        if( t != null) {
            t.setCategoryPackaging(categoryPackagingService.findOrSave(t.getCategoryPackaging()));
        }
    }

    public List<Packaging> findByCategoryPackagingId(Long id){
        return dao.findByCategoryPackagingId(id);
    }
    public int deleteByCategoryPackagingId(Long id){
        return dao.deleteByCategoryPackagingId(id);
    }
    public long countByCategoryPackagingId(Long id){
        return dao.countByCategoryPackagingId(id);
    }






    public void configure() {
        super.configure(Packaging.class, PackagingSpecification.class);
    }


    @Autowired
    private CategoryPackagingAdminService categoryPackagingService ;

    public PackagingAdminServiceImpl(PackagingDao dao) {
        super(dao);
    }

}
