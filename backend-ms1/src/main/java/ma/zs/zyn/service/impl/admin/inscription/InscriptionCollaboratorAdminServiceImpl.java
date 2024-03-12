package ma.zs.zyn.service.impl.admin.inscription;


import ma.zs.zyn.bean.core.inscription.InscriptionCollaborator;
import ma.zs.zyn.dao.criteria.core.inscription.InscriptionCollaboratorCriteria;
import ma.zs.zyn.dao.facade.core.inscription.InscriptionCollaboratorDao;
import ma.zs.zyn.dao.specification.core.inscription.InscriptionCollaboratorSpecification;
import ma.zs.zyn.service.facade.admin.inscription.InscriptionCollaboratorAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.zyn.service.facade.admin.collaborator.CollaboratorAdminService ;
import ma.zs.zyn.bean.core.collaborator.Collaborator ;
import ma.zs.zyn.service.facade.admin.packaging.PackagingAdminService ;
import ma.zs.zyn.bean.core.packaging.Packaging ;
import ma.zs.zyn.service.facade.admin.inscription.InscriptionStateAdminService ;
import ma.zs.zyn.bean.core.inscription.InscriptionState ;

import java.util.List;
@Service
public class InscriptionCollaboratorAdminServiceImpl extends AbstractServiceImpl<InscriptionCollaborator, InscriptionCollaboratorCriteria, InscriptionCollaboratorDao> implements InscriptionCollaboratorAdminService {






    public void findOrSaveAssociatedObject(InscriptionCollaborator t){
        if( t != null) {
            t.setPackaging(packagingService.findOrSave(t.getPackaging()));
            t.setCollaborator(collaboratorService.findOrSave(t.getCollaborator()));
            t.setInscriptionState(inscriptionStateService.findOrSave(t.getInscriptionState()));
        }
    }

    public List<InscriptionCollaborator> findByPackagingId(Long id){
        return dao.findByPackagingId(id);
    }
    public int deleteByPackagingId(Long id){
        return dao.deleteByPackagingId(id);
    }
    public long countByPackagingId(Long id){
        return dao.countByPackagingId(id);
    }
    public List<InscriptionCollaborator> findByCollaboratorId(Long id){
        return dao.findByCollaboratorId(id);
    }
    public int deleteByCollaboratorId(Long id){
        return dao.deleteByCollaboratorId(id);
    }
    public long countByCollaboratorId(Long id){
        return dao.countByCollaboratorId(id);
    }
    public List<InscriptionCollaborator> findByInscriptionStateId(Long id){
        return dao.findByInscriptionStateId(id);
    }
    public int deleteByInscriptionStateId(Long id){
        return dao.deleteByInscriptionStateId(id);
    }
    public long countByInscriptionStateId(Long id){
        return dao.countByInscriptionStateId(id);
    }






    public void configure() {
        super.configure(InscriptionCollaborator.class, InscriptionCollaboratorSpecification.class);
    }


    @Autowired
    private CollaboratorAdminService collaboratorService ;
    @Autowired
    private PackagingAdminService packagingService ;
    @Autowired
    private InscriptionStateAdminService inscriptionStateService ;

    public InscriptionCollaboratorAdminServiceImpl(InscriptionCollaboratorDao dao) {
        super(dao);
    }

}
