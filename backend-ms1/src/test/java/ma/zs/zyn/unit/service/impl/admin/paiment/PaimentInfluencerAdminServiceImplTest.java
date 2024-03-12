package ma.zs.zyn.unit.service.impl.admin.paiment;

import ma.zs.zyn.bean.core.paiment.PaimentInfluencer;
import ma.zs.zyn.dao.facade.core.paiment.PaimentInfluencerDao;
import ma.zs.zyn.service.impl.admin.paiment.PaimentInfluencerAdminServiceImpl;

import ma.zs.zyn.bean.core.coupon.Coupon ;
import ma.zs.zyn.bean.core.coupon.Influencer ;
import ma.zs.zyn.bean.core.project.PaimentInfluencerState ;
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
class PaimentInfluencerAdminServiceImplTest {

    @Mock
    private PaimentInfluencerDao repository;
    private AutoCloseable autoCloseable;
    private PaimentInfluencerAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PaimentInfluencerAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPaimentInfluencer() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePaimentInfluencer() {
        // Given
        PaimentInfluencer toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePaimentInfluencer() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPaimentInfluencerById() {
        // Given
        Long idToRetrieve = 1L; // Example PaimentInfluencer ID to retrieve
        PaimentInfluencer expected = new PaimentInfluencer(); // You need to replace PaimentInfluencer with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        PaimentInfluencer result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private PaimentInfluencer constructSample(int i) {
		PaimentInfluencer given = new PaimentInfluencer();
        given.setId(id);
        given.setName("name-"+i);
        given.setName(name);
        given.setDescription("description-"+i);
        given.setDescription(description);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setInfluencer(new Influencer(1L));
        given.setInfluencer(influencer);
        given.setCoupon(new Coupon(1L));
        given.setCoupon(coupon);
        given.setDatePaiement(LocalDateTime.now());
        given.setDatePaiement(datePaiement);
        given.setPaimentInfluencerState(new PaimentInfluencerState(1L));
        given.setPaimentInfluencerState(paimentInfluencerState);
        return given;
    }

}
