
package modelo;


public class Garajes {
    
    private String IdGaraje;
    private String GarajeNombre;

    public Garajes(String IdGaraje, String GarajeNombre) {
        this.IdGaraje = IdGaraje;
        this.GarajeNombre = GarajeNombre;
    }
    
    public String getIdGaraje() {
        return IdGaraje;
    }

    public void setIdGaraje(String IdGaraje) {
        this.IdGaraje = IdGaraje;
    }

    public String getGarajeNombre() {
        return GarajeNombre;
    }

    public void setGarajeNombre(String GarajeNombre) {
        this.GarajeNombre = GarajeNombre;
    }
   
    
}
