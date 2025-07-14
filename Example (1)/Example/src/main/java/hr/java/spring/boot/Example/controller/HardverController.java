package hr.java.spring.boot.Example.controller;

import hr.java.spring.boot.Example.data.Hardver;
import hr.java.spring.boot.Example.dto.HardverDTO;
import hr.java.spring.boot.Example.service.HardverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardver")
public class HardverController {

    private final HardverService hardverService;

    @Autowired
    public HardverController(HardverService hardverService) {
        this.hardverService = hardverService;
    }


    @GetMapping
    public ResponseEntity<List<HardverDTO>> getAll() {
        List<HardverDTO> hardverList = hardverService.findAll();
        return ResponseEntity.ok(hardverList);
    }


    @GetMapping("/{sifra}")
    public ResponseEntity<HardverDTO> getBySifra(@PathVariable String sifra) {
        HardverDTO dto = hardverService.findBySifra(sifra);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<String> createHardver(@Valid @RequestBody HardverDTO dto) {
        hardverService.save(dto);
        return ResponseEntity.ok("Hardver uspješno spremljen.");
    }


    @PutMapping("/{sifra}")
    public ResponseEntity<String> updateHardver(@PathVariable String sifra, @Valid @RequestBody HardverDTO dto) {
        HardverDTO updated = hardverService.updateBySifra(sifra, dto);
        if (updated != null) {
            return ResponseEntity.ok("Hardver ažuriran.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{sifra}")
    public ResponseEntity<String> deleteHardver(@PathVariable String sifra) {
        hardverService.deleteBySifra(sifra);
        return ResponseEntity.ok("Hardver obrisan.");
    }
}
