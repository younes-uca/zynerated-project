package ma.zs.zyn.service.impl.admin.collaborator;


import ma.zs.zyn.bean.core.collaborator.Collaborator;
import ma.zs.zyn.dao.criteria.core.collaborator.CollaboratorCriteria;
import ma.zs.zyn.dao.facade.core.collaborator.CollaboratorDao;
import ma.zs.zyn.dao.specification.core.collaborator.CollaboratorSpecification;
import ma.zs.zyn.service.facade.admin.collaborator.CollaboratorAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.packaging.PackagingAdminService ;
import ma.zs.zyn.bean.core.packaging.Packaging ;
import ma.zs.zyn.service.facade.admin.collaborator.MemberAdminService ;
import ma.zs.zyn.bean.core.collaborator.Member ;

import ma.zs.zyn.zynerator.security.service.facade.UserService;
import ma.zs.zyn.zynerator.security.service.facade.RoleService;
import ma.zs.zyn.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class CollaboratorAdminServiceImpl extends AbstractServiceImpl<Collaborator, CollaboratorCriteria, CollaboratorDao> implements CollaboratorAdminService {






    public void findOrSaveAssociatedObject(Collaborator t){
        if( t != null) {
            t.setPackaging(packagingService.findOrSave(t.getPackaging()));
            t.setMember(memberService.findOrSave(t.getMember()));
        }
    }

    public List<Collaborator> findByPackagingId(Long id){
        return dao.findByPackagingId(id);
    }
    public int deleteByPackagingId(Long id){
        return dao.deleteByPackagingId(id);
    }
    public long countByPackagingId(Long id){
        return dao.countByPackagingId(id);
    }
    public List<Collaborator> findByMemberId(Long id){
        return dao.findByMemberId(id);
    }
    public int deleteByMemberId(Long id){
        return dao.deleteByMemberId(id);
    }
    public long countByMemberId(Long id){
        return dao.countByMemberId(id);
    }

    public List<Collaborator> findAllOptimized() {
        return dao.findAllOptimized();
    }




    @Override
    public Collaborator create(Collaborator t) {
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
        Collaborator mySaved = super.create(t);

        return mySaved;
     }

    public Collaborator findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Collaborator.class, CollaboratorSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    @Autowired
    private PackagingAdminService packagingService ;
    @Autowired
    private MemberAdminService memberService ;

    public CollaboratorAdminServiceImpl(CollaboratorDao dao) {
        super(dao);
    }

}
