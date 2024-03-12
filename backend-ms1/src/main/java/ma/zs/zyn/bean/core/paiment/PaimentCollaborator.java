package ma.zs.zyn.bean.core.paiment;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.zyn.bean.core.collaborator.Collaborator;
import ma.zs.zyn.bean.core.coupon.Coupon;
import ma.zs.zyn.bean.core.project.PaimentCollaboratorState;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "paiment_collaborator")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiment_collaborator_seq",sequenceName="paiment_collaborator_seq",allocationSize=1, initialValue = 1)
public class PaimentCollaborator   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String name;
    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String code;
    private LocalDateTime datePaiement ;

    private Collaborator collaborator ;
    private Coupon coupon ;
    private PaimentCollaboratorState paimentCollaboratorState ;


    public PaimentCollaborator(){
        super();
    }

    public PaimentCollaborator(Long id){
        this.id = id;
    }

    public PaimentCollaborator(Long id,String name){
        this.id = id;
        this.name = name ;
    }
    public PaimentCollaborator(String name){
        this.name = name ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="paiment_collaborator_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collaborator")
    public Collaborator getCollaborator(){
        return this.collaborator;
    }
    public void setCollaborator(Collaborator collaborator){
        this.collaborator = collaborator;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon")
    public Coupon getCoupon(){
        return this.coupon;
    }
    public void setCoupon(Coupon coupon){
        this.coupon = coupon;
    }
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paiment_collaborator_state")
    public PaimentCollaboratorState getPaimentCollaboratorState(){
        return this.paimentCollaboratorState;
    }
    public void setPaimentCollaboratorState(PaimentCollaboratorState paimentCollaboratorState){
        this.paimentCollaboratorState = paimentCollaboratorState;
    }

    @Transient
    public String getLabel() {
        label = name;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaimentCollaborator paimentCollaborator = (PaimentCollaborator) o;
        return id != null && id.equals(paimentCollaborator.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

