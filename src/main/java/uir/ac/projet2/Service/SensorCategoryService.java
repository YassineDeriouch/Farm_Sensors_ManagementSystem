package uir.ac.projet2.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uir.ac.projet2.Entity.SensorCategory;
import uir.ac.projet2.Repository.SensorCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Yassine
 * @project SensorCategory_Sensors_ManagementSystem
 */
@Service
@Data
public class SensorCategoryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SensorCategoryRepository categoryRepository;

    @Transactional
    public SensorCategory saveCategory(SensorCategory sensorCategory) {
        sensorCategory.setReference(sensorCategory.getReference());
        sensorCategory.setDescription(sensorCategory.getDescription());
        SensorCategory savedCategory = categoryRepository.save(sensorCategory);
        return modelMapper.map(savedCategory, SensorCategory.class);
    }

    @Transactional
    public SensorCategory updateCategory(int id, SensorCategory sensorCategory) throws EntityNotFoundException {
        Optional<SensorCategory> sensorCategoryOptional = categoryRepository.findById(id);
        if (sensorCategoryOptional.isPresent()) {
            SensorCategory sensorCategory1 = modelMapper.map(sensorCategory, SensorCategory.class);
            sensorCategory1.setIdCateg(id);
            SensorCategory updatedSensorCategory = categoryRepository.save(sensorCategory1);
            return modelMapper.map(updatedSensorCategory, SensorCategory.class);
        } else {
            throw new EntityNotFoundException("sensorCategory id= " + id + " not found");
        }
    }

    @Transactional
    public List<SensorCategory> getAllCategories() throws EntityNotFoundException {
        return categoryRepository.findAll().stream().map(element -> modelMapper.map(element, SensorCategory.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public SensorCategory getCategoryByID(int id) throws EntityNotFoundException {
        Optional<SensorCategory> sensorCategory = categoryRepository.findById(id);
        if (sensorCategory.isPresent())
            return modelMapper.map(sensorCategory, SensorCategory.class);
        else
            throw new EntityNotFoundException("Category id= " + id + " not found");
    }

    @Transactional
    public SensorCategory deleteCategoryByID(int id) throws EntityNotFoundException {
        Optional<SensorCategory> sensorCategory = categoryRepository.findById(id);
        if (sensorCategory.isPresent()) {
            categoryRepository.deleteById(id);
            return modelMapper.map(sensorCategory, SensorCategory.class);
        } else
            throw new EntityNotFoundException("SensorCategory id= " + id + " not found");
    }

    /**
     * DELETE ALL CATEGORIES
     *
     * @return
     * @throws EntityNotFoundException
     */
    @Transactional
    public List<SensorCategory> deleteAllSensorCategorys() throws EntityNotFoundException {
        List<SensorCategory> sensorCategorys = categoryRepository.findAll();
        if (!sensorCategorys.isEmpty()) {
            categoryRepository.deleteAll();
            return sensorCategorys.stream().map(element -> modelMapper.map(element, SensorCategory.class))
                    .collect(Collectors.toList());
        } else {
            throw new EntityNotFoundException("NO sensorCategory has been found !");
        }
    }
}
