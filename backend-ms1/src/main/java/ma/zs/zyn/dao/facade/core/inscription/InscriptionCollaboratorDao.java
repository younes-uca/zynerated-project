package ma.zs.zyn.dao.facade.core.inscription;

import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.inscription.InscriptionCollaborator;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InscriptionCollaboratorDao extends AbstractRepository<InscriptionCollaborator,Long>  {

    List<InscriptionCollaborator> findByPackagingId(Long id);
    int deleteByPackagingId(Long id);
    long countByPackagingId(Long id);
    List<InscriptionCollaborator> findByCollaboratorId(Long id);
    int deleteByCollaboratorId(Long id);
    long countByCollaboratorId(Long id);
    List<InscriptionCollaborator> findByInscriptionStateId(Long id);
    int deleteByInscriptionStateId(Long id);
    long countByInscriptionStateId(Long id);


}
