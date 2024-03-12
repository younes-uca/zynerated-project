package ma.zs.zyn.service.impl.admin.project;


import ma.zs.zyn.bean.core.project.ProjectState;
import ma.zs.zyn.dao.criteria.core.project.ProjectStateCriteria;
import ma.zs.zyn.dao.facade.core.project.ProjectStateDao;
import ma.zs.zyn.dao.specification.core.project.ProjectStateSpecification;
import ma.zs.zyn.service.facade.admin.project.ProjectStateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProjectStateAdminServiceImpl extends AbstractServiceImpl<ProjectState, ProjectStateCriteria, ProjectStateDao> implements ProjectStateAdminService {






    public ProjectState findByReferenceEntity(ProjectState t){
        return  dao.findByCode(t.getCode());
    }


    public List<ProjectState> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ProjectState.class, ProjectStateSpecification.class);
    }



    public ProjectStateAdminServiceImpl(ProjectStateDao dao) {
        super(dao);
    }

}
