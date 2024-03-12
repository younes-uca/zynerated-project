package  ma.zs.zyn.ws.converter.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.project.PaimentInfluencerState;
import ma.zs.zyn.ws.dto.project.PaimentInfluencerStateDto;

@Component
public class PaimentInfluencerStateConverter extends AbstractConverter<PaimentInfluencerState, PaimentInfluencerStateDto> {


    public  PaimentInfluencerStateConverter() {
        super(PaimentInfluencerState.class, PaimentInfluencerStateDto.class);
    }

    @Override
    public PaimentInfluencerState toItem(PaimentInfluencerStateDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaimentInfluencerState item = new PaimentInfluencerState();
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
    public PaimentInfluencerStateDto toDto(PaimentInfluencerState item) {
        if (item == null) {
            return null;
        } else {
            PaimentInfluencerStateDto dto = new PaimentInfluencerStateDto();
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
