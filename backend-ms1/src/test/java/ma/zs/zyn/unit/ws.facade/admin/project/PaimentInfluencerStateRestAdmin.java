package ma.zs.zyn.unit.ws.facade.admin.project;

import ma.zs.zyn.bean.core.project.PaimentInfluencerState;
import ma.zs.zyn.service.impl.admin.project.PaimentInfluencerStateAdminServiceImpl;
import ma.zs.zyn.ws.converter.project.PaimentInfluencerStateConverter;
import ma.zs.zyn.ws.dto.project.PaimentInfluencerStateDto;
import ma.zs.zyn.ws.facade.admin.project.PaimentInfluencerStateRestAdmin;
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
public class PaimentInfluencerStateRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private PaimentInfluencerStateAdminServiceImpl service;
    @Mock
    private PaimentInfluencerStateConverter converter;

    @InjectMocks
    private PaimentInfluencerStateRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllPaimentInfluencerStateTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<PaimentInfluencerStateDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<PaimentInfluencerStateDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSavePaimentInfluencerStateTest() throws Exception {
        // Mock data
        PaimentInfluencerStateDto requestDto = new PaimentInfluencerStateDto();
        PaimentInfluencerState entity = new PaimentInfluencerState();
        PaimentInfluencerState saved = new PaimentInfluencerState();
        PaimentInfluencerStateDto savedDto = new PaimentInfluencerStateDto();

        // Mock the converter to return the paimentInfluencerState object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved paimentInfluencerState DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<PaimentInfluencerStateDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        PaimentInfluencerStateDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved paimentInfluencerState DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getName(), responseBody.getName());
    }

}
