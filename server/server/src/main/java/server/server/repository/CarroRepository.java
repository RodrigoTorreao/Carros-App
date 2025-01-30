package server.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.server.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
