
package controlador;

import modelo.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class EventoCarrera {
    
    
   

    public EventoCarrera() {
    }

   
   
    //escribo en el fichero
    
    public  void CarrerasFicheroEscribir(String carreras,ArrayList <Carreras> carrerasfichero) throws IOException {
        
        
        File file = new File(carreras+".txt");
           if (file.exists()) {
                file.createNewFile();
            }
  
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < carrerasfichero.size(); i++) {             
                  bw.write(carrerasfichero.get(i).getIdCarrera()+","+ carrerasfichero.get(i).getCarreraNombre()+","+carrerasfichero.get(i).getCarrerasTipo()+","+carrerasfichero.get(i).getIdTorneo()+ "\n");                
            }    
           
            bw.close();
            
    }
    
    //leo fichero
    
     public  void CarrerasFicheroLeer(String carreras) throws IOException {
   
           String currLine;
                    File file = new File(carreras+".txt");
      if (file.exists()) {
               
       
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(carreras+".txt"));
            
         while ((currLine = bufferedReader.readLine()) != null)
            {
                System.out.println(currLine);
            }
         
         
           }else{
          System.out.println("No existe fichero ");
      } 
         
         
    
    }
    
    public  ArrayList CarrerasFicheroVolcarArray(String carrerasFile,ArrayList <Carreras> carreras) throws IOException {
   
                   
            String     IdCarrera1=null; 
            String     CarreraNombre1=null;
            String     CarrerasTipo1=null;
            String     CarrerasTorneo1=null;
           
          

           String currLine;
          
           File file = new File(carrerasFile+".txt");
           if (file.exists()==false) {
                file.createNewFile();
                 
            }else{
               if(file.length()==0){
                  
               }
           }
           
           
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(carrerasFile+".txt"));
           int contador = 0;
           
         while ((currLine = bufferedReader.readLine()) != null)
            {
               // System.out.println(currLine);
                
                String[] values = currLine.split(",");
            //recorremos el arrar de string
            for (int i = 0; i<values.length; i++) {
                //se obtiene el primer caracter de el arreglo de strings
                if (i==0){
                    IdCarrera1=values[i]; 
                }
                if (i==1){
                    CarreraNombre1 =values[i]; 
                }
             
                 if (i==2){
                    CarrerasTipo1 =values[i]; 
                }
                
                
                  if (i==3){
                    CarrerasTorneo1 =values[i]; 
                }
                 
                 
                
            }
                Carreras e = new Carreras(IdCarrera1,CarreraNombre1,CarrerasTipo1,CarrerasTorneo1);
                carreras.add(e);
                file.delete();
            }
    
         
         
         return carreras;
         
    }
     
    //listo array
     public void ListarArrayCarreras(ArrayList <Carreras> carreras) throws IOException{
    
      if(carreras.size()==0){
          CarrerasFicheroVolcarArray("carreras",carreras);
         
    
      }   
         
         
     if(carreras!=null){



                                System.out.println("\t\tLista de carreras disponibles\n");
                                
                 for(int i=0; i<carreras.size();i++){
     
                    System.out.println("\t\tLinea: "+ Integer.toString(i)+"\t" +"IdCarrera: "+ carreras.get(i).getIdCarrera()+"\t"+"Nombre carrera: "+ carreras.get(i).getCarreraNombre()+"\t"+"Tipo carrera: "+ carreras.get(i).getCarrerasTipo()+"\t"+"Torneo :"+ carreras.get(i).getIdTorneo());

                  }

                                
                                
                                
                        

                    }
    
     if(carreras.size()==0){
     
          System.out.println("\t\tSin valores");
    
    
     }
     
     }
    
   
     //borrar
      public void BorrarArrayCarreras(ArrayList <Carreras> carreras,Integer  posicioncontrolborrar) throws IOException{
    
      
          if(carreras.size()==0){
          CarrerasFicheroVolcarArray("carreras",carreras);
         
    
      }   
          
     if(carreras!=null){

                       

                                System.out.println("\t\tLista de carreras");
                                
                                for(int i=0; i<carreras.size();i++){
                                    
                                    if (i== posicioncontrolborrar){
                                        
                                        carreras.remove(i);
                                        
                                        System.out.println("\t\tBorrado registro :"+Integer.toString(i));
                                        System.out.println("\t\tNuevos valores  ");
                                               for(int i1=0; i1<carreras.size();i1++){
                                     
                                            System.out.println("\t\tPosicion "+ Integer.toString(i1) +"  Valor IdCarrera :"+ carreras.get(i1).getIdCarrera()+" Nombre carrera :"
                                                    + carreras.get(i1).getCarreraNombre()+ " Tipo carrera :"+carreras.get(i1).getCarrerasTipo()+" Torneo :"+ carreras.get(i1).getIdTorneo());


                                                 }
                                        
                                        
                                        
                                    }
                                    
                                   
                                    
                                }

                        

                    }
    
     if(carreras.size()==0){
     
          System.out.println("Sin valores");
    
    
     }
     
     }
     
     //editar
    public  void CarrerasEdit(ArrayList <Carreras> carreras) throws IOException {
       
      String respuesta2 = "no";
      
      if(carreras.size()==0){
          CarrerasFicheroVolcarArray("carreras",carreras);
         
    
      }   
      
      
      
      
      
      
      
      do { 
       
       Scanner teclado = new Scanner(System.in);
       
       
      
       
       ListarArrayCarreras(carreras);
       
       System.out.println("\nIntroduce Carrera a editar (Posicion)  ((-1 salir) : ");
       Integer IdPosicion = teclado.nextInt();      
      
       if(IdPosicion.equals(-1)){
           break;
       }
       
       
                 
                 boolean devexiste = false;
             
                  for(int i=0; i<carreras.size();i++){
                                    
                        if (i==IdPosicion){
                                        
                             
                            System.out.println("\t\tPosicion "+ Integer.toString(i)+"\t" +carreras.get(i).getIdCarrera()+"\t"+ carreras.get(i).getCarreraNombre()+"-"+ carreras.get(i).getIdTorneo());
           
                            
                            
                            
                              System.out.println("\nIntroduce el codigo de la Carrera para Editar        ((-1 salir) : ");
                              
                              
                              
                               teclado = new Scanner(System.in);
                               String IdCarrera = teclado.nextLine();      

                               if(IdCarrera.equals("-1")){
                                   break;
                               }



                               System.out.println("Introduce el nombre Carrera : ");
                               String CarreraNombre = teclado.nextLine();

                               if(CarreraNombre.equals("-1")){
                                  break;
                               }


                               System.out.println("Introduce el tipo Carrera : ");
                               String CarrerasTipo = teclado.nextLine();

                               if(CarrerasTipo.equals("-1")){
                                  break; 
                               }

                               System.out.println("Introduce el torneo : ");
                               String IdTorneo = teclado.nextLine();

                               if(IdTorneo.equals("-1")){
                                   break;
                               }


                               Carreras cl = new Carreras(IdCarrera,CarreraNombre,CarrerasTipo,IdTorneo) ;



                                          


                                                teclado = new Scanner(System.in);





                                                System.out.println("- Menu de editar Carreras -");    

                                                carreras.remove(i);
                                                carreras.add(cl);


                                                System.out.println(" Se ha editado correctamente ");

      
                            
                            
                                        
                           }
                  }
       
       
       
          ListarArrayCarreras(carreras);
       
           System.out.println("¿Desea editar Otra Carrera ?");
           
           teclado = new Scanner(System.in);
           respuesta2 = teclado.nextLine();
           
           
           
           
       } while (respuesta2.equalsIgnoreCase("S"));
        
        
    
      

}   
    
