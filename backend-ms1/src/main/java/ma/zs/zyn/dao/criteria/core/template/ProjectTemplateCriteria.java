package  ma.zs.zyn.dao.criteria.core.template;



import ma.zs.zyn.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ProjectTemplateCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String name;
    private String nameLike;
    private LocalDateTime addingDate;
    private LocalDateTime addingDateFrom;
    private LocalDateTime addingDateTo;
    private LocalDateTime lastUpdateDate;
    private LocalDateTime lastUpdateDateFrom;
    private LocalDateTime lastUpdateDateTo;
    private String projectTemplateTags;
    private String projectTemplateTagsLike;
    private String price;
    private String priceMin;
    private String priceMax;

    private CategoryProjectTemplateCriteria categoryProjectTemplate ;
    private List<CategoryProjectTemplateCriteria> categoryProjectTemplates ;
    private SubDomainTemplateCriteria subDomainTemplate ;
    private List<SubDomainTemplateCriteria> subDomainTemplates ;


    public ProjectTemplateCriteria(){}

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

    public LocalDateTime getAddingDate(){
        return this.addingDate;
    }
    public void setAddingDate(LocalDateTime addingDate){
        this.addingDate = addingDate;
    }
    public LocalDateTime getAddingDateFrom(){
        return this.addingDateFrom;
    }
    public void setAddingDateFrom(LocalDateTime addingDateFrom){
        this.addingDateFrom = addingDateFrom;
    }
    public LocalDateTime getAddingDateTo(){
        return this.addingDateTo;
    }
    public void setAddingDateTo(LocalDateTime addingDateTo){
        this.addingDateTo = addingDateTo;
    }
    public LocalDateTime getLastUpdateDate(){
        return this.lastUpdateDate;
    }
    public void setLastUpdateDate(LocalDateTime lastUpdateDate){
        this.lastUpdateDate = lastUpdateDate;
    }
    public LocalDateTime getLastUpdateDateFrom(){
        return this.lastUpdateDateFrom;
    }
    public void setLastUpdateDateFrom(LocalDateTime lastUpdateDateFrom){
        this.lastUpdateDateFrom = lastUpdateDateFrom;
    }
    public LocalDateTime getLastUpdateDateTo(){
        return this.lastUpdateDateTo;
    }
    public void setLastUpdateDateTo(LocalDateTime lastUpdateDateTo){
        this.lastUpdateDateTo = lastUpdateDateTo;
    }
    public String getProjectTemplateTags(){
        return this.projectTemplateTags;
    }
    public void setProjectTemplateTags(String projectTemplateTags){
        this.projectTemplateTags = projectTemplateTags;
    }
    public String getProjectTemplateTagsLike(){
        return this.projectTemplateTagsLike;
    }
    public void setProjectTemplateTagsLike(String projectTemplateTagsLike){
        this.projectTemplateTagsLike = projectTemplateTagsLike;
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
      

    public CategoryProjectTemplateCriteria getCategoryProjectTemplate(){
        return this.categoryProjectTemplate;
    }

    public void setCategoryProjectTemplate(CategoryProjectTemplateCriteria categoryProjectTemplate){
        this.categoryProjectTemplate = categoryProjectTemplate;
    }
    public List<CategoryProjectTemplateCriteria> getCategoryProjectTemplates(){
        return this.categoryProjectTemplates;
    }

    public void setCategoryProjectTemplates(List<CategoryProjectTemplateCriteria> categoryProjectTemplates){
        this.categoryProjectTemplates = categoryProjectTemplates;
    }
    public SubDomainTemplateCriteria getSubDomainTemplate(){
        return this.subDomainTemplate;
    }

    public void setSubDomainTemplate(SubDomainTemplateCriteria subDomainTemplate){
        this.subDomainTemplate = subDomainTemplate;
    }
    public List<SubDomainTemplateCriteria> getSubDomainTemplates(){
        return this.subDomainTemplates;
    }

    public void setSubDomainTemplates(List<SubDomainTemplateCriteria> subDomainTemplates){
        this.subDomainTemplates = subDomainTemplates;
    }
}
