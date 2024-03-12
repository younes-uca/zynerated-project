package  ma.zs.zyn.ws.dto.template;

import ma.zs.zyn.zynerator.audit.Log;
import ma.zs.zyn.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubDomainTemplateDto  extends AuditBaseDto {

    private String code  ;
    private String name  ;

    private DomainTemplateDto domainTemplate ;



    public SubDomainTemplateDto(){
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
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    public DomainTemplateDto getDomainTemplate(){
        return this.domainTemplate;
    }

    public void setDomainTemplate(DomainTemplateDto domainTemplate){
        this.domainTemplate = domainTemplate;
    }






}
