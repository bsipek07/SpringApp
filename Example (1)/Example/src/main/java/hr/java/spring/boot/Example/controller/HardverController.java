package hr.java.spring.boot.Example.controller;

import hr.java.spring.boot.Example.data.Hardver;
import hr.java.spring.boot.Example.dto.HardverDTO;
import hr.java.spring.boot.Example.service.HardverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardver")
public class HardverController {

    @Autowired
    private HardverService service;

    @GetMapping
    public List<HardverDTO> getAllHardver() {
        return service.findAll();
    }

    @GetMapping("/{sifra}")
    public HardverDTO getBySifra(@PathVariable String sifra) {
        return service.findBySifra(sifra);
    }

    @PostMapping
    public Hardver createHardver(@RequestBody Hardver hardver){
        return service.save(hardver);
    }
    @PutMapping("/{sifra}")
    public Hardver update(@PathVariable String sifra,@RequestBody Hardver update){
        return  service.updateBySifra(sifra,update);
    }

    @DeleteMapping("/{sifra}")
    public void deleteBySifra(@PathVariable String sifra){
        service.deleteBySifra(sifra);
    }



}

