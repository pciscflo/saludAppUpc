package pe.upc.salud.business;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.salud.dtos.HealthCenterDTO;
import pe.upc.salud.entity.HealthCenter;
import pe.upc.salud.repositories.RepositoryHealthCenter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessHealthCenter {
    //inyectando el repositorio
    @Autowired
    private RepositoryHealthCenter repositoryHealthCenter;

    public HealthCenter register(HealthCenter healthCenter){ //1
        return repositoryHealthCenter.save(healthCenter);
    }
    public List<HealthCenter> listHealthCenters(){ // 2
        return repositoryHealthCenter.findAll();
    }
    public List<HealthCenterDTO> listHealthCenterCalification(){//3
            List<HealthCenter> list = repositoryHealthCenter.findAll();//ya trae los datos
            List<HealthCenterDTO> listDTO = convertToLisDto(list);
            //calculando datos para cada Health
            for (HealthCenterDTO p:listDTO){
                p.setCalification(p.getPointsInfraeatructure()*0.35 + p.getPointsServices()*0.65);
            }
            return listDTO;
    }
    public List<HealthCenter> listHealthCenterType(String type){//4
        return repositoryHealthCenter.findByType(type);
    }
    private List<HealthCenterDTO> convertToLisDto(List<HealthCenter> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private HealthCenterDTO convertToDto(HealthCenter author) {
        ModelMapper modelMapper = new ModelMapper();
        HealthCenterDTO authorDTO = modelMapper.map(author, HealthCenterDTO.class);
        return authorDTO;
    }

}
