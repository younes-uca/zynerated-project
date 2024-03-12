package  ma.zs.zyn.ws.converter.collaborator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.collaborator.CollaboratorConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.collaborator.Member;
import ma.zs.zyn.ws.dto.collaborator.MemberDto;

@Component
public class MemberConverter extends AbstractConverter<Member, MemberDto> {

    @Autowired
    private CollaboratorConverter collaboratorConverter ;
    private boolean collaborator;

    public  MemberConverter() {
        super(Member.class, MemberDto.class);
        init(true);
    }

    @Override
    public Member toItem(MemberDto dto) {
        if (dto == null) {
            return null;
        } else {
        Member item = new Member();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            item.setCredentialsNonExpired(dto.getCredentialsNonExpired());
            item.setEnabled(dto.getEnabled());
            item.setAccountNonExpired(dto.getAccountNonExpired());
            item.setAccountNonLocked(dto.getAccountNonLocked());
            item.setPasswordChanged(dto.getPasswordChanged());
            if(StringUtil.isNotEmpty(dto.getUsername()))
                item.setUsername(dto.getUsername());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());
            if(this.collaborator && dto.getCollaborator()!=null &&  dto.getCollaborator().getId() != null)
                item.setCollaborator(collaboratorConverter.toItem(dto.getCollaborator())) ;



            //item.setRoles(dto.getRoles());

        return item;
        }
    }

    @Override
    public MemberDto toDto(Member item) {
        if (item == null) {
            return null;
        } else {
            MemberDto dto = new MemberDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getCredentialsNonExpired()))
                dto.setCredentialsNonExpired(item.getCredentialsNonExpired());
            if(StringUtil.isNotEmpty(item.getEnabled()))
                dto.setEnabled(item.getEnabled());
            if(StringUtil.isNotEmpty(item.getAccountNonExpired()))
                dto.setAccountNonExpired(item.getAccountNonExpired());
            if(StringUtil.isNotEmpty(item.getAccountNonLocked()))
                dto.setAccountNonLocked(item.getAccountNonLocked());
            if(StringUtil.isNotEmpty(item.getPasswordChanged()))
                dto.setPasswordChanged(item.getPasswordChanged());
            if(StringUtil.isNotEmpty(item.getUsername()))
                dto.setUsername(item.getUsername());
            if(StringUtil.isNotEmpty(item.getPassword()))
                dto.setPassword(item.getPassword());
            if(this.collaborator && item.getCollaborator()!=null) {
                collaboratorConverter.setMember(false);
                dto.setCollaborator(collaboratorConverter.toDto(item.getCollaborator())) ;
                collaboratorConverter.setMember(true);

            }


        return dto;
        }
    }

    public void copy(MemberDto dto, Member t) {
    super.copy(dto, t);
    if (dto.getCollaborator() != null)
        collaboratorConverter.copy(dto.getCollaborator(), t.getCollaborator());
    }



    public void initObject(boolean value) {
        this.collaborator = value;
    }


    public CollaboratorConverter getCollaboratorConverter(){
        return this.collaboratorConverter;
    }
    public void setCollaboratorConverter(CollaboratorConverter collaboratorConverter ){
        this.collaboratorConverter = collaboratorConverter;
    }
    public boolean  isCollaborator(){
        return this.collaborator;
    }
    public void  setCollaborator(boolean collaborator){
        this.collaborator = collaborator;
    }
}
