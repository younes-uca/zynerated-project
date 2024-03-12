package  ma.zs.zyn.ws.facade.admin.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.CategoryProjectTemplateCriteria;
import ma.zs.zyn.service.facade.admin.template.CategoryProjectTemplateAdminService;
import ma.zs.zyn.ws.converter.template.CategoryProjectTemplateConverter;
import ma.zs.zyn.ws.dto.template.CategoryProjectTemplateDto;
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
@RequestMapping("/api/admin/categoryProjectTemplate/")
public class CategoryProjectTemplateRestAdmin  extends AbstractController<CategoryProjectTemplate, CategoryProjectTemplateDto, CategoryProjectTemplateCriteria, CategoryProjectTemplateAdminService, CategoryProjectTemplateConverter> {



    @Operation(summary = "upload one categoryProjectTemplate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categoryProjectTemplates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categoryProjectTemplates")
    @GetMapping("")
    public ResponseEntity<List<CategoryProjectTemplateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categoryProjectTemplates")
    @GetMapping("optimized")
    public ResponseEntity<List<CategoryProjectTemplateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categoryProjectTemplate by name")
    @GetMapping("name/{name}")
    public ResponseEntity<CategoryProjectTemplateDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new CategoryProjectTemplate(name));
    }

    @Operation(summary = "Saves the specified  categoryProjectTemplate")
    @PostMapping("")
    public ResponseEntity<CategoryProjectTemplateDto> save(@RequestBody CategoryProjectTemplateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categoryProjectTemplate")
    @PutMapping("")
    public ResponseEntity<CategoryProjectTemplateDto> update(@RequestBody CategoryProjectTemplateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categoryProjectTemplate")
    @PostMapping("multiple")
    public ResponseEntity<List<CategoryProjectTemplateDto>> delete(@RequestBody List<CategoryProjectTemplateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categoryProjectTemplate")
    @DeleteMapping("")
    public ResponseEntity<CategoryProjectTemplateDto> delete(@RequestBody CategoryProjectTemplateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categoryProjectTemplate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categoryProjectTemplates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a categoryProjectTemplate and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategoryProjectTemplateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds categoryProjectTemplates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategoryProjectTemplateDto>> findByCriteria(@RequestBody CategoryProjectTemplateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categoryProjectTemplates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategoryProjectTemplateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categoryProjectTemplates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategoryProjectTemplateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categoryProjectTemplate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategoryProjectTemplateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategoryProjectTemplateRestAdmin (CategoryProjectTemplateAdminService service, CategoryProjectTemplateConverter converter) {
        super(service, converter);
    }




}
