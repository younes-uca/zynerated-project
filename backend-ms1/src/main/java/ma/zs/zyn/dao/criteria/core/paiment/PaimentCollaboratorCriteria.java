package  ma.zs.zyn.dao.criteria.core.paiment;


import ma.zs.zyn.dao.criteria.core.collaborator.CollaboratorCriteria;
import ma.zs.zyn.dao.criteria.core.coupon.CouponCriteria;
import ma.zs.zyn.dao.criteria.core.project.PaimentCollaboratorStateCriteria;

import ma.zs.zyn.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaimentCollaboratorCriteria extends  BaseCriteria  {

    private String name;
    private String nameLike;
    private String description;
    private String descriptionLike;
    private String code;
    private String codeLike;
    private LocalDateTime datePaiement;
    private LocalDateTime datePaiementFrom;
    private LocalDateTime datePaiementTo;

    private CollaboratorCriteria collaborator ;
    private List<CollaboratorCriteria> collaborators ;
    private CouponCriteria coupon ;
    private List<CouponCriteria> coupons ;
    private PaimentCollaboratorStateCriteria paimentCollaboratorState ;
    private List<PaimentCollaboratorStateCriteria> paimentCollaboratorStates ;


    public PaimentCollaboratorCriteria(){}

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNameLike(){
        return this.nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public LocalDateTime getDatePaiementFrom(){
        return this.datePaiementFrom;
    }
    public void setDatePaiementFrom(LocalDateTime datePaiementFrom){
        this.datePaiementFrom = datePaiementFrom;
    }
    public LocalDateTime getDatePaiementTo(){
        return this.datePaiementTo;
    }
    public void setDatePaiementTo(LocalDateTime datePaiementTo){
        this.datePaiementTo = datePaiementTo;
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
    public CouponCriteria getCoupon(){
        return this.coupon;
    }

    public void setCoupon(CouponCriteria coupon){
        this.coupon = coupon;
    }
    public List<CouponCriteria> getCoupons(){
        return this.coupons;
    }

    public void setCoupons(List<CouponCriteria> coupons){
        this.coupons = coupons;
    }
    public PaimentCollaboratorStateCriteria getPaimentCollaboratorState(){
        return this.paimentCollaboratorState;
    }

    public void setPaimentCollaboratorState(PaimentCollaboratorStateCriteria paimentCollaboratorState){
        this.paimentCollaboratorState = paimentCollaboratorState;
    }
    public List<PaimentCollaboratorStateCriteria> getPaimentCollaboratorStates(){
        return this.paimentCollaboratorStates;
    }

    public void setPaimentCollaboratorStates(List<PaimentCollaboratorStateCriteria> paimentCollaboratorStates){
        this.paimentCollaboratorStates = paimentCollaboratorStates;
    }
}
