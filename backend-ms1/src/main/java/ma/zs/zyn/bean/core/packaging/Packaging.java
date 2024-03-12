package ma.zs.zyn.bean.core.packaging;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.zyn.bean.core.category.CategoryPackaging;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "packaging")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="packaging_seq",sequenceName="packaging_seq",allocationSize=1, initialValue = 1)
public class Packaging   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String description;
    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;
    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal maxProject = BigDecimal.ZERO;

    private CategoryPackaging categoryPackaging ;


    public Packaging(){
        super();
    }

    public Packaging(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="packaging_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public BigDecimal getMaxProject(){
        return this.maxProject;
    }
    public void setMaxProject(BigDecimal maxProject){
        this.maxProject = maxProject;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_packaging")
    public CategoryPackaging getCategoryPackaging(){
        return this.categoryPackaging;
    }
    public void setCategoryPackaging(CategoryPackaging categoryPackaging){
        this.categoryPackaging = categoryPackaging;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packaging packaging = (Packaging) o;
        return id != null && id.equals(packaging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

