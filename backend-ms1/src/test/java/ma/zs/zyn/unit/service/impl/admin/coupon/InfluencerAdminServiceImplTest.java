package ma.zs.zyn.unit.service.impl.admin.coupon;

import ma.zs.zyn.bean.core.coupon.Influencer;
import ma.zs.zyn.dao.facade.core.coupon.InfluencerDao;
import ma.zs.zyn.service.impl.admin.coupon.InfluencerAdminServiceImpl;

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
class InfluencerAdminServiceImplTest {

    @Mock
    private InfluencerDao repository;
    private AutoCloseable autoCloseable;
    private InfluencerAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new InfluencerAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllInfluencer() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveInfluencer() {
        // Given
        Influencer toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteInfluencer() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetInfluencerById() {
        // Given
        Long idToRetrieve = 1L; // Example Influencer ID to retrieve
        Influencer expected = new Influencer(); // You need to replace Influencer with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Influencer result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Influencer constructSample(int i) {
		Influencer given = new Influencer();
        given.setId(id);
        given.setNickName("nickName-"+i);
        given.setNickName(nickName);
        given.setCredentialsNonExpired(false);
        given.setCredentialsNonExpired(credentialsNonExpired);
        given.setEnabled(false);
        given.setEnabled(enabled);
        given.setAccountNonExpired(false);
        given.setAccountNonExpired(accountNonExpired);
        given.setAccountNonLocked(false);
        given.setAccountNonLocked(accountNonLocked);
        given.setPasswordChanged(false);
        given.setPasswordChanged(passwordChanged);
        given.setUsername("username-"+i);
        given.setUsername(username);
        given.setPassword("password-"+i);
        given.setPassword(password);
        return given;
    }

}
