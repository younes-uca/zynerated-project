package  ma.zs.zyn.ws.facade.admin.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import ma.zs.zyn.dao.criteria.core.template.SubDomainTemplateCriteria;
import ma.zs.zyn.service.facade.admin.template.SubDomainTemplateAdminService;
import ma.zs.zyn.ws.converter.template.SubDomainTemplateConverter;
import ma.zs.zyn.ws.dto.template.SubDomainTemplateDto;
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
@RequestMapping("/api/admin/subDomainTemplate/")
public class SubDomainTemplateRestAdmin  extends AbstractController<SubDomainTemplate, SubDomainTemplateDto, SubDomainTemplateCriteria, SubDomainTemplateAdminService, SubDomainTemplateConverter> {



    @Operation(summary = "upload one subDomainTemplate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple subDomainTemplates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all subDomainTemplates")
    @GetMapping("")
    public ResponseEntity<List<SubDomainTemplateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all subDomainTemplates")
    @GetMapping("optimized")
    public ResponseEntity<List<SubDomainTemplateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a subDomainTemplate by name")
    @GetMapping("name/{name}")
    public ResponseEntity<SubDomainTemplateDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new SubDomainTemplate(name));
    }

    @Operation(summary = "Saves the specified  subDomainTemplate")
    @PostMapping("")
    public ResponseEntity<SubDomainTemplateDto> save(@RequestBody SubDomainTemplateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  subDomainTemplate")
    @PutMapping("")
    public ResponseEntity<SubDomainTemplateDto> update(@RequestBody SubDomainTemplateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of subDomainTemplate")
    @PostMapping("multiple")
    public ResponseEntity<List<SubDomainTemplateDto>> delete(@RequestBody List<SubDomainTemplateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified subDomainTemplate")
    @DeleteMapping("")
    public ResponseEntity<SubDomainTemplateDto> delete(@RequestBody SubDomainTemplateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified subDomainTemplate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple subDomainTemplates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by domainTemplate id")
    @GetMapping("domainTemplate/id/{id}")
    public List<SubDomainTemplateDto> findByDomainTemplateId(@PathVariable Long id){
        return findDtos(service.findByDomainTemplateId(id));
    }
    @Operation(summary = "delete by domainTemplate id")
    @DeleteMapping("domainTemplate/id/{id}")
    public int deleteByDomainTemplateId(@PathVariable Long id){
        return service.deleteByDomainTemplateId(id);
    }

    @Operation(summary = "Finds a subDomainTemplate and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SubDomainTemplateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds subDomainTemplates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SubDomainTemplateDto>> findByCriteria(@RequestBody SubDomainTemplateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated subDomainTemplates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SubDomainTemplateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports subDomainTemplates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SubDomainTemplateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets subDomainTemplate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SubDomainTemplateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SubDomainTemplateRestAdmin (SubDomainTemplateAdminService service, SubDomainTemplateConverter converter) {
        super(service, converter);
    }




}
