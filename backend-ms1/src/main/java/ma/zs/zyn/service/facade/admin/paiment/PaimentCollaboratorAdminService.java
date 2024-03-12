package ma.zs.zyn.service.facade.admin.paiment;

import java.util.List;
import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import ma.zs.zyn.dao.criteria.core.paiment.PaimentCollaboratorCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface PaimentCollaboratorAdminService extends  IService<PaimentCollaborator,PaimentCollaboratorCriteria>  {

    List<PaimentCollaborator> findByCollaboratorId(Long id);
    int deleteByCollaboratorId(Long id);
    long countByCollaboratorId(Long id);
    List<PaimentCollaborator> findByCouponId(Long id);
    int deleteByCouponId(Long id);
    long countByCouponCode(String code);
    List<PaimentCollaborator> findByPaimentCollaboratorStateId(Long id);
    int deleteByPaimentCollaboratorStateId(Long id);
    long countByPaimentCollaboratorStateCode(String code);




}
