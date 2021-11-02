/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto_3R.Reto_3R.repositorio;

import Reto_3R.Reto_3R.modelo.Computer;
import Reto_3R.Reto_3R.Interface.InterfaceComputer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioComputer {
    
    @Autowired
    private InterfaceComputer crud;

    public List<Computer> getAll(){
        return (List<Computer>) crud.findAll();
    }

    public Optional<Computer> getComputer(int id){
        return crud.findById(id);
    }

    public Computer save(Computer computer){
        return crud.save(computer);
    }
    public void delete(Computer computer){
        crud.delete(computer);
    }

    
    }
    

