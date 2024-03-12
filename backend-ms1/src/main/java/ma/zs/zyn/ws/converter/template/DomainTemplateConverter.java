package  ma.zs.zyn.ws.converter.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.template.DomainTemplate;
import ma.zs.zyn.ws.dto.template.DomainTemplateDto;

@Component
public class DomainTemplateConverter extends AbstractConverter<DomainTemplate, DomainTemplateDto> {


    public  DomainTemplateConverter() {
        super(DomainTemplate.class, DomainTemplateDto.class);
    }

    @Override
    public DomainTemplate toItem(DomainTemplateDto dto) {
        if (dto == null) {
            return null;
        } else {
        DomainTemplate item = new DomainTemplate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());



        return item;
        }
    }

    @Override
    public DomainTemplateDto toDto(DomainTemplate item) {
        if (item == null) {
            return null;
        } else {
            DomainTemplateDto dto = new DomainTemplateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
