package ma.zs.zyn.unit.ws.facade.admin.coupon;

import ma.zs.zyn.bean.core.coupon.Coupon;
import ma.zs.zyn.service.impl.admin.coupon.CouponAdminServiceImpl;
import ma.zs.zyn.ws.converter.coupon.CouponConverter;
import ma.zs.zyn.ws.dto.coupon.CouponDto;
import ma.zs.zyn.ws.facade.admin.coupon.CouponRestAdmin;
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
public class CouponRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private CouponAdminServiceImpl service;
    @Mock
    private CouponConverter converter;

    @InjectMocks
    private CouponRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCouponTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CouponDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CouponDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCouponTest() throws Exception {
        // Mock data
        CouponDto requestDto = new CouponDto();
        Coupon entity = new Coupon();
        Coupon saved = new Coupon();
        CouponDto savedDto = new CouponDto();

        // Mock the converter to return the coupon object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved coupon DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CouponDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CouponDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved coupon DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getDateDebut(), responseBody.getDateDebut());
        assertEquals(savedDto.getDateFin(), responseBody.getDateFin());
        assertEquals(savedDto.getName(), responseBody.getName());
        assertEquals(savedDto.getPourcentageCoupon(), responseBody.getPourcentageCoupon());
        assertEquals(savedDto.getPourcentageInfluencer(), responseBody.getPourcentageInfluencer());
        assertEquals(savedDto.getUsingNumber(), responseBody.getUsingNumber());
    }

}
