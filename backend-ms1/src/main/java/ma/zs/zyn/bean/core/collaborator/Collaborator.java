package ma.zs.zyn.bean.core.collaborator;

import java.util.Objects;





import ma.zs.zyn.bean.core.packaging.Packaging;
import ma.zs.zyn.bean.core.collaborator.Member;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;



import ma.zs.zyn.zynerator.security.bean.User;

@Entity
@Table(name = "collaborator")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="collaborator_seq",sequenceName="collaborator_seq",allocationSize=1, initialValue = 1)
public class Collaborator  extends User    {


    public Collaborator(String username) {
        super(username);
    }
    @Column(length = 500)
    private String name;
    @Column(length = 500)
    private String code;
    @Column(columnDefinition = "boolean default false")
    private boolean credentialsNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private boolean enabled = false;
    @Column(columnDefinition = "boolean default false")
    private boolean accountNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private boolean accountNonLocked = false;
    @Column(columnDefinition = "boolean default false")
    private boolean passwordChanged = false;
    @Column(length = 500)
    private String username;
    @Column(length = 500)
    private String password;

    private Packaging packaging ;
    private Member member ;


    public Collaborator(){
        super();
    }

    public Collaborator(Long id){
        this.id = id;
    }

    public Collaborator(Long id,String name){
        this.id = id;
        this.name = name ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="collaborator_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packaging")
    public Packaging getPackaging(){
        return this.packaging;
    }
    public void setPackaging(Packaging packaging){
        this.packaging = packaging;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    public Member getMember(){
        return this.member;
    }
    public void setMember(Member member){
        this.member = member;
    }
    public boolean  getCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }
    public void setCredentialsNonExpired(boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public boolean  getEnabled(){
        return this.enabled;
    }
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
    public boolean  getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }
    public boolean  getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }
    public boolean  getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Transient
    public String getLabel() {
        label = name;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborator collaborator = (Collaborator) o;
        return id != null && id.equals(collaborator.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

