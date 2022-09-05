
package com.Sushi.carta.repository;

import com.Sushi.carta.entity.MenuExtra;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RMenuExtra extends JpaRepository<MenuExtra, Integer> {
    public Optional<MenuExtra> findByNombreCombo(String nombreCombo);
    public boolean existsByNombreCombo(String nombreCombo);
}
