package  ma.zs.zyn.ws.converter.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.category.CategoryPackaging;
import ma.zs.zyn.ws.dto.category.CategoryPackagingDto;

@Component
public class CategoryPackagingConverter extends AbstractConverter<CategoryPackaging, CategoryPackagingDto> {


    public  CategoryPackagingConverter() {
        super(CategoryPackaging.class, CategoryPackagingDto.class);
    }

    @Override
    public CategoryPackaging toItem(CategoryPackagingDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategoryPackaging item = new CategoryPackaging();
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
    public CategoryPackagingDto toDto(CategoryPackaging item) {
        if (item == null) {
            return null;
        } else {
            CategoryPackagingDto dto = new CategoryPackagingDto();
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
