package ma.zs.zyn.service.facade.admin.coupon;

import java.util.List;
import ma.zs.zyn.bean.core.coupon.Coupon;
import ma.zs.zyn.dao.criteria.core.coupon.CouponCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface CouponAdminService extends  IService<Coupon,CouponCriteria>  {

    List<Coupon> findByPackagingId(Long id);
    int deleteByPackagingId(Long id);
    long countByPackagingId(Long id);
    List<Coupon> findByInfluencerId(Long id);
    int deleteByInfluencerId(Long id);
    long countByInfluencerId(Long id);




}
