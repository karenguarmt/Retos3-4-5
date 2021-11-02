/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto_3R.Reto_3R.repositorio;

import Reto_3R.Reto_3R.modelo.Reservaciones;
import Reto_3R.Reto_3R.modelo.Cliente;
import Reto_3R.Reto_3R.Interface.InterfaceReservaciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto_3R.Reto_3R.reportes.ContadorClientes;


/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioReservaciones{
     @Autowired
    private InterfaceReservaciones crud4;
    
    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
     public void delete(Reservaciones reservacion){
        crud4.delete(reservacion);
    }
     
     public List<Reservaciones> ReservacionesStatus (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<Reservaciones> ReservacionesTiempo (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorClientes> getTopClientes(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
         }
         return res;
     }
   
}
 