package  ma.zs.zyn.ws.facade.admin.packaging;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.packaging.Packaging;
import ma.zs.zyn.dao.criteria.core.packaging.PackagingCriteria;
import ma.zs.zyn.service.facade.admin.packaging.PackagingAdminService;
import ma.zs.zyn.ws.converter.packaging.PackagingConverter;
import ma.zs.zyn.ws.dto.packaging.PackagingDto;
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
@RequestMapping("/api/admin/packaging/")
public class PackagingRestAdmin  extends AbstractController<Packaging, PackagingDto, PackagingCriteria, PackagingAdminService, PackagingConverter> {



    @Operation(summary = "upload one packaging")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple packagings")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all packagings")
    @GetMapping("")
    public ResponseEntity<List<PackagingDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  packaging")
    @PostMapping("")
    public ResponseEntity<PackagingDto> save(@RequestBody PackagingDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  packaging")
    @PutMapping("")
    public ResponseEntity<PackagingDto> update(@RequestBody PackagingDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of packaging")
    @PostMapping("multiple")
    public ResponseEntity<List<PackagingDto>> delete(@RequestBody List<PackagingDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified packaging")
    @DeleteMapping("")
    public ResponseEntity<PackagingDto> delete(@RequestBody PackagingDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified packaging")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple packagings by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by categoryPackaging id")
    @GetMapping("categoryPackaging/id/{id}")
    public List<PackagingDto> findByCategoryPackagingId(@PathVariable Long id){
        return findDtos(service.findByCategoryPackagingId(id));
    }
    @Operation(summary = "delete by categoryPackaging id")
    @DeleteMapping("categoryPackaging/id/{id}")
    public int deleteByCategoryPackagingId(@PathVariable Long id){
        return service.deleteByCategoryPackagingId(id);
    }

    @Operation(summary = "Finds a packaging and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PackagingDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds packagings by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PackagingDto>> findByCriteria(@RequestBody PackagingCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated packagings by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PackagingCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports packagings by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PackagingCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets packaging data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PackagingCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PackagingRestAdmin (PackagingAdminService service, PackagingConverter converter) {
        super(service, converter);
    }




}
