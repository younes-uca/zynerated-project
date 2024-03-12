package  ma.zs.zyn.ws.facade.admin.paiment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.paiment.PaimentInfluencer;
import ma.zs.zyn.dao.criteria.core.paiment.PaimentInfluencerCriteria;
import ma.zs.zyn.service.facade.admin.paiment.PaimentInfluencerAdminService;
import ma.zs.zyn.ws.converter.paiment.PaimentInfluencerConverter;
import ma.zs.zyn.ws.dto.paiment.PaimentInfluencerDto;
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
@RequestMapping("/api/admin/paimentInfluencer/")
public class PaimentInfluencerRestAdmin  extends AbstractController<PaimentInfluencer, PaimentInfluencerDto, PaimentInfluencerCriteria, PaimentInfluencerAdminService, PaimentInfluencerConverter> {



    @Operation(summary = "upload one paimentInfluencer")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paimentInfluencers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paimentInfluencers")
    @GetMapping("")
    public ResponseEntity<List<PaimentInfluencerDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paimentInfluencers")
    @GetMapping("optimized")
    public ResponseEntity<List<PaimentInfluencerDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paimentInfluencer by name")
    @GetMapping("name/{name}")
    public ResponseEntity<PaimentInfluencerDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new PaimentInfluencer(name));
    }

    @Operation(summary = "Saves the specified  paimentInfluencer")
    @PostMapping("")
    public ResponseEntity<PaimentInfluencerDto> save(@RequestBody PaimentInfluencerDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paimentInfluencer")
    @PutMapping("")
    public ResponseEntity<PaimentInfluencerDto> update(@RequestBody PaimentInfluencerDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paimentInfluencer")
    @PostMapping("multiple")
    public ResponseEntity<List<PaimentInfluencerDto>> delete(@RequestBody List<PaimentInfluencerDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paimentInfluencer")
    @DeleteMapping("")
    public ResponseEntity<PaimentInfluencerDto> delete(@RequestBody PaimentInfluencerDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paimentInfluencer")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paimentInfluencers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by influencer id")
    @GetMapping("influencer/id/{id}")
    public List<PaimentInfluencerDto> findByInfluencerId(@PathVariable Long id){
        return findDtos(service.findByInfluencerId(id));
    }
    @Operation(summary = "delete by influencer id")
    @DeleteMapping("influencer/id/{id}")
    public int deleteByInfluencerId(@PathVariable Long id){
        return service.deleteByInfluencerId(id);
    }
    @Operation(summary = "find by coupon id")
    @GetMapping("coupon/id/{id}")
    public List<PaimentInfluencerDto> findByCouponId(@PathVariable Long id){
        return findDtos(service.findByCouponId(id));
    }
    @Operation(summary = "delete by coupon id")
    @DeleteMapping("coupon/id/{id}")
    public int deleteByCouponId(@PathVariable Long id){
        return service.deleteByCouponId(id);
    }
    @Operation(summary = "find by paimentInfluencerState id")
    @GetMapping("paimentInfluencerState/id/{id}")
    public List<PaimentInfluencerDto> findByPaimentInfluencerStateId(@PathVariable Long id){
        return findDtos(service.findByPaimentInfluencerStateId(id));
    }
    @Operation(summary = "delete by paimentInfluencerState id")
    @DeleteMapping("paimentInfluencerState/id/{id}")
    public int deleteByPaimentInfluencerStateId(@PathVariable Long id){
        return service.deleteByPaimentInfluencerStateId(id);
    }

    @Operation(summary = "Finds a paimentInfluencer and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaimentInfluencerDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds paimentInfluencers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaimentInfluencerDto>> findByCriteria(@RequestBody PaimentInfluencerCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paimentInfluencers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaimentInfluencerCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paimentInfluencers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaimentInfluencerCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paimentInfluencer data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaimentInfluencerCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaimentInfluencerRestAdmin (PaimentInfluencerAdminService service, PaimentInfluencerConverter converter) {
        super(service, converter);
    }




}
