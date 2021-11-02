/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto_3R.Reto_3R.servicios;

import Reto_3R.Reto_3R.repositorio.RepositorioComputer;
import Reto_3R.Reto_3R.modelo.Computer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosComputer {
    @Autowired
    private RepositorioComputer metodosCrud;

    public List<Computer> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Computer> getComputer(int computerId) {
        return metodosCrud.getComputer(computerId);
    }

    public Computer save(Computer computer){
        if(computer.getId()==null){
            return metodosCrud.save(computer);
        }else{
            Optional<Computer> e=metodosCrud.getComputer(computer.getId());
            if(e.isEmpty()){
                return metodosCrud.save(computer);
            }else{
                return computer;
            }
        }
    }

    public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> e=metodosCrud.getComputer(computer.getId());
            if(!e.isEmpty()){
                if(computer.getName()!=null){
                    e.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    e.get().setBrand(computer.getBrand());
                }
                if(computer.getYear()!=null){
                    e.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    e.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    e.get().setCategory(computer.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteComputer(int computerId) {
        Boolean aBoolean = getComputer(computerId).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
