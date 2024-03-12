package ma.zs.zyn.service.impl.admin.coupon;


import ma.zs.zyn.bean.core.coupon.Influencer;
import ma.zs.zyn.dao.criteria.core.coupon.InfluencerCriteria;
import ma.zs.zyn.dao.facade.core.coupon.InfluencerDao;
import ma.zs.zyn.dao.specification.core.coupon.InfluencerSpecification;
import ma.zs.zyn.service.facade.admin.coupon.InfluencerAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import ma.zs.zyn.zynerator.security.service.facade.UserService;
import ma.zs.zyn.zynerator.security.service.facade.RoleService;
import ma.zs.zyn.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class InfluencerAdminServiceImpl extends AbstractServiceImpl<Influencer, InfluencerCriteria, InfluencerDao> implements InfluencerAdminService {












    @Override
    public Influencer create(Influencer t) {
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
        Influencer mySaved = super.create(t);

        return mySaved;
     }

    public Influencer findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Influencer.class, InfluencerSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    public InfluencerAdminServiceImpl(InfluencerDao dao) {
        super(dao);
    }

}
