package uir.ac.projet2.Service;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uir.ac.projet2.Entity.Farm;
import uir.ac.projet2.Entity.Sensor;
import uir.ac.projet2.Repository.FarmRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created By Youssef on 10/05/2023
 *
 * @Author : Youssef
 * @Date : 10/05/2023
 * @Project : projet2
 */
@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * SAVE FARM
     *
     * @param farm
     * @return savedFarm
     */
    @Transactional
    public Farm SaveFarm(Farm farm) {
        farm.setIdFarm(farm.getIdFarm());
        farm.setAddress(farm.getAddress());
        farm.setArea(farm.getArea());
        farm.setName(farm.getName());
        farm.setDescription(farm.getDescription());
        farm.setLatitude(farm.getLatitude());
        farm.setLongitude(farm.getLongitude());
        farm.setUserFarms(farm.getUserFarms());
        //farm.setSensorList(farm.getSensorList());
        Farm savedFarm = farmRepository.save(farm);
        return modelMapper.map(savedFarm, Farm.class);
    }

    /**
     * UPDATE FARM
     *
     * @param id
     * @param farm
     * @return farm object updatedFarm
     */
    @Transactional
    public Farm updateFarm(int id, Farm farm) throws EntityNotFoundException {
        Optional<Farm> farmOptional = farmRepository.findById(id);
        if (farmOptional.isPresent()) {
            Farm farm1 = modelMapper.map(farm, Farm.class);
            farm1.setIdFarm(id);
            Farm updatedFarm = farmRepository.save(farm1);
            return modelMapper.map(updatedFarm, Farm.class);
        } else {
            throw new EntityNotFoundException("farm id= " + id + " name= " + farm.getName() + "not found");
        }
    }

    /**
     * GET ALL FARMS
     *
     * @return
     */
    @Transactional
    public List<Farm> getAllFarms() throws EntityNotFoundException {
        return farmRepository.findAll().stream().map(element -> modelMapper.map(element, Farm.class))
                .collect(Collectors.toList());
    }

    /**
     * GET FARM BY ID
     *
     * @param id
     * @return farm object
     */
    @Transactional
    public Farm getFarmByID(int id) throws EntityNotFoundException {
        Optional<Farm> farm = farmRepository.findById(id);
        if (farm.isPresent())
            return modelMapper.map(farm, Farm.class);
        else
            throw new EntityNotFoundException("Farm id= " + id + "name= " + farm.get().getName() + " not found");
    }

    /**
     * GET FARM BY NAME
     *
     * @param
     * @return farm object
     */
    @Transactional
    public Farm getFarmByName(String Name) throws EntityNotFoundException {
        Farm farm = farmRepository.findFarmByName(Name);
        if (farm != null)
            return modelMapper.map(farm, Farm.class);
        else
            throw new EntityNotFoundException("Farm name = " + Name + " not found");
    }

    /*@Transactional
    public Farm getFarmSensors(int id)throws EntityNotFoundException{
        Optional<Farm> farmOptional = farmRepository.findById(id);
        if(farmOptional.isPresent()){
            List<Sensor> farmList =farmOptional.get().getSensorList();
            if(!farmList.isEmpty())
                return (Farm) farmList.stream().map(element -> Farm.class).collect(Collectors.toList());
            else
                return null;
        }else{
            throw new EntityNotFoundException("Farm with id : "+id+" not found !");
        }
    }*/

    /**
     * DELETE FARM BY ID
     *
     * @param id
     * @return FARM OBJECT
     * @throws EntityNotFoundException
     */
    @Transactional
    public Farm deleteFarmByID(int id) throws EntityNotFoundException {
        Optional<Farm> farm = farmRepository.findById(id);
        if (farm.isPresent()) {
            farmRepository.deleteById(id);
            return modelMapper.map(farm, Farm.class);
        } else
            throw new EntityNotFoundException("Farm id= " + id + " not found");
    }

    /**
     * DELETE ALL FARMS
     *
     * @return
     * @throws EntityNotFoundException
     */
    @Transactional
    public List<Farm> deleteAllFarms() throws EntityNotFoundException {
        List<Farm> farms = farmRepository.findAll();
        if (!farms.isEmpty()) {
            farmRepository.deleteAll();
            return farms.stream().map(element -> modelMapper.map(element, Farm.class))
                    .collect(Collectors.toList());
        } else {
            throw new EntityNotFoundException("NO farm has been found !");
        }
    }


}