//__________________________Fin carrerasedit______________________________________
     
     
     public  void CarreraUpdate(ArrayList <Carreras> carreras,ArrayList <Torneos> torneos) throws IOException {
       
      String respuesta = "no";
      
     do {
         
     
  
       Scanner teclado = new Scanner(System.in);
       
       System.out.println("\nIntroduce el codigo de la Carrera((-1 salir) : ");
       String IdCarrera = teclado.nextLine();      
      
       if(IdCarrera.equals("-1")){
           break;
       }
       
       
      
       System.out.println("Introduce el nombre Carrera : ");
       String CarreraNombre = teclado.nextLine();
      
       if(CarreraNombre.equals("-1")){
          break;
       }
       
       new EventoTorneo().ListarArrayTorneos(torneos);
       
       
        System.out.println("Introduce el torneo : ");
       String IdTorneo = teclado.nextLine();
       
       if(IdTorneo.equals("-1")){
           break;
       }
       System.out.println("Introduce el tipo Carrera : ");
       String CarrerasTipo = teclado.nextLine();
       
       if(CarrerasTipo.equals("-1")){
          break; 
       }
       
      
       
       
       Carreras cl = new Carreras(IdCarrera,CarreraNombre,CarrerasTipo,IdTorneo) ;
      
       
       
                     boolean devexiste = false;
             
                        
                        teclado = new Scanner(System.in);



                    

                        System.out.println("- Menu de editar Carreras -");    

                      
                        carreras.add(cl);
                      

                        System.out.println(" Se ha editado correctamente ");
                 
                         break;
                  
     } while (true) ;
        
        
    }
   
    
   public boolean SiExisteCarrera(ArrayList <Carreras> carreras,String idcarrera){
   
        boolean devexiste = false;
        for (int i1 = 0; i1 < carreras.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (carreras.get(i1).getIdCarrera().equals(idcarrera) )
                                         {
                                             devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
   
   public Integer SiExisteCarreraTipo(ArrayList <Carreras> carreras,String idTorneo,String idcarrera){
   
        Integer devexiste = 0;
        for (int i1 = 0; i1 < carreras.size(); i1++) {
                             
                             
                 
                                         
                                        
                       if (carreras.get(i1).getIdTorneo().equals(idTorneo) && carreras.get(i1).getCarrerasTipo().equals(idcarrera) )
                                    {
                                            
                                   
                            
                                             devexiste = devexiste+1;  
                                            // System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                          }  
       
       
       return devexiste;
       
   } 
   
   public Integer SiExisteCarreraTipoCoches(ArrayList <Carreras> carreras,String idTorneo,String idcarrera,ArrayList <Coches> coches){
   
        Integer devexiste = 0;
        for (int i1 = 0; i1 < carreras.size(); i1++) {
                             
                             
                 
                                         
                                        
                       if (carreras.get(i1).getIdTorneo().equals(idTorneo) && carreras.get(i1).getCarrerasTipo().equals(idcarrera) )
                                    {
                                            
                                            
                                        
                            
                                             devexiste = devexiste+1;  
                                            // System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                          }  
       
       
       return devexiste;
       
   } 
   
   
   
     
  
   public void ListarArrayCarrerasT(ArrayList <Carreras> carreras,String idTorneo,String idcarrera,Integer numerocoches,ArrayList <Simulas> simulas,ArrayList <Coches> coches) throws IOException{
    
      if(carreras.size()==0){
          CarrerasFicheroVolcarArray("carreras",carreras);
         
    
      }   
         
         
     if(carreras!=null){



                                System.out.println("\t\tLista de carreras disponibles\n");
                  
                            
                                
                 for(int i=0; i<carreras.size();i++){
                     
                      if (carreras.get(i).getIdTorneo().equals(idTorneo) && carreras.get(i).getCarrerasTipo().equals(idcarrera) )
                                    {
                     
                     
     
                    System.out.println("\t\tLinea: "+ Integer.toString(i)+"\t" +"IdCarrera: "+ carreras.get(i).getIdCarrera()+"\t"+"Nombre carrera: "+ carreras.get(i).getCarreraNombre()+"\t"+"Tipo carrera: "+ carreras.get(i).getCarrerasTipo()+"\t"+"Torneo :"+ carreras.get(i).getIdTorneo());
                                 
                          
                                 
                                         for(int j=0; j<coches.size();j++){
                                         
                                            // System.out.println("\t\tgetied"+coches.get(j).getIdCarrera()+"  idcarrera "+carreras.get(i).getIdCarrera());
                                             
                                        
                                       if (coches.get(j).getIdCarrera().equals(carreras.get(i).getIdCarrera()) )  {     
                                             
                                        System.out.println("\t\t\t\tPosicion "+ Integer.toString(j) +"\t IdCoche :"
                                            + coches.get(j).getIdCoche()+"\t Marca Coche :"+ coches.get(j).getCocheMarca()+"\t Velocidad :"+ coches.get(j).getCocheVelocidad()+
                                            "\t IdGaraje :"+ coches.get(j).getIdGaraje()+"\t IdCarrera :"+ coches.get(j).getIdCarrera());
                                        
                                        
                              int contador=0;
                               Integer puntua=0;
                               Integer puesto=1;
                            
                                  
                                  Random rd = new Random();
                                  int valor = rd.nextInt(127);
                                  int valor1 = valor;
                                  //System.out.println((char)valor1);
                                  contador = contador+1;
                                 
                                   if(contador>2 ){
                                      puntua=0;
                                      puesto=0;
                                   }
                                  
                                  if(valor<11 && contador<3 ){
                                      puntua=10;
                                      puesto=1;
                                  }
                                  if (valor>10 && valor<20 && contador<3){
                                       puntua=8;
                                       puesto=2;
                                  }
                                  if (valor>19  && contador<3){
                                       puntua=6;
                                       puesto=3;
                                  }    
                                      
                                  
                                 //   Simulas cl = new Simulas(idTorneo,idcarrera,carreras.get(i).getCarrerasTipo(),valor1);
                                    Simulas cl = new Simulas(idTorneo,carreras.get(i).getIdCarrera(), coches.get(j).getIdCoche() , puntua,puesto, Integer.toString(valor1) );
                       //    System.out.println("******eventocarrera*************\t\t" +"IdTorneo: "+ idTorneo+"\t"+"IdCarrera: "+ idcarrera+"\t"+"Coche: "+ "puntua  :"+puntua + "puntua  :"+valor1 );
                                 
                      
                                    
                                    
                      
                                   simulas.add(cl);
                                  
                                  
                                  
                                        
                                        
                                        
                         
                                         }    
                                             
                                         
                                         }
                    
                    
                    
                    
                    
                    
                        
                    
                    
                    
                                
                                    
                                    
                                    }
                              }

                                
                                
                                
                        

                    }
    
     if(carreras.size()==0){
     
          System.out.println("\t\tSin valores");
    
    
     }
     
     }








   
   
   public  void Carreras(ArrayList <Carreras> carreras,ArrayList <Torneos> torneos) throws IOException {
       
      String respuesta = "no";
       boolean SalidaCarreras = false;
      
      
      if(carreras.size()==0){
          CarrerasFicheroVolcarArray("carreras",carreras);
        
      }   
      
      
      
      
      
      
      
      do { 
       
       Scanner teclado = new Scanner(System.in);
       
       
       
       
       
       ListarArrayCarreras(carreras);
       
       System.out.println("\nIntroduce el codigo de la Carrera  para Alta Nueva en Carreras        ((-1 salir) : ");
       String IdCarrera = teclado.nextLine();      
      
        boolean retornoExiste = SiExisteCarrera(carreras,IdCarrera);
       
       
       
       if(IdCarrera.equals("-1") || retornoExiste==true){
           break;
       }
       
       
      
       System.out.println("Introduce el nombre Carrera : ");
       String CarreraNombre = teclado.nextLine();
      
       if(CarreraNombre.equals("-1")){
           
           break;
       }
       
      
       boolean valido = false; 
       String CarrerasTipo=null; 
    do{
        
       System.out.println("Introduce el tipo Carrera (S/E): ");
       CarrerasTipo= teclado.nextLine();
       
       
       if(CarrerasTipo.equals("-1")){
           
           break;
       }
       
        if(CarrerasTipo.toUpperCase().equals("S") || CarrerasTipo.toUpperCase().equals("E")){
           valido = true; 
           CarrerasTipo=CarrerasTipo.toUpperCase();
       }
       
     }while(valido==false);
       
        if(CarrerasTipo.equals("-1")){
           break;
       }
       
        
        String IdTorneo=null;
        
        
        new EventoTorneo().ListarArrayTorneos(torneos);
        
        
        
        
       do {     
       
       System.out.println("\t\tIntroduce el codigo de IdTorneo   para esta Carreras  (-1 salir )  : ");
       
        IdTorneo = teclado.nextLine();
           if(IdTorneo.equals("-1") ){
           break;
       }
     
       
       retornoExiste=new EventoTorneo().SiExisteTorneo(torneos, IdTorneo);
       
        String resultIdTipo = new EventoTorneo().SiExisteTorneoTipor(torneos, IdTorneo);
     
         if(resultIdTipo.toUpperCase().equals(CarrerasTipo.toUpperCase())==false){
             System.out.println("\n La carrera tiene que ser del mismo tipo que el torneo \n  ");
              retornoExiste=false; 
         }
     
         
        if(retornoExiste==false ){
            new EventoTorneo().Torneos(torneos);
           // System.out.println("\nNo existe Torneo puedes darla de Alta ahora   : ");
           
             }
        
        
          
      } while (retornoExiste==false);  
       
       
        
        
        
      /**    
        
        
        
      valido = false;
      String IdTorneo=null;
      do{ 
       new EventoTorneo().ListarArrayTorneos(torneos);
     
       System.out.println("Introduce  idtorneo  en Carreras :                 (-2)/Alta Nueva en torneos   (-1)/Salir de carreras ");
       IdTorneo = teclado.nextLine();
       
       
       if(IdTorneo.equals("-1")){
           break;
       }
       
       if(IdTorneo.equals("-2")|| new EventoTorneo().SiExisteTorneo(torneos, IdTorneo)==false ){
            System.out.println("No existe torneo procedo a realizar Alta nueva  ");
             new EventoTorneo().Torneos(torneos);
             break;
       }
       }while(valido==false);
       
     
       String IdTorneo = teclado.nextLine();
      if(new EventoTorneo().SiExisteTorneo(torneos, IdTorneo)==false){
           System.out.println("No existe torneo  ");
           break;
      }
     
    **/   
       
         
       if(IdTorneo.equals("-1")){
           break;
       }
       
       
       Carreras cl = new Carreras(IdCarrera,CarreraNombre,CarrerasTipo,IdTorneo) ;
      
       
      // System.out.println("Compruebo si existe : "+ cl.getIdCarrera() +" con este Nombre :"+cl.getCarreraNombre());
     
                   if(carreras!=null){




                                for(int i=0; i<carreras.size();i++){

                                   // System.out.println("recorro "+carreras.get(i).getIdCarrera()+"-"+ carreras.get(i).getCarreraNombre()+"-"+ carreras.get(i).getIdTorneo());

                                }

                        }else{
                            System.out.println("\t\tSin valores");

                    }
   
       
                     boolean devexiste = false;
             
                    if(carreras!=null){

                        
                         for (int i1 = 0; i1 < carreras.size(); i1++) {
                             
                             
                 
                                        if (carreras.get(i1).getIdCarrera().equals(cl.getIdCarrera()) 
                                                && carreras.get(i1).getCarreraNombre().equals(cl.getCarreraNombre()) 
                                                && carreras.get(i1).getCarrerasTipo().equals(cl.getCarrerasTipo()))
                                         {
                                            devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                         if (carreras.get(i1).getIdCarrera().equals(cl.getIdCarrera()) )
                                         {
                                            devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
                     } 
       
       
          if (devexiste==false){
            
                        
                        teclado = new Scanner(System.in);



                    

                      //  System.out.println("- Menu de alta Carreras -");    


                        carreras.add(cl);


//                        System.out.println(" Se ha añadido correctamente ");
                      //  System.out.println(" El tamaño del control es "+carreras.size());



                    }
       
          ListarArrayCarreras(carreras);
       
           System.out.println("¿Desea dar de alta Otra Carrera en Control ?");
           respuesta = teclado.nextLine();
       } while (respuesta.equalsIgnoreCase("S"));
        
        
    }
   
   //__________________________Fin carreras______________________________________
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    
    
    
    
    
    
}
