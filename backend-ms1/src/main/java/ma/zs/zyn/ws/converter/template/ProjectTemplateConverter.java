package  ma.zs.zyn.ws.converter.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.template.SubDomainTemplateConverter;
import ma.zs.zyn.ws.converter.template.CategoryProjectTemplateConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.ws.dto.template.ProjectTemplateDto;

@Component
public class ProjectTemplateConverter extends AbstractConverter<ProjectTemplate, ProjectTemplateDto> {

    @Autowired
    private SubDomainTemplateConverter subDomainTemplateConverter ;
    @Autowired
    private CategoryProjectTemplateConverter categoryProjectTemplateConverter ;
    private boolean categoryProjectTemplate;
    private boolean subDomainTemplate;

    public  ProjectTemplateConverter() {
        super(ProjectTemplate.class, ProjectTemplateDto.class);
        init(true);
    }

    @Override
    public ProjectTemplate toItem(ProjectTemplateDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProjectTemplate item = new ProjectTemplate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getAddingDate()))
                item.setAddingDate(DateUtil.stringEnToDate(dto.getAddingDate()));
            if(StringUtil.isNotEmpty(dto.getLastUpdateDate()))
                item.setLastUpdateDate(DateUtil.stringEnToDate(dto.getLastUpdateDate()));
            if(StringUtil.isNotEmpty(dto.getProjectTemplateTags()))
                item.setProjectTemplateTags(dto.getProjectTemplateTags());
            if(StringUtil.isNotEmpty(dto.getPrice()))
                item.setPrice(dto.getPrice());
            if(this.categoryProjectTemplate && dto.getCategoryProjectTemplate()!=null &&  dto.getCategoryProjectTemplate().getId() != null)
                item.setCategoryProjectTemplate(categoryProjectTemplateConverter.toItem(dto.getCategoryProjectTemplate())) ;

            if(this.subDomainTemplate && dto.getSubDomainTemplate()!=null &&  dto.getSubDomainTemplate().getId() != null)
                item.setSubDomainTemplate(subDomainTemplateConverter.toItem(dto.getSubDomainTemplate())) ;




        return item;
        }
    }

    @Override
    public ProjectTemplateDto toDto(ProjectTemplate item) {
        if (item == null) {
            return null;
        } else {
            ProjectTemplateDto dto = new ProjectTemplateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(item.getAddingDate()!=null)
                dto.setAddingDate(DateUtil.dateTimeToString(item.getAddingDate()));
            if(item.getLastUpdateDate()!=null)
                dto.setLastUpdateDate(DateUtil.dateTimeToString(item.getLastUpdateDate()));
            if(StringUtil.isNotEmpty(item.getProjectTemplateTags()))
                dto.setProjectTemplateTags(item.getProjectTemplateTags());
            if(StringUtil.isNotEmpty(item.getPrice()))
                dto.setPrice(item.getPrice());
            if(this.categoryProjectTemplate && item.getCategoryProjectTemplate()!=null) {
                dto.setCategoryProjectTemplate(categoryProjectTemplateConverter.toDto(item.getCategoryProjectTemplate())) ;

            }
            if(this.subDomainTemplate && item.getSubDomainTemplate()!=null) {
                dto.setSubDomainTemplate(subDomainTemplateConverter.toDto(item.getSubDomainTemplate())) ;

            }


        return dto;
        }
    }

    public void copy(ProjectTemplateDto dto, ProjectTemplate t) {
    super.copy(dto, t);
    if (dto.getCategoryProjectTemplate() != null)
        categoryProjectTemplateConverter.copy(dto.getCategoryProjectTemplate(), t.getCategoryProjectTemplate());
    if (dto.getSubDomainTemplate() != null)
        subDomainTemplateConverter.copy(dto.getSubDomainTemplate(), t.getSubDomainTemplate());
    }



    public void initObject(boolean value) {
        this.categoryProjectTemplate = value;
        this.subDomainTemplate = value;
    }


    public SubDomainTemplateConverter getSubDomainTemplateConverter(){
        return this.subDomainTemplateConverter;
    }
    public void setSubDomainTemplateConverter(SubDomainTemplateConverter subDomainTemplateConverter ){
        this.subDomainTemplateConverter = subDomainTemplateConverter;
    }
    public CategoryProjectTemplateConverter getCategoryProjectTemplateConverter(){
        return this.categoryProjectTemplateConverter;
    }
    public void setCategoryProjectTemplateConverter(CategoryProjectTemplateConverter categoryProjectTemplateConverter ){
        this.categoryProjectTemplateConverter = categoryProjectTemplateConverter;
    }
    public boolean  isCategoryProjectTemplate(){
        return this.categoryProjectTemplate;
    }
    public void  setCategoryProjectTemplate(boolean categoryProjectTemplate){
        this.categoryProjectTemplate = categoryProjectTemplate;
    }
    public boolean  isSubDomainTemplate(){
        return this.subDomainTemplate;
    }
    public void  setSubDomainTemplate(boolean subDomainTemplate){
        this.subDomainTemplate = subDomainTemplate;
    }
}
