package org.example.gamestore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TBJOGO")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String titulo;

    String genero;

    Double preco;

    String classificacao;

    String descricao;

    @ManyToOne
    @JoinColumn(name = "idDesenvolvedora")
    Desenvolvedora desenvolvedora;
}
