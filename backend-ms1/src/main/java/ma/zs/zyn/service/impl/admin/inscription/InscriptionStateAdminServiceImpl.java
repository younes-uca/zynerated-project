package ma.zs.zyn.service.impl.admin.inscription;


import ma.zs.zyn.bean.core.inscription.InscriptionState;
import ma.zs.zyn.dao.criteria.core.inscription.InscriptionStateCriteria;
import ma.zs.zyn.dao.facade.core.inscription.InscriptionStateDao;
import ma.zs.zyn.dao.specification.core.inscription.InscriptionStateSpecification;
import ma.zs.zyn.service.facade.admin.inscription.InscriptionStateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class InscriptionStateAdminServiceImpl extends AbstractServiceImpl<InscriptionState, InscriptionStateCriteria, InscriptionStateDao> implements InscriptionStateAdminService {








    public List<InscriptionState> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(InscriptionState.class, InscriptionStateSpecification.class);
    }



    public InscriptionStateAdminServiceImpl(InscriptionStateDao dao) {
        super(dao);
    }

}
