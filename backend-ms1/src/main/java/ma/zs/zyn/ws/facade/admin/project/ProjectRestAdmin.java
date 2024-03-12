package  ma.zs.zyn.ws.facade.admin.project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.project.Project;
import ma.zs.zyn.dao.criteria.core.project.ProjectCriteria;
import ma.zs.zyn.service.facade.admin.project.ProjectAdminService;
import ma.zs.zyn.ws.converter.project.ProjectConverter;
import ma.zs.zyn.ws.dto.project.ProjectDto;
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
@RequestMapping("/api/admin/project/")
public class ProjectRestAdmin  extends AbstractController<Project, ProjectDto, ProjectCriteria, ProjectAdminService, ProjectConverter> {



    @Operation(summary = "upload one project")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple projects")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all projects")
    @GetMapping("")
    public ResponseEntity<List<ProjectDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all projects")
    @GetMapping("optimized")
    public ResponseEntity<List<ProjectDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a project by code")
    @GetMapping("code/{code}")
    public ResponseEntity<ProjectDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new Project(code));
    }

    @Operation(summary = "Saves the specified  project")
    @PostMapping("")
    public ResponseEntity<ProjectDto> save(@RequestBody ProjectDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  project")
    @PutMapping("")
    public ResponseEntity<ProjectDto> update(@RequestBody ProjectDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of project")
    @PostMapping("multiple")
    public ResponseEntity<List<ProjectDto>> delete(@RequestBody List<ProjectDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified project")
    @DeleteMapping("")
    public ResponseEntity<ProjectDto> delete(@RequestBody ProjectDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified project")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple projects by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by owner id")
    @GetMapping("owner/id/{id}")
    public List<ProjectDto> findByOwnerId(@PathVariable Long id){
        return findDtos(service.findByOwnerId(id));
    }
    @Operation(summary = "delete by owner id")
    @DeleteMapping("owner/id/{id}")
    public int deleteByOwnerId(@PathVariable Long id){
        return service.deleteByOwnerId(id);
    }
    @Operation(summary = "find by projectState id")
    @GetMapping("projectState/id/{id}")
    public List<ProjectDto> findByProjectStateId(@PathVariable Long id){
        return findDtos(service.findByProjectStateId(id));
    }
    @Operation(summary = "delete by projectState id")
    @DeleteMapping("projectState/id/{id}")
    public int deleteByProjectStateId(@PathVariable Long id){
        return service.deleteByProjectStateId(id);
    }

    @Operation(summary = "Finds a project and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProjectDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds projects by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProjectDto>> findByCriteria(@RequestBody ProjectCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated projects by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProjectCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports projects by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProjectCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets project data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProjectCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ProjectRestAdmin (ProjectAdminService service, ProjectConverter converter) {
        super(service, converter);
    }




}
