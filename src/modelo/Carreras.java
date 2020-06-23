
package modelo;


public class Carreras {
    
     private String     IdCarrera; 
     private String     CarreraNombre;
     private String     CarrerasTipo;
     private String     IdTorneo;
     

    public Carreras(String IdCarrera, String CarreraNombre, String CarrerasTipo) {
        this.IdCarrera = IdCarrera;
        this.CarreraNombre = CarreraNombre;
        this.CarrerasTipo = CarrerasTipo;
    }

    public Carreras(String IdCarrera, String CarreraNombre, String CarrerasTipo, String IdTorneo) {
        this.IdCarrera = IdCarrera;
        this.CarreraNombre = CarreraNombre;
        this.CarrerasTipo = CarrerasTipo;
        this.IdTorneo = IdTorneo;
    }

    public String getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(String IdCarrera) {
        this.IdCarrera = IdCarrera;
    }

    public String getCarreraNombre() {
        return CarreraNombre;
    }

    public void setCarreraNombre(String CarreraNombre) {
        this.CarreraNombre = CarreraNombre;
    }

    public String getCarrerasTipo() {
        return CarrerasTipo;
    }

    public void setCarrerasTipo(String CarrerasTipo) {
        this.CarrerasTipo = CarrerasTipo;
    }

    public String getIdTorneo() {
        return IdTorneo;
    }

    public void setIdTorneo(String IdTorneo) {
        this.IdTorneo = IdTorneo;
    }

    
    
     
     
    
}
