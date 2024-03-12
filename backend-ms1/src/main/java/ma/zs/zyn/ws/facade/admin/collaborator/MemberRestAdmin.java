package  ma.zs.zyn.ws.facade.admin.collaborator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.collaborator.Member;
import ma.zs.zyn.dao.criteria.core.collaborator.MemberCriteria;
import ma.zs.zyn.service.facade.admin.collaborator.MemberAdminService;
import ma.zs.zyn.ws.converter.collaborator.MemberConverter;
import ma.zs.zyn.ws.dto.collaborator.MemberDto;
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
@RequestMapping("/api/admin/member/")
public class MemberRestAdmin  extends AbstractController<Member, MemberDto, MemberCriteria, MemberAdminService, MemberConverter> {



    @Operation(summary = "upload one member")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple members")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all members")
    @GetMapping("")
    public ResponseEntity<List<MemberDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  member")
    @PostMapping("")
    public ResponseEntity<MemberDto> save(@RequestBody MemberDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  member")
    @PutMapping("")
    public ResponseEntity<MemberDto> update(@RequestBody MemberDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of member")
    @PostMapping("multiple")
    public ResponseEntity<List<MemberDto>> delete(@RequestBody List<MemberDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified member")
    @DeleteMapping("")
    public ResponseEntity<MemberDto> delete(@RequestBody MemberDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified member")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple members by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by collaborator id")
    @GetMapping("collaborator/id/{id}")
    public List<MemberDto> findByCollaboratorId(@PathVariable Long id){
        return findDtos(service.findByCollaboratorId(id));
    }
    @Operation(summary = "delete by collaborator id")
    @DeleteMapping("collaborator/id/{id}")
    public int deleteByCollaboratorId(@PathVariable Long id){
        return service.deleteByCollaboratorId(id);
    }

    @Operation(summary = "Finds a member and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MemberDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds members by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MemberDto>> findByCriteria(@RequestBody MemberCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated members by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MemberCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports members by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MemberCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets member data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MemberCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }
    public MemberRestAdmin (MemberAdminService service, MemberConverter converter) {
        super(service, converter);
    }




}
