/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto_3R.Reto_3R.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Reto_3R.Reto_3R.repositorio.RepositorioReservaciones;
import Reto_3R.Reto_3R.modelo.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Reto_3R.Reto_3R.reportes.ContadorClientes;
import Reto_3R.Reto_3R.reportes.StatusReservas;
import static org.springframework.http.ResponseEntity.status;



/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosReservaciones {
       @Autowired
    private RepositorioReservaciones metodosCrud;
    
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public Reservaciones update(Reservaciones reservaciones){
        if(reservaciones.getIdReservation()!=null){
            Optional<Reservaciones> e= metodosCrud.getReservation(reservaciones.getIdReservation());
            if(!e.isEmpty()){

                if(reservaciones.getStartDate()!=null){
                    e.get().setStartDate(reservaciones.getStartDate());
                }
                if(reservaciones.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservaciones.getDevolutionDate());
                }
                if(reservaciones.getStatus()!=null){
                    e.get().setStatus(reservaciones.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservaciones;
            }
        }else{
            return reservaciones;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
  
    public StatusReservas getReporteStatusReservaciones (){
        List<Reservaciones>completed= metodosCrud.ReservacionesStatus("completed");
        List<Reservaciones>cancelled= metodosCrud.ReservacionesStatus("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
    
    public List<Reservaciones> getReportesTiempoReservaciones(String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionesTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
     public List<ContadorClientes> servicioTopClientes(){
            return metodosCrud.getTopClientes();
        } 
}
