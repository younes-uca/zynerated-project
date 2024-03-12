package  ma.zs.zyn.ws.converter.collaborator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.packaging.PackagingConverter;
import ma.zs.zyn.ws.converter.collaborator.MemberConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.collaborator.Collaborator;
import ma.zs.zyn.ws.dto.collaborator.CollaboratorDto;

@Component
public class CollaboratorConverter extends AbstractConverter<Collaborator, CollaboratorDto> {

    @Autowired
    private PackagingConverter packagingConverter ;
    @Autowired
    private MemberConverter memberConverter ;
    private boolean packaging;
    private boolean member;

    public  CollaboratorConverter() {
        super(Collaborator.class, CollaboratorDto.class);
        init(true);
    }

    @Override
    public Collaborator toItem(CollaboratorDto dto) {
        if (dto == null) {
            return null;
        } else {
        Collaborator item = new Collaborator();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            item.setCredentialsNonExpired(dto.getCredentialsNonExpired());
            item.setEnabled(dto.getEnabled());
            item.setAccountNonExpired(dto.getAccountNonExpired());
            item.setAccountNonLocked(dto.getAccountNonLocked());
            item.setPasswordChanged(dto.getPasswordChanged());
            if(StringUtil.isNotEmpty(dto.getUsername()))
                item.setUsername(dto.getUsername());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());
            if(this.packaging && dto.getPackaging()!=null &&  dto.getPackaging().getId() != null)
                item.setPackaging(packagingConverter.toItem(dto.getPackaging())) ;

            if(this.member && dto.getMember()!=null &&  dto.getMember().getId() != null)
                item.setMember(memberConverter.toItem(dto.getMember())) ;



            //item.setRoles(dto.getRoles());

        return item;
        }
    }

    @Override
    public CollaboratorDto toDto(Collaborator item) {
        if (item == null) {
            return null;
        } else {
            CollaboratorDto dto = new CollaboratorDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
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
            if(this.packaging && item.getPackaging()!=null) {
                dto.setPackaging(packagingConverter.toDto(item.getPackaging())) ;

            }
            if(this.member && item.getMember()!=null) {
                memberConverter.setCollaborator(false);
                dto.setMember(memberConverter.toDto(item.getMember())) ;
                memberConverter.setCollaborator(true);

            }


        return dto;
        }
    }

    public void copy(CollaboratorDto dto, Collaborator t) {
    super.copy(dto, t);
    if (dto.getPackaging() != null)
        packagingConverter.copy(dto.getPackaging(), t.getPackaging());
    if (dto.getMember() != null)
        memberConverter.copy(dto.getMember(), t.getMember());
    }



    public void initObject(boolean value) {
        this.packaging = value;
        this.member = value;
    }


    public PackagingConverter getPackagingConverter(){
        return this.packagingConverter;
    }
    public void setPackagingConverter(PackagingConverter packagingConverter ){
        this.packagingConverter = packagingConverter;
    }
    public MemberConverter getMemberConverter(){
        return this.memberConverter;
    }
    public void setMemberConverter(MemberConverter memberConverter ){
        this.memberConverter = memberConverter;
    }
    public boolean  isPackaging(){
        return this.packaging;
    }
    public void  setPackaging(boolean packaging){
        this.packaging = packaging;
    }
    public boolean  isMember(){
        return this.member;
    }
    public void  setMember(boolean member){
        this.member = member;
    }
}
