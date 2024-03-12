package ma.zs.zyn.unit.dao.facade.core.project;

import ma.zs.zyn.bean.core.project.PaimentInfluencerState;
import ma.zs.zyn.dao.facade.core.project.PaimentInfluencerStateDao;

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
public class PaimentInfluencerStateDaoTest {

@Autowired
    private PaimentInfluencerStateDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        PaimentInfluencerState entity = new PaimentInfluencerState();
        entity.setCode(code);
        underTest.save(entity);
        PaimentInfluencerState loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        PaimentInfluencerState entity = new PaimentInfluencerState();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        PaimentInfluencerState loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        PaimentInfluencerState entity = new PaimentInfluencerState();
        entity.setId(id);
        underTest.save(entity);
        PaimentInfluencerState loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        PaimentInfluencerState entity = new PaimentInfluencerState();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        PaimentInfluencerState loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<PaimentInfluencerState> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<PaimentInfluencerState> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        PaimentInfluencerState given = constructSample(1);
        PaimentInfluencerState saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private PaimentInfluencerState constructSample(int i) {
		PaimentInfluencerState given = new PaimentInfluencerState();
        given.setCode("code-"+i);
        given.setName("name-"+i);
        return given;
    }

}
