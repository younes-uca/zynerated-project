package  ma.zs.zyn.dao.criteria.core.template;



import ma.zs.zyn.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SubDomainTemplateCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String name;
    private String nameLike;

    private DomainTemplateCriteria domainTemplate ;
    private List<DomainTemplateCriteria> domainTemplates ;


    public SubDomainTemplateCriteria(){}

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


    public DomainTemplateCriteria getDomainTemplate(){
        return this.domainTemplate;
    }

    public void setDomainTemplate(DomainTemplateCriteria domainTemplate){
        this.domainTemplate = domainTemplate;
    }
    public List<DomainTemplateCriteria> getDomainTemplates(){
        return this.domainTemplates;
    }

    public void setDomainTemplates(List<DomainTemplateCriteria> domainTemplates){
        this.domainTemplates = domainTemplates;
    }
}
