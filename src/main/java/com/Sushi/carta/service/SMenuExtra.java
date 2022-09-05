
package com.Sushi.carta.service;

import com.Sushi.carta.entity.MenuExtra;
import com.Sushi.carta.repository.RMenuExtra;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SMenuExtra {
    @Autowired
    RMenuExtra rMenuExtra;
    
    public List<MenuExtra> list(){
        return rMenuExtra.findAll();
    }
    
    public Optional<MenuExtra> getOne(int id){
        return rMenuExtra.findById(id);
    }
    
    public Optional<MenuExtra> findByNombreCombo(String nombreCombo){
        return rMenuExtra.findByNombreCombo(nombreCombo);
    }
    
    public void save(MenuExtra menuExtra){
        rMenuExtra.save(menuExtra);
    }
    
    public void delete(int id){
        rMenuExtra.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rMenuExtra.existsById(id);
    }
    
    public boolean existsByNombreCombo(String nombreCombo){
        return rMenuExtra.existsByNombreCombo(nombreCombo);
    }
    
}
