package  ma.zs.zyn.ws.converter.paiment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.collaborator.CollaboratorConverter;
import ma.zs.zyn.ws.converter.coupon.CouponConverter;
import ma.zs.zyn.ws.converter.project.PaimentCollaboratorStateConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.paiment.PaimentCollaborator;
import ma.zs.zyn.ws.dto.paiment.PaimentCollaboratorDto;

@Component
public class PaimentCollaboratorConverter extends AbstractConverter<PaimentCollaborator, PaimentCollaboratorDto> {

    @Autowired
    private CollaboratorConverter collaboratorConverter ;
    @Autowired
    private CouponConverter couponConverter ;
    @Autowired
    private PaimentCollaboratorStateConverter paimentCollaboratorStateConverter ;
    private boolean collaborator;
    private boolean coupon;
    private boolean paimentCollaboratorState;

    public  PaimentCollaboratorConverter() {
        super(PaimentCollaborator.class, PaimentCollaboratorDto.class);
        init(true);
    }

    @Override
    public PaimentCollaborator toItem(PaimentCollaboratorDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaimentCollaborator item = new PaimentCollaborator();
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
            if(this.collaborator && dto.getCollaborator()!=null &&  dto.getCollaborator().getId() != null)
                item.setCollaborator(collaboratorConverter.toItem(dto.getCollaborator())) ;

            if(this.coupon && dto.getCoupon()!=null &&  dto.getCoupon().getId() != null)
                item.setCoupon(couponConverter.toItem(dto.getCoupon())) ;

            if(this.paimentCollaboratorState && dto.getPaimentCollaboratorState()!=null &&  dto.getPaimentCollaboratorState().getId() != null)
                item.setPaimentCollaboratorState(paimentCollaboratorStateConverter.toItem(dto.getPaimentCollaboratorState())) ;




        return item;
        }
    }

    @Override
    public PaimentCollaboratorDto toDto(PaimentCollaborator item) {
        if (item == null) {
            return null;
        } else {
            PaimentCollaboratorDto dto = new PaimentCollaboratorDto();
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
            if(this.collaborator && item.getCollaborator()!=null) {
                dto.setCollaborator(collaboratorConverter.toDto(item.getCollaborator())) ;

            }
            if(this.coupon && item.getCoupon()!=null) {
                dto.setCoupon(couponConverter.toDto(item.getCoupon())) ;

            }
            if(this.paimentCollaboratorState && item.getPaimentCollaboratorState()!=null) {
                dto.setPaimentCollaboratorState(paimentCollaboratorStateConverter.toDto(item.getPaimentCollaboratorState())) ;

            }


        return dto;
        }
    }

    public void copy(PaimentCollaboratorDto dto, PaimentCollaborator t) {
    super.copy(dto, t);
    if (dto.getCollaborator() != null)
        collaboratorConverter.copy(dto.getCollaborator(), t.getCollaborator());
    if (dto.getCoupon() != null)
        couponConverter.copy(dto.getCoupon(), t.getCoupon());
    if (dto.getPaimentCollaboratorState() != null)
        paimentCollaboratorStateConverter.copy(dto.getPaimentCollaboratorState(), t.getPaimentCollaboratorState());
    }



    public void initObject(boolean value) {
        this.collaborator = value;
        this.coupon = value;
        this.paimentCollaboratorState = value;
    }


    public CollaboratorConverter getCollaboratorConverter(){
        return this.collaboratorConverter;
    }
    public void setCollaboratorConverter(CollaboratorConverter collaboratorConverter ){
        this.collaboratorConverter = collaboratorConverter;
    }
    public CouponConverter getCouponConverter(){
        return this.couponConverter;
    }
    public void setCouponConverter(CouponConverter couponConverter ){
        this.couponConverter = couponConverter;
    }
    public PaimentCollaboratorStateConverter getPaimentCollaboratorStateConverter(){
        return this.paimentCollaboratorStateConverter;
    }
    public void setPaimentCollaboratorStateConverter(PaimentCollaboratorStateConverter paimentCollaboratorStateConverter ){
        this.paimentCollaboratorStateConverter = paimentCollaboratorStateConverter;
    }
    public boolean  isCollaborator(){
        return this.collaborator;
    }
    public void  setCollaborator(boolean collaborator){
        this.collaborator = collaborator;
    }
    public boolean  isCoupon(){
        return this.coupon;
    }
    public void  setCoupon(boolean coupon){
        this.coupon = coupon;
    }
    public boolean  isPaimentCollaboratorState(){
        return this.paimentCollaboratorState;
    }
    public void  setPaimentCollaboratorState(boolean paimentCollaboratorState){
        this.paimentCollaboratorState = paimentCollaboratorState;
    }
}
