package ma.zs.zyn.unit.ws.facade.admin.inscription;

import ma.zs.zyn.bean.core.inscription.InscriptionState;
import ma.zs.zyn.service.impl.admin.inscription.InscriptionStateAdminServiceImpl;
import ma.zs.zyn.ws.converter.inscription.InscriptionStateConverter;
import ma.zs.zyn.ws.dto.inscription.InscriptionStateDto;
import ma.zs.zyn.ws.facade.admin.inscription.InscriptionStateRestAdmin;
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
public class InscriptionStateRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private InscriptionStateAdminServiceImpl service;
    @Mock
    private InscriptionStateConverter converter;

    @InjectMocks
    private InscriptionStateRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllInscriptionStateTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<InscriptionStateDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<InscriptionStateDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveInscriptionStateTest() throws Exception {
        // Mock data
        InscriptionStateDto requestDto = new InscriptionStateDto();
        InscriptionState entity = new InscriptionState();
        InscriptionState saved = new InscriptionState();
        InscriptionStateDto savedDto = new InscriptionStateDto();

        // Mock the converter to return the inscriptionState object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved inscriptionState DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<InscriptionStateDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        InscriptionStateDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved inscriptionState DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getName(), responseBody.getName());
    }

}
