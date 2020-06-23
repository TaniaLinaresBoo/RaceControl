
package modelo;


public class Coches {
     private String     IdCoche; 
     private String     CocheMarca;
     private String     CocheModelo; 
     private Integer    CocheVelocidad; 
     private String     IdGaraje; 
     private String     IdCarrera; 
     
     
    public Coches(String IdCoche, String CocheMarca, String CocheModelo, Integer CocheVelocidad) {
        this.IdCoche = IdCoche;
        this.CocheMarca = CocheMarca;
        this.CocheModelo = CocheModelo;
        this.CocheVelocidad = CocheVelocidad;
    }

    public Coches(String IdCoche, String CocheMarca, String CocheModelo, Integer CocheVelocidad, String IdGaraje, String IdCarrera) {
        this.IdCoche = IdCoche;
        this.CocheMarca = CocheMarca;
        this.CocheModelo = CocheModelo;
        this.CocheVelocidad = CocheVelocidad;
        this.IdGaraje = IdGaraje;
        this.IdCarrera = IdCarrera;
    }

    public String getIdCoche() {
        return IdCoche;
    }

    public void setIdCoche(String IdCoche) {
        this.IdCoche = IdCoche;
    }

    public String getCocheMarca() {
        return CocheMarca;
    }

    public void setCocheMarca(String CocheMarca) {
        this.CocheMarca = CocheMarca;
    }

    public String getCocheModelo() {
        return CocheModelo;
    }

    public void setCocheModelo(String CocheModelo) {
        this.CocheModelo = CocheModelo;
    }

    public Integer getCocheVelocidad() {
        return CocheVelocidad;
    }

    public void setCocheVelocidad(Integer CocheVelocidad) {
        this.CocheVelocidad = CocheVelocidad;
    }

    public String getIdGaraje() {
        return IdGaraje;
    }

    public void setIdGaraje(String IdGaraje) {
        this.IdGaraje = IdGaraje;
    }

    public String getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(String IdCarrera) {
        this.IdCarrera = IdCarrera;
    }
     
     
     
    
      
     
}
