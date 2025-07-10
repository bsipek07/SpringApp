package hr.java.spring.boot.Example.service;


import hr.java.spring.boot.Example.data.Hardver;
import hr.java.spring.boot.Example.dto.HardverDTO;
import hr.java.spring.boot.Example.repository.MockHardverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.java.spring.boot.Example.repository.HardverRepository;

import java.util.List;

@Service
public class HardverServiceImpl implements HardverService {


    @Autowired
    private MockHardverRepository repository;

    public HardverServiceImpl(MockHardverRepository repository){
        this.repository=repository;
    }

    @Override
    public List<HardverDTO> findAll() {
        return repository.findAll().stream()
                .map(h -> new HardverDTO(h.getNaziv(), h.getCijena(), h.getTip()))
                .toList();
    }

    @Override
    public HardverDTO findBySifra(String sifra) {
        Hardver h = repository.findBySifra(sifra)
                .orElseThrow(() -> new RuntimeException("Hardver nije pronađen"));
        return new HardverDTO(h.getNaziv(), h.getCijena(), h.getTip());
    }

    @Override
    public Hardver save(Hardver hardver){
        return repository.save(hardver);
    }

    @Override
    public Hardver updateBySifra(String sifra,Hardver updated){
        var optional = repository.findBySifra(sifra);
        if(optional.isPresent()){
            repository.deleteBySifra(sifra);
            repository.save(updated);
            return updated;
        }
        return null;
    }

    @Override
    public void deleteBySifra(String sifra){
        repository.deleteBySifra(sifra);
    }

}
