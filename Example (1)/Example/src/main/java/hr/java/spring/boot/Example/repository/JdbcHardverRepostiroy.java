package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.data.Hardver;
import hr.java.spring.boot.Example.data.TipHardvera;
import hr.java.spring.boot.Example.dto.HardverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JdbcHardverRepostiroy {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Hardver> hardverRowMapper = (rs, rowNum) -> new Hardver(
            rs.getLong("id"),
            rs.getString("naziv"),
            rs.getString("sifra"),
            rs.getBigDecimal("cijena"),
            TipHardvera.valueOf(rs.getString("tip")),
            rs.getInt("kolicina_na_stanju")
    );

    public List<Hardver> findAll(){
        return jdbcTemplate.query("SELECT * FROM hardver",hardverRowMapper);
    }

    public Optional<Hardver> findBySifra(String sifra){
        List<Hardver> result = jdbcTemplate.query(
                "SELECT * FROM hardver WHERE sifra = ?",
                hardverRowMapper,
                sifra
        );
        return result.stream().findFirst();
    }

    public Hardver save(Hardver hardver){
        jdbcTemplate.update("INSERT INTO hardver (naziv, sifra, cijena, tip, kolicina_na_stanju) VALUES (?, ?, ?, ?, ?)",
                hardver.getNaziv(),
                hardver.getSifra(),
                hardver.getCijena(),
                hardver.getTip().toString(),
                hardver.getKolicinaNaStanju()
        );
        return hardver;
    }
    public void deleteBySifra(String sifra) {
        jdbcTemplate.update("DELETE FROM hardver WHERE sifra = ?", sifra);
    }

    public void updateBySifra(String sifra, Hardver updated) {
        jdbcTemplate.update(
                "UPDATE hardver SET naziv = ?, cijena = ?, tip = ?, kolicina_na_stanju = ? WHERE sifra = ?",
                updated.getNaziv(),
                updated.getCijena(),
                updated.getTip().toString(),
                updated.getKolicinaNaStanju(),
                sifra
        );
    }

}
