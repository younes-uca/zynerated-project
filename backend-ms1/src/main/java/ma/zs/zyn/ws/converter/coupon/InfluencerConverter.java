package  ma.zs.zyn.ws.converter.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.coupon.Influencer;
import ma.zs.zyn.ws.dto.coupon.InfluencerDto;

@Component
public class InfluencerConverter extends AbstractConverter<Influencer, InfluencerDto> {


    public  InfluencerConverter() {
        super(Influencer.class, InfluencerDto.class);
    }

    @Override
    public Influencer toItem(InfluencerDto dto) {
        if (dto == null) {
            return null;
        } else {
        Influencer item = new Influencer();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNickName()))
                item.setNickName(dto.getNickName());
            item.setCredentialsNonExpired(dto.getCredentialsNonExpired());
            item.setEnabled(dto.getEnabled());
            item.setAccountNonExpired(dto.getAccountNonExpired());
            item.setAccountNonLocked(dto.getAccountNonLocked());
            item.setPasswordChanged(dto.getPasswordChanged());
            if(StringUtil.isNotEmpty(dto.getUsername()))
                item.setUsername(dto.getUsername());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());


            //item.setRoles(dto.getRoles());

        return item;
        }
    }

    @Override
    public InfluencerDto toDto(Influencer item) {
        if (item == null) {
            return null;
        } else {
            InfluencerDto dto = new InfluencerDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNickName()))
                dto.setNickName(item.getNickName());
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


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
