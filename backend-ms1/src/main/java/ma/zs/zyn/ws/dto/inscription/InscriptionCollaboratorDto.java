package  ma.zs.zyn.ws.dto.inscription;

import ma.zs.zyn.zynerator.audit.Log;
import ma.zs.zyn.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.zyn.ws.dto.collaborator.CollaboratorDto;
import ma.zs.zyn.ws.dto.packaging.PackagingDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InscriptionCollaboratorDto  extends AuditBaseDto {

    private String inscriptionDate ;
    private String renewDate ;

    private PackagingDto packaging ;
    private CollaboratorDto collaborator ;
    private InscriptionStateDto inscriptionState ;



    public InscriptionCollaboratorDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getInscriptionDate(){
        return this.inscriptionDate;
    }
    public void setInscriptionDate(String inscriptionDate){
        this.inscriptionDate = inscriptionDate;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getRenewDate(){
        return this.renewDate;
    }
    public void setRenewDate(String renewDate){
        this.renewDate = renewDate;
    }


    public PackagingDto getPackaging(){
        return this.packaging;
    }

    public void setPackaging(PackagingDto packaging){
        this.packaging = packaging;
    }
    public CollaboratorDto getCollaborator(){
        return this.collaborator;
    }

    public void setCollaborator(CollaboratorDto collaborator){
        this.collaborator = collaborator;
    }
    public InscriptionStateDto getInscriptionState(){
        return this.inscriptionState;
    }

    public void setInscriptionState(InscriptionStateDto inscriptionState){
        this.inscriptionState = inscriptionState;
    }






}
