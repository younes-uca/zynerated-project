package  ma.zs.zyn.ws.facade.admin.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.ProjectTemplateCriteria;
import ma.zs.zyn.service.facade.admin.template.ProjectTemplateAdminService;
import ma.zs.zyn.ws.converter.template.ProjectTemplateConverter;
import ma.zs.zyn.ws.dto.template.ProjectTemplateDto;
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
@RequestMapping("/api/admin/projectTemplate/")
public class ProjectTemplateRestAdmin  extends AbstractController<ProjectTemplate, ProjectTemplateDto, ProjectTemplateCriteria, ProjectTemplateAdminService, ProjectTemplateConverter> {



    @Operation(summary = "upload one projectTemplate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple projectTemplates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all projectTemplates")
    @GetMapping("")
    public ResponseEntity<List<ProjectTemplateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all projectTemplates")
    @GetMapping("optimized")
    public ResponseEntity<List<ProjectTemplateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a projectTemplate by code")
    @GetMapping("code/{code}")
    public ResponseEntity<ProjectTemplateDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new ProjectTemplate(code));
    }

    @Operation(summary = "Saves the specified  projectTemplate")
    @PostMapping("")
    public ResponseEntity<ProjectTemplateDto> save(@RequestBody ProjectTemplateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  projectTemplate")
    @PutMapping("")
    public ResponseEntity<ProjectTemplateDto> update(@RequestBody ProjectTemplateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of projectTemplate")
    @PostMapping("multiple")
    public ResponseEntity<List<ProjectTemplateDto>> delete(@RequestBody List<ProjectTemplateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified projectTemplate")
    @DeleteMapping("")
    public ResponseEntity<ProjectTemplateDto> delete(@RequestBody ProjectTemplateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified projectTemplate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple projectTemplates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by categoryProjectTemplate id")
    @GetMapping("categoryProjectTemplate/id/{id}")
    public List<ProjectTemplateDto> findByCategoryProjectTemplateId(@PathVariable Long id){
        return findDtos(service.findByCategoryProjectTemplateId(id));
    }
    @Operation(summary = "delete by categoryProjectTemplate id")
    @DeleteMapping("categoryProjectTemplate/id/{id}")
    public int deleteByCategoryProjectTemplateId(@PathVariable Long id){
        return service.deleteByCategoryProjectTemplateId(id);
    }
    @Operation(summary = "find by subDomainTemplate id")
    @GetMapping("subDomainTemplate/id/{id}")
    public List<ProjectTemplateDto> findBySubDomainTemplateId(@PathVariable Long id){
        return findDtos(service.findBySubDomainTemplateId(id));
    }
    @Operation(summary = "delete by subDomainTemplate id")
    @DeleteMapping("subDomainTemplate/id/{id}")
    public int deleteBySubDomainTemplateId(@PathVariable Long id){
        return service.deleteBySubDomainTemplateId(id);
    }

    @Operation(summary = "Finds a projectTemplate and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProjectTemplateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds projectTemplates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProjectTemplateDto>> findByCriteria(@RequestBody ProjectTemplateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated projectTemplates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProjectTemplateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports projectTemplates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProjectTemplateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets projectTemplate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProjectTemplateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ProjectTemplateRestAdmin (ProjectTemplateAdminService service, ProjectTemplateConverter converter) {
        super(service, converter);
    }




}
