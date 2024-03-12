package  ma.zs.zyn.ws.converter.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.ws.dto.template.CategoryProjectTemplateDto;

@Component
public class CategoryProjectTemplateConverter extends AbstractConverter<CategoryProjectTemplate, CategoryProjectTemplateDto> {


    public  CategoryProjectTemplateConverter() {
        super(CategoryProjectTemplate.class, CategoryProjectTemplateDto.class);
    }

    @Override
    public CategoryProjectTemplate toItem(CategoryProjectTemplateDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategoryProjectTemplate item = new CategoryProjectTemplate();
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
    public CategoryProjectTemplateDto toDto(CategoryProjectTemplate item) {
        if (item == null) {
            return null;
        } else {
            CategoryProjectTemplateDto dto = new CategoryProjectTemplateDto();
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
