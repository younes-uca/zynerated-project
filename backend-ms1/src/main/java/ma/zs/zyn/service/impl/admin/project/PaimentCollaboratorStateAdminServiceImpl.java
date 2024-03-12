package ma.zs.zyn.service.impl.admin.project;


import ma.zs.zyn.bean.core.project.PaimentCollaboratorState;
import ma.zs.zyn.dao.criteria.core.project.PaimentCollaboratorStateCriteria;
import ma.zs.zyn.dao.facade.core.project.PaimentCollaboratorStateDao;
import ma.zs.zyn.dao.specification.core.project.PaimentCollaboratorStateSpecification;
import ma.zs.zyn.service.facade.admin.project.PaimentCollaboratorStateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class PaimentCollaboratorStateAdminServiceImpl extends AbstractServiceImpl<PaimentCollaboratorState, PaimentCollaboratorStateCriteria, PaimentCollaboratorStateDao> implements PaimentCollaboratorStateAdminService {






    public PaimentCollaboratorState findByReferenceEntity(PaimentCollaboratorState t){
        return  dao.findByCode(t.getCode());
    }


    public List<PaimentCollaboratorState> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PaimentCollaboratorState.class, PaimentCollaboratorStateSpecification.class);
    }



    public PaimentCollaboratorStateAdminServiceImpl(PaimentCollaboratorStateDao dao) {
        super(dao);
    }

}
