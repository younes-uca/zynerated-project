package  ma.zs.zyn.ws.converter.inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.inscription.InscriptionState;
import ma.zs.zyn.ws.dto.inscription.InscriptionStateDto;

@Component
public class InscriptionStateConverter extends AbstractConverter<InscriptionState, InscriptionStateDto> {


    public  InscriptionStateConverter() {
        super(InscriptionState.class, InscriptionStateDto.class);
    }

    @Override
    public InscriptionState toItem(InscriptionStateDto dto) {
        if (dto == null) {
            return null;
        } else {
        InscriptionState item = new InscriptionState();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());



        return item;
        }
    }

    @Override
    public InscriptionStateDto toDto(InscriptionState item) {
        if (item == null) {
            return null;
        } else {
            InscriptionStateDto dto = new InscriptionStateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
