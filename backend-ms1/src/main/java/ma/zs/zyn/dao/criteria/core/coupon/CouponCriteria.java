package  ma.zs.zyn.dao.criteria.core.coupon;


import ma.zs.zyn.dao.criteria.core.packaging.PackagingCriteria;

import ma.zs.zyn.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CouponCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;
    private String name;
    private String nameLike;
    private String pourcentageCoupon;
    private String pourcentageCouponMin;
    private String pourcentageCouponMax;
    private String pourcentageInfluencer;
    private String pourcentageInfluencerMin;
    private String pourcentageInfluencerMax;
    private String usingNumber;
    private String usingNumberMin;
    private String usingNumberMax;

    private PackagingCriteria packaging ;
    private List<PackagingCriteria> packagings ;
    private InfluencerCriteria influencer ;
    private List<InfluencerCriteria> influencers ;


    public CouponCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateDebutFrom(){
        return this.dateDebutFrom;
    }
    public void setDateDebutFrom(LocalDateTime dateDebutFrom){
        this.dateDebutFrom = dateDebutFrom;
    }
    public LocalDateTime getDateDebutTo(){
        return this.dateDebutTo;
    }
    public void setDateDebutTo(LocalDateTime dateDebutTo){
        this.dateDebutTo = dateDebutTo;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNameLike(){
        return this.nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }

    public String getPourcentageCoupon(){
        return this.pourcentageCoupon;
    }
    public void setPourcentageCoupon(String pourcentageCoupon){
        this.pourcentageCoupon = pourcentageCoupon;
    }   
    public String getPourcentageCouponMin(){
        return this.pourcentageCouponMin;
    }
    public void setPourcentageCouponMin(String pourcentageCouponMin){
        this.pourcentageCouponMin = pourcentageCouponMin;
    }
    public String getPourcentageCouponMax(){
        return this.pourcentageCouponMax;
    }
    public void setPourcentageCouponMax(String pourcentageCouponMax){
        this.pourcentageCouponMax = pourcentageCouponMax;
    }
      
    public String getPourcentageInfluencer(){
        return this.pourcentageInfluencer;
    }
    public void setPourcentageInfluencer(String pourcentageInfluencer){
        this.pourcentageInfluencer = pourcentageInfluencer;
    }   
    public String getPourcentageInfluencerMin(){
        return this.pourcentageInfluencerMin;
    }
    public void setPourcentageInfluencerMin(String pourcentageInfluencerMin){
        this.pourcentageInfluencerMin = pourcentageInfluencerMin;
    }
    public String getPourcentageInfluencerMax(){
        return this.pourcentageInfluencerMax;
    }
    public void setPourcentageInfluencerMax(String pourcentageInfluencerMax){
        this.pourcentageInfluencerMax = pourcentageInfluencerMax;
    }
      
    public String getUsingNumber(){
        return this.usingNumber;
    }
    public void setUsingNumber(String usingNumber){
        this.usingNumber = usingNumber;
    }   
    public String getUsingNumberMin(){
        return this.usingNumberMin;
    }
    public void setUsingNumberMin(String usingNumberMin){
        this.usingNumberMin = usingNumberMin;
    }
    public String getUsingNumberMax(){
        return this.usingNumberMax;
    }
    public void setUsingNumberMax(String usingNumberMax){
        this.usingNumberMax = usingNumberMax;
    }
      

    public PackagingCriteria getPackaging(){
        return this.packaging;
    }

    public void setPackaging(PackagingCriteria packaging){
        this.packaging = packaging;
    }
    public List<PackagingCriteria> getPackagings(){
        return this.packagings;
    }

    public void setPackagings(List<PackagingCriteria> packagings){
        this.packagings = packagings;
    }
    public InfluencerCriteria getInfluencer(){
        return this.influencer;
    }

    public void setInfluencer(InfluencerCriteria influencer){
        this.influencer = influencer;
    }
    public List<InfluencerCriteria> getInfluencers(){
        return this.influencers;
    }

    public void setInfluencers(List<InfluencerCriteria> influencers){
        this.influencers = influencers;
    }
}
