package ma.zs.zyn.unit.dao.facade.core.paiment;

import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import ma.zs.zyn.dao.facade.core.paiment.PaimentCollaboratorDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PaimentCollaboratorDaoTest {

@Autowired
    private PaimentCollaboratorDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        PaimentCollaborator entity = new PaimentCollaborator();
        entity.setId(id);
        underTest.save(entity);
        PaimentCollaborator loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        PaimentCollaborator entity = new PaimentCollaborator();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        PaimentCollaborator loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<PaimentCollaborator> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<PaimentCollaborator> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        PaimentCollaborator given = constructSample(1);
        PaimentCollaborator saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private PaimentCollaborator constructSample(int i) {
		PaimentCollaborator given = new PaimentCollaborator();
        given.setName("name-"+i);
        given.setDescription("description-"+i);
        given.setCode("code-"+i);
        given.setCollaborator(new Collaborator(1L));
        given.setCoupon(new Coupon(1L));
        given.setDatePaiement(LocalDateTime.now());
        given.setPaimentCollaboratorState(new PaimentCollaboratorState(1L));
        return given;
    }

}
