package  ma.zs.zyn.ws.facade.admin.category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.category.CategoryPackaging;
import ma.zs.zyn.dao.criteria.core.category.CategoryPackagingCriteria;
import ma.zs.zyn.service.facade.admin.category.CategoryPackagingAdminService;
import ma.zs.zyn.ws.converter.category.CategoryPackagingConverter;
import ma.zs.zyn.ws.dto.category.CategoryPackagingDto;
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
@RequestMapping("/api/admin/categoryPackaging/")
public class CategoryPackagingRestAdmin  extends AbstractController<CategoryPackaging, CategoryPackagingDto, CategoryPackagingCriteria, CategoryPackagingAdminService, CategoryPackagingConverter> {



    @Operation(summary = "upload one categoryPackaging")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categoryPackagings")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categoryPackagings")
    @GetMapping("")
    public ResponseEntity<List<CategoryPackagingDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categoryPackagings")
    @GetMapping("optimized")
    public ResponseEntity<List<CategoryPackagingDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categoryPackaging by name")
    @GetMapping("name/{name}")
    public ResponseEntity<CategoryPackagingDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new CategoryPackaging(name));
    }

    @Operation(summary = "Saves the specified  categoryPackaging")
    @PostMapping("")
    public ResponseEntity<CategoryPackagingDto> save(@RequestBody CategoryPackagingDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categoryPackaging")
    @PutMapping("")
    public ResponseEntity<CategoryPackagingDto> update(@RequestBody CategoryPackagingDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categoryPackaging")
    @PostMapping("multiple")
    public ResponseEntity<List<CategoryPackagingDto>> delete(@RequestBody List<CategoryPackagingDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categoryPackaging")
    @DeleteMapping("")
    public ResponseEntity<CategoryPackagingDto> delete(@RequestBody CategoryPackagingDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categoryPackaging")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categoryPackagings by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a categoryPackaging and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategoryPackagingDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds categoryPackagings by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategoryPackagingDto>> findByCriteria(@RequestBody CategoryPackagingCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categoryPackagings by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategoryPackagingCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categoryPackagings by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategoryPackagingCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categoryPackaging data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategoryPackagingCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategoryPackagingRestAdmin (CategoryPackagingAdminService service, CategoryPackagingConverter converter) {
        super(service, converter);
    }




}
