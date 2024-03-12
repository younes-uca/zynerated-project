package ma.zs.zyn.service.facade.admin.packaging;

import java.util.List;
import ma.zs.zyn.bean.core.packaging.Packaging;
import ma.zs.zyn.dao.criteria.core.packaging.PackagingCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface PackagingAdminService extends  IService<Packaging,PackagingCriteria>  {

    List<Packaging> findByCategoryPackagingId(Long id);
    int deleteByCategoryPackagingId(Long id);
    long countByCategoryPackagingId(Long id);




}
