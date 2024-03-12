package  ma.zs.zyn.ws.converter.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.project.ProjectState;
import ma.zs.zyn.ws.dto.project.ProjectStateDto;

@Component
public class ProjectStateConverter extends AbstractConverter<ProjectState, ProjectStateDto> {


    public  ProjectStateConverter() {
        super(ProjectState.class, ProjectStateDto.class);
    }

    @Override
    public ProjectState toItem(ProjectStateDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProjectState item = new ProjectState();
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
    public ProjectStateDto toDto(ProjectState item) {
        if (item == null) {
            return null;
        } else {
            ProjectStateDto dto = new ProjectStateDto();
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
