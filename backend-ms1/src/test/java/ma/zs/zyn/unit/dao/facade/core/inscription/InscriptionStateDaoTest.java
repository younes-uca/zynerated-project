package ma.zs.zyn.unit.dao.facade.core.inscription;

import ma.zs.zyn.bean.core.inscription.InscriptionState;
import ma.zs.zyn.dao.facade.core.inscription.InscriptionStateDao;

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
public class InscriptionStateDaoTest {

@Autowired
    private InscriptionStateDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        InscriptionState entity = new InscriptionState();
        entity.setId(id);
        underTest.save(entity);
        InscriptionState loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        InscriptionState entity = new InscriptionState();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        InscriptionState loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<InscriptionState> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<InscriptionState> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        InscriptionState given = constructSample(1);
        InscriptionState saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private InscriptionState constructSample(int i) {
		InscriptionState given = new InscriptionState();
        given.setCode("code-"+i);
        given.setName("name-"+i);
        return given;
    }

}
