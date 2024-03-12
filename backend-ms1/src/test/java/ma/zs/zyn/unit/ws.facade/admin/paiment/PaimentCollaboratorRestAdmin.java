package ma.zs.zyn.unit.ws.facade.admin.paiment;

import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import ma.zs.zyn.service.impl.admin.paiment.PaimentCollaboratorAdminServiceImpl;
import ma.zs.zyn.ws.converter.paiment.PaimentCollaboratorConverter;
import ma.zs.zyn.ws.dto.paiment.PaimentCollaboratorDto;
import ma.zs.zyn.ws.facade.admin.paiment.PaimentCollaboratorRestAdmin;
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
public class PaimentCollaboratorRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private PaimentCollaboratorAdminServiceImpl service;
    @Mock
    private PaimentCollaboratorConverter converter;

    @InjectMocks
    private PaimentCollaboratorRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllPaimentCollaboratorTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<PaimentCollaboratorDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<PaimentCollaboratorDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSavePaimentCollaboratorTest() throws Exception {
        // Mock data
        PaimentCollaboratorDto requestDto = new PaimentCollaboratorDto();
        PaimentCollaborator entity = new PaimentCollaborator();
        PaimentCollaborator saved = new PaimentCollaborator();
        PaimentCollaboratorDto savedDto = new PaimentCollaboratorDto();

        // Mock the converter to return the paimentCollaborator object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved paimentCollaborator DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<PaimentCollaboratorDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        PaimentCollaboratorDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved paimentCollaborator DTO
        assertEquals(savedDto.getName(), responseBody.getName());
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getDatePaiement(), responseBody.getDatePaiement());
    }

}
