
package controlador;

import modelo.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class EventoSimula {
    
    
   

    public EventoSimula() {
    }

    
    
    
     public  void SimulasFicheroEscribir(String simulas,ArrayList <Simulas> simulasfichero) throws IOException {
        
        
        File file = new File(simulas+".txt");
           if (file.exists()) {
                file.createNewFile();
            }
  
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < simulasfichero.size(); i++) {             
                  bw.write(simulasfichero.get(i).getIdTorneo()+","+ simulasfichero.get(i).getIdCarrera()+","+ simulasfichero.get(i).getIdCoche()+","+ simulasfichero.get(i).getPuesto()+"\n");                
            }    
           
            bw.close();
            
    }
    
    
    public  void SimulasFicheroLeer(String simulas) throws IOException {
   
           String currLine;
           
                    File file = new File(simulas+".txt");
      if (file.exists()) {
     
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(simulas+".txt"));
            
         while ((currLine = bufferedReader.readLine()) != null)
            {
                System.out.println(currLine);
            }
    
           }else{
          System.out.println("No existe fichero ");
      } 
         
         
    } 
    
      public  ArrayList SimulasFicheroVolcarArray(String simulasFile,ArrayList <Simulas> simulas) throws IOException {
   
                String    IdTorneo1=null; 
                String    TorneoNombre1=null;
                String    TorneoActivo1=null; 
                String    TorneoTipo1="0";  
                String    SimulaPuesto=null;  
                String    TorneoActivo3=null; 
                
                  File file = new File(simulasFile+".txt");
           if (file.exists()==false) {
                file.createNewFile();
                 
            }else{
               if(file.length()==0){
                  
               }
           }
                
                
                
                
          
        
           String currLine;
           BufferedReader bufferedReader = new BufferedReader(new FileReader(simulasFile+".txt"));
           int contador = 0;
          
         while ((currLine = bufferedReader.readLine()) != null)
            {
             
                
                String[] values = currLine.split(",");
            //recorremos el arrar de string
            for (int i = 0; i<values.length; i++) {
                //se obtiene el primer caracter de el arreglo de strings
                if (i==0){
                    IdTorneo1 =values[i]; 
                }
                if (i==1){
                    TorneoNombre1 =values[i]; 
                }
              if (i==2){
                    TorneoTipo1 =values[i]; 
                }
                
               
                if (i==3){
                    SimulaPuesto =values[i];
                }
               /**
            
                if (i==4){
                    TorneoActivo2 =values[i]; 
                }
                
                   if (i==5){
                    TorneoActivo3 =values[i]; 
                }
                * 
                *
              **/
            }
              
           
            
               //Simulas e = new Simulas(IdTorneo1,TorneoNombre1,TorneoTipo1, Integer.parseInt(TorneoActivo1),Integer.parseInt(TorneoActivo2),TorneoActivo3 );
                //Simulas e = new Simulas(IdTorneo1,TorneoNombre1,TorneoTipo1,Integer.parseInt(SimulaPuesto) );
               
               // simulas.add(e);
                file.delete();
                
                
                
            }
    
         return simulas;
         
    }
     
     public void ListarArraySimulas(ArrayList <Simulas> simulas) throws IOException{
    
      if(simulas.size()==0){
         
           SimulasFicheroVolcarArray("simulas",simulas);  
    
      }          
         
     if(simulas!=null){

         
         
         
         
         
         
                                ArrayList<Simulas> simulasc = (ArrayList<Simulas>)simulas.clone();

                                System.out.println("\t\tLista de simulas\n");
                                    Integer longuitudmax=0;
                                      Integer longuitudmed=0;
                                      Integer longuitudmin=0;
                                       Integer longuitudvolanda=0;
                                
                                for(int i=0; i<simulas.size();i++){
                                     
                           

                                  
                                                                         
                           //       System.out.println("El tamaño de simulas son:" +  simulas.size());
                            //        System.out.println("El tamaño de simulasc son:" +  simulasc.size());
                                 for(int j=0; j<simulasc.size();j++){
                                     
                                   
                                      
                                      if(simulasc.get(j).getIdCarrera()==simulas.get(i).getIdCarrera()){
             //      System.out.println("para la carrera) + contador "+j+"    "+ simulas.get(i).getIdCarrera()+
               //            "para la carrerael valor de la longuitud "+ simulas.get(i).getEstado());
                                          
                          //                System.out.println("+++++++++++"+simulasc.get(j).getIdCarrera()+"\t"+
                            //                    "Coche :  "+ simulasc.get(j).getIdCoche()+"\t"+"Puesto :  "+ simulasc.get(j).getPuesto()+"Longuitud :  "+ simulasc.get(i).getEstado());
                                        
                                   
                            //        System.out.println("Fuera del if final Posicionmin ");         
                           //      System.out.println(" final Posicionmin "+longuitudmin); 
                           //      System.out.println("final Posicionmed "+longuitudmed); 
                           //      System.out.println("final Posicionmax "+longuitudmax); 
                           //        System.out.println("final Posicionvolanda "+longuitudvolanda);          
                                          
                                           
                                           
                                    if (Integer.parseInt(simulasc.get(i).getEstado())<=longuitudvolanda || longuitudvolanda==0 ){
                                        
                                           //  System.out.println("debtro del 1  Posicionmin ");     
                                        
                                               
                                               
                                             
                                               longuitudmin= Integer.parseInt(simulasc.get(i).getEstado());
                                               longuitudvolanda=longuitudmin;
                                              
                                               if(longuitudmin>longuitudmed){
                                                   
                                                   
                                                  if( longuitudmed>longuitudmax){
                                                  
                                                     longuitudmax= longuitudmed;
                                                     
                                                     longuitudvolanda=longuitudmax; 
                                                  }else{
                                                      
                                                    
                                                      longuitudvolanda=longuitudmed;
                                                        longuitudmed= longuitudmin;
                                                  };
                                                   
                                                   
                                                   
                                               }
                                               
                                               
                                              //  longuitudmed=0;
                                               // longuitudmax=0;
                                            //   simulas.get(i).setPuesto(3); 
                                           }
                                           
                                            if ((Integer.parseInt(simulasc.get(i).getEstado())> longuitudmin && Integer.parseInt(simulasc.get(i).getEstado())<longuitudmax)  ){
                                               
                                            
                           
                                               longuitudmed= Integer.parseInt(simulasc.get(i).getEstado());
                                               longuitudvolanda=longuitudmed;
                                              
                                               
                                                   
                                                   
                                                  if( longuitudmed>longuitudmax){
                                                  
                                                     longuitudmax= longuitudmed;
                                                     
                                                     longuitudvolanda=longuitudmax; 
                                                  }else{
                                                      
                                                      longuitudmed= longuitudmin;
                                                      longuitudvolanda=longuitudmed;
                                                  };
                                                   
                                                   
                                                   
                                            
                                           }
                                           
                                           
                                           
                                           if (Integer.parseInt(simulasc.get(i).getEstado())>=longuitudmax ){
                                               
                                
                                               
                                               longuitudmax=Integer.parseInt(simulasc.get(i).getEstado());
                                              // longuitudmed=0;
                                              // longuitudmin=0;
                                              
                                               //simulas.get(i).setPuesto(1); 
                                               
                                           }
                                           
                               
                                         
                                           
                                          
                                      }
                                      
                                
                                      
                                     
                                 }
                                 
                              
                                 
                                 
                                 
                                 
                        //          System.out.println("\tLinea: "+ Integer.toString(i)+"\t" +"Id del Torneo: "+
                        //         simulas.get(i).getIdTorneo()+"\t"+"\t"+"Carrera:  "+ 
                          //       simulas.get(i).getIdCarrera()+"\t"+"Coche :  "+ simulas.get(i).getIdCoche()+"\t"+"Puesto :  "+ simulas.get(i).getPuesto()+"\t"+"Longuitud :  "+ simulas.get(i).getEstado()+"\t"+"Puntuacion :  "+ simulas.get(i).getPuntuacion());
 
                                
                                
                                
                                
                                }
                                
                                
                                 int[] arr = null;
                                
                                 for(int j=0; j<simulasc.size();j++){
                                     
                                   
                                      
                                      if(simulasc.get(j).getIdCarrera()==simulas.get(j).getIdCarrera()){
                                         
                                                                                  
                                          int valor = Integer.parseInt(simulasc.get(j).getEstado());
                                          
                                          
                                           
                                           if (valor==longuitudmin ||valor==longuitudmed || valor==longuitudmax){
                                               
                                           }else{
                                               longuitudmed=valor;
                                           }
                                           
                                           
                                            
                                      }
                                
                                 }
                                 
                                 
                                 
                                 
                                        
                                 for(int i=0; i<simulasc.size();i++){
                                     
                                   
                                      
                                      if(simulasc.get(i).getIdCarrera()==simulas.get(i).getIdCarrera()){
                                         
                                                                                  
                                          int valor = Integer.parseInt(simulasc.get(i).getEstado());
                                          
                                          
                                           
                                           if (valor==longuitudmin ){
                                               
                                                 simulas.get(i).setPuesto(3);
                                               simulas.get(i).setPuntuacion(6);
                                                
                                               
                                               
                                               System.out.println("\tLinea: "+ Integer.toString(i)+"\t" +"Id del Torneo: "+
                                 simulas.get(i).getIdTorneo()+"\t"+"\t"+"Carrera:  "+ 
                                 simulas.get(i).getIdCarrera()+"\t"+"Coche :  "+ simulas.get(i).getIdCoche()+"\t"+"Puesto :  "+ simulas.get(i).getPuesto()+"\t"+"Longuitud :  "+ simulas.get(i).getEstado()+"\t"+"Puntuacion :  "+ simulas.get(i).getPuntuacion());
    
                                               
                                           }
                                           
                                              
                                           if (valor==longuitudmed ){
                                                simulas.get(i).setPuesto(2);
                                               simulas.get(i).setPuntuacion(8);
                                                
                                                  System.out.println("\tLinea: "+ Integer.toString(i)+"\t" +"Id del Torneo: "+
                                 simulas.get(i).getIdTorneo()+"\t"+"\t"+"Carrera:  "+ 
                                 simulas.get(i).getIdCarrera()+"\t"+"Coche :  "+ simulas.get(i).getIdCoche()+"\t"+"Puesto :  "+ simulas.get(i).getPuesto()+"\t"+"Longuitud :  "+ simulas.get(i).getEstado()+"\t"+"Puntuacion :  "+ simulas.get(i).getPuntuacion());
 
                                               
                                               
                                               
                                           }
                                           
                                              
                                           if (valor==longuitudmax){
                                               simulas.get(i).setPuesto(1);
                                               simulas.get(i).setPuntuacion(10);
                                                
                                                
                                               System.out.println("\tLinea: "+ Integer.toString(i)+"\t" +"Id del Torneo: "+
                                 simulas.get(i).getIdTorneo()+"\t"+"\t"+"Carrera:  "+ 
                                 simulas.get(i).getIdCarrera()+"\t"+"Coche :  "+ simulas.get(i).getIdCoche()+"\t"+"Puesto :  "+ simulas.get(i).getPuesto()+"\t"+"Longuitud :  "+ simulas.get(i).getEstado()+"\t"+"Puntuacion :  "+ simulas.get(i).getPuntuacion());
    
                                               
                                               
                                               
                                               
                                           }
                                           
                                           
                                           
                                            
                                      }
                                
                                 }
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                // System.out.println(" final Posicionmin "+longuitudmin); 
                                // System.out.println("final Posicionmed "+longuitudmed); 
                                // System.out.println("final Posicionmax "+longuitudmax); 
                                

                        

                    }
    
     if(simulas.size()==0){
     
          System.out.println("\t\tSin valores\n");
    
    
     }
     
     }
    
   
      public void BorrarArraySimulas(ArrayList <Simulas> simulas,Integer  posicioncontrolborrar) throws IOException{
    
              
           if(simulas.size()==0){
         
           SimulasFicheroVolcarArray("simulas",simulas);  
    
      }   
          
     if(simulas!=null){

                                

                                System.out.println("Lista de simulas");
                                
                                for(int i=0; i<simulas.size();i++){
                                    
                                    if (i== posicioncontrolborrar){
                                        
                                        simulas.remove(i);
                                        
                                        System.out.println("Borrado registro :"+Integer.toString(i));
                                        System.out.println("Nuevos valores  ");
                                               for(int i1=0; i1<simulas.size();i1++){
                                     
                                                  
                                                    System.out.println("Linea: "+ Integer.toString(i1)+"\t" +"Id del Torneo: "+
                                                    simulas.get(i1).getIdTorneo()+"\t"+"Nombre torneo :"+ simulas.get(i1).getIdTorneo()+"\t"+"Carrera:  "+ 
                                                    simulas.get(i1).getIdCarrera()+"\t"+"Coche :  "+ simulas.get(i1).getIdCoche());
                                                   
                                                   
                                                 }
                                        
                                        
                                        
                                    }
                                    
                                   
                                    
                                }

                        

                    }
    
     if(simulas.size()==0){
     
          System.out.println("Sin valores");
    
    
     }
     
     }
     
     
   public boolean SiExisteTorneo(ArrayList <Simulas> simulas,String idtorneo){
   
        boolean devexiste = false;
        for (int i1 = 0; i1 < simulas.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (simulas.get(i1).getIdTorneo().equals(idtorneo) )
                                         {
                                             devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
     
     
     
     
   
   public  void Simulas(ArrayList <Simulas> simulas,ArrayList <Torneos> torneos,ArrayList <Carreras> carreras,ArrayList <Coches> coches) throws IOException {
       
      String respuesta = "no";
      String  SimulaPuesto =null;
      
        if(simulas.size()==0){
         
           SimulasFicheroVolcarArray("simulas",simulas);  
    
      }   
      
      
      
      
   do { 
       
       Scanner teclado = new Scanner(System.in);
       
      SimulasFicheroVolcarArray("simulas",simulas);       
      ListarArraySimulas(simulas);
       
       
       new EventoTorneo().ListarArrayTorneos(torneos);
       
       
       
       
       System.out.println("Introduce el ID del torneo en Torneo: ");
       String CodigoTorneo = teclado.nextLine();      
      
       boolean retornoExiste = new EventoTorneo().SiExisteTorneo(torneos,CodigoTorneo);
       
       if(CodigoTorneo.equals("-1") || retornoExiste==false){
           new EventoTorneo().Torneos(torneos);
           
           break;
       }
      
  
      
       //boolean retornoExiste = SiExisteTorneo(simulas,CodigoTorneo);
       
       if(CodigoTorneo.equals("-1") ){
           break;
       }
       
       
             retornoExiste=false;
       String CodigoCarrera=null;
    do {     
       
       System.out.println("\nIntroduce el codigo de Carrera   para Alta en Simula  (-1 salir )  : ");
       
       CodigoCarrera = teclado.nextLine();
          if(CodigoCarrera.equals("-1") ){
           break;
       }
          
          
       retornoExiste=new EventoCarrera().SiExisteCarrera(carreras, CodigoCarrera);
      
       
        if(retornoExiste==false ){
            new EventoCarrera().Carreras(carreras, torneos);
            //System.out.println("\nNo existe Carrera puedes darla de Alta ahora   : ");
           
           
            
       }
       
      } while (retornoExiste==false);  
        
    
    retornoExiste=false;
     do { 
       
         
        new EventoCoche().ListarArrayCoches(coches); 
          
          
          
       teclado = new Scanner(System.in);
       System.out.println("\nIntroduce el codigo de coche : ");
       String Codigocoche = teclado.nextLine();      
       
         retornoExiste = new EventoCoche().SiExisteCoche(coches,Codigocoche);
       
       if(Codigocoche.equals("-1") || retornoExiste==true){
           break;
       }
     } while (retornoExiste==false);  
    
    
    
    
    
    
    
    
    
    
    
         boolean valido = false; 
       String TorneoTipo=null; 
       
        
       System.out.println("Introduce el Id del coche ");
       TorneoTipo = teclado.nextLine();
       
       
       if(TorneoTipo.equals("-1")){
           break;
       }
       
      System.out.println("Introduce puesto : ");
       Integer CodigoPuesto = teclado.nextInt(); 
    
        
        
       Simulas cl = new Simulas(CodigoTorneo,CodigoCarrera,TorneoTipo,CodigoPuesto);
       
       
       //System.out.println("Compruebo si existe control : "+ cl.getIdTorneo()+" con Nombre :"+cl.getTorneoNombre());
     
                   if(simulas!=null){




                                for(int i=0; i<simulas.size();i++){

                                   // System.out.println("recorro "+simulas.get(i).getIdTorneo()+"-"+ simulas.get(i).getTorneoNombre());

                                }

                        }else{
                            System.out.println("Sin valores");

                    }
   
       
                     boolean devexiste = false;
             
                    if(simulas!=null){

                        // System.out.println("Estoy dentro.....");
                         for (int i1 = 0; i1 < simulas.size(); i1++) {
                             
                             
                 
                                        if (simulas.get(i1).getIdTorneo().equals(cl.getIdTorneo()) && simulas.get(i1).getIdCarrera().equals(cl.getIdCarrera()) && simulas.get(i1).getIdCoche().equals(cl.getIdCoche()))
                                         {
                                            devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }   
                                        
                                          
                                        
                                        
                                        
                            }  
                     } 
       
       
       if (devexiste==false){
            
                        
                        teclado = new Scanner(System.in);



                    

                        System.out.println("- Menu de alta Simulas -");    

                       



                        simulas.add(cl);


                        System.out.println(" Se ha añadido correctamente ");
                        System.out.println(" El tamaño del control es "+simulas.size());


                 



                    }
           ListarArraySimulas(simulas);
           System.out.println("¿Desea dar de alta Otro  Torneo ?");
           respuesta = teclado.nextLine();
       } while (respuesta.equalsIgnoreCase("S"));
        
        
    }
   
    
    public  void SimulasInicioTorneo(ArrayList <Simulas> simulas,ArrayList <Torneos> torneos,ArrayList <Carreras> carreras,ArrayList <Coches> coches,ArrayList <Garajes> garajes,ArrayList <Controles> controles) throws IOException {
       
      String respuesta = "no";
      String  SimulaPuesto =null;
      
          
     if(torneos.size()==0){
         
            new EventoTorneo().TorneosFicheroVolcarArray("torneos",torneos);    
       
    
      }   
      
        if(simulas.size()==0){
         
           SimulasFicheroVolcarArray("simulas",simulas);  
    
      }   
     
     if(garajes.size()==0){
         
           new EventoGaraje().GarajesFicheroVolcarArray("garajes",garajes);  
    
      }   
      
      
      
      
   do { 
       
       Scanner teclado = new Scanner(System.in);
       
      
       
       
       
      
       if (torneos.size()==0){
          
            
             System.out.println("Debes cargar inicialmente Torneos: "); 
             break; 
           
       }
       
       new EventoTorneo().ListarArrayTorneos(torneos);
       System.out.println("\nIntroduce el ID del torneo en Torneo que quieres simular: ");
       
       
       String CodigoTorneo = teclado.nextLine();      
      
       boolean retornoExiste = new EventoTorneo().SiExisteTorneo(torneos,CodigoTorneo);
       
       if(CodigoTorneo.equals("-1") ){
         
           
           break;
       }
       
       if( retornoExiste==true){
           
          System.out.println("El Torneo existe, simulacion Torneo: " +CodigoTorneo +" "+new EventoTorneo().SiExisteTorneoNombre(torneos,CodigoTorneo)); 
          System.out.println("\nEl numero de carreras seran  10 y son de tipo:"+new EventoTorneo().SiExisteTorneoTipo(torneos,CodigoTorneo));           
          System.out.println("\nSe le asignara puntuación a los 3 primeros:"); 
          
          
          System.out.println("\n¿Quieres cargar carreras y coches (S/n)?: ");
       
           String CodigoCarrera = teclado.nextLine();     
          if(CodigoCarrera.contentEquals("s") || CodigoCarrera.contentEquals("S")){
       
              
              
              new EventoCoche().ListarArrayCoches(coches);
              
              System.out.println("\n¿El numero de coches disponibles son : "+coches.size());
              int valor = coches.size();
              
              
              
              new EventoCarrera().ListarArrayCarreras(carreras);
              
               System.out.println("\n¿El numero de carreras disponibles con las condiciones tipo de carrera y  que  pertenezca a ese torneo son : "+new EventoCarrera().SiExisteCarreraTipo(carreras,CodigoTorneo,new EventoTorneo().SiExisteTorneoTipor(torneos,CodigoTorneo)));
               
               new EventoCarrera().ListarArrayCarrerasT(carreras,CodigoTorneo,new EventoTorneo().SiExisteTorneoTipor(torneos,CodigoTorneo),valor,simulas,coches);
               
              
          }
          
          
       } 
       
       
      
  
      
       //boolean retornoExiste = SiExisteTorneo(simulas,CodigoTorneo);
       
      
           ListarArraySimulas(simulas);
           
           
           
           
           
           
           System.out.println("¿hacer otra simulación ?");
           respuesta = teclado.nextLine();
           simulas.clear();
       } while (respuesta.equalsIgnoreCase("S"));
        
        
    }
   
   
   
   
   
     
    public  void SimulasEdit(ArrayList <Simulas> simulas) throws IOException {
       
      String respuesta2 = "no";
      
      
   do { 
       
       Scanner teclado = new Scanner(System.in);
       
       SimulasFicheroVolcarArray("simulas",simulas);       
       ListarArraySimulas(simulas);
       
       
       System.out.println("\nIntroduce Torneo a editar (Posicion)  ((-1 salir) : ");
       Integer IdPosicion = teclado.nextInt();      
      
       if(IdPosicion.equals(-1)){
           break;
       }
       
       
                 
               boolean devexiste = false;
             
               for(int i=0; i<simulas.size();i++){
                                    
                    if (i==IdPosicion){
                                        
                             
                           System.out.println("Posicion "+ Integer.toString(i)+"\t Torneo :" +simulas.get(i).getIdTorneo()+"\t Carrera :"+ simulas.get(i).getIdCarrera()+"\tCoche :"+ simulas.get(i).getIdCoche());
                          
       
                           System.out.println("Introduce el ID del torneo : ");
                           teclado = new Scanner(System.in);
                           String CodigoTorneo = teclado.nextLine();      

                         

                           if(CodigoTorneo.equals("-1") ){
                               break;
                           }


                           System.out.println("Introduce el Nombre Torneo : ");
                           String CodigoCarrera = teclado.nextLine();

                            if(CodigoCarrera.equals("-1")){
                               break;
                           }


                           boolean valido = false; 
                           String TorneoTipo=null; 
                             do{

                           System.out.println("Introduce el tipo Torneo (S/E): ");
                           TorneoTipo = teclado.nextLine();


                           if(TorneoTipo.equals("-1")){
                               break;
                           }

                            if(TorneoTipo.toUpperCase().equals("S") || TorneoTipo.toUpperCase().equals("E")){
                               valido = true; 
                               TorneoTipo=TorneoTipo.toUpperCase();
                           }

                         }while(valido==false);  
                            
                           
                            
                           valido = false; 
                           Integer CodigoActivo=0; 


                                do{ 


                                    System.out.println("Esta no activo (0) / Activo (1) : ");
                                    CodigoActivo = teclado.nextInt();

                                    if(CodigoActivo==0 || CodigoActivo==1 ){
                                       valido = true; 
                                   }

                                    if(CodigoActivo==-1){
                                       break;
                                   }
                                 }while(valido==false);

                                if(CodigoActivo==-1){
                                 break;
                                  }


                           Simulas cl = new Simulas(CodigoTorneo,CodigoCarrera,TorneoTipo,CodigoActivo);

                                            teclado = new Scanner(System.in);

                                                simulas.remove(i);
                                                simulas.add(cl);


                             System.out.println(" Se ha editado correctamente ");

                                
                                        
                    }        
               } 
       
       
       
           ListarArraySimulas(simulas);
       
           System.out.println("¿Desea editar otro torneo (S/N) ?");
           
           teclado = new Scanner(System.in);
           respuesta2 = teclado.nextLine();
           
           
           
           
       } while (respuesta2.equalsIgnoreCase("S"));
        
        
    
      }   
      

    

     
     
     public  void TorneoUpdate(ArrayList <Simulas> simulas) throws IOException {
       
      String respuesta = "no";
      
     do {
         
     
  
       Scanner teclado = new Scanner(System.in);
       
    
       System.out.println("Introduce el ID del torneo : ");
       String CodigoTorneo = teclado.nextLine();      
      
       boolean retornoExiste = SiExisteTorneo(simulas,CodigoTorneo);
       
       if(CodigoTorneo.equals("-1") || retornoExiste==true){
           break;
       }
       
       
       System.out.println("Introduce el Nombre Torneo : ");
       String CodigoCarrera = teclado.nextLine();
       
        if(CodigoCarrera.equals("-1")){
           break;
       }
       
           boolean valido = false; 
               String TorneoTipo=null; 
                 do{

               System.out.println("Introduce el tipo Torneo (S/E): ");
               TorneoTipo = teclado.nextLine();


               if(TorneoTipo.equals("-1")){
                   break;
               }

                if(TorneoTipo.toUpperCase().equals("S") || TorneoTipo.toUpperCase().equals("E")){
                   valido = true; 
                   TorneoTipo=TorneoTipo.toUpperCase();
               }

            }while(valido==false);  
        
        
        
        
        
        valido = false; 
       Integer CodigoActivo=0; 
        
        
        do{ 
       
       
        System.out.println("Esta no activo (0) / Activo (1) : ");
        CodigoActivo = teclado.nextInt();
       
        if(CodigoActivo==0 || CodigoActivo==1 ){
           valido = true; 
       }
       
        if(CodigoActivo==-1){
           break;
       }
       }while(valido==false);
     
         if(CodigoActivo==-1){
           break;
       }
        
        
       Simulas cl = new Simulas(CodigoTorneo,CodigoCarrera,TorneoTipo,CodigoActivo);
       
      
      
                     boolean devexiste = false;
             
                        
                        teclado = new Scanner(System.in);



                    

                        System.out.println("- Menu de editar Simulas -");    

                      
                        simulas.add(cl);
                      

                        System.out.println(" Se ha editado correctamente ");
                 
                         break;
                  
     } while (true) ;
        
        
    }
   
    
  
    
}
