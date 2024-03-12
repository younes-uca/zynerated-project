package  ma.zs.zyn.ws.converter.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.project.ProjectStateConverter;
import ma.zs.zyn.ws.converter.collaborator.MemberConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.project.Project;
import ma.zs.zyn.ws.dto.project.ProjectDto;

@Component
public class ProjectConverter extends AbstractConverter<Project, ProjectDto> {

    @Autowired
    private ProjectStateConverter projectStateConverter ;
    @Autowired
    private MemberConverter memberConverter ;
    private boolean owner;
    private boolean projectState;

    public  ProjectConverter() {
        super(Project.class, ProjectDto.class);
        init(true);
    }

    @Override
    public Project toItem(ProjectDto dto) {
        if (dto == null) {
            return null;
        } else {
        Project item = new Project();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getGeneratedDate()))
                item.setGeneratedDate(DateUtil.stringEnToDate(dto.getGeneratedDate()));
            if(StringUtil.isNotEmpty(dto.getYaml()))
                item.setYaml(dto.getYaml());
            if(this.owner && dto.getOwner()!=null &&  dto.getOwner().getId() != null)
                item.setOwner(memberConverter.toItem(dto.getOwner())) ;

            if(this.projectState && dto.getProjectState()!=null &&  dto.getProjectState().getId() != null)
                item.setProjectState(projectStateConverter.toItem(dto.getProjectState())) ;




        return item;
        }
    }

    @Override
    public ProjectDto toDto(Project item) {
        if (item == null) {
            return null;
        } else {
            ProjectDto dto = new ProjectDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(item.getGeneratedDate()!=null)
                dto.setGeneratedDate(DateUtil.dateTimeToString(item.getGeneratedDate()));
            if(StringUtil.isNotEmpty(item.getYaml()))
                dto.setYaml(item.getYaml());
            if(this.owner && item.getOwner()!=null) {
                dto.setOwner(memberConverter.toDto(item.getOwner())) ;

            }
            if(this.projectState && item.getProjectState()!=null) {
                dto.setProjectState(projectStateConverter.toDto(item.getProjectState())) ;

            }


        return dto;
        }
    }

    public void copy(ProjectDto dto, Project t) {
    super.copy(dto, t);
    if (dto.getOwner() != null)
        memberConverter.copy(dto.getOwner(), t.getOwner());
    if (dto.getProjectState() != null)
        projectStateConverter.copy(dto.getProjectState(), t.getProjectState());
    }



    public void initObject(boolean value) {
        this.owner = value;
        this.projectState = value;
    }


    public ProjectStateConverter getProjectStateConverter(){
        return this.projectStateConverter;
    }
    public void setProjectStateConverter(ProjectStateConverter projectStateConverter ){
        this.projectStateConverter = projectStateConverter;
    }
    public MemberConverter getMemberConverter(){
        return this.memberConverter;
    }
    public void setMemberConverter(MemberConverter memberConverter ){
        this.memberConverter = memberConverter;
    }
    public boolean  isOwner(){
        return this.owner;
    }
    public void  setOwner(boolean owner){
        this.owner = owner;
    }
    public boolean  isProjectState(){
        return this.projectState;
    }
    public void  setProjectState(boolean projectState){
        this.projectState = projectState;
    }
}
