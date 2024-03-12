package ma.zs.zyn.service.impl.admin.coupon;


import ma.zs.zyn.bean.core.coupon.Coupon;
import ma.zs.zyn.dao.criteria.core.coupon.CouponCriteria;
import ma.zs.zyn.dao.facade.core.coupon.CouponDao;
import ma.zs.zyn.dao.specification.core.coupon.CouponSpecification;
import ma.zs.zyn.service.facade.admin.coupon.CouponAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.coupon.InfluencerAdminService ;
import ma.zs.zyn.bean.core.coupon.Influencer ;
import ma.zs.zyn.service.facade.admin.packaging.PackagingAdminService ;
import ma.zs.zyn.bean.core.packaging.Packaging ;

import java.util.List;
@Service
public class CouponAdminServiceImpl extends AbstractServiceImpl<Coupon, CouponCriteria, CouponDao> implements CouponAdminService {






    public Coupon findByReferenceEntity(Coupon t){
        return  dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Coupon t){
        if( t != null) {
            t.setPackaging(packagingService.findOrSave(t.getPackaging()));
            t.setInfluencer(influencerService.findOrSave(t.getInfluencer()));
        }
    }

    public List<Coupon> findByPackagingId(Long id){
        return dao.findByPackagingId(id);
    }
    public int deleteByPackagingId(Long id){
        return dao.deleteByPackagingId(id);
    }
    public long countByPackagingId(Long id){
        return dao.countByPackagingId(id);
    }
    public List<Coupon> findByInfluencerId(Long id){
        return dao.findByInfluencerId(id);
    }
    public int deleteByInfluencerId(Long id){
        return dao.deleteByInfluencerId(id);
    }
    public long countByInfluencerId(Long id){
        return dao.countByInfluencerId(id);
    }

    public List<Coupon> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Coupon.class, CouponSpecification.class);
    }


    @Autowired
    private InfluencerAdminService influencerService ;
    @Autowired
    private PackagingAdminService packagingService ;

    public CouponAdminServiceImpl(CouponDao dao) {
        super(dao);
    }

}
