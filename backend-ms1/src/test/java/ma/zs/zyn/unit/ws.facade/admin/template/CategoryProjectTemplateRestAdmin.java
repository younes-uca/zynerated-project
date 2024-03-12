package ma.zs.zyn.unit.ws.facade.admin.template;

import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.service.impl.admin.template.CategoryProjectTemplateAdminServiceImpl;
import ma.zs.zyn.ws.converter.template.CategoryProjectTemplateConverter;
import ma.zs.zyn.ws.dto.template.CategoryProjectTemplateDto;
import ma.zs.zyn.ws.facade.admin.template.CategoryProjectTemplateRestAdmin;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryProjectTemplateRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private CategoryProjectTemplateAdminServiceImpl service;
    @Mock
    private CategoryProjectTemplateConverter converter;

    @InjectMocks
    private CategoryProjectTemplateRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCategoryProjectTemplateTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CategoryProjectTemplateDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CategoryProjectTemplateDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCategoryProjectTemplateTest() throws Exception {
        // Mock data
        CategoryProjectTemplateDto requestDto = new CategoryProjectTemplateDto();
        CategoryProjectTemplate entity = new CategoryProjectTemplate();
        CategoryProjectTemplate saved = new CategoryProjectTemplate();
        CategoryProjectTemplateDto savedDto = new CategoryProjectTemplateDto();

        // Mock the converter to return the categoryProjectTemplate object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved categoryProjectTemplate DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CategoryProjectTemplateDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CategoryProjectTemplateDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved categoryProjectTemplate DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getName(), responseBody.getName());
    }

}
