package ma.zs.zyn.dao.facade.core.project;

import org.springframework.data.jpa.repository.Query;
import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.project.Project;
import org.springframework.stereotype.Repository;
import ma.zs.zyn.bean.core.project.Project;
import java.util.List;


@Repository
public interface ProjectDao extends AbstractRepository<Project,Long>  {
    Project findByCode(String code);
    int deleteByCode(String code);

    List<Project> findByOwnerId(Long id);
    int deleteByOwnerId(Long id);
    long countByOwnerId(Long id);
    List<Project> findByProjectStateId(Long id);
    int deleteByProjectStateId(Long id);
    long countByProjectStateCode(String code);

    @Query("SELECT NEW Project(item.id,item.code) FROM Project item")
    List<Project> findAllOptimized();

}
