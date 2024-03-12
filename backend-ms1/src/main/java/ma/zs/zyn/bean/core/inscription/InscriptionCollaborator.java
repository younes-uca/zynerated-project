package ma.zs.zyn.bean.core.inscription;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.zyn.bean.core.collaborator.Collaborator;
import ma.zs.zyn.bean.core.packaging.Packaging;
import ma.zs.zyn.bean.core.inscription.InscriptionState;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "inscription_collaborator")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="inscription_collaborator_seq",sequenceName="inscription_collaborator_seq",allocationSize=1, initialValue = 1)
public class InscriptionCollaborator   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime inscriptionDate ;
    private LocalDateTime renewDate ;

    private Packaging packaging ;
    private Collaborator collaborator ;
    private InscriptionState inscriptionState ;


    public InscriptionCollaborator(){
        super();
    }

    public InscriptionCollaborator(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="inscription_collaborator_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getInscriptionDate(){
        return this.inscriptionDate;
    }
    public void setInscriptionDate(LocalDateTime inscriptionDate){
        this.inscriptionDate = inscriptionDate;
    }
    public LocalDateTime getRenewDate(){
        return this.renewDate;
    }
    public void setRenewDate(LocalDateTime renewDate){
        this.renewDate = renewDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packaging")
    public Packaging getPackaging(){
        return this.packaging;
    }
    public void setPackaging(Packaging packaging){
        this.packaging = packaging;
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
    @JoinColumn(name = "inscription_state")
    public InscriptionState getInscriptionState(){
        return this.inscriptionState;
    }
    public void setInscriptionState(InscriptionState inscriptionState){
        this.inscriptionState = inscriptionState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionCollaborator inscriptionCollaborator = (InscriptionCollaborator) o;
        return id != null && id.equals(inscriptionCollaborator.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

