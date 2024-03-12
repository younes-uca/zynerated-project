package ma.zs.zyn.service.impl.admin.paiment;


import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import ma.zs.zyn.dao.criteria.core.paiment.PaimentCollaboratorCriteria;
import ma.zs.zyn.dao.facade.core.paiment.PaimentCollaboratorDao;
import ma.zs.zyn.dao.specification.core.paiment.PaimentCollaboratorSpecification;
import ma.zs.zyn.service.facade.admin.paiment.PaimentCollaboratorAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.collaborator.CollaboratorAdminService ;
import ma.zs.zyn.bean.core.collaborator.Collaborator ;
import ma.zs.zyn.service.facade.admin.coupon.CouponAdminService ;
import ma.zs.zyn.bean.core.coupon.Coupon ;
import ma.zs.zyn.service.facade.admin.project.PaimentCollaboratorStateAdminService ;
import ma.zs.zyn.bean.core.project.PaimentCollaboratorState ;

import java.util.List;
@Service
public class PaimentCollaboratorAdminServiceImpl extends AbstractServiceImpl<PaimentCollaborator, PaimentCollaboratorCriteria, PaimentCollaboratorDao> implements PaimentCollaboratorAdminService {






    public void findOrSaveAssociatedObject(PaimentCollaborator t){
        if( t != null) {
            t.setCollaborator(collaboratorService.findOrSave(t.getCollaborator()));
            t.setCoupon(couponService.findOrSave(t.getCoupon()));
            t.setPaimentCollaboratorState(paimentCollaboratorStateService.findOrSave(t.getPaimentCollaboratorState()));
        }
    }

    public List<PaimentCollaborator> findByCollaboratorId(Long id){
        return dao.findByCollaboratorId(id);
    }
    public int deleteByCollaboratorId(Long id){
        return dao.deleteByCollaboratorId(id);
    }
    public long countByCollaboratorId(Long id){
        return dao.countByCollaboratorId(id);
    }
    public List<PaimentCollaborator> findByCouponId(Long id){
        return dao.findByCouponId(id);
    }
    public int deleteByCouponId(Long id){
        return dao.deleteByCouponId(id);
    }
    public long countByCouponCode(String code){
        return dao.countByCouponCode(code);
    }
    public List<PaimentCollaborator> findByPaimentCollaboratorStateId(Long id){
        return dao.findByPaimentCollaboratorStateId(id);
    }
    public int deleteByPaimentCollaboratorStateId(Long id){
        return dao.deleteByPaimentCollaboratorStateId(id);
    }
    public long countByPaimentCollaboratorStateCode(String code){
        return dao.countByPaimentCollaboratorStateCode(code);
    }

    public List<PaimentCollaborator> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PaimentCollaborator.class, PaimentCollaboratorSpecification.class);
    }


    @Autowired
    private CollaboratorAdminService collaboratorService ;
    @Autowired
    private CouponAdminService couponService ;
    @Autowired
    private PaimentCollaboratorStateAdminService paimentCollaboratorStateService ;

    public PaimentCollaboratorAdminServiceImpl(PaimentCollaboratorDao dao) {
        super(dao);
    }

}
