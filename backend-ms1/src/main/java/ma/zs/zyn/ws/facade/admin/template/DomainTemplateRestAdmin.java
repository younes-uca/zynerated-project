package  ma.zs.zyn.ws.facade.admin.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.template.DomainTemplate;
import ma.zs.zyn.dao.criteria.core.template.DomainTemplateCriteria;
import ma.zs.zyn.service.facade.admin.template.DomainTemplateAdminService;
import ma.zs.zyn.ws.converter.template.DomainTemplateConverter;
import ma.zs.zyn.ws.dto.template.DomainTemplateDto;
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
@RequestMapping("/api/admin/domainTemplate/")
public class DomainTemplateRestAdmin  extends AbstractController<DomainTemplate, DomainTemplateDto, DomainTemplateCriteria, DomainTemplateAdminService, DomainTemplateConverter> {



    @Operation(summary = "upload one domainTemplate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple domainTemplates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all domainTemplates")
    @GetMapping("")
    public ResponseEntity<List<DomainTemplateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all domainTemplates")
    @GetMapping("optimized")
    public ResponseEntity<List<DomainTemplateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a domainTemplate by name")
    @GetMapping("name/{name}")
    public ResponseEntity<DomainTemplateDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new DomainTemplate(name));
    }

    @Operation(summary = "Saves the specified  domainTemplate")
    @PostMapping("")
    public ResponseEntity<DomainTemplateDto> save(@RequestBody DomainTemplateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  domainTemplate")
    @PutMapping("")
    public ResponseEntity<DomainTemplateDto> update(@RequestBody DomainTemplateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of domainTemplate")
    @PostMapping("multiple")
    public ResponseEntity<List<DomainTemplateDto>> delete(@RequestBody List<DomainTemplateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified domainTemplate")
    @DeleteMapping("")
    public ResponseEntity<DomainTemplateDto> delete(@RequestBody DomainTemplateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified domainTemplate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple domainTemplates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a domainTemplate and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DomainTemplateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds domainTemplates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DomainTemplateDto>> findByCriteria(@RequestBody DomainTemplateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated domainTemplates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DomainTemplateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports domainTemplates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DomainTemplateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets domainTemplate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DomainTemplateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public DomainTemplateRestAdmin (DomainTemplateAdminService service, DomainTemplateConverter converter) {
        super(service, converter);
    }




}
