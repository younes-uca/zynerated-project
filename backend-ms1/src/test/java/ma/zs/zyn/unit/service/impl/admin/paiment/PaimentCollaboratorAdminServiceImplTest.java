package ma.zs.zyn.unit.service.impl.admin.paiment;

import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import ma.zs.zyn.dao.facade.core.paiment.PaimentCollaboratorDao;
import ma.zs.zyn.service.impl.admin.paiment.PaimentCollaboratorAdminServiceImpl;

import ma.zs.zyn.bean.core.collaborator.Collaborator ;
import ma.zs.zyn.bean.core.coupon.Coupon ;
import ma.zs.zyn.bean.core.project.PaimentCollaboratorState ;
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
class PaimentCollaboratorAdminServiceImplTest {

    @Mock
    private PaimentCollaboratorDao repository;
    private AutoCloseable autoCloseable;
    private PaimentCollaboratorAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PaimentCollaboratorAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPaimentCollaborator() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePaimentCollaborator() {
        // Given
        PaimentCollaborator toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePaimentCollaborator() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPaimentCollaboratorById() {
        // Given
        Long idToRetrieve = 1L; // Example PaimentCollaborator ID to retrieve
        PaimentCollaborator expected = new PaimentCollaborator(); // You need to replace PaimentCollaborator with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        PaimentCollaborator result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private PaimentCollaborator constructSample(int i) {
		PaimentCollaborator given = new PaimentCollaborator();
        given.setId(id);
        given.setName("name-"+i);
        given.setName(name);
        given.setDescription("description-"+i);
        given.setDescription(description);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setCollaborator(new Collaborator(1L));
        given.setCollaborator(collaborator);
        given.setCoupon(new Coupon(1L));
        given.setCoupon(coupon);
        given.setDatePaiement(LocalDateTime.now());
        given.setDatePaiement(datePaiement);
        given.setPaimentCollaboratorState(new PaimentCollaboratorState(1L));
        given.setPaimentCollaboratorState(paimentCollaboratorState);
        return given;
    }

}
