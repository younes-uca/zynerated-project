package  ma.zs.zyn.ws.facade.admin.coupon;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.coupon.Coupon;
import ma.zs.zyn.dao.criteria.core.coupon.CouponCriteria;
import ma.zs.zyn.service.facade.admin.coupon.CouponAdminService;
import ma.zs.zyn.ws.converter.coupon.CouponConverter;
import ma.zs.zyn.ws.dto.coupon.CouponDto;
import ma.zs.zyn.zynerator.controller.AbstractController;
import ma.zs.zyn.zynerator.dto.AuditEntityDto;
import ma.zs.zyn.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.zyn.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.zyn.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/coupon/")
public class CouponRestAdmin  extends AbstractController<Coupon, CouponDto, CouponCriteria, CouponAdminService, CouponConverter> {



    @Operation(summary = "upload one coupon")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple coupons")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all coupons")
    @GetMapping("")
    public ResponseEntity<List<CouponDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all coupons")
    @GetMapping("optimized")
    public ResponseEntity<List<CouponDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a coupon by name")
    @GetMapping("name/{name}")
    public ResponseEntity<CouponDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new Coupon(name));
    }

    @Operation(summary = "Saves the specified  coupon")
    @PostMapping("")
    public ResponseEntity<CouponDto> save(@RequestBody CouponDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  coupon")
    @PutMapping("")
    public ResponseEntity<CouponDto> update(@RequestBody CouponDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of coupon")
    @PostMapping("multiple")
    public ResponseEntity<List<CouponDto>> delete(@RequestBody List<CouponDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified coupon")
    @DeleteMapping("")
    public ResponseEntity<CouponDto> delete(@RequestBody CouponDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified coupon")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple coupons by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by packaging id")
    @GetMapping("packaging/id/{id}")
    public List<CouponDto> findByPackagingId(@PathVariable Long id){
        return findDtos(service.findByPackagingId(id));
    }
    @Operation(summary = "delete by packaging id")
    @DeleteMapping("packaging/id/{id}")
    public int deleteByPackagingId(@PathVariable Long id){
        return service.deleteByPackagingId(id);
    }
    @Operation(summary = "find by influencer id")
    @GetMapping("influencer/id/{id}")
    public List<CouponDto> findByInfluencerId(@PathVariable Long id){
        return findDtos(service.findByInfluencerId(id));
    }
    @Operation(summary = "delete by influencer id")
    @DeleteMapping("influencer/id/{id}")
    public int deleteByInfluencerId(@PathVariable Long id){
        return service.deleteByInfluencerId(id);
    }

    @Operation(summary = "Finds a coupon and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CouponDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds coupons by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CouponDto>> findByCriteria(@RequestBody CouponCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated coupons by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CouponCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports coupons by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CouponCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets coupon data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CouponCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CouponRestAdmin (CouponAdminService service, CouponConverter converter) {
        super(service, converter);
    }




}
