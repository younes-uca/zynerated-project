package ma.zs.zyn.unit.service.impl.admin.template;

import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import ma.zs.zyn.dao.facade.core.template.SubDomainTemplateDao;
import ma.zs.zyn.service.impl.admin.template.SubDomainTemplateAdminServiceImpl;

import ma.zs.zyn.bean.core.template.DomainTemplate ;
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
class SubDomainTemplateAdminServiceImplTest {

    @Mock
    private SubDomainTemplateDao repository;
    private AutoCloseable autoCloseable;
    private SubDomainTemplateAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SubDomainTemplateAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSubDomainTemplate() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSubDomainTemplate() {
        // Given
        SubDomainTemplate toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSubDomainTemplate() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSubDomainTemplateById() {
        // Given
        Long idToRetrieve = 1L; // Example SubDomainTemplate ID to retrieve
        SubDomainTemplate expected = new SubDomainTemplate(); // You need to replace SubDomainTemplate with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        SubDomainTemplate result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private SubDomainTemplate constructSample(int i) {
		SubDomainTemplate given = new SubDomainTemplate();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setName("name-"+i);
        given.setName(name);
        given.setDomainTemplate(new DomainTemplate(1L));
        given.setDomainTemplate(domainTemplate);
        return given;
    }

}
