package ma.zs.zyn.dao.facade.core.paiment;

import org.springframework.data.jpa.repository.Query;
import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PaimentCollaboratorDao extends AbstractRepository<PaimentCollaborator,Long>  {

    List<PaimentCollaborator> findByCollaboratorId(Long id);
    int deleteByCollaboratorId(Long id);
    long countByCollaboratorId(Long id);
    List<PaimentCollaborator> findByCouponId(Long id);
    int deleteByCouponId(Long id);
    long countByCouponCode(String code);
    List<PaimentCollaborator> findByPaimentCollaboratorStateId(Long id);
    int deleteByPaimentCollaboratorStateId(Long id);
    long countByPaimentCollaboratorStateCode(String code);

    @Query("SELECT NEW PaimentCollaborator(item.id,item.name) FROM PaimentCollaborator item")
    List<PaimentCollaborator> findAllOptimized();

}
