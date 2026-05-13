package org.example.gamestore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TBDESENVOLVEDORA")
public class Desenvolvedora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDesenvolvedora")
    private Long id;

    private String nome;

    private String pais;

    @NotNull
    private Integer anoFundacao;
}
