package  ma.zs.zyn.ws.facade.admin.paiment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import ma.zs.zyn.dao.criteria.core.paiment.PaimentCollaboratorCriteria;
import ma.zs.zyn.service.facade.admin.paiment.PaimentCollaboratorAdminService;
import ma.zs.zyn.ws.converter.paiment.PaimentCollaboratorConverter;
import ma.zs.zyn.ws.dto.paiment.PaimentCollaboratorDto;
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
@RequestMapping("/api/admin/paimentCollaborator/")
public class PaimentCollaboratorRestAdmin  extends AbstractController<PaimentCollaborator, PaimentCollaboratorDto, PaimentCollaboratorCriteria, PaimentCollaboratorAdminService, PaimentCollaboratorConverter> {



    @Operation(summary = "upload one paimentCollaborator")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paimentCollaborators")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paimentCollaborators")
    @GetMapping("")
    public ResponseEntity<List<PaimentCollaboratorDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paimentCollaborators")
    @GetMapping("optimized")
    public ResponseEntity<List<PaimentCollaboratorDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paimentCollaborator by name")
    @GetMapping("name/{name}")
    public ResponseEntity<PaimentCollaboratorDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new PaimentCollaborator(name));
    }

    @Operation(summary = "Saves the specified  paimentCollaborator")
    @PostMapping("")
    public ResponseEntity<PaimentCollaboratorDto> save(@RequestBody PaimentCollaboratorDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paimentCollaborator")
    @PutMapping("")
    public ResponseEntity<PaimentCollaboratorDto> update(@RequestBody PaimentCollaboratorDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paimentCollaborator")
    @PostMapping("multiple")
    public ResponseEntity<List<PaimentCollaboratorDto>> delete(@RequestBody List<PaimentCollaboratorDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paimentCollaborator")
    @DeleteMapping("")
    public ResponseEntity<PaimentCollaboratorDto> delete(@RequestBody PaimentCollaboratorDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paimentCollaborator")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paimentCollaborators by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by collaborator id")
    @GetMapping("collaborator/id/{id}")
    public List<PaimentCollaboratorDto> findByCollaboratorId(@PathVariable Long id){
        return findDtos(service.findByCollaboratorId(id));
    }
    @Operation(summary = "delete by collaborator id")
    @DeleteMapping("collaborator/id/{id}")
    public int deleteByCollaboratorId(@PathVariable Long id){
        return service.deleteByCollaboratorId(id);
    }
    @Operation(summary = "find by coupon id")
    @GetMapping("coupon/id/{id}")
    public List<PaimentCollaboratorDto> findByCouponId(@PathVariable Long id){
        return findDtos(service.findByCouponId(id));
    }
    @Operation(summary = "delete by coupon id")
    @DeleteMapping("coupon/id/{id}")
    public int deleteByCouponId(@PathVariable Long id){
        return service.deleteByCouponId(id);
    }
    @Operation(summary = "find by paimentCollaboratorState id")
    @GetMapping("paimentCollaboratorState/id/{id}")
    public List<PaimentCollaboratorDto> findByPaimentCollaboratorStateId(@PathVariable Long id){
        return findDtos(service.findByPaimentCollaboratorStateId(id));
    }
    @Operation(summary = "delete by paimentCollaboratorState id")
    @DeleteMapping("paimentCollaboratorState/id/{id}")
    public int deleteByPaimentCollaboratorStateId(@PathVariable Long id){
        return service.deleteByPaimentCollaboratorStateId(id);
    }

    @Operation(summary = "Finds a paimentCollaborator and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaimentCollaboratorDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds paimentCollaborators by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaimentCollaboratorDto>> findByCriteria(@RequestBody PaimentCollaboratorCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paimentCollaborators by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaimentCollaboratorCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paimentCollaborators by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaimentCollaboratorCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paimentCollaborator data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaimentCollaboratorCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaimentCollaboratorRestAdmin (PaimentCollaboratorAdminService service, PaimentCollaboratorConverter converter) {
        super(service, converter);
    }




}
