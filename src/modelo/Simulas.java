
package modelo;

public class Simulas {
     private String     IdTorneo;
     private String     IdCarrera;      
     private String     IdCoche;      
     private Integer    Puesto;      
     private String     Estado; 
     private Integer    Puntuacion; 
    public Simulas( String IdTorneo,String IdCarrera, String IdCoche, Integer Puntuacion, Integer Puesto, String Estado) {
        this.IdCarrera = IdCarrera;
        this.IdTorneo = IdTorneo;
        this.IdCoche = IdCoche;
        this.Puntuacion = Puntuacion;
        this.Puesto = Puesto;
        this.Estado = Estado;
    }

    public Simulas(String IdTorneo,String IdCarrera,  String IdCoche) {
        this.IdCarrera = IdCarrera;
        this.IdTorneo = IdTorneo;
        this.IdCoche = IdCoche;
    }

    public Simulas( String IdTorneo,String IdCarrera, String IdCoche, Integer Puesto) {
        this.IdCarrera = IdCarrera;
        this.IdTorneo = IdTorneo;
        this.IdCoche = IdCoche;
        this.Puntuacion = Puntuacion;
    }
    
    
    

    public String getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(String IdCarrera) {
        this.IdCarrera = IdCarrera;
    }

    public String getIdTorneo() {
        return IdTorneo;
    }

    public void setIdTorneo(String IdTorneo) {
        this.IdTorneo = IdTorneo;
    }

    public String getIdCoche() {
        return IdCoche;
    }

    public void setIdCoche(String IdCoche) {
        this.IdCoche = IdCoche;
    }

    public Integer getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(Integer Puntuacion) {
        this.Puntuacion = Puntuacion;
    }

    public Integer getPuesto() {
        return Puesto;
    }

    public void setPuesto(Integer Puesto) {
        this.Puesto = Puesto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
     
     
     
}
