package ma.zs.zyn.unit.service.impl.admin.collaborator;

import ma.zs.zyn.bean.core.collaborator.Collaborator;
import ma.zs.zyn.dao.facade.core.collaborator.CollaboratorDao;
import ma.zs.zyn.service.impl.admin.collaborator.CollaboratorAdminServiceImpl;

import ma.zs.zyn.bean.core.packaging.Packaging ;
import ma.zs.zyn.bean.core.collaborator.Member ;
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
class CollaboratorAdminServiceImplTest {

    @Mock
    private CollaboratorDao repository;
    private AutoCloseable autoCloseable;
    private CollaboratorAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CollaboratorAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCollaborator() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCollaborator() {
        // Given
        Collaborator toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCollaborator() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCollaboratorById() {
        // Given
        Long idToRetrieve = 1L; // Example Collaborator ID to retrieve
        Collaborator expected = new Collaborator(); // You need to replace Collaborator with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Collaborator result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Collaborator constructSample(int i) {
		Collaborator given = new Collaborator();
        given.setId(id);
        given.setName("name-"+i);
        given.setName(name);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setPackaging(new Packaging(1L));
        given.setPackaging(packaging);
        given.setMember(new Member(1L));
        given.setMember(member);
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
