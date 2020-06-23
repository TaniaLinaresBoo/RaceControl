
package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Carreras;


import modelo.Coches;

import modelo.Controles;
import modelo.Garajes;
import modelo.Torneos;

import controlador.EventoCarrera;
import controlador.EventoCoche;
import controlador.EventoControl;
import controlador.EventoGaraje;
import controlador.EventoSimula;
import controlador.EventoTorneo;
import modelo.Simulas;

public class MenuOpciones {
    public void menuEntrada(ArrayList <Controles> controles,ArrayList<Garajes> garajes,
            ArrayList<Torneos>torneos,ArrayList<Coches>coches,ArrayList<Carreras> carreras,ArrayList<Simulas> simulas) throws IOException {
    
        
    int opcion = 0;
    
    Scanner teclado = new Scanner(System.in);
    
    EventoCarrera ev = new EventoCarrera();
    EventoTorneo et = new EventoTorneo();
    
    EventoCoche ec = new EventoCoche();
    EventoGaraje eg = new EventoGaraje();
    EventoControl eco = new EventoControl();
    EventoSimula es = new EventoSimula();
    
    
    
    
    
    do {
    
    System.out.println("************ Eventos Automovilísticos********** \n ");      
        
    System.out.println("Controles   11/Alta - 12/Baja - 13/Lista  - 14/Editar"); 
    System.out.println("Garajes     21/Alta - 22/Baja - 23/Lista  - 24/Editar"); 
    System.out.println("Carreras    31/Alta - 32/Baja - 33/Lista  - 34/Editar");
    System.out.println("Torneos     41/Alta - 42/Baja - 43/Lista  - 44/Editar");
    System.out.println("Coches      71/Alta - 72/Baja - 73/Lista  - 74/Editar"); 
    System.out.println("Simulacion  81/Simula Torneo"); 
    
    System.out.println( "\n");   
    
       
    System.out.println("pulse 0 para salir");
    String respuesta; 
    opcion = teclado.nextInt();
    
    switch (opcion){
        case 11: 
                       
                        
                eco.Controles(controles,carreras,torneos);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
            
            break;
        case 12:
            
             eco.ListarArrayControles(controles);
            
                teclado = new Scanner(System.in);
                System.out.println("selecciona linea a eliminar(valor posicion)  ");
                int respuesta1 = teclado.nextInt();
            
                eco.BorrarArrayControles(controles,respuesta1);
               
                
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
                
            
            break;

        case 13:
            
            eco.ListarArrayControles(controles);
            
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
           
            break;
        case 14:
            
             eco.Controles(controles,carreras,torneos);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
            
            
           
            
            break;

        case 15:  
           
            break;
       
         case 16:  
             
            
            
            
            break;    
           
            
       
       case 21: 
                       
           
            eg.Garajes(garajes);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
            
            break;
        case 22:
            
             eg.ListarArrayGarajes(garajes);
            
                teclado = new Scanner(System.in);
                System.out.println("selecciona linea a eliminar(valor posicion)  ");
                int respuesta2 = teclado.nextInt();
            
              eg.BorrarArrayGarajes(garajes,respuesta2);
               
                
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
                
            
            break;

        case 23:
            
           eg.ListarArrayGarajes(garajes);
            
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
           
            break;
        case 24:
             eg.GarajesEdit(garajes);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
           
            
            break;

        case 25:  
          
            
            break;
       
         case 26:  
             
            
           
            
            
            break;    
           
            
                
           case 31: 
                       
           
            ev.Carreras(carreras,torneos);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
            
            break;
        case 32:
            
              ev.CarrerasFicheroVolcarArray("carreras",carreras);
              ev.ListarArrayCarreras(carreras);
              
       
      
                teclado = new Scanner(System.in);
                System.out.println("selecciona linea a eliminar(valor posicion)  ");
                int respuesta3 = teclado.nextInt();
            
                ev.BorrarArrayCarreras(carreras,respuesta3);
               
                
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
                
            
            break;

        case 33:
            
            ev.CarrerasFicheroVolcarArray("carreras",carreras);
            ev.ListarArrayCarreras(carreras);
            
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
           
            break;
            
          case 34:
            
         
                ev.CarrerasEdit(carreras);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
            
    
            
           
            break;
    
            
           
            
            case 41: 
                       
           
            et.Torneos(torneos);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
            
            break;
        case 42:
            
             et.ListarArrayTorneos(torneos);
            
                teclado = new Scanner(System.in);
                System.out.println("selecciona linea a eliminar(valor linea)  ");
                int respuesta4 = teclado.nextInt();
            
                et.BorrarArrayTorneos(torneos,respuesta4);
               
                
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
                
            
            break;

        case 43:
            
            et.ListarArrayTorneos(torneos);
            
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
           
            break;
        case 44:
            
           et.TorneosEdit(torneos);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
            
         
             break;
        case 45:  
            
        
            
            break;
       
         case 46:  
             
            
             
             
            
            
            break;    
           
        case 51: 
                       
           
         
            
            break;
        case 52:
            
            
                
            
            break;

        case 53:
            
           
            break;
        case 54:
            
           
            
            break;

        case 55:  
        
            
            
            break;
       
         case 56:  
             
           
            
            
            break;    
           
            
                 
        case 61: 
                       
           
           
            
            
            break;
        case 62:
            
            
            
            break;

        case 63:
            
          
           
            break;
        case 64:
            
          
            
            break;

        case 65:  
          
            
            break;
       
         case 66:  
             
            
             
            
            
            break;    
           
            
                           
        case 71: 
                       
             
            ec.Coches(coches,carreras,torneos,garajes);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
          
            
            
            break;
        case 72:
            
             ec.ListarArrayCoches(coches);
            
                teclado = new Scanner(System.in);
                System.out.println("selecciona linea a eliminar(valor posicion)  ");
                int respuesta7 = teclado.nextInt();
            
                ec.BorrarArrayCoches(coches,respuesta7);
               
                
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
                
            
            break;

        case 73:
            
            ec.ListarArrayCoches(coches);
            
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
           
            break;
        case 74:
             ec.CochesEdit(coches) ;
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
           
            break;

        case 75:  
          
            
            
            break;
       
         case 76:  
             
            
           
            
            
            break;    
           
            
        case 81: 
               es.SimulasInicioTorneo(simulas, torneos, carreras, coches,garajes,controles);
                teclado = new Scanner(System.in);
                System.out.println("\npulsa intro para menu... ");
                respuesta = teclado.nextLine();
            
            
            break;         
       
            
            
        
        case 82:
           
            break;

        case 83:
            
             
           
            break;
           
            
        case 84:
            
           
           
            break;
            
            
            
         
       

        case 85:  
          
              
            
            
            break;         
           
           
       
         case 86:  
             
            
          
            
            
            break;    
           
            
            case 91: 
                 
               
           
         
            
            break;
        case 92:
            
        
            break;

        case 93:
            
           
           
            break;
        case 94:
            
          
            
            break;

        case 95:  
          
            
            
            break;
       
         case 96:  
             
            
             
             
            
            
            break;    
           
            
           case 101: 
                       
           
            
            break;
        case 102:
            
             
            
            break;

        case 103:
            
          
           
            break;
        case 104:
          
            break;

        case 105:  
         
            
            
            break;
       
         case 106:  
             
            
             
          
            
            break;    
           
            
                                
            
            
            
            
            
            
            
            
        case 0:{ System.out.println("ha pulsado salir");
        
        if (carreras.size()>0){
        ev.CarrerasFicheroEscribir("carreras",carreras);
        }
        
         if (torneos.size()>0){
        et.TorneosFicheroEscribir("torneos",torneos);
        }
        
        if (coches.size()>0){
        ec.CochesFicheroEscribir("coches",coches);
        }
        
         if (garajes.size()>0){
         eg.GarajesFicheroEscribir("garajes",garajes);
        }
         
         if (controles.size()>0){
         eco.ControlesFicheroEscribir("controles",controles);
        } 
         
         if (simulas.size()>0){
         es.SimulasFicheroEscribir("simulas", simulas);
        } 
         
         
         
         
         
         
        
        break;
        }
    
    }
    } while(opcion != 0);
    
    

    }
    
    
    
}
