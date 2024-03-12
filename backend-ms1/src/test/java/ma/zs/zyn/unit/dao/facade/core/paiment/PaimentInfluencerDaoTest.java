package ma.zs.zyn.unit.dao.facade.core.paiment;

import ma.zs.zyn.bean.core.paiment.PaimentInfluencer;
import ma.zs.zyn.dao.facade.core.paiment.PaimentInfluencerDao;

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
public class PaimentInfluencerDaoTest {

@Autowired
    private PaimentInfluencerDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        PaimentInfluencer entity = new PaimentInfluencer();
        entity.setId(id);
        underTest.save(entity);
        PaimentInfluencer loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        PaimentInfluencer entity = new PaimentInfluencer();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        PaimentInfluencer loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<PaimentInfluencer> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<PaimentInfluencer> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        PaimentInfluencer given = constructSample(1);
        PaimentInfluencer saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private PaimentInfluencer constructSample(int i) {
		PaimentInfluencer given = new PaimentInfluencer();
        given.setName("name-"+i);
        given.setDescription("description-"+i);
        given.setCode("code-"+i);
        given.setInfluencer(new Influencer(1L));
        given.setCoupon(new Coupon(1L));
        given.setDatePaiement(LocalDateTime.now());
        given.setPaimentInfluencerState(new PaimentInfluencerState(1L));
        return given;
    }

}
