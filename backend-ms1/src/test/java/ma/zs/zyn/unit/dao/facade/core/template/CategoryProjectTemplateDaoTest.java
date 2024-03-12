package ma.zs.zyn.unit.dao.facade.core.template;

import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.dao.facade.core.template.CategoryProjectTemplateDao;

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
public class CategoryProjectTemplateDaoTest {

@Autowired
    private CategoryProjectTemplateDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        CategoryProjectTemplate entity = new CategoryProjectTemplate();
        entity.setId(id);
        underTest.save(entity);
        CategoryProjectTemplate loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CategoryProjectTemplate entity = new CategoryProjectTemplate();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CategoryProjectTemplate loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CategoryProjectTemplate> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CategoryProjectTemplate> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CategoryProjectTemplate given = constructSample(1);
        CategoryProjectTemplate saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CategoryProjectTemplate constructSample(int i) {
		CategoryProjectTemplate given = new CategoryProjectTemplate();
        given.setCode("code-"+i);
        given.setName("name-"+i);
        return given;
    }

}
