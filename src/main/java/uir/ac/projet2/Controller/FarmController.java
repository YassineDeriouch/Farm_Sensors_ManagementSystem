package uir.ac.projet2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uir.ac.projet2.Entity.Farm;
import uir.ac.projet2.Service.FarmService;

/**
 * Created By Youssef on 10/05/2023
 *
 * @Author : Youssef
 * @Date : 10/05/2023
 * @Project : projet2
 */

@RestController
@RequestMapping("/Farms")
public class FarmController {

    @Autowired private FarmService farmService;
    @PostMapping
    public ResponseEntity<Farm> SaveFarm(@RequestBody Farm farm){
        try{

            return new ResponseEntity<>(farmService.SaveFarm(farm), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
