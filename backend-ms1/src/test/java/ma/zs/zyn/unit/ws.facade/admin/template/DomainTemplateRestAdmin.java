package ma.zs.zyn.unit.ws.facade.admin.template;

import ma.zs.zyn.bean.core.template.DomainTemplate;
import ma.zs.zyn.service.impl.admin.template.DomainTemplateAdminServiceImpl;
import ma.zs.zyn.ws.converter.template.DomainTemplateConverter;
import ma.zs.zyn.ws.dto.template.DomainTemplateDto;
import ma.zs.zyn.ws.facade.admin.template.DomainTemplateRestAdmin;
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
public class DomainTemplateRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private DomainTemplateAdminServiceImpl service;
    @Mock
    private DomainTemplateConverter converter;

    @InjectMocks
    private DomainTemplateRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllDomainTemplateTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<DomainTemplateDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<DomainTemplateDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveDomainTemplateTest() throws Exception {
        // Mock data
        DomainTemplateDto requestDto = new DomainTemplateDto();
        DomainTemplate entity = new DomainTemplate();
        DomainTemplate saved = new DomainTemplate();
        DomainTemplateDto savedDto = new DomainTemplateDto();

        // Mock the converter to return the domainTemplate object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved domainTemplate DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<DomainTemplateDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        DomainTemplateDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved domainTemplate DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getName(), responseBody.getName());
    }

}
