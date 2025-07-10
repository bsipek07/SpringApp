package hr.java.spring.boot.Example.service;



import hr.java.spring.boot.Example.data.Hardver;
import hr.java.spring.boot.Example.dto.HardverDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HardverService {
    List<HardverDTO> findAll();
    HardverDTO findBySifra(String sifra);
    Hardver save(Hardver hardver);
    Hardver updateBySifra(String sifra,Hardver updated);
    void deleteBySifra(String sifra);
}
