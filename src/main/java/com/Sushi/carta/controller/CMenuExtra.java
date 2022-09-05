
package com.Sushi.carta.controller;

import com.Sushi.carta.dto.DtoMenuExtra;
import com.Sushi.carta.entity.MenuExtra;
import com.Sushi.carta.service.SMenuExtra;
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
@RequestMapping("menuExtra")
@CrossOrigin(origins = "http://localhost:4200")
public class CMenuExtra {
    @Autowired
    SMenuExtra sMenuExtra;
    
    @GetMapping("/lista")
    public ResponseEntity <List<MenuExtra>> list(){
        List<MenuExtra> list = sMenuExtra.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity <?> create (@RequestBody DtoMenuExtra dtoMenuExtra){
        if(StringUtils.isBlank(dtoMenuExtra.getNombreCombo()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoMenuExtra.getNombreRolls()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        MenuExtra menuExtra = new MenuExtra(dtoMenuExtra.getNombreCombo(), dtoMenuExtra.getCantidad(), dtoMenuExtra.getNombreRolls(), dtoMenuExtra.getPrecioCombo());
        sMenuExtra.save(menuExtra);
        
        return new ResponseEntity (new Mensaje("Agregado con éxito"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity <?> update (@PathVariable("id") int id, @RequestBody DtoMenuExtra dtoMenuExtra){
        if (!sMenuExtra.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoMenuExtra.getNombreCombo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        MenuExtra menuExtra = sMenuExtra.getOne(id).get();
        menuExtra.setNombreCombo(dtoMenuExtra.getNombreCombo());
        menuExtra.setCantidad(dtoMenuExtra.getCantidad());
        menuExtra.setNombreRolls(dtoMenuExtra.getNombreRolls());
        menuExtra.setPrecioCombo(dtoMenuExtra.getPrecioCombo());
        
        sMenuExtra.save(menuExtra);
        return new ResponseEntity(new Mensaje("Actualizado con éxito"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity <?> delete(@PathVariable("id") int id){
        if (!sMenuExtra.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        sMenuExtra.delete(id);
        return new ResponseEntity (new Mensaje ("Eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<MenuExtra> getById(@PathVariable("id") int id){
        if (!sMenuExtra.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        
        MenuExtra menuExtra = sMenuExtra.getOne(id).get();
        return new ResponseEntity(menuExtra, HttpStatus.OK);
    }
}
