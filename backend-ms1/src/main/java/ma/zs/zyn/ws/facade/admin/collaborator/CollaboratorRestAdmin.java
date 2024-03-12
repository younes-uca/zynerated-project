package  ma.zs.zyn.ws.facade.admin.collaborator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.collaborator.Collaborator;
import ma.zs.zyn.dao.criteria.core.collaborator.CollaboratorCriteria;
import ma.zs.zyn.service.facade.admin.collaborator.CollaboratorAdminService;
import ma.zs.zyn.ws.converter.collaborator.CollaboratorConverter;
import ma.zs.zyn.ws.dto.collaborator.CollaboratorDto;
import ma.zs.zyn.zynerator.controller.AbstractController;
import ma.zs.zyn.zynerator.dto.AuditEntityDto;
import ma.zs.zyn.zynerator.util.PaginatedList;


import ma.zs.zyn.zynerator.security.bean.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.zyn.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.zyn.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/collaborator/")
public class CollaboratorRestAdmin  extends AbstractController<Collaborator, CollaboratorDto, CollaboratorCriteria, CollaboratorAdminService, CollaboratorConverter> {



    @Operation(summary = "upload one collaborator")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple collaborators")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all collaborators")
    @GetMapping("")
    public ResponseEntity<List<CollaboratorDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all collaborators")
    @GetMapping("optimized")
    public ResponseEntity<List<CollaboratorDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a collaborator by name")
    @GetMapping("name/{name}")
    public ResponseEntity<CollaboratorDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new Collaborator(name));
    }

    @Operation(summary = "Saves the specified  collaborator")
    @PostMapping("")
    public ResponseEntity<CollaboratorDto> save(@RequestBody CollaboratorDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  collaborator")
    @PutMapping("")
    public ResponseEntity<CollaboratorDto> update(@RequestBody CollaboratorDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of collaborator")
    @PostMapping("multiple")
    public ResponseEntity<List<CollaboratorDto>> delete(@RequestBody List<CollaboratorDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified collaborator")
    @DeleteMapping("")
    public ResponseEntity<CollaboratorDto> delete(@RequestBody CollaboratorDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified collaborator")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple collaborators by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by packaging id")
    @GetMapping("packaging/id/{id}")
    public List<CollaboratorDto> findByPackagingId(@PathVariable Long id){
        return findDtos(service.findByPackagingId(id));
    }
    @Operation(summary = "delete by packaging id")
    @DeleteMapping("packaging/id/{id}")
    public int deleteByPackagingId(@PathVariable Long id){
        return service.deleteByPackagingId(id);
    }
    @Operation(summary = "find by member id")
    @GetMapping("member/id/{id}")
    public List<CollaboratorDto> findByMemberId(@PathVariable Long id){
        return findDtos(service.findByMemberId(id));
    }
    @Operation(summary = "delete by member id")
    @DeleteMapping("member/id/{id}")
    public int deleteByMemberId(@PathVariable Long id){
        return service.deleteByMemberId(id);
    }

    @Operation(summary = "Finds a collaborator and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CollaboratorDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds collaborators by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CollaboratorDto>> findByCriteria(@RequestBody CollaboratorCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated collaborators by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CollaboratorCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports collaborators by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CollaboratorCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets collaborator data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CollaboratorCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }
    public CollaboratorRestAdmin (CollaboratorAdminService service, CollaboratorConverter converter) {
        super(service, converter);
    }




}
