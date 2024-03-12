package ma.zs.zyn.service.facade.admin.collaborator;

import java.util.List;
import ma.zs.zyn.bean.core.collaborator.Member;
import ma.zs.zyn.dao.criteria.core.collaborator.MemberCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface MemberAdminService extends  IService<Member,MemberCriteria>  {
    Member findByUsername(String username);
    boolean changePassword(String username, String newPassword);

    List<Member> findByCollaboratorId(Long id);
    int deleteByCollaboratorId(Long id);
    long countByCollaboratorId(Long id);




}
