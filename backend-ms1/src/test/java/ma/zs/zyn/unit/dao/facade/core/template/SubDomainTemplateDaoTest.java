package ma.zs.zyn.unit.dao.facade.core.template;

import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import ma.zs.zyn.dao.facade.core.template.SubDomainTemplateDao;

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
public class SubDomainTemplateDaoTest {

@Autowired
    private SubDomainTemplateDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        SubDomainTemplate entity = new SubDomainTemplate();
        entity.setId(id);
        underTest.save(entity);
        SubDomainTemplate loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        SubDomainTemplate entity = new SubDomainTemplate();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        SubDomainTemplate loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<SubDomainTemplate> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<SubDomainTemplate> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        SubDomainTemplate given = constructSample(1);
        SubDomainTemplate saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private SubDomainTemplate constructSample(int i) {
		SubDomainTemplate given = new SubDomainTemplate();
        given.setCode("code-"+i);
        given.setName("name-"+i);
        given.setDomainTemplate(new DomainTemplate(1L));
        return given;
    }

}
