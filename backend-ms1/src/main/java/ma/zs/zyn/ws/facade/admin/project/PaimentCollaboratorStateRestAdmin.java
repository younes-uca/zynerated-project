package  ma.zs.zyn.ws.facade.admin.project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.project.PaimentCollaboratorState;
import ma.zs.zyn.dao.criteria.core.project.PaimentCollaboratorStateCriteria;
import ma.zs.zyn.service.facade.admin.project.PaimentCollaboratorStateAdminService;
import ma.zs.zyn.ws.converter.project.PaimentCollaboratorStateConverter;
import ma.zs.zyn.ws.dto.project.PaimentCollaboratorStateDto;
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
@RequestMapping("/api/admin/paimentCollaboratorState/")
public class PaimentCollaboratorStateRestAdmin  extends AbstractController<PaimentCollaboratorState, PaimentCollaboratorStateDto, PaimentCollaboratorStateCriteria, PaimentCollaboratorStateAdminService, PaimentCollaboratorStateConverter> {



    @Operation(summary = "upload one paimentCollaboratorState")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paimentCollaboratorStates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paimentCollaboratorStates")
    @GetMapping("")
    public ResponseEntity<List<PaimentCollaboratorStateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paimentCollaboratorStates")
    @GetMapping("optimized")
    public ResponseEntity<List<PaimentCollaboratorStateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paimentCollaboratorState by code")
    @GetMapping("code/{code}")
    public ResponseEntity<PaimentCollaboratorStateDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new PaimentCollaboratorState(code));
    }

    @Operation(summary = "Saves the specified  paimentCollaboratorState")
    @PostMapping("")
    public ResponseEntity<PaimentCollaboratorStateDto> save(@RequestBody PaimentCollaboratorStateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paimentCollaboratorState")
    @PutMapping("")
    public ResponseEntity<PaimentCollaboratorStateDto> update(@RequestBody PaimentCollaboratorStateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paimentCollaboratorState")
    @PostMapping("multiple")
    public ResponseEntity<List<PaimentCollaboratorStateDto>> delete(@RequestBody List<PaimentCollaboratorStateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paimentCollaboratorState")
    @DeleteMapping("")
    public ResponseEntity<PaimentCollaboratorStateDto> delete(@RequestBody PaimentCollaboratorStateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paimentCollaboratorState")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paimentCollaboratorStates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a paimentCollaboratorState and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaimentCollaboratorStateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds paimentCollaboratorStates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaimentCollaboratorStateDto>> findByCriteria(@RequestBody PaimentCollaboratorStateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paimentCollaboratorStates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaimentCollaboratorStateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paimentCollaboratorStates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaimentCollaboratorStateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paimentCollaboratorState data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaimentCollaboratorStateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaimentCollaboratorStateRestAdmin (PaimentCollaboratorStateAdminService service, PaimentCollaboratorStateConverter converter) {
        super(service, converter);
    }




}
