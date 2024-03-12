package ma.zs.zyn.service.facade.admin.coupon;

import java.util.List;
import ma.zs.zyn.bean.core.coupon.Influencer;
import ma.zs.zyn.dao.criteria.core.coupon.InfluencerCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface InfluencerAdminService extends  IService<Influencer,InfluencerCriteria>  {
    Influencer findByUsername(String username);
    boolean changePassword(String username, String newPassword);





}
