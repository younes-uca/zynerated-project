package ma.zs.zyn.dao.facade.core.template;

import org.springframework.data.jpa.repository.Query;
import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.template.ProjectTemplate;
import org.springframework.stereotype.Repository;
import ma.zs.zyn.bean.core.template.ProjectTemplate;
import java.util.List;


@Repository
public interface ProjectTemplateDao extends AbstractRepository<ProjectTemplate,Long>  {
    ProjectTemplate findByCode(String code);
    int deleteByCode(String code);

    List<ProjectTemplate> findByCategoryProjectTemplateId(Long id);
    int deleteByCategoryProjectTemplateId(Long id);
    long countByCategoryProjectTemplateId(Long id);
    List<ProjectTemplate> findBySubDomainTemplateId(Long id);
    int deleteBySubDomainTemplateId(Long id);
    long countBySubDomainTemplateId(Long id);

    @Query("SELECT NEW ProjectTemplate(item.id,item.code) FROM ProjectTemplate item")
    List<ProjectTemplate> findAllOptimized();

}
