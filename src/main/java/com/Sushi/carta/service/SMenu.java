
package com.Sushi.carta.service;

import com.Sushi.carta.entity.Menu;
import com.Sushi.carta.repository.RMenu;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SMenu {
    @Autowired
    RMenu rMenu;
    
    public List<Menu> list(){
        return rMenu.findAll();
    }
    
    public Optional<Menu> getOne(int id){
        return rMenu.findById(id);
    }
    
    public Optional<Menu> getByNombre(String nombre){
        return rMenu.findByNombre(nombre);
    }
    
    public void save(Menu menu){
        rMenu.save(menu);
    }
    
    public void delete(int id){
        rMenu.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rMenu.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rMenu.existsByNombre(nombre);
    }
    
}
