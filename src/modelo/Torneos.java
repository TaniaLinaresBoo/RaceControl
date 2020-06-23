
package modelo;


public class Torneos {
    
     private String     IdTorneo; 
     private String     TorneoNombre;
     private String     TorneoTipoCarrera;
     private Integer    TorneoActivo; 

    public Torneos(String IdTorneo, String TorneoNombre, Integer TorneoActivo) {
        this.IdTorneo = IdTorneo;
        this.TorneoNombre = TorneoNombre;
        this.TorneoActivo = TorneoActivo;
    }

    public Torneos(String IdTorneo, String TorneoNombre, String TorneoTipoCarrera, Integer TorneoActivo) {
        this.IdTorneo = IdTorneo;
        this.TorneoNombre = TorneoNombre;
        this.TorneoTipoCarrera = TorneoTipoCarrera;
        this.TorneoActivo = TorneoActivo;
    }

    public String getIdTorneo() {
        return IdTorneo;
    }

    public void setIdTorneo(String IdTorneo) {
        this.IdTorneo = IdTorneo;
    }

    public String getTorneoNombre() {
        return TorneoNombre;
    }

    public void setTorneoNombre(String TorneoNombre) {
        this.TorneoNombre = TorneoNombre;
    }

    public String getTorneoTipoCarrera() {
        return TorneoTipoCarrera;
    }

    public void setTorneoTipoCarrera(String TorneoTipoCarrera) {
        this.TorneoTipoCarrera = TorneoTipoCarrera;
    }

    public Integer getTorneoActivo() {
        return TorneoActivo;
    }

    public void setTorneoActivo(Integer TorneoActivo) {
        this.TorneoActivo = TorneoActivo;
    }

     
}
