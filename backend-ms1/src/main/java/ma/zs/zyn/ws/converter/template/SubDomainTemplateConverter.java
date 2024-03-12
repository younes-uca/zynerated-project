package  ma.zs.zyn.ws.converter.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.template.DomainTemplateConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.template.SubDomainTemplate;
import ma.zs.zyn.ws.dto.template.SubDomainTemplateDto;

@Component
public class SubDomainTemplateConverter extends AbstractConverter<SubDomainTemplate, SubDomainTemplateDto> {

    @Autowired
    private DomainTemplateConverter domainTemplateConverter ;
    private boolean domainTemplate;

    public  SubDomainTemplateConverter() {
        super(SubDomainTemplate.class, SubDomainTemplateDto.class);
        init(true);
    }

    @Override
    public SubDomainTemplate toItem(SubDomainTemplateDto dto) {
        if (dto == null) {
            return null;
        } else {
        SubDomainTemplate item = new SubDomainTemplate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(this.domainTemplate && dto.getDomainTemplate()!=null &&  dto.getDomainTemplate().getId() != null)
                item.setDomainTemplate(domainTemplateConverter.toItem(dto.getDomainTemplate())) ;




        return item;
        }
    }

    @Override
    public SubDomainTemplateDto toDto(SubDomainTemplate item) {
        if (item == null) {
            return null;
        } else {
            SubDomainTemplateDto dto = new SubDomainTemplateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(this.domainTemplate && item.getDomainTemplate()!=null) {
                dto.setDomainTemplate(domainTemplateConverter.toDto(item.getDomainTemplate())) ;

            }


        return dto;
        }
    }

    public void copy(SubDomainTemplateDto dto, SubDomainTemplate t) {
    super.copy(dto, t);
    if (dto.getDomainTemplate() != null)
        domainTemplateConverter.copy(dto.getDomainTemplate(), t.getDomainTemplate());
    }



    public void initObject(boolean value) {
        this.domainTemplate = value;
    }


    public DomainTemplateConverter getDomainTemplateConverter(){
        return this.domainTemplateConverter;
    }
    public void setDomainTemplateConverter(DomainTemplateConverter domainTemplateConverter ){
        this.domainTemplateConverter = domainTemplateConverter;
    }
    public boolean  isDomainTemplate(){
        return this.domainTemplate;
    }
    public void  setDomainTemplate(boolean domainTemplate){
        this.domainTemplate = domainTemplate;
    }
}
