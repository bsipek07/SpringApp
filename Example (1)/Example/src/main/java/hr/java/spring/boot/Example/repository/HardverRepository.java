package hr.java.spring.boot.Example.repository;


import hr.java.spring.boot.Example.data.Hardver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HardverRepository extends JpaRepository<Hardver, Long> {
    Optional<Hardver> findBySifra(String sifra);
    void deleteBySifra(String sifra);
}
