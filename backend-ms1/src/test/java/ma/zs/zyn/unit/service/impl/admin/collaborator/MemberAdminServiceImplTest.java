package ma.zs.zyn.unit.service.impl.admin.collaborator;

import ma.zs.zyn.bean.core.collaborator.Member;
import ma.zs.zyn.dao.facade.core.collaborator.MemberDao;
import ma.zs.zyn.service.impl.admin.collaborator.MemberAdminServiceImpl;

import ma.zs.zyn.bean.core.collaborator.Collaborator ;
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
class MemberAdminServiceImplTest {

    @Mock
    private MemberDao repository;
    private AutoCloseable autoCloseable;
    private MemberAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new MemberAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllMember() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveMember() {
        // Given
        Member toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteMember() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetMemberById() {
        // Given
        Long idToRetrieve = 1L; // Example Member ID to retrieve
        Member expected = new Member(); // You need to replace Member with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Member result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Member constructSample(int i) {
		Member given = new Member();
        given.setId(id);
        given.setDescription("description-"+i);
        given.setDescription(description);
        given.setCollaborator(new Collaborator(1L));
        given.setCollaborator(collaborator);
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
