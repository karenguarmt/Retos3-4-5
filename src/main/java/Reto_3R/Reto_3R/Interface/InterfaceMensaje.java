/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto_3R.Reto_3R.Interface;

import Reto_3R.Reto_3R.modelo.Mensaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface InterfaceMensaje extends CrudRepository<Mensaje,Integer>{
    
}
