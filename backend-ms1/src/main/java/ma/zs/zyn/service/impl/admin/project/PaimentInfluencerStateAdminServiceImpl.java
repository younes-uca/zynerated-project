package ma.zs.zyn.service.impl.admin.project;


import ma.zs.zyn.bean.core.project.PaimentInfluencerState;
import ma.zs.zyn.dao.criteria.core.project.PaimentInfluencerStateCriteria;
import ma.zs.zyn.dao.facade.core.project.PaimentInfluencerStateDao;
import ma.zs.zyn.dao.specification.core.project.PaimentInfluencerStateSpecification;
import ma.zs.zyn.service.facade.admin.project.PaimentInfluencerStateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class PaimentInfluencerStateAdminServiceImpl extends AbstractServiceImpl<PaimentInfluencerState, PaimentInfluencerStateCriteria, PaimentInfluencerStateDao> implements PaimentInfluencerStateAdminService {






    public PaimentInfluencerState findByReferenceEntity(PaimentInfluencerState t){
        return  dao.findByCode(t.getCode());
    }


    public List<PaimentInfluencerState> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PaimentInfluencerState.class, PaimentInfluencerStateSpecification.class);
    }



    public PaimentInfluencerStateAdminServiceImpl(PaimentInfluencerStateDao dao) {
        super(dao);
    }

}
