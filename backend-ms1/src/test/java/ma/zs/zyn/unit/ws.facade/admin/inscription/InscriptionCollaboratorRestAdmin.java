package ma.zs.zyn.unit.ws.facade.admin.inscription;

import ma.zs.zyn.bean.core.inscription.InscriptionCollaborator;
import ma.zs.zyn.service.impl.admin.inscription.InscriptionCollaboratorAdminServiceImpl;
import ma.zs.zyn.ws.converter.inscription.InscriptionCollaboratorConverter;
import ma.zs.zyn.ws.dto.inscription.InscriptionCollaboratorDto;
import ma.zs.zyn.ws.facade.admin.inscription.InscriptionCollaboratorRestAdmin;
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
public class InscriptionCollaboratorRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private InscriptionCollaboratorAdminServiceImpl service;
    @Mock
    private InscriptionCollaboratorConverter converter;

    @InjectMocks
    private InscriptionCollaboratorRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllInscriptionCollaboratorTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<InscriptionCollaboratorDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<InscriptionCollaboratorDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveInscriptionCollaboratorTest() throws Exception {
        // Mock data
        InscriptionCollaboratorDto requestDto = new InscriptionCollaboratorDto();
        InscriptionCollaborator entity = new InscriptionCollaborator();
        InscriptionCollaborator saved = new InscriptionCollaborator();
        InscriptionCollaboratorDto savedDto = new InscriptionCollaboratorDto();

        // Mock the converter to return the inscriptionCollaborator object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved inscriptionCollaborator DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<InscriptionCollaboratorDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        InscriptionCollaboratorDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved inscriptionCollaborator DTO
        assertEquals(savedDto.getInscriptionDate(), responseBody.getInscriptionDate());
        assertEquals(savedDto.getRenewDate(), responseBody.getRenewDate());
    }

}
