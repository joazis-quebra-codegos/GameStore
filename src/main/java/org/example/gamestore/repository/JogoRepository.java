package org.example.gamestore.repository;

import org.example.gamestore.model.Desenvolvedora;
import org.example.gamestore.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
