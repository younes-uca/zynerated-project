package ma.zs.zyn.unit.service.impl.admin.template;

import ma.zs.zyn.bean.core.template.DomainTemplate;
import ma.zs.zyn.dao.facade.core.template.DomainTemplateDao;
import ma.zs.zyn.service.impl.admin.template.DomainTemplateAdminServiceImpl;

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
class DomainTemplateAdminServiceImplTest {

    @Mock
    private DomainTemplateDao repository;
    private AutoCloseable autoCloseable;
    private DomainTemplateAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new DomainTemplateAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllDomainTemplate() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveDomainTemplate() {
        // Given
        DomainTemplate toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteDomainTemplate() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetDomainTemplateById() {
        // Given
        Long idToRetrieve = 1L; // Example DomainTemplate ID to retrieve
        DomainTemplate expected = new DomainTemplate(); // You need to replace DomainTemplate with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        DomainTemplate result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private DomainTemplate constructSample(int i) {
		DomainTemplate given = new DomainTemplate();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setName("name-"+i);
        given.setName(name);
        return given;
    }

}
