package hr.java.spring.boot.Example.service;


import hr.java.spring.boot.Example.data.Hardver;
import hr.java.spring.boot.Example.dto.HardverDTO;
import hr.java.spring.boot.Example.repository.JdbcHardverRepostiroy;
import hr.java.spring.boot.Example.repository.MockHardverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.java.spring.boot.Example.repository.HardverRepository;

import java.util.List;

@Service
public class HardverServiceImpl implements HardverService {


    @Autowired
    private JdbcHardverRepostiroy repository;

    public HardverServiceImpl(JdbcHardverRepostiroy repository){
        this.repository=repository;
    }
    @Override
    public List<HardverDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public HardverDTO findBySifra(String sifra) {
        Hardver h = repository.findBySifra(sifra)
                .orElseThrow(() -> new RuntimeException("Hardver nije pronađen"));
        return toDTO(h);
    }

    @Override
    public HardverDTO save(HardverDTO hardverDTO) {
        Hardver hardver = toEntity(hardverDTO);
        repository.save(hardver);
        return toDTO(hardver);
    }

    @Override
    public HardverDTO updateBySifra(String sifra, HardverDTO updatedDTO) {
        var optional = repository.findBySifra(sifra);
        if (optional.isPresent()) {
            repository.deleteBySifra(sifra);
            Hardver updated = toEntity(updatedDTO);
            repository.save(updated);
            return toDTO(updated);
        }
        throw new RuntimeException("Hardver s tom šifrom ne postoji");
    }
    @Override
    public void deleteBySifra(String sifra){
        repository.deleteBySifra(sifra);
    }
    private HardverDTO toDTO(Hardver h) {
        return new HardverDTO(h.getNaziv(), h.getCijena(), h.getTip());
    }

    private Hardver toEntity(HardverDTO dto) {
        return new Hardver(null, dto.getNaziv(), null, dto.getCijena(), dto.getTip(), 0);
    }

}
