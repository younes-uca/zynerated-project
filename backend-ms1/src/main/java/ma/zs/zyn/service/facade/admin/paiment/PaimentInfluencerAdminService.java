package ma.zs.zyn.service.facade.admin.paiment;

import java.util.List;
import ma.zs.zyn.bean.core.paiment.PaimentInfluencer;
import ma.zs.zyn.dao.criteria.core.paiment.PaimentInfluencerCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface PaimentInfluencerAdminService extends  IService<PaimentInfluencer,PaimentInfluencerCriteria>  {

    List<PaimentInfluencer> findByInfluencerId(Long id);
    int deleteByInfluencerId(Long id);
    long countByInfluencerId(Long id);
    List<PaimentInfluencer> findByCouponId(Long id);
    int deleteByCouponId(Long id);
    long countByCouponCode(String code);
    List<PaimentInfluencer> findByPaimentInfluencerStateId(Long id);
    int deleteByPaimentInfluencerStateId(Long id);
    long countByPaimentInfluencerStateCode(String code);




}
