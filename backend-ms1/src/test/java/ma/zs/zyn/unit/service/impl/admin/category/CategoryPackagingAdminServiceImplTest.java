package ma.zs.zyn.unit.service.impl.admin.category;

import ma.zs.zyn.bean.core.category.CategoryPackaging;
import ma.zs.zyn.dao.facade.core.category.CategoryPackagingDao;
import ma.zs.zyn.service.impl.admin.category.CategoryPackagingAdminServiceImpl;

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
class CategoryPackagingAdminServiceImplTest {

    @Mock
    private CategoryPackagingDao repository;
    private AutoCloseable autoCloseable;
    private CategoryPackagingAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategoryPackagingAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategoryPackaging() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCategoryPackaging() {
        // Given
        CategoryPackaging toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCategoryPackaging() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCategoryPackagingById() {
        // Given
        Long idToRetrieve = 1L; // Example CategoryPackaging ID to retrieve
        CategoryPackaging expected = new CategoryPackaging(); // You need to replace CategoryPackaging with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CategoryPackaging result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CategoryPackaging constructSample(int i) {
		CategoryPackaging given = new CategoryPackaging();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setName("name-"+i);
        given.setName(name);
        return given;
    }

}
