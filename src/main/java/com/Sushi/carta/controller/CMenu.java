
package com.Sushi.carta.controller;

import com.Sushi.carta.dto.DtoMenu;
import com.Sushi.carta.entity.Menu;
import com.Sushi.carta.service.SMenu;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("menu")
@CrossOrigin(origins = "http://localhost:4200")
public class CMenu {
    @Autowired
    SMenu sMenu;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Menu>> list(){
        List<Menu> list = sMenu.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity <?> create (@RequestBody DtoMenu dtoMenu){
        if(StringUtils.isBlank(dtoMenu.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoMenu.getDescripcion()))
            return new ResponseEntity(new Mensaje("la descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoMenu.getPrecio()))
            return new ResponseEntity(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
        Menu menu = new Menu(dtoMenu.getNombre(), dtoMenu.getDescripcion(), dtoMenu.getPrecio(), dtoMenu.getImg());
        sMenu.save(menu);
            
        return new ResponseEntity (new Mensaje("Producto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody DtoMenu dtoMenu){
        if (!sMenu.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(sMenu.existsByNombre(dtoMenu.getNombre()) && sMenu.getByNombre(dtoMenu.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje ("El producto ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoMenu.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Menu menu = sMenu.getOne(id).get();
        menu.setNombre(dtoMenu.getNombre());
        menu.setDescripcion(dtoMenu.getDescripcion());
        menu.setPrecio(dtoMenu.getPrecio());
        menu.setImg(dtoMenu.getImg());
        
        sMenu.save(menu);
        return new ResponseEntity(new Mensaje("Producto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id){
         if (!sMenu.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
         
         sMenu.delete(id);
         return new ResponseEntity (new Mensaje ("Producto eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Menu> getById(@PathVariable("id") int id){
        if (!sMenu.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        Menu menu = sMenu.getOne(id).get();
        return new ResponseEntity(menu, HttpStatus.OK);
    }
    
    
    
}
