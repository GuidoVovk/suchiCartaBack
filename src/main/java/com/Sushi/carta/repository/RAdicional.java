
package com.Sushi.carta.repository;

import com.Sushi.carta.entity.Adicional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAdicional extends JpaRepository<Adicional, Integer> {
    public Optional<Adicional> findByNombreA(String nombreA );
    public boolean existsByNombreA (String nombreA);
}
