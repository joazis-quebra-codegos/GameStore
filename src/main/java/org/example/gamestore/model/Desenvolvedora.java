package org.example.gamestore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    private Integer anoFundacao;

    @OneToMany(mappedBy = "desenvolvedora")
    private List<Jogo> jogos = new ArrayList<>();

}
