package ma.zs.zyn.unit.service.impl.admin.project;

import ma.zs.zyn.bean.core.project.PaimentInfluencerState;
import ma.zs.zyn.dao.facade.core.project.PaimentInfluencerStateDao;
import ma.zs.zyn.service.impl.admin.project.PaimentInfluencerStateAdminServiceImpl;

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
class PaimentInfluencerStateAdminServiceImplTest {

    @Mock
    private PaimentInfluencerStateDao repository;
    private AutoCloseable autoCloseable;
    private PaimentInfluencerStateAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PaimentInfluencerStateAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPaimentInfluencerState() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePaimentInfluencerState() {
        // Given
        PaimentInfluencerState toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePaimentInfluencerState() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPaimentInfluencerStateById() {
        // Given
        Long idToRetrieve = 1L; // Example PaimentInfluencerState ID to retrieve
        PaimentInfluencerState expected = new PaimentInfluencerState(); // You need to replace PaimentInfluencerState with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        PaimentInfluencerState result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private PaimentInfluencerState constructSample(int i) {
		PaimentInfluencerState given = new PaimentInfluencerState();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setName("name-"+i);
        given.setName(name);
        return given;
    }

}
