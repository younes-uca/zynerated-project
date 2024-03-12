package ma.zs.zyn.service.facade.admin.collaborator;

import java.util.List;
import ma.zs.zyn.bean.core.collaborator.Collaborator;
import ma.zs.zyn.dao.criteria.core.collaborator.CollaboratorCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface CollaboratorAdminService extends  IService<Collaborator,CollaboratorCriteria>  {
    Collaborator findByUsername(String username);
    boolean changePassword(String username, String newPassword);

    List<Collaborator> findByPackagingId(Long id);
    int deleteByPackagingId(Long id);
    long countByPackagingId(Long id);
    List<Collaborator> findByMemberId(Long id);
    int deleteByMemberId(Long id);
    long countByMemberId(Long id);




}
