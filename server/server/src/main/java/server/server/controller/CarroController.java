package server.server.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.server.entity.Carro;
import server.server.service.CarroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/carro")
public class CarroController {
    
    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<Carro> save(@RequestBody Carro carro){
        try {
            return new ResponseEntity<>(this.carroService.save(carro), HttpStatus.OK);
            
        } catch (Exception e) {
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findById")
    public ResponseEntity<Optional<Carro>> findById(@RequestParam long id) {
        try {
            return new ResponseEntity<>(this.carroService.findById(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Carro>> findAll() {
        try {
            return new ResponseEntity<>(this.carroService.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<Carro> updateCar(@PathVariable Long id, @RequestBody Carro carro) {
        try {
            return new ResponseEntity<>(this.carroService.updateCar(id, carro), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> updateCar(@PathVariable Long id) {
        try {
            this.carroService.deleteCar(id);
            return new ResponseEntity<>("Carro deletado com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
