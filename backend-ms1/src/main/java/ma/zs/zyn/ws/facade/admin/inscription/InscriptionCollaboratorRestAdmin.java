package  ma.zs.zyn.ws.facade.admin.inscription;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.inscription.InscriptionCollaborator;
import ma.zs.zyn.dao.criteria.core.inscription.InscriptionCollaboratorCriteria;
import ma.zs.zyn.service.facade.admin.inscription.InscriptionCollaboratorAdminService;
import ma.zs.zyn.ws.converter.inscription.InscriptionCollaboratorConverter;
import ma.zs.zyn.ws.dto.inscription.InscriptionCollaboratorDto;
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
@RequestMapping("/api/admin/inscriptionCollaborator/")
public class InscriptionCollaboratorRestAdmin  extends AbstractController<InscriptionCollaborator, InscriptionCollaboratorDto, InscriptionCollaboratorCriteria, InscriptionCollaboratorAdminService, InscriptionCollaboratorConverter> {



    @Operation(summary = "upload one inscriptionCollaborator")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple inscriptionCollaborators")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all inscriptionCollaborators")
    @GetMapping("")
    public ResponseEntity<List<InscriptionCollaboratorDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  inscriptionCollaborator")
    @PostMapping("")
    public ResponseEntity<InscriptionCollaboratorDto> save(@RequestBody InscriptionCollaboratorDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  inscriptionCollaborator")
    @PutMapping("")
    public ResponseEntity<InscriptionCollaboratorDto> update(@RequestBody InscriptionCollaboratorDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of inscriptionCollaborator")
    @PostMapping("multiple")
    public ResponseEntity<List<InscriptionCollaboratorDto>> delete(@RequestBody List<InscriptionCollaboratorDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified inscriptionCollaborator")
    @DeleteMapping("")
    public ResponseEntity<InscriptionCollaboratorDto> delete(@RequestBody InscriptionCollaboratorDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified inscriptionCollaborator")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple inscriptionCollaborators by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by packaging id")
    @GetMapping("packaging/id/{id}")
    public List<InscriptionCollaboratorDto> findByPackagingId(@PathVariable Long id){
        return findDtos(service.findByPackagingId(id));
    }
    @Operation(summary = "delete by packaging id")
    @DeleteMapping("packaging/id/{id}")
    public int deleteByPackagingId(@PathVariable Long id){
        return service.deleteByPackagingId(id);
    }
    @Operation(summary = "find by collaborator id")
    @GetMapping("collaborator/id/{id}")
    public List<InscriptionCollaboratorDto> findByCollaboratorId(@PathVariable Long id){
        return findDtos(service.findByCollaboratorId(id));
    }
    @Operation(summary = "delete by collaborator id")
    @DeleteMapping("collaborator/id/{id}")
    public int deleteByCollaboratorId(@PathVariable Long id){
        return service.deleteByCollaboratorId(id);
    }
    @Operation(summary = "find by inscriptionState id")
    @GetMapping("inscriptionState/id/{id}")
    public List<InscriptionCollaboratorDto> findByInscriptionStateId(@PathVariable Long id){
        return findDtos(service.findByInscriptionStateId(id));
    }
    @Operation(summary = "delete by inscriptionState id")
    @DeleteMapping("inscriptionState/id/{id}")
    public int deleteByInscriptionStateId(@PathVariable Long id){
        return service.deleteByInscriptionStateId(id);
    }

    @Operation(summary = "Finds a inscriptionCollaborator and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InscriptionCollaboratorDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds inscriptionCollaborators by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InscriptionCollaboratorDto>> findByCriteria(@RequestBody InscriptionCollaboratorCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated inscriptionCollaborators by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InscriptionCollaboratorCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports inscriptionCollaborators by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InscriptionCollaboratorCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets inscriptionCollaborator data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InscriptionCollaboratorCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InscriptionCollaboratorRestAdmin (InscriptionCollaboratorAdminService service, InscriptionCollaboratorConverter converter) {
        super(service, converter);
    }




}
