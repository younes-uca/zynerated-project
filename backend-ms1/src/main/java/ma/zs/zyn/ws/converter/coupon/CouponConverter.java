package  ma.zs.zyn.ws.converter.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.coupon.InfluencerConverter;
import ma.zs.zyn.ws.converter.packaging.PackagingConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.coupon.Coupon;
import ma.zs.zyn.ws.dto.coupon.CouponDto;

@Component
public class CouponConverter extends AbstractConverter<Coupon, CouponDto> {

    @Autowired
    private InfluencerConverter influencerConverter ;
    @Autowired
    private PackagingConverter packagingConverter ;
    private boolean packaging;
    private boolean influencer;

    public  CouponConverter() {
        super(Coupon.class, CouponDto.class);
        init(true);
    }

    @Override
    public Coupon toItem(CouponDto dto) {
        if (dto == null) {
            return null;
        } else {
        Coupon item = new Coupon();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getPourcentageCoupon()))
                item.setPourcentageCoupon(dto.getPourcentageCoupon());
            if(StringUtil.isNotEmpty(dto.getPourcentageInfluencer()))
                item.setPourcentageInfluencer(dto.getPourcentageInfluencer());
            if(StringUtil.isNotEmpty(dto.getUsingNumber()))
                item.setUsingNumber(dto.getUsingNumber());
            if(this.packaging && dto.getPackaging()!=null &&  dto.getPackaging().getId() != null)
                item.setPackaging(packagingConverter.toItem(dto.getPackaging())) ;

            if(this.influencer && dto.getInfluencer()!=null &&  dto.getInfluencer().getId() != null)
                item.setInfluencer(influencerConverter.toItem(dto.getInfluencer())) ;




        return item;
        }
    }

    @Override
    public CouponDto toDto(Coupon item) {
        if (item == null) {
            return null;
        } else {
            CouponDto dto = new CouponDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(StringUtil.isNotEmpty(item.getPourcentageCoupon()))
                dto.setPourcentageCoupon(item.getPourcentageCoupon());
            if(StringUtil.isNotEmpty(item.getPourcentageInfluencer()))
                dto.setPourcentageInfluencer(item.getPourcentageInfluencer());
            if(StringUtil.isNotEmpty(item.getUsingNumber()))
                dto.setUsingNumber(item.getUsingNumber());
            if(this.packaging && item.getPackaging()!=null) {
                dto.setPackaging(packagingConverter.toDto(item.getPackaging())) ;

            }
            if(this.influencer && item.getInfluencer()!=null) {
                dto.setInfluencer(influencerConverter.toDto(item.getInfluencer())) ;

            }


        return dto;
        }
    }

    public void copy(CouponDto dto, Coupon t) {
    super.copy(dto, t);
    if (dto.getPackaging() != null)
        packagingConverter.copy(dto.getPackaging(), t.getPackaging());
    if (dto.getInfluencer() != null)
        influencerConverter.copy(dto.getInfluencer(), t.getInfluencer());
    }



    public void initObject(boolean value) {
        this.packaging = value;
        this.influencer = value;
    }


    public InfluencerConverter getInfluencerConverter(){
        return this.influencerConverter;
    }
    public void setInfluencerConverter(InfluencerConverter influencerConverter ){
        this.influencerConverter = influencerConverter;
    }
    public PackagingConverter getPackagingConverter(){
        return this.packagingConverter;
    }
    public void setPackagingConverter(PackagingConverter packagingConverter ){
        this.packagingConverter = packagingConverter;
    }
    public boolean  isPackaging(){
        return this.packaging;
    }
    public void  setPackaging(boolean packaging){
        this.packaging = packaging;
    }
    public boolean  isInfluencer(){
        return this.influencer;
    }
    public void  setInfluencer(boolean influencer){
        this.influencer = influencer;
    }
}
