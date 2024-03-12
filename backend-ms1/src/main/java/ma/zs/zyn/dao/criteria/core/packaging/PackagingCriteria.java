package  ma.zs.zyn.dao.criteria.core.packaging;


import ma.zs.zyn.dao.criteria.core.category.CategoryPackagingCriteria;

import ma.zs.zyn.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PackagingCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String description;
    private String descriptionLike;
    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;
    private String price;
    private String priceMin;
    private String priceMax;
    private String maxProject;
    private String maxProjectMin;
    private String maxProjectMax;

    private CategoryPackagingCriteria categoryPackaging ;
    private List<CategoryPackagingCriteria> categoryPackagings ;


    public PackagingCriteria(){}

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

    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateDebutFrom(){
        return this.dateDebutFrom;
    }
    public void setDateDebutFrom(LocalDateTime dateDebutFrom){
        this.dateDebutFrom = dateDebutFrom;
    }
    public LocalDateTime getDateDebutTo(){
        return this.dateDebutTo;
    }
    public void setDateDebutTo(LocalDateTime dateDebutTo){
        this.dateDebutTo = dateDebutTo;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }
    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price = price;
    }   
    public String getPriceMin(){
        return this.priceMin;
    }
    public void setPriceMin(String priceMin){
        this.priceMin = priceMin;
    }
    public String getPriceMax(){
        return this.priceMax;
    }
    public void setPriceMax(String priceMax){
        this.priceMax = priceMax;
    }
      
    public String getMaxProject(){
        return this.maxProject;
    }
    public void setMaxProject(String maxProject){
        this.maxProject = maxProject;
    }   
    public String getMaxProjectMin(){
        return this.maxProjectMin;
    }
    public void setMaxProjectMin(String maxProjectMin){
        this.maxProjectMin = maxProjectMin;
    }
    public String getMaxProjectMax(){
        return this.maxProjectMax;
    }
    public void setMaxProjectMax(String maxProjectMax){
        this.maxProjectMax = maxProjectMax;
    }
      

    public CategoryPackagingCriteria getCategoryPackaging(){
        return this.categoryPackaging;
    }

    public void setCategoryPackaging(CategoryPackagingCriteria categoryPackaging){
        this.categoryPackaging = categoryPackaging;
    }
    public List<CategoryPackagingCriteria> getCategoryPackagings(){
        return this.categoryPackagings;
    }

    public void setCategoryPackagings(List<CategoryPackagingCriteria> categoryPackagings){
        this.categoryPackagings = categoryPackagings;
    }
}
