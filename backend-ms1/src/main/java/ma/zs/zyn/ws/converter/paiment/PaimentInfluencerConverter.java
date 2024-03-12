package  ma.zs.zyn.ws.converter.paiment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.coupon.CouponConverter;
import ma.zs.zyn.ws.converter.coupon.InfluencerConverter;
import ma.zs.zyn.ws.converter.project.PaimentInfluencerStateConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.paiment.PaimentInfluencer;
import ma.zs.zyn.ws.dto.paiment.PaimentInfluencerDto;

@Component
public class PaimentInfluencerConverter extends AbstractConverter<PaimentInfluencer, PaimentInfluencerDto> {

    @Autowired
    private CouponConverter couponConverter ;
    @Autowired
    private InfluencerConverter influencerConverter ;
    @Autowired
    private PaimentInfluencerStateConverter paimentInfluencerStateConverter ;
    private boolean influencer;
    private boolean coupon;
    private boolean paimentInfluencerState;

    public  PaimentInfluencerConverter() {
        super(PaimentInfluencer.class, PaimentInfluencerDto.class);
        init(true);
    }

    @Override
    public PaimentInfluencer toItem(PaimentInfluencerDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaimentInfluencer item = new PaimentInfluencer();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(this.influencer && dto.getInfluencer()!=null &&  dto.getInfluencer().getId() != null)
                item.setInfluencer(influencerConverter.toItem(dto.getInfluencer())) ;

            if(this.coupon && dto.getCoupon()!=null &&  dto.getCoupon().getId() != null)
                item.setCoupon(couponConverter.toItem(dto.getCoupon())) ;

            if(this.paimentInfluencerState && dto.getPaimentInfluencerState()!=null &&  dto.getPaimentInfluencerState().getId() != null)
                item.setPaimentInfluencerState(paimentInfluencerStateConverter.toItem(dto.getPaimentInfluencerState())) ;




        return item;
        }
    }

    @Override
    public PaimentInfluencerDto toDto(PaimentInfluencer item) {
        if (item == null) {
            return null;
        } else {
            PaimentInfluencerDto dto = new PaimentInfluencerDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(this.influencer && item.getInfluencer()!=null) {
                dto.setInfluencer(influencerConverter.toDto(item.getInfluencer())) ;

            }
            if(this.coupon && item.getCoupon()!=null) {
                dto.setCoupon(couponConverter.toDto(item.getCoupon())) ;

            }
            if(this.paimentInfluencerState && item.getPaimentInfluencerState()!=null) {
                dto.setPaimentInfluencerState(paimentInfluencerStateConverter.toDto(item.getPaimentInfluencerState())) ;

            }


        return dto;
        }
    }

    public void copy(PaimentInfluencerDto dto, PaimentInfluencer t) {
    super.copy(dto, t);
    if (dto.getInfluencer() != null)
        influencerConverter.copy(dto.getInfluencer(), t.getInfluencer());
    if (dto.getCoupon() != null)
        couponConverter.copy(dto.getCoupon(), t.getCoupon());
    if (dto.getPaimentInfluencerState() != null)
        paimentInfluencerStateConverter.copy(dto.getPaimentInfluencerState(), t.getPaimentInfluencerState());
    }



    public void initObject(boolean value) {
        this.influencer = value;
        this.coupon = value;
        this.paimentInfluencerState = value;
    }


    public CouponConverter getCouponConverter(){
        return this.couponConverter;
    }
    public void setCouponConverter(CouponConverter couponConverter ){
        this.couponConverter = couponConverter;
    }
    public InfluencerConverter getInfluencerConverter(){
        return this.influencerConverter;
    }
    public void setInfluencerConverter(InfluencerConverter influencerConverter ){
        this.influencerConverter = influencerConverter;
    }
    public PaimentInfluencerStateConverter getPaimentInfluencerStateConverter(){
        return this.paimentInfluencerStateConverter;
    }
    public void setPaimentInfluencerStateConverter(PaimentInfluencerStateConverter paimentInfluencerStateConverter ){
        this.paimentInfluencerStateConverter = paimentInfluencerStateConverter;
    }
    public boolean  isInfluencer(){
        return this.influencer;
    }
    public void  setInfluencer(boolean influencer){
        this.influencer = influencer;
    }
    public boolean  isCoupon(){
        return this.coupon;
    }
    public void  setCoupon(boolean coupon){
        this.coupon = coupon;
    }
    public boolean  isPaimentInfluencerState(){
        return this.paimentInfluencerState;
    }
    public void  setPaimentInfluencerState(boolean paimentInfluencerState){
        this.paimentInfluencerState = paimentInfluencerState;
    }
}
