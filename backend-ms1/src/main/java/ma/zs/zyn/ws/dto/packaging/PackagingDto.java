package  ma.zs.zyn.ws.dto.packaging;

import ma.zs.zyn.zynerator.audit.Log;
import ma.zs.zyn.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.zyn.ws.dto.category.CategoryPackagingDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackagingDto  extends AuditBaseDto {

    private String code  ;
    private String description  ;
    private String dateDebut ;
    private String dateFin ;
    private BigDecimal price  ;
    private BigDecimal maxProject  ;

    private CategoryPackagingDto categoryPackaging ;



    public PackagingDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }

    @Log
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    @Log
    public BigDecimal getMaxProject(){
        return this.maxProject;
    }
    public void setMaxProject(BigDecimal maxProject){
        this.maxProject = maxProject;
    }


    public CategoryPackagingDto getCategoryPackaging(){
        return this.categoryPackaging;
    }

    public void setCategoryPackaging(CategoryPackagingDto categoryPackaging){
        this.categoryPackaging = categoryPackaging;
    }






}
