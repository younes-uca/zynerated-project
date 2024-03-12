package ma.zs.zyn.bean.core.coupon;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.zyn.bean.core.coupon.Influencer;
import ma.zs.zyn.bean.core.packaging.Packaging;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "coupon")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="coupon_seq",sequenceName="coupon_seq",allocationSize=1, initialValue = 1)
public class Coupon   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;
    @Column(length = 500)
    private String name;
    private BigDecimal pourcentageCoupon = BigDecimal.ZERO;
    private BigDecimal pourcentageInfluencer = BigDecimal.ZERO;
    private BigDecimal usingNumber = BigDecimal.ZERO;

    private Packaging packaging ;
    private Influencer influencer ;


    public Coupon(){
        super();
    }

    public Coupon(Long id){
        this.id = id;
    }

    public Coupon(Long id,String name){
        this.id = id;
        this.name = name ;
    }
    public Coupon(String name){
        this.name = name ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="coupon_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
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
    @JoinColumn(name = "influencer")
    public Influencer getInfluencer(){
        return this.influencer;
    }
    public void setInfluencer(Influencer influencer){
        this.influencer = influencer;
    }
    public BigDecimal getPourcentageCoupon(){
        return this.pourcentageCoupon;
    }
    public void setPourcentageCoupon(BigDecimal pourcentageCoupon){
        this.pourcentageCoupon = pourcentageCoupon;
    }
    public BigDecimal getPourcentageInfluencer(){
        return this.pourcentageInfluencer;
    }
    public void setPourcentageInfluencer(BigDecimal pourcentageInfluencer){
        this.pourcentageInfluencer = pourcentageInfluencer;
    }
    public BigDecimal getUsingNumber(){
        return this.usingNumber;
    }
    public void setUsingNumber(BigDecimal usingNumber){
        this.usingNumber = usingNumber;
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
        Coupon coupon = (Coupon) o;
        return id != null && id.equals(coupon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

