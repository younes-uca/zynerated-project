package ma.zs.zyn.bean.core.template;

import java.util.Objects;





import ma.zs.zyn.bean.core.template.DomainTemplate;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "sub_domain_template")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sub_domain_template_seq",sequenceName="sub_domain_template_seq",allocationSize=1, initialValue = 1)
public class SubDomainTemplate   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String name;

    private DomainTemplate domainTemplate ;


    public SubDomainTemplate(){
        super();
    }

    public SubDomainTemplate(Long id){
        this.id = id;
    }

    public SubDomainTemplate(Long id,String name){
        this.id = id;
        this.name = name ;
    }
    public SubDomainTemplate(String name){
        this.name = name ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="sub_domain_template_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domain_template")
    public DomainTemplate getDomainTemplate(){
        return this.domainTemplate;
    }
    public void setDomainTemplate(DomainTemplate domainTemplate){
        this.domainTemplate = domainTemplate;
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
        SubDomainTemplate subDomainTemplate = (SubDomainTemplate) o;
        return id != null && id.equals(subDomainTemplate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

