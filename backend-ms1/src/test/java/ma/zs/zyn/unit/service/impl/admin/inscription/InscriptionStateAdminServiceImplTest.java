package ma.zs.zyn.unit.service.impl.admin.inscription;

import ma.zs.zyn.bean.core.inscription.InscriptionState;
import ma.zs.zyn.dao.facade.core.inscription.InscriptionStateDao;
import ma.zs.zyn.service.impl.admin.inscription.InscriptionStateAdminServiceImpl;

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
class InscriptionStateAdminServiceImplTest {

    @Mock
    private InscriptionStateDao repository;
    private AutoCloseable autoCloseable;
    private InscriptionStateAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new InscriptionStateAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllInscriptionState() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveInscriptionState() {
        // Given
        InscriptionState toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteInscriptionState() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetInscriptionStateById() {
        // Given
        Long idToRetrieve = 1L; // Example InscriptionState ID to retrieve
        InscriptionState expected = new InscriptionState(); // You need to replace InscriptionState with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        InscriptionState result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private InscriptionState constructSample(int i) {
		InscriptionState given = new InscriptionState();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setName("name-"+i);
        given.setName(name);
        return given;
    }

}
