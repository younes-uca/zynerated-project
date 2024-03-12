package ma.zs.zyn.service.facade.admin.inscription;

import java.util.List;
import ma.zs.zyn.bean.core.inscription.InscriptionCollaborator;
import ma.zs.zyn.dao.criteria.core.inscription.InscriptionCollaboratorCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface InscriptionCollaboratorAdminService extends  IService<InscriptionCollaborator,InscriptionCollaboratorCriteria>  {

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
