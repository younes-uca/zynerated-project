package ma.zs.zyn.dao.facade.core.inscription;

import org.springframework.data.jpa.repository.Query;
import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.inscription.InscriptionState;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InscriptionStateDao extends AbstractRepository<InscriptionState,Long>  {


    @Query("SELECT NEW InscriptionState(item.id,item.name) FROM InscriptionState item")
    List<InscriptionState> findAllOptimized();

}
