
package com.Sushi.carta.service;

import com.Sushi.carta.entity.Adicional;
import com.Sushi.carta.repository.RAdicional;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAdicional {
    @Autowired
    RAdicional rAdicional;
    
    public List<Adicional> list(){
        return rAdicional.findAll();
    }
    
    public Optional<Adicional> getOne(int id){
        return rAdicional.findById(id);
    }
    
    public Optional<Adicional> getByNombreA(String nombreA){
        return rAdicional.findByNombreA(nombreA);
    }
    
    public void save(Adicional adicional){
        rAdicional.save(adicional);
    }
    
    public void delete(int id){
        rAdicional.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAdicional.existsById(id);
    }
    
    public boolean existsByNombreA(String nombreA){
        return rAdicional.existsByNombreA(nombreA);
    }
}
