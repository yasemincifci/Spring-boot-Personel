package com.postgrebaglanti.deneme;

import com.postgrebaglanti.deneme.dto.PersonelDTO;
import com.postgrebaglanti.deneme.service.IPersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private IPersonelService iPersonelService;

    //@Autowired
    public Controller(IPersonelService iPersonelService) {
        this.iPersonelService = iPersonelService;
    }

    @GetMapping("/personels")
    public ResponseEntity<List<PersonelDTO>> getAllPersonel() {
        List<PersonelDTO> personel = iPersonelService.getAllPersonel();
        return new ResponseEntity<>(personel, HttpStatus.OK);

    }

    @GetMapping("/personelsSize")
    public String size() {
        List<PersonelDTO> personel = iPersonelService.getAllPersonel();
        return personel.size() + " adet kullanıcı mevcut";

    }

    @PostMapping("/savedPersonels")
    public ResponseEntity<PersonelDTO> savePersonel(@RequestBody PersonelDTO personelDto) {
        PersonelDTO savedPersonel = iPersonelService.savePersonel(personelDto);
        return  ResponseEntity.ok(savedPersonel);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonel(@PathVariable Long id) {
        iPersonelService.deletePersonel(id);
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  ResponseEntity.ok("id: " + id + " nolu personel listeden kaldırıldı.");
    }


/*
    @GetMapping("/personel")
    public List<PersonelDTO> getAllPersonel() {
        List<PersonelDTO> personel = iPersonelService.getAllPersonel();
        return  personel;

    }

 */


}
