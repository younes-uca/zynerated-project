package ma.zs.zyn.unit.service.impl.admin.project;

import ma.zs.zyn.bean.core.project.Project;
import ma.zs.zyn.dao.facade.core.project.ProjectDao;
import ma.zs.zyn.service.impl.admin.project.ProjectAdminServiceImpl;

import ma.zs.zyn.bean.core.project.ProjectState ;
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
class ProjectAdminServiceImplTest {

    @Mock
    private ProjectDao repository;
    private AutoCloseable autoCloseable;
    private ProjectAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ProjectAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllProject() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveProject() {
        // Given
        Project toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteProject() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetProjectById() {
        // Given
        Long idToRetrieve = 1L; // Example Project ID to retrieve
        Project expected = new Project(); // You need to replace Project with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Project result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Project constructSample(int i) {
		Project given = new Project();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setName("name-"+i);
        given.setName(name);
        given.setGeneratedDate(LocalDateTime.now());
        given.setGeneratedDate(generatedDate);
        given.setYaml("yaml-"+i);
        given.setYaml(yaml);
        given.setOwner(new Member(1L));
        given.setOwner(owner);
        given.setProjectState(new ProjectState(1L));
        given.setProjectState(projectState);
        return given;
    }

}
