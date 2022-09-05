
package com.Sushi.carta.controller;

import com.Sushi.carta.dto.DtoAdicional;
import com.Sushi.carta.entity.Adicional;
import com.Sushi.carta.service.SAdicional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adicional")
@CrossOrigin(origins = "http://localhost:4200")
public class CAdicional {
    @Autowired
    SAdicional sAdicional;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Adicional>> list(){
        List<Adicional> list = sAdicional.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity <?> create (@RequestBody DtoAdicional dtoAdicional){
        Adicional adicional = new Adicional(dtoAdicional.getNombreA(), dtoAdicional.getPrecioA(), dtoAdicional.getPrecioB(), dtoAdicional.getPrecioEnvio(), dtoAdicional.getPrecioEnvioDos());
        sAdicional.save(adicional);
            
        return new ResponseEntity (new Mensaje("Agregado con éxito"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody DtoAdicional dtoAdicional){
        if (!sAdicional.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        Adicional adicional = sAdicional.getOne(id).get();
        adicional.setNombreA(dtoAdicional.getNombreA());
        adicional.setPrecioA(dtoAdicional.getPrecioA());
        adicional.setPrecioB(dtoAdicional.getPrecioB());
        adicional.setPrecioEnvio(dtoAdicional.getPrecioEnvio());
        adicional.setPrecioEnvioDos(dtoAdicional.getPrecioEnvioDos());
          
        sAdicional.save(adicional);
        return new ResponseEntity(new Mensaje("Actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id){
         if (!sAdicional.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
         
         sAdicional.delete(id);
         return new ResponseEntity (new Mensaje ("Eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Adicional> getById(@PathVariable("id") int id){
        if (!sAdicional.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        Adicional adicional = sAdicional.getOne(id).get();
        return new ResponseEntity(adicional, HttpStatus.OK);
    }
      
}
