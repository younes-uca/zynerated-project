package ma.zs.zyn.bean.core.template;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "project_template")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="project_template_seq",sequenceName="project_template_seq",allocationSize=1, initialValue = 1)
public class ProjectTemplate   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String name;
    private LocalDateTime addingDate ;
    private LocalDateTime lastUpdateDate ;
    @Column(length = 500)
    private String projectTemplateTags;
    private BigDecimal price = BigDecimal.ZERO;

    private CategoryProjectTemplate categoryProjectTemplate ;
    private SubDomainTemplate subDomainTemplate ;


    public ProjectTemplate(){
        super();
    }

    public ProjectTemplate(Long id){
        this.id = id;
    }

    public ProjectTemplate(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public ProjectTemplate(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="project_template_seq")
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
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public LocalDateTime getAddingDate(){
        return this.addingDate;
    }
    public void setAddingDate(LocalDateTime addingDate){
        this.addingDate = addingDate;
    }
    public LocalDateTime getLastUpdateDate(){
        return this.lastUpdateDate;
    }
    public void setLastUpdateDate(LocalDateTime lastUpdateDate){
        this.lastUpdateDate = lastUpdateDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_project_template")
    public CategoryProjectTemplate getCategoryProjectTemplate(){
        return this.categoryProjectTemplate;
    }
    public void setCategoryProjectTemplate(CategoryProjectTemplate categoryProjectTemplate){
        this.categoryProjectTemplate = categoryProjectTemplate;
    }
    public String getProjectTemplateTags(){
        return this.projectTemplateTags;
    }
    public void setProjectTemplateTags(String projectTemplateTags){
        this.projectTemplateTags = projectTemplateTags;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_domain_template")
    public SubDomainTemplate getSubDomainTemplate(){
        return this.subDomainTemplate;
    }
    public void setSubDomainTemplate(SubDomainTemplate subDomainTemplate){
        this.subDomainTemplate = subDomainTemplate;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTemplate projectTemplate = (ProjectTemplate) o;
        return id != null && id.equals(projectTemplate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

