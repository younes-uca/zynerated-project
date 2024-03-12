package ma.zs.zyn.service.impl.admin.paiment;


import ma.zs.zyn.bean.core.paiment.PaimentInfluencer;
import ma.zs.zyn.dao.criteria.core.paiment.PaimentInfluencerCriteria;
import ma.zs.zyn.dao.facade.core.paiment.PaimentInfluencerDao;
import ma.zs.zyn.dao.specification.core.paiment.PaimentInfluencerSpecification;
import ma.zs.zyn.service.facade.admin.paiment.PaimentInfluencerAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.coupon.CouponAdminService ;
import ma.zs.zyn.bean.core.coupon.Coupon ;
import ma.zs.zyn.service.facade.admin.coupon.InfluencerAdminService ;
import ma.zs.zyn.bean.core.coupon.Influencer ;
import ma.zs.zyn.service.facade.admin.project.PaimentInfluencerStateAdminService ;
import ma.zs.zyn.bean.core.project.PaimentInfluencerState ;

import java.util.List;
@Service
public class PaimentInfluencerAdminServiceImpl extends AbstractServiceImpl<PaimentInfluencer, PaimentInfluencerCriteria, PaimentInfluencerDao> implements PaimentInfluencerAdminService {






    public void findOrSaveAssociatedObject(PaimentInfluencer t){
        if( t != null) {
            t.setInfluencer(influencerService.findOrSave(t.getInfluencer()));
            t.setCoupon(couponService.findOrSave(t.getCoupon()));
            t.setPaimentInfluencerState(paimentInfluencerStateService.findOrSave(t.getPaimentInfluencerState()));
        }
    }

    public List<PaimentInfluencer> findByInfluencerId(Long id){
        return dao.findByInfluencerId(id);
    }
    public int deleteByInfluencerId(Long id){
        return dao.deleteByInfluencerId(id);
    }
    public long countByInfluencerId(Long id){
        return dao.countByInfluencerId(id);
    }
    public List<PaimentInfluencer> findByCouponId(Long id){
        return dao.findByCouponId(id);
    }
    public int deleteByCouponId(Long id){
        return dao.deleteByCouponId(id);
    }
    public long countByCouponCode(String code){
        return dao.countByCouponCode(code);
    }
    public List<PaimentInfluencer> findByPaimentInfluencerStateId(Long id){
        return dao.findByPaimentInfluencerStateId(id);
    }
    public int deleteByPaimentInfluencerStateId(Long id){
        return dao.deleteByPaimentInfluencerStateId(id);
    }
    public long countByPaimentInfluencerStateCode(String code){
        return dao.countByPaimentInfluencerStateCode(code);
    }

    public List<PaimentInfluencer> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PaimentInfluencer.class, PaimentInfluencerSpecification.class);
    }


    @Autowired
    private CouponAdminService couponService ;
    @Autowired
    private InfluencerAdminService influencerService ;
    @Autowired
    private PaimentInfluencerStateAdminService paimentInfluencerStateService ;

    public PaimentInfluencerAdminServiceImpl(PaimentInfluencerDao dao) {
        super(dao);
    }

}
