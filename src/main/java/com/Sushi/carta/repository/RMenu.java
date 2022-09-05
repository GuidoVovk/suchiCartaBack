
package com.Sushi.carta.repository;

import com.Sushi.carta.entity.Menu;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RMenu extends JpaRepository<Menu, Integer> {
    public Optional<Menu> findByNombre(String nombre);
    public boolean existsByNombre (String nombre);
}
