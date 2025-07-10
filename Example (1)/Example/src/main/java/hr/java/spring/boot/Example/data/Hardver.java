package hr.java.spring.boot.Example.data;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hardver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String sifra;
    private BigDecimal cijena;

    @Enumerated(EnumType.STRING)
    private TipHardvera tip;

    private int kolicinaNaStanju;
}
