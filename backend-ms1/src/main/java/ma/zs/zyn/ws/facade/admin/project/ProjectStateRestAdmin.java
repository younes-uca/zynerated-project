package  ma.zs.zyn.ws.facade.admin.project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.project.ProjectState;
import ma.zs.zyn.dao.criteria.core.project.ProjectStateCriteria;
import ma.zs.zyn.service.facade.admin.project.ProjectStateAdminService;
import ma.zs.zyn.ws.converter.project.ProjectStateConverter;
import ma.zs.zyn.ws.dto.project.ProjectStateDto;
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
@RequestMapping("/api/admin/projectState/")
public class ProjectStateRestAdmin  extends AbstractController<ProjectState, ProjectStateDto, ProjectStateCriteria, ProjectStateAdminService, ProjectStateConverter> {



    @Operation(summary = "upload one projectState")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple projectStates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all projectStates")
    @GetMapping("")
    public ResponseEntity<List<ProjectStateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all projectStates")
    @GetMapping("optimized")
    public ResponseEntity<List<ProjectStateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a projectState by code")
    @GetMapping("code/{code}")
    public ResponseEntity<ProjectStateDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new ProjectState(code));
    }

    @Operation(summary = "Saves the specified  projectState")
    @PostMapping("")
    public ResponseEntity<ProjectStateDto> save(@RequestBody ProjectStateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  projectState")
    @PutMapping("")
    public ResponseEntity<ProjectStateDto> update(@RequestBody ProjectStateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of projectState")
    @PostMapping("multiple")
    public ResponseEntity<List<ProjectStateDto>> delete(@RequestBody List<ProjectStateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified projectState")
    @DeleteMapping("")
    public ResponseEntity<ProjectStateDto> delete(@RequestBody ProjectStateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified projectState")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple projectStates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a projectState and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProjectStateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds projectStates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProjectStateDto>> findByCriteria(@RequestBody ProjectStateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated projectStates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProjectStateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports projectStates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProjectStateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets projectState data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProjectStateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ProjectStateRestAdmin (ProjectStateAdminService service, ProjectStateConverter converter) {
        super(service, converter);
    }




}
