package  ma.zs.zyn.ws.facade.admin.inscription;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.inscription.InscriptionState;
import ma.zs.zyn.dao.criteria.core.inscription.InscriptionStateCriteria;
import ma.zs.zyn.service.facade.admin.inscription.InscriptionStateAdminService;
import ma.zs.zyn.ws.converter.inscription.InscriptionStateConverter;
import ma.zs.zyn.ws.dto.inscription.InscriptionStateDto;
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
@RequestMapping("/api/admin/inscriptionState/")
public class InscriptionStateRestAdmin  extends AbstractController<InscriptionState, InscriptionStateDto, InscriptionStateCriteria, InscriptionStateAdminService, InscriptionStateConverter> {



    @Operation(summary = "upload one inscriptionState")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple inscriptionStates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all inscriptionStates")
    @GetMapping("")
    public ResponseEntity<List<InscriptionStateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all inscriptionStates")
    @GetMapping("optimized")
    public ResponseEntity<List<InscriptionStateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a inscriptionState by name")
    @GetMapping("name/{name}")
    public ResponseEntity<InscriptionStateDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new InscriptionState(name));
    }

    @Operation(summary = "Saves the specified  inscriptionState")
    @PostMapping("")
    public ResponseEntity<InscriptionStateDto> save(@RequestBody InscriptionStateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  inscriptionState")
    @PutMapping("")
    public ResponseEntity<InscriptionStateDto> update(@RequestBody InscriptionStateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of inscriptionState")
    @PostMapping("multiple")
    public ResponseEntity<List<InscriptionStateDto>> delete(@RequestBody List<InscriptionStateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified inscriptionState")
    @DeleteMapping("")
    public ResponseEntity<InscriptionStateDto> delete(@RequestBody InscriptionStateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified inscriptionState")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple inscriptionStates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a inscriptionState and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InscriptionStateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds inscriptionStates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InscriptionStateDto>> findByCriteria(@RequestBody InscriptionStateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated inscriptionStates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InscriptionStateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports inscriptionStates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InscriptionStateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets inscriptionState data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InscriptionStateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InscriptionStateRestAdmin (InscriptionStateAdminService service, InscriptionStateConverter converter) {
        super(service, converter);
    }




}
