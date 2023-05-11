package uir.ac.projet2.Controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uir.ac.projet2.Entity.SensorCategory;
import uir.ac.projet2.Service.SensorCategoryService;

import java.util.List;

/**
 * @author Yassine
 * @project SensorCategory_Sensors_ManagementSystem
 */
@RestController
@RequestMapping("SensorCategories")
@Data
public class SensorCategoryController {

    @Autowired
    private SensorCategoryService sensorCategoryService;

    @PostMapping("/save")
    public ResponseEntity<SensorCategory> SaveSensorCategory(@RequestBody SensorCategory sensorCategory) {
        try {
            return new ResponseEntity<>(sensorCategoryService.saveCategory(sensorCategory), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * UPDATE SensorCategory
     *
     * @param idCategory
     * @param sensorCategory
     * @return
     */
    @PutMapping("/update/id")
    public ResponseEntity<SensorCategory> updateSensorCategory(@RequestParam int idCategory, @RequestBody SensorCategory sensorCategory) {
        try {
            return new ResponseEntity<>(sensorCategoryService.updateCategory(idCategory, sensorCategory), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * GET SensorCategory BY ID
     *
     * @param idCategory
     * @return
     */
    @GetMapping("/get/id")
    public ResponseEntity<SensorCategory> getSensorCategoryByID(@RequestParam int idCategory) {
        try {
            return new ResponseEntity<>(sensorCategoryService.getCategoryByID(idCategory), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GET SensorCategory BY ID
     *
     * @param idCategory
     * @return
     */
    @GetMapping("/get/sensors/id")
    public ResponseEntity<SensorCategory> getSensorCategorySensorsByID(@RequestParam int idCategory) {
        try {
            return new ResponseEntity<>(sensorCategoryService.getCategoryByID(idCategory), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GET ALL SensorCategory
     *
     * @return
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<SensorCategory>> getAllSensorCategorys() {
        try {
            return new ResponseEntity<>(sensorCategoryService.getAllCategories(), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE ONE SensorCategory
     *
     * @param idCategory
     * @return
     */
    @DeleteMapping("/delete/id")
    public ResponseEntity<SensorCategory> deleteSensorCategoryByID(@RequestParam int idCategory) {
        try {
            return new ResponseEntity<>(sensorCategoryService.deleteCategoryByID(idCategory), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE ALL SensorCategory
     *
     * @return
     */
    @DeleteMapping("/delete/all")
    public ResponseEntity<List<SensorCategory>> deleteAllSensorCategorys() {
        try {
            List<SensorCategory> sensorCategory = sensorCategoryService.deleteAllSensorCategorys();
            return new ResponseEntity<>(sensorCategory, HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
