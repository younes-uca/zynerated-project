package  ma.zs.zyn.ws.converter.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.project.PaimentCollaboratorState;
import ma.zs.zyn.ws.dto.project.PaimentCollaboratorStateDto;

@Component
public class PaimentCollaboratorStateConverter extends AbstractConverter<PaimentCollaboratorState, PaimentCollaboratorStateDto> {


    public  PaimentCollaboratorStateConverter() {
        super(PaimentCollaboratorState.class, PaimentCollaboratorStateDto.class);
    }

    @Override
    public PaimentCollaboratorState toItem(PaimentCollaboratorStateDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaimentCollaboratorState item = new PaimentCollaboratorState();
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
    public PaimentCollaboratorStateDto toDto(PaimentCollaboratorState item) {
        if (item == null) {
            return null;
        } else {
            PaimentCollaboratorStateDto dto = new PaimentCollaboratorStateDto();
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
