package ma.zs.zyn.dao.facade.core.template;

import org.springframework.data.jpa.repository.Query;
import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SubDomainTemplateDao extends AbstractRepository<SubDomainTemplate,Long>  {

    List<SubDomainTemplate> findByDomainTemplateId(Long id);
    int deleteByDomainTemplateId(Long id);
    long countByDomainTemplateId(Long id);

    @Query("SELECT NEW SubDomainTemplate(item.id,item.name) FROM SubDomainTemplate item")
    List<SubDomainTemplate> findAllOptimized();

}
