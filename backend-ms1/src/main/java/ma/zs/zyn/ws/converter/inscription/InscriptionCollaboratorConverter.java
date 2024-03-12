package  ma.zs.zyn.ws.converter.inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.zyn.ws.converter.collaborator.CollaboratorConverter;
import ma.zs.zyn.ws.converter.packaging.PackagingConverter;
import ma.zs.zyn.ws.converter.inscription.InscriptionStateConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.inscription.InscriptionCollaborator;
import ma.zs.zyn.ws.dto.inscription.InscriptionCollaboratorDto;

@Component
public class InscriptionCollaboratorConverter extends AbstractConverter<InscriptionCollaborator, InscriptionCollaboratorDto> {

    @Autowired
    private CollaboratorConverter collaboratorConverter ;
    @Autowired
    private PackagingConverter packagingConverter ;
    @Autowired
    private InscriptionStateConverter inscriptionStateConverter ;
    private boolean packaging;
    private boolean collaborator;
    private boolean inscriptionState;

    public  InscriptionCollaboratorConverter() {
        super(InscriptionCollaborator.class, InscriptionCollaboratorDto.class);
        init(true);
    }

    @Override
    public InscriptionCollaborator toItem(InscriptionCollaboratorDto dto) {
        if (dto == null) {
            return null;
        } else {
        InscriptionCollaborator item = new InscriptionCollaborator();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getInscriptionDate()))
                item.setInscriptionDate(DateUtil.stringEnToDate(dto.getInscriptionDate()));
            if(StringUtil.isNotEmpty(dto.getRenewDate()))
                item.setRenewDate(DateUtil.stringEnToDate(dto.getRenewDate()));
            if(this.packaging && dto.getPackaging()!=null &&  dto.getPackaging().getId() != null)
                item.setPackaging(packagingConverter.toItem(dto.getPackaging())) ;

            if(this.collaborator && dto.getCollaborator()!=null &&  dto.getCollaborator().getId() != null)
                item.setCollaborator(collaboratorConverter.toItem(dto.getCollaborator())) ;

            if(this.inscriptionState && dto.getInscriptionState()!=null &&  dto.getInscriptionState().getId() != null)
                item.setInscriptionState(inscriptionStateConverter.toItem(dto.getInscriptionState())) ;




        return item;
        }
    }

    @Override
    public InscriptionCollaboratorDto toDto(InscriptionCollaborator item) {
        if (item == null) {
            return null;
        } else {
            InscriptionCollaboratorDto dto = new InscriptionCollaboratorDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getInscriptionDate()!=null)
                dto.setInscriptionDate(DateUtil.dateTimeToString(item.getInscriptionDate()));
            if(item.getRenewDate()!=null)
                dto.setRenewDate(DateUtil.dateTimeToString(item.getRenewDate()));
            if(this.packaging && item.getPackaging()!=null) {
                dto.setPackaging(packagingConverter.toDto(item.getPackaging())) ;

            }
            if(this.collaborator && item.getCollaborator()!=null) {
                dto.setCollaborator(collaboratorConverter.toDto(item.getCollaborator())) ;

            }
            if(this.inscriptionState && item.getInscriptionState()!=null) {
                dto.setInscriptionState(inscriptionStateConverter.toDto(item.getInscriptionState())) ;

            }


        return dto;
        }
    }

    public void copy(InscriptionCollaboratorDto dto, InscriptionCollaborator t) {
    super.copy(dto, t);
    if (dto.getPackaging() != null)
        packagingConverter.copy(dto.getPackaging(), t.getPackaging());
    if (dto.getCollaborator() != null)
        collaboratorConverter.copy(dto.getCollaborator(), t.getCollaborator());
    if (dto.getInscriptionState() != null)
        inscriptionStateConverter.copy(dto.getInscriptionState(), t.getInscriptionState());
    }



    public void initObject(boolean value) {
        this.packaging = value;
        this.collaborator = value;
        this.inscriptionState = value;
    }


    public CollaboratorConverter getCollaboratorConverter(){
        return this.collaboratorConverter;
    }
    public void setCollaboratorConverter(CollaboratorConverter collaboratorConverter ){
        this.collaboratorConverter = collaboratorConverter;
    }
    public PackagingConverter getPackagingConverter(){
        return this.packagingConverter;
    }
    public void setPackagingConverter(PackagingConverter packagingConverter ){
        this.packagingConverter = packagingConverter;
    }
    public InscriptionStateConverter getInscriptionStateConverter(){
        return this.inscriptionStateConverter;
    }
    public void setInscriptionStateConverter(InscriptionStateConverter inscriptionStateConverter ){
        this.inscriptionStateConverter = inscriptionStateConverter;
    }
    public boolean  isPackaging(){
        return this.packaging;
    }
    public void  setPackaging(boolean packaging){
        this.packaging = packaging;
    }
    public boolean  isCollaborator(){
        return this.collaborator;
    }
    public void  setCollaborator(boolean collaborator){
        this.collaborator = collaborator;
    }
    public boolean  isInscriptionState(){
        return this.inscriptionState;
    }
    public void  setInscriptionState(boolean inscriptionState){
        this.inscriptionState = inscriptionState;
    }
}
