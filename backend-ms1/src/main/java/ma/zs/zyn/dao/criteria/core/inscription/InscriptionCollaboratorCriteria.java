package  ma.zs.zyn.dao.criteria.core.inscription;


import ma.zs.zyn.dao.criteria.core.collaborator.CollaboratorCriteria;
import ma.zs.zyn.dao.criteria.core.packaging.PackagingCriteria;

import ma.zs.zyn.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class InscriptionCollaboratorCriteria extends  BaseCriteria  {

    private LocalDateTime inscriptionDate;
    private LocalDateTime inscriptionDateFrom;
    private LocalDateTime inscriptionDateTo;
    private LocalDateTime renewDate;
    private LocalDateTime renewDateFrom;
    private LocalDateTime renewDateTo;

    private PackagingCriteria packaging ;
    private List<PackagingCriteria> packagings ;
    private CollaboratorCriteria collaborator ;
    private List<CollaboratorCriteria> collaborators ;
    private InscriptionStateCriteria inscriptionState ;
    private List<InscriptionStateCriteria> inscriptionStates ;


    public InscriptionCollaboratorCriteria(){}

    public LocalDateTime getInscriptionDate(){
        return this.inscriptionDate;
    }
    public void setInscriptionDate(LocalDateTime inscriptionDate){
        this.inscriptionDate = inscriptionDate;
    }
    public LocalDateTime getInscriptionDateFrom(){
        return this.inscriptionDateFrom;
    }
    public void setInscriptionDateFrom(LocalDateTime inscriptionDateFrom){
        this.inscriptionDateFrom = inscriptionDateFrom;
    }
    public LocalDateTime getInscriptionDateTo(){
        return this.inscriptionDateTo;
    }
    public void setInscriptionDateTo(LocalDateTime inscriptionDateTo){
        this.inscriptionDateTo = inscriptionDateTo;
    }
    public LocalDateTime getRenewDate(){
        return this.renewDate;
    }
    public void setRenewDate(LocalDateTime renewDate){
        this.renewDate = renewDate;
    }
    public LocalDateTime getRenewDateFrom(){
        return this.renewDateFrom;
    }
    public void setRenewDateFrom(LocalDateTime renewDateFrom){
        this.renewDateFrom = renewDateFrom;
    }
    public LocalDateTime getRenewDateTo(){
        return this.renewDateTo;
    }
    public void setRenewDateTo(LocalDateTime renewDateTo){
        this.renewDateTo = renewDateTo;
    }

    public PackagingCriteria getPackaging(){
        return this.packaging;
    }

    public void setPackaging(PackagingCriteria packaging){
        this.packaging = packaging;
    }
    public List<PackagingCriteria> getPackagings(){
        return this.packagings;
    }

    public void setPackagings(List<PackagingCriteria> packagings){
        this.packagings = packagings;
    }
    public CollaboratorCriteria getCollaborator(){
        return this.collaborator;
    }

    public void setCollaborator(CollaboratorCriteria collaborator){
        this.collaborator = collaborator;
    }
    public List<CollaboratorCriteria> getCollaborators(){
        return this.collaborators;
    }

    public void setCollaborators(List<CollaboratorCriteria> collaborators){
        this.collaborators = collaborators;
    }
    public InscriptionStateCriteria getInscriptionState(){
        return this.inscriptionState;
    }

    public void setInscriptionState(InscriptionStateCriteria inscriptionState){
        this.inscriptionState = inscriptionState;
    }
    public List<InscriptionStateCriteria> getInscriptionStates(){
        return this.inscriptionStates;
    }

    public void setInscriptionStates(List<InscriptionStateCriteria> inscriptionStates){
        this.inscriptionStates = inscriptionStates;
    }
}
