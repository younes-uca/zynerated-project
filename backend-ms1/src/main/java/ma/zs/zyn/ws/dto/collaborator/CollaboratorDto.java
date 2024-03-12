package  ma.zs.zyn.ws.dto.collaborator;

import ma.zs.zyn.zynerator.audit.Log;
import ma.zs.zyn.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import ma.zs.zyn.zynerator.security.bean.Role;
import java.util.Collection;


import ma.zs.zyn.ws.dto.packaging.PackagingDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollaboratorDto  extends AuditBaseDto {

    private String name  ;
    private String code  ;
    private Boolean credentialsNonExpired  ;
    private Boolean enabled  ;
    private Boolean accountNonExpired  ;
    private Boolean accountNonLocked  ;
    private Boolean passwordChanged  ;
    private String username  ;
    private String password  ;

    private PackagingDto packaging ;
    private MemberDto member ;



    private Collection<Role> roles;
    public CollaboratorDto(){
        super();
    }



    @Log
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public Boolean getCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Log
    public Boolean getEnabled(){
        return this.enabled;
    }
    public void setEnabled(Boolean enabled){
        this.enabled = enabled;
    }

    @Log
    public Boolean getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }

    @Log
    public Boolean getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }

    @Log
    public Boolean getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(Boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }

    @Log
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    @Log
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }


    public PackagingDto getPackaging(){
        return this.packaging;
    }

    public void setPackaging(PackagingDto packaging){
        this.packaging = packaging;
    }
    public MemberDto getMember(){
        return this.member;
    }

    public void setMember(MemberDto member){
        this.member = member;
    }







    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
