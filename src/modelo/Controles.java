
package modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Controles implements Serializable {
    
     
     private String     IdControl; 
     private String     IdCarrera; 
     private Boolean    CarreraActiva; 

    public Controles() {
    }

     
     public Controles(String IdControl, String IdCarrera, Boolean CarreraActiva) {
        this.IdControl = IdControl;
        this.IdCarrera = IdCarrera;
        this.CarreraActiva = CarreraActiva;
    }

    public Controles(String IdControl, String IdCarrera) {
        this.IdControl = IdControl;
        this.IdCarrera = IdCarrera;
    }
     
     
     

    public String getIdControl() {
        return IdControl;
    }

    public void setIdControl(String IdControl) {
        this.IdControl = IdControl;
    }

    public String getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(String IdCarrera) {
        this.IdCarrera = IdCarrera;
    }

    public Boolean getCarreraActiva() {
        return CarreraActiva;
    }

    public void setCarreraActiva(Boolean CarreraActiva) {
        this.CarreraActiva = CarreraActiva;
    }

   
 
    
    
    
}
                       
    
    
    
    

