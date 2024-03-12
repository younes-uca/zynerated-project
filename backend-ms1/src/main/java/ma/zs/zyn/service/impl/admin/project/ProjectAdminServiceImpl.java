package ma.zs.zyn.service.impl.admin.project;


import ma.zs.zyn.bean.core.project.Project;
import ma.zs.zyn.dao.criteria.core.project.ProjectCriteria;
import ma.zs.zyn.dao.facade.core.project.ProjectDao;
import ma.zs.zyn.dao.specification.core.project.ProjectSpecification;
import ma.zs.zyn.service.facade.admin.project.ProjectAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.project.ProjectStateAdminService ;
import ma.zs.zyn.bean.core.project.ProjectState ;
import ma.zs.zyn.service.facade.admin.collaborator.MemberAdminService ;
import ma.zs.zyn.bean.core.collaborator.Member ;

import java.util.List;
@Service
public class ProjectAdminServiceImpl extends AbstractServiceImpl<Project, ProjectCriteria, ProjectDao> implements ProjectAdminService {






    public Project findByReferenceEntity(Project t){
        return  dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Project t){
        if( t != null) {
            t.setOwner(memberService.findOrSave(t.getOwner()));
            t.setProjectState(projectStateService.findOrSave(t.getProjectState()));
        }
    }

    public List<Project> findByOwnerId(Long id){
        return dao.findByOwnerId(id);
    }
    public int deleteByOwnerId(Long id){
        return dao.deleteByOwnerId(id);
    }
    public long countByOwnerId(Long id){
        return dao.countByOwnerId(id);
    }
    public List<Project> findByProjectStateId(Long id){
        return dao.findByProjectStateId(id);
    }
    public int deleteByProjectStateId(Long id){
        return dao.deleteByProjectStateId(id);
    }
    public long countByProjectStateCode(String code){
        return dao.countByProjectStateCode(code);
    }

    public List<Project> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Project.class, ProjectSpecification.class);
    }


    @Autowired
    private ProjectStateAdminService projectStateService ;
    @Autowired
    private MemberAdminService memberService ;

    public ProjectAdminServiceImpl(ProjectDao dao) {
        super(dao);
    }

}
