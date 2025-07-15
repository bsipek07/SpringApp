package hr.java.spring.boot.Example.dto;

import hr.java.spring.boot.Example.data.TipHardvera;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor

public class HardverDTO {

    @NotBlank(message = "Naziv ne smije biti prazan")
    private String naziv;

    @NotNull(message = "Cijena mora biti unesena")
    @Positive(message = "Cijena mora biti veća od 0")
    private BigDecimal cijena;

    @NotNull(message = "Tip hardvera mora biti odabran")
    private TipHardvera tip;

    public HardverDTO() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public TipHardvera getTip() {
        return tip;
    }

    public void setTip(TipHardvera tip) {
        this.tip = tip;
    }
}
