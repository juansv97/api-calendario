package com.apicalendario.servicio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicalendario.cliente.FestivoCliente;
import com.apicalendario.modelo.Dia;
import com.apicalendario.modelo.RespuestaFestivo;
import com.apicalendario.repositorio.DiaRepositorio;

@Service
public class CalendarioServicio {

    @Autowired
    private DiaRepositorio diaRepositorio;

    @Autowired
    private FestivoCliente festivoCliente;

    public boolean generarCalendario(int anio) {

        // Evitar generar el calendario si ya existe
        if(!diaRepositorio.findByFechaStartingWith(String.valueOf(anio)).isEmpty()){
            return false;
        }

        LocalDate fecha = LocalDate.of(anio, 1, 1);

        while(fecha.getYear() == anio){

            int mes = fecha.getMonthValue();
            int dia = fecha.getDayOfMonth();

            RespuestaFestivo respuesta =
                    festivoCliente.verificar(anio, mes, dia);

            Dia nuevo = new Dia();
            nuevo.setFecha(fecha.toString());

            if(respuesta.isEsFestivo()){

                nuevo.setTipo("FESTIVO");
                nuevo.setDescripcion(respuesta.getNombre());

            }else if(
                    fecha.getDayOfWeek().toString().equals("SATURDAY") ||
                    fecha.getDayOfWeek().toString().equals("SUNDAY")
            ){

                nuevo.setTipo("FIN_DE_SEMANA");
                nuevo.setDescripcion("Fin de semana");

            }else{

                nuevo.setTipo("LABORAL");
                nuevo.setDescripcion("Día laboral");

            }

            diaRepositorio.save(nuevo);

            fecha = fecha.plusDays(1);
        }

        return true;
    }

    // Obtener calendario de un año
    public List<Dia> obtenerCalendario(String anio){
        return diaRepositorio.findByFechaStartingWith(anio);
    }

    // Obtener un día específico
    public Dia obtenerDia(String fecha){
        return diaRepositorio.findByFecha(fecha);
    }

}