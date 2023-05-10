package uir.ac.projet2.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uir.ac.projet2.Entity.Farm;
import uir.ac.projet2.Repository.FarmRepository;

/**
 * Created By Youssef on 10/05/2023
 *
 * @Author : Youssef
 * @Date : 10/05/2023
 * @Project : projet2
 */
@Service
public class FarmService {

    @Autowired private FarmRepository farmRepository;

    @Autowired private ModelMapper modelMapper;

    @Transactional
    public Farm SaveFarm(Farm farm){
        farm.setIdFarm(farm.getIdFarm());
        farm.setAddress(farm.getAddress());
        farm.setArea(farm.getArea());
        farm.setName(farm.getName());
        farm.setDescription(farm.getDescription());
        farm.setLatitude(farm.getLatitude());
        farm.setLongitude(farm.getLongitude());
        farm.setUserFarms(farm.getUserFarms());
        Farm savedFarm = farmRepository.save(farm);
        return modelMapper.map(savedFarm, Farm.class);
    }

}
