package ma.zs.zyn.unit.ws.facade.admin.paiment;

import ma.zs.zyn.bean.core.paiment.PaimentInfluencer;
import ma.zs.zyn.service.impl.admin.paiment.PaimentInfluencerAdminServiceImpl;
import ma.zs.zyn.ws.converter.paiment.PaimentInfluencerConverter;
import ma.zs.zyn.ws.dto.paiment.PaimentInfluencerDto;
import ma.zs.zyn.ws.facade.admin.paiment.PaimentInfluencerRestAdmin;
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
public class PaimentInfluencerRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private PaimentInfluencerAdminServiceImpl service;
    @Mock
    private PaimentInfluencerConverter converter;

    @InjectMocks
    private PaimentInfluencerRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllPaimentInfluencerTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<PaimentInfluencerDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<PaimentInfluencerDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSavePaimentInfluencerTest() throws Exception {
        // Mock data
        PaimentInfluencerDto requestDto = new PaimentInfluencerDto();
        PaimentInfluencer entity = new PaimentInfluencer();
        PaimentInfluencer saved = new PaimentInfluencer();
        PaimentInfluencerDto savedDto = new PaimentInfluencerDto();

        // Mock the converter to return the paimentInfluencer object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved paimentInfluencer DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<PaimentInfluencerDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        PaimentInfluencerDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved paimentInfluencer DTO
        assertEquals(savedDto.getName(), responseBody.getName());
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getDatePaiement(), responseBody.getDatePaiement());
    }

}
