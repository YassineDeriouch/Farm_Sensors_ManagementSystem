package uir.ac.projet2.Controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uir.ac.projet2.Entity.Farm;
import uir.ac.projet2.Service.FarmService;

import java.util.List;

/**
 * Created By Youssef on 10/05/2023
 * FARM API
 *
 * @Author : Youssef
 * @Date : 10/05/2023
 * @Project : projet2
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("Farms")
public class FarmController {

    @Autowired
    private FarmService farmService;

    /**
     * SAVE FARM
     *
     * @param farm
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<Farm> SaveFarm(@RequestBody Farm farm) {
        try {
            return new ResponseEntity<>(farmService.SaveFarm(farm), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * UPDATE FARM
     *
     * @param idFarm
     * @param farm
     * @return
     */
    @PutMapping("/update/id")
    public ResponseEntity<Farm> updateFarm(@RequestParam int idFarm, @RequestBody Farm farm) {
        try {
            return new ResponseEntity<>(farmService.updateFarm(idFarm, farm), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * GET FARM BY ID
     *
     * @param idFarm
     * @return
     */
    @GetMapping("/get/id")
    public ResponseEntity<Farm> getFarmByID(@RequestParam int idFarm) {
        try {
            return new ResponseEntity<>(farmService.getFarmByID(idFarm), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GET FARM BY ID
     * @param idFarm
     * @return

     @GetMapping("/get/sensors/id") public ResponseEntity<Farm> getFarmSensorsByID(@RequestParam int idFarm){
     try{
     return new ResponseEntity<>(farmService.getFarmSensors(idFarm), HttpStatus.OK);
     }catch (EntityNotFoundException exception){
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     }
     */
    /**
     * GET FARM BY NAME
     *
     * @param FarmName
     * @return
     */
    @GetMapping("/get/name")
    public ResponseEntity<Farm> getFarmByName(@RequestParam String FarmName) {
        try {
            return new ResponseEntity<>(farmService.getFarmByName(FarmName), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GET ALL FARMS
     *
     * @return
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<Farm>> getAllFarms() {
        try {
            return new ResponseEntity<>(farmService.getAllFarms(), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE ONE FARM
     *
     * @param idFarm
     * @return
     */
    @DeleteMapping("/delete/id")
    public ResponseEntity<Farm> deleteFarmByID(@RequestParam int idFarm) {
        try {
            return new ResponseEntity<>(farmService.deleteFarmByID(idFarm), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE ALL FARMS
     *
     * @return
     */
    @DeleteMapping("/delete/all")
    public ResponseEntity<List<Farm>> deleteAllFarms() {
        try {
            List<Farm> farm = farmService.deleteAllFarms();
            return new ResponseEntity<>(farm, HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
