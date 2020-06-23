

package EventsCarsPlus;

import controlador.EventoCarrera;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Carreras;


import modelo.Coches;

import modelo.Controles;
import modelo.Garajes;
import modelo.Simulas;
import modelo.Torneos;



public class Inicio {


    public static void main(String[] args) throws IOException {
        
    
       
        
        ArrayList <Controles> controles=new ArrayList<Controles>();         
        ArrayList <Garajes> garajes=new ArrayList<Garajes>();          
        ArrayList <Torneos> torneos=new ArrayList<Torneos>();         
          
        ArrayList <Coches> coches=new ArrayList<Coches>(); 
        
        ArrayList <Carreras> carreras=new ArrayList<Carreras>(); 
         
        ArrayList <Simulas> simulas=new ArrayList<Simulas>(); 
        
        new vista.MenuOpciones().menuEntrada(controles,garajes,torneos,coches,carreras,simulas);

    }
    
}