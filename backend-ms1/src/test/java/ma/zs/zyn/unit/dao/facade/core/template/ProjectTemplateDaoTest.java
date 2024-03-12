package ma.zs.zyn.unit.dao.facade.core.template;

import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.dao.facade.core.template.ProjectTemplateDao;

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
public class ProjectTemplateDaoTest {

@Autowired
    private ProjectTemplateDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        ProjectTemplate entity = new ProjectTemplate();
        entity.setCode(code);
        underTest.save(entity);
        ProjectTemplate loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        ProjectTemplate entity = new ProjectTemplate();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        ProjectTemplate loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        ProjectTemplate entity = new ProjectTemplate();
        entity.setId(id);
        underTest.save(entity);
        ProjectTemplate loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ProjectTemplate entity = new ProjectTemplate();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ProjectTemplate loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ProjectTemplate> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ProjectTemplate> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ProjectTemplate given = constructSample(1);
        ProjectTemplate saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ProjectTemplate constructSample(int i) {
		ProjectTemplate given = new ProjectTemplate();
        given.setCode("code-"+i);
        given.setName("name-"+i);
        given.setAddingDate(LocalDateTime.now());
        given.setLastUpdateDate(LocalDateTime.now());
        given.setCategoryProjectTemplate(new CategoryProjectTemplate(1L));
        given.setProjectTemplateTags("projectTemplateTags-"+i);
        given.setSubDomainTemplate(new SubDomainTemplate(1L));
        given.setPrice(BigDecimal.TEN);
        return given;
    }

}
