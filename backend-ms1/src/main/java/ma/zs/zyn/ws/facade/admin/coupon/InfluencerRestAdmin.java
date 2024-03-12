package  ma.zs.zyn.ws.facade.admin.coupon;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.zyn.bean.core.coupon.Influencer;
import ma.zs.zyn.dao.criteria.core.coupon.InfluencerCriteria;
import ma.zs.zyn.service.facade.admin.coupon.InfluencerAdminService;
import ma.zs.zyn.ws.converter.coupon.InfluencerConverter;
import ma.zs.zyn.ws.dto.coupon.InfluencerDto;
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
@RequestMapping("/api/admin/influencer/")
public class InfluencerRestAdmin  extends AbstractController<Influencer, InfluencerDto, InfluencerCriteria, InfluencerAdminService, InfluencerConverter> {



    @Operation(summary = "upload one influencer")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple influencers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all influencers")
    @GetMapping("")
    public ResponseEntity<List<InfluencerDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  influencer")
    @PostMapping("")
    public ResponseEntity<InfluencerDto> save(@RequestBody InfluencerDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  influencer")
    @PutMapping("")
    public ResponseEntity<InfluencerDto> update(@RequestBody InfluencerDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of influencer")
    @PostMapping("multiple")
    public ResponseEntity<List<InfluencerDto>> delete(@RequestBody List<InfluencerDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified influencer")
    @DeleteMapping("")
    public ResponseEntity<InfluencerDto> delete(@RequestBody InfluencerDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified influencer")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple influencers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a influencer and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InfluencerDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds influencers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InfluencerDto>> findByCriteria(@RequestBody InfluencerCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated influencers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InfluencerCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports influencers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InfluencerCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets influencer data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InfluencerCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }
    public InfluencerRestAdmin (InfluencerAdminService service, InfluencerConverter converter) {
        super(service, converter);
    }




}
