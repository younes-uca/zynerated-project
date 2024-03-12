package ma.zs.zyn.service.facade.admin.project;

import java.util.List;
import ma.zs.zyn.bean.core.project.Project;
import ma.zs.zyn.dao.criteria.core.project.ProjectCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface ProjectAdminService extends  IService<Project,ProjectCriteria>  {

    List<Project> findByOwnerId(Long id);
    int deleteByOwnerId(Long id);
    long countByOwnerId(Long id);
    List<Project> findByProjectStateId(Long id);
    int deleteByProjectStateId(Long id);
    long countByProjectStateCode(String code);




}
