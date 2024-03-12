package  ma.zs.zyn.ws.facade.admin.project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.project.PaimentInfluencerState;
import ma.zs.zyn.dao.criteria.core.project.PaimentInfluencerStateCriteria;
import ma.zs.zyn.service.facade.admin.project.PaimentInfluencerStateAdminService;
import ma.zs.zyn.ws.converter.project.PaimentInfluencerStateConverter;
import ma.zs.zyn.ws.dto.project.PaimentInfluencerStateDto;
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
@RequestMapping("/api/admin/paimentInfluencerState/")
public class PaimentInfluencerStateRestAdmin  extends AbstractController<PaimentInfluencerState, PaimentInfluencerStateDto, PaimentInfluencerStateCriteria, PaimentInfluencerStateAdminService, PaimentInfluencerStateConverter> {



    @Operation(summary = "upload one paimentInfluencerState")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paimentInfluencerStates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paimentInfluencerStates")
    @GetMapping("")
    public ResponseEntity<List<PaimentInfluencerStateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paimentInfluencerStates")
    @GetMapping("optimized")
    public ResponseEntity<List<PaimentInfluencerStateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paimentInfluencerState by code")
    @GetMapping("code/{code}")
    public ResponseEntity<PaimentInfluencerStateDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new PaimentInfluencerState(code));
    }

    @Operation(summary = "Saves the specified  paimentInfluencerState")
    @PostMapping("")
    public ResponseEntity<PaimentInfluencerStateDto> save(@RequestBody PaimentInfluencerStateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paimentInfluencerState")
    @PutMapping("")
    public ResponseEntity<PaimentInfluencerStateDto> update(@RequestBody PaimentInfluencerStateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paimentInfluencerState")
    @PostMapping("multiple")
    public ResponseEntity<List<PaimentInfluencerStateDto>> delete(@RequestBody List<PaimentInfluencerStateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paimentInfluencerState")
    @DeleteMapping("")
    public ResponseEntity<PaimentInfluencerStateDto> delete(@RequestBody PaimentInfluencerStateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paimentInfluencerState")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paimentInfluencerStates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a paimentInfluencerState and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaimentInfluencerStateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds paimentInfluencerStates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaimentInfluencerStateDto>> findByCriteria(@RequestBody PaimentInfluencerStateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paimentInfluencerStates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaimentInfluencerStateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paimentInfluencerStates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaimentInfluencerStateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paimentInfluencerState data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaimentInfluencerStateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaimentInfluencerStateRestAdmin (PaimentInfluencerStateAdminService service, PaimentInfluencerStateConverter converter) {
        super(service, converter);
    }




}
