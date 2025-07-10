package hr.java.spring.boot.Example.dto;

import hr.java.spring.boot.Example.data.TipHardvera;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class HardverDTO {
    private String naziv;
    private BigDecimal cijena;
    private TipHardvera tip;
}
