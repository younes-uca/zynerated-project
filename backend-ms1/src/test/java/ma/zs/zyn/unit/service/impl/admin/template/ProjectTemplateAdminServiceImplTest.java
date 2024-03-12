package ma.zs.zyn.unit.service.impl.admin.template;

import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.dao.facade.core.template.ProjectTemplateDao;
import ma.zs.zyn.service.impl.admin.template.ProjectTemplateAdminServiceImpl;

import ma.zs.zyn.bean.core.template.SubDomainTemplate ;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate ;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProjectTemplateAdminServiceImplTest {

    @Mock
    private ProjectTemplateDao repository;
    private AutoCloseable autoCloseable;
    private ProjectTemplateAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ProjectTemplateAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllProjectTemplate() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveProjectTemplate() {
        // Given
        ProjectTemplate toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteProjectTemplate() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetProjectTemplateById() {
        // Given
        Long idToRetrieve = 1L; // Example ProjectTemplate ID to retrieve
        ProjectTemplate expected = new ProjectTemplate(); // You need to replace ProjectTemplate with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ProjectTemplate result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ProjectTemplate constructSample(int i) {
		ProjectTemplate given = new ProjectTemplate();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setName("name-"+i);
        given.setName(name);
        given.setAddingDate(LocalDateTime.now());
        given.setAddingDate(addingDate);
        given.setLastUpdateDate(LocalDateTime.now());
        given.setLastUpdateDate(lastUpdateDate);
        given.setCategoryProjectTemplate(new CategoryProjectTemplate(1L));
        given.setCategoryProjectTemplate(categoryProjectTemplate);
        given.setProjectTemplateTags("projectTemplateTags-"+i);
        given.setProjectTemplateTags(projectTemplateTags);
        given.setSubDomainTemplate(new SubDomainTemplate(1L));
        given.setSubDomainTemplate(subDomainTemplate);
        given.setPrice(BigDecimal.TEN);
        given.setPrice(price);
        return given;
    }

}
