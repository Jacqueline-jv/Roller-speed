package com.rollerspeed.rollerspeed.Model;



import jakarta.persistence.*;

@Entity
@Table(name = "horarios")
public class horario {

    public horario() {
    }

     public horario( String dia, String horaInicio, String horaFin) {
       
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String dia;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String horaFin;             
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }



    

}
