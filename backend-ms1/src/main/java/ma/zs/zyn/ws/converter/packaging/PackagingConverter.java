package  ma.zs.zyn.ws.converter.packaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.category.CategoryPackagingConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.packaging.Packaging;
import ma.zs.zyn.ws.dto.packaging.PackagingDto;

@Component
public class PackagingConverter extends AbstractConverter<Packaging, PackagingDto> {

    @Autowired
    private CategoryPackagingConverter categoryPackagingConverter ;
    private boolean categoryPackaging;

    public  PackagingConverter() {
        super(Packaging.class, PackagingDto.class);
        init(true);
    }

    @Override
    public Packaging toItem(PackagingDto dto) {
        if (dto == null) {
            return null;
        } else {
        Packaging item = new Packaging();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(StringUtil.isNotEmpty(dto.getPrice()))
                item.setPrice(dto.getPrice());
            if(StringUtil.isNotEmpty(dto.getMaxProject()))
                item.setMaxProject(dto.getMaxProject());
            if(this.categoryPackaging && dto.getCategoryPackaging()!=null &&  dto.getCategoryPackaging().getId() != null)
                item.setCategoryPackaging(categoryPackagingConverter.toItem(dto.getCategoryPackaging())) ;




        return item;
        }
    }

    @Override
    public PackagingDto toDto(Packaging item) {
        if (item == null) {
            return null;
        } else {
            PackagingDto dto = new PackagingDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(StringUtil.isNotEmpty(item.getPrice()))
                dto.setPrice(item.getPrice());
            if(StringUtil.isNotEmpty(item.getMaxProject()))
                dto.setMaxProject(item.getMaxProject());
            if(this.categoryPackaging && item.getCategoryPackaging()!=null) {
                dto.setCategoryPackaging(categoryPackagingConverter.toDto(item.getCategoryPackaging())) ;

            }


        return dto;
        }
    }

    public void copy(PackagingDto dto, Packaging t) {
    super.copy(dto, t);
    if (dto.getCategoryPackaging() != null)
        categoryPackagingConverter.copy(dto.getCategoryPackaging(), t.getCategoryPackaging());
    }



    public void initObject(boolean value) {
        this.categoryPackaging = value;
    }


    public CategoryPackagingConverter getCategoryPackagingConverter(){
        return this.categoryPackagingConverter;
    }
    public void setCategoryPackagingConverter(CategoryPackagingConverter categoryPackagingConverter ){
        this.categoryPackagingConverter = categoryPackagingConverter;
    }
    public boolean  isCategoryPackaging(){
        return this.categoryPackaging;
    }
    public void  setCategoryPackaging(boolean categoryPackaging){
        this.categoryPackaging = categoryPackaging;
    }
}
