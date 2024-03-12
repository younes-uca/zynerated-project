package  ma.zs.zyn.ws.dto.coupon;

import ma.zs.zyn.zynerator.audit.Log;
import ma.zs.zyn.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.zyn.ws.dto.packaging.PackagingDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CouponDto  extends AuditBaseDto {

    private String code  ;
    private String dateDebut ;
    private String dateFin ;
    private String name  ;
    private BigDecimal pourcentageCoupon  ;
    private BigDecimal pourcentageInfluencer  ;
    private BigDecimal usingNumber  ;

    private PackagingDto packaging ;
    private InfluencerDto influencer ;



    public CouponDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }

    @Log
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Log
    public BigDecimal getPourcentageCoupon(){
        return this.pourcentageCoupon;
    }
    public void setPourcentageCoupon(BigDecimal pourcentageCoupon){
        this.pourcentageCoupon = pourcentageCoupon;
    }

    @Log
    public BigDecimal getPourcentageInfluencer(){
        return this.pourcentageInfluencer;
    }
    public void setPourcentageInfluencer(BigDecimal pourcentageInfluencer){
        this.pourcentageInfluencer = pourcentageInfluencer;
    }

    @Log
    public BigDecimal getUsingNumber(){
        return this.usingNumber;
    }
    public void setUsingNumber(BigDecimal usingNumber){
        this.usingNumber = usingNumber;
    }


    public PackagingDto getPackaging(){
        return this.packaging;
    }

    public void setPackaging(PackagingDto packaging){
        this.packaging = packaging;
    }
    public InfluencerDto getInfluencer(){
        return this.influencer;
    }

    public void setInfluencer(InfluencerDto influencer){
        this.influencer = influencer;
    }






}
