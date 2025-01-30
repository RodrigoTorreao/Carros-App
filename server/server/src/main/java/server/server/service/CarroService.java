package server.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.server.entity.Carro;
import server.server.repository.CarroRepository;

@Service
public class CarroService {
    @Autowired
    CarroRepository carroRepository;

    public Carro save(Carro carro){
       return this.carroRepository.save(carro);
    }
    
    public Optional<Carro> findById(long Id){
       return this.carroRepository.findById(Id);

    }

    public List<Carro> findAll(){
        return this.carroRepository.findAll();
 
     }

     public Carro updateCar(Long id, Carro carro){
         Optional<Carro> oldCar = this.carroRepository.findById(id);
         if(!oldCar.isPresent()) {
            throw new IllegalArgumentException("Carro nao encontrado");
        }

        carro.setId(id);
        return this.carroRepository.save(carro);
 
     }

     public void deleteCar(Long id){
        Optional<Carro> oldCar = this.carroRepository.findById(id);
        if(!oldCar.isPresent()) {
           throw new IllegalArgumentException("Carro nao encontrado");
       }
        this.carroRepository.deleteById(id);

    }

}
