package ma.zs.zyn.dao.facade.core.collaborator;

import org.springframework.data.jpa.repository.Query;
import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.collaborator.Collaborator;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CollaboratorDao extends AbstractRepository<Collaborator,Long>  {

    List<Collaborator> findByPackagingId(Long id);
    int deleteByPackagingId(Long id);
    long countByPackagingId(Long id);
    List<Collaborator> findByMemberId(Long id);
    int deleteByMemberId(Long id);
    long countByMemberId(Long id);
    Collaborator findByUsername(String username);

    @Query("SELECT NEW Collaborator(item.id,item.name) FROM Collaborator item")
    List<Collaborator> findAllOptimized();

}
