package hr.java.spring.boot.Example.repository;
import hr.java.spring.boot.Example.data.Hardver;
import hr.java.spring.boot.Example.data.TipHardvera;
import hr.java.spring.boot.Example.dto.HardverDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockHardverRepository {

    private static List<Hardver> hardverList;

    static {
        hardverList = new ArrayList<>();

        Hardver firstHardver = new Hardver(1L, "RADEON GT859", "225883", new BigDecimal("330.00"), TipHardvera.GPU, 7);
        Hardver secondHardver = new Hardver(2L, "RYZEN 9", "332131", new BigDecimal("599.99"), TipHardvera.CPU, 3);
        Hardver thirdHardver = new Hardver(3L, "Gigabyte 16GB", "333213", new BigDecimal("100.00"), TipHardvera.RAM, 5);
        Hardver fourthHardver = new Hardver(4L, "SSD", "444112", new BigDecimal("441.00"), TipHardvera.STORAGE, 5);

        hardverList.add(firstHardver);
        hardverList.add(secondHardver);
        hardverList.add(thirdHardver);
        hardverList.add(fourthHardver);
    }

    public List<Hardver> findAll() {
        return hardverList;
    }

    public Optional<Hardver> findBySifra(String sifra) {
        return hardverList.stream().filter(h -> h.getSifra().equals(sifra)).findFirst();
    }

    public Hardver save(Hardver hardver) {
        hardverList.add(hardver);
        return hardver;
    }

    public void deleteBySifra(String sifra) {
        hardverList.removeIf(h -> h.getSifra().equals(sifra));
    }
}
