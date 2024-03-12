package  ma.zs.zyn.ws.dto.paiment;

import ma.zs.zyn.zynerator.audit.Log;
import ma.zs.zyn.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.zyn.ws.dto.collaborator.CollaboratorDto;
import ma.zs.zyn.ws.dto.coupon.CouponDto;
import ma.zs.zyn.ws.dto.project.PaimentCollaboratorStateDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaimentCollaboratorDto  extends AuditBaseDto {

    private String name  ;
    private String description  ;
    private String code  ;
    private String datePaiement ;

    private CollaboratorDto collaborator ;
    private CouponDto coupon ;
    private PaimentCollaboratorStateDto paimentCollaboratorState ;



    public PaimentCollaboratorDto(){
        super();
    }



    @Log
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
    }


    public CollaboratorDto getCollaborator(){
        return this.collaborator;
    }

    public void setCollaborator(CollaboratorDto collaborator){
        this.collaborator = collaborator;
    }
    public CouponDto getCoupon(){
        return this.coupon;
    }

    public void setCoupon(CouponDto coupon){
        this.coupon = coupon;
    }
    public PaimentCollaboratorStateDto getPaimentCollaboratorState(){
        return this.paimentCollaboratorState;
    }

    public void setPaimentCollaboratorState(PaimentCollaboratorStateDto paimentCollaboratorState){
        this.paimentCollaboratorState = paimentCollaboratorState;
    }






}
