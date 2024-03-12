package ma.zs.zyn.service.impl.admin.collaborator;


import ma.zs.zyn.bean.core.collaborator.Member;
import ma.zs.zyn.dao.criteria.core.collaborator.MemberCriteria;
import ma.zs.zyn.dao.facade.core.collaborator.MemberDao;
import ma.zs.zyn.dao.specification.core.collaborator.MemberSpecification;
import ma.zs.zyn.service.facade.admin.collaborator.MemberAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.collaborator.CollaboratorAdminService ;
import ma.zs.zyn.bean.core.collaborator.Collaborator ;

import ma.zs.zyn.zynerator.security.service.facade.UserService;
import ma.zs.zyn.zynerator.security.service.facade.RoleService;
import ma.zs.zyn.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class MemberAdminServiceImpl extends AbstractServiceImpl<Member, MemberCriteria, MemberDao> implements MemberAdminService {






    public void findOrSaveAssociatedObject(Member t){
        if( t != null) {
            t.setCollaborator(collaboratorService.findOrSave(t.getCollaborator()));
        }
    }

    public List<Member> findByCollaboratorId(Long id){
        return dao.findByCollaboratorId(id);
    }
    public int deleteByCollaboratorId(Long id){
        return dao.deleteByCollaboratorId(id);
    }
    public long countByCollaboratorId(Long id){
        return dao.countByCollaboratorId(id);
    }





    @Override
    public Member create(Member t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);
        /*if (t.getRoles() != null) {
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : t.getRoles()) {
                roles.add(roleService.save(role));
            }
            t.setRoles(roles);
        }*/
        Member mySaved = super.create(t);

        return mySaved;
     }

    public Member findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Member.class, MemberSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    @Autowired
    private CollaboratorAdminService collaboratorService ;

    public MemberAdminServiceImpl(MemberDao dao) {
        super(dao);
    }

}
