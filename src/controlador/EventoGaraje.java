
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


public class EventoGaraje {
    
    
   

    public EventoGaraje() {
    }

 
   
   
   //_________________________Garajes_______________________________
   
    public  void GarajesFicheroEscribir(String Garajes,ArrayList <Garajes> Garajesfichero) throws IOException {
        
        
        File file = new File(Garajes+".txt");
           if (file.exists()) {
                file.createNewFile();
            }
  
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < Garajesfichero.size(); i++) {             
                  bw.write(Garajesfichero.get(i).getIdGaraje()+","+ Garajesfichero.get(i).getGarajeNombre()+"\n");                
            }    
           
            bw.close();
            
    }
    
     public  void GarajesFicheroLeer(String Garajes) throws IOException {
   
           String currLine;
           
                    File file = new File(Garajes+".txt");
      if (file.exists()) {
    
           
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(Garajes+".txt"));
            
         while ((currLine = bufferedReader.readLine()) != null)
            {
                System.out.println(currLine);
            }
    
           }else{
          System.out.println("No existe fichero ");
      } 
         
         
         
    }
    
    public  ArrayList GarajesFicheroVolcarArray(String GarajesFile,ArrayList <Garajes> garajes) throws IOException {
   
           String     IdGaraje = null; 
           String     GarajeNombre = null; 
           
          
         
           String currLine;
           
            File file = new File(GarajesFile+".txt");
           if (file.exists()==false) {
                file.createNewFile();
                 
            }else{
               if(file.length()==0){
                  
               }
           }
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(GarajesFile+".txt"));
           int contador = 0;
       
         while ((currLine = bufferedReader.readLine()) != null)
            {
               // System.out.println(currLine);
                
                String[] values = currLine.split(",");
            //recorremos el arrar de string
            for (int i = 0; i<values.length; i++) {
                //se obtiene el primer caracter de el arreglo de strings
                if (i==0){
                    IdGaraje=values[i]; 
                }
                if (i==1){
                    GarajeNombre =values[i]; 
                }
             
            }
            
            
               Garajes e = new Garajes(IdGaraje,GarajeNombre);
               garajes.add(e);
               
            }
    
         return garajes;
         
    }
     
     public void ListarArrayGarajes(ArrayList <Garajes> garajes) throws IOException{
     if(garajes.size()==0){
         
           GarajesFicheroVolcarArray("garajes",garajes);  
    
      }   
     if(garajes!=null){



                                System.out.println("\t\tLista de Garajes");
                                
                                for(int i=0; i<garajes.size();i++){
                               
                                       
                                     System.out.println("\t\tLinea "+ Integer.toString(i)+"\t IdGarajes  :" +garajes.get(i).getIdGaraje()+"\tNombre Garaje: "+ garajes.get(i).getGarajeNombre());
           
                            
                                    
                                    
                                    
                                }

                        

                    }
    
     if(garajes.size()==0){
     
          System.out.println("Sin valores");
    
    
     }
     
     }
    
   
      public void BorrarArrayGarajes(ArrayList <Garajes> garajes,Integer  posicionGarajesborrar) throws IOException{
    
          
             if(garajes.size()==0){
         
           GarajesFicheroVolcarArray("garajes",garajes);  
    
      }   
          
     if(garajes!=null){

                            

                                System.out.println("Lista de controles");
                                
                                for(int i=0; i<garajes.size();i++){
                                    
                                    if (i== posicionGarajesborrar){
                                        
                                        garajes.remove(i);
                                        
                                        System.out.println("\t\tBorrado registro :"+Integer.toString(i));
                                       // System.out.println("Nuevos valores  ");
                                               for(int i1=0; i1<garajes.size();i1++){
                                     
                                                 

                                                     System.out.println("\t\tLinea "+ Integer.toString(i1)+"\t IdGarajes: " +garajes.get(i1).getIdGaraje()+"\tNombre Garaje: "+ garajes.get(i1).getGarajeNombre());
           
                                                     
                                                     
                                                     
                                                     
                                                 }
                                        
                                        
                                        
                                    }
                                    
                                   
                                    
                                }

                        

                    }
    
     if(garajes.size()==0){
     
          System.out.println("Sin valores");
    
    
     }
     
     }
     
     
     
     
     
     
   
   public  void Garajes(ArrayList <Garajes> garajes) throws IOException {
       
      String respuesta = "no";
         if(garajes.size()==0){
         
           GarajesFicheroVolcarArray("garajes",garajes);  
    
      }   
    
      
      do { 
            
     ListarArrayGarajes(garajes);
          
          
       Scanner teclado = new Scanner(System.in);
       System.out.println("\nIntroduce el codigo del Garajes : ");
       String CodigoControlgaraje = teclado.nextLine();      
       
       
       boolean retornoExiste = SiExisteGaraje(garajes,CodigoControlgaraje);
       
       if(CodigoControlgaraje.equals("-1") || retornoExiste==true){
           break;
       }
       
       
       
       
       
       System.out.println("Introduce el nombre del Garaje: ");
       String CodigoNombreGaraje = teclado.nextLine();
       
       
       Garajes cl = new Garajes(CodigoControlgaraje,CodigoNombreGaraje);
       
       
     //  System.out.println("Compruebo si existe  : "+ cl.getIdGaraje() +" con esta carrera :"+cl.getGarajeNombre());
     
                   if(garajes!=null){




                                for(int i=0; i<garajes.size();i++){

                                    System.out.println("recorro "+garajes.get(i).getIdGaraje()+"-"+ garajes.get(i).getGarajeNombre());

                                }

                        }else{
                            System.out.println("Sin valores");

                    }
   
       
                     boolean devexiste = false;
             
                    if(garajes!=null){

                       //  System.out.println("Estoy dentro.....");
                         for (int i1 = 0; i1 < garajes.size(); i1++) {
                             
                             
                 
                                        if (garajes.get(i1).getIdGaraje().equals(cl.getIdGaraje()) && garajes.get(i1).getGarajeNombre().equals(cl.getGarajeNombre()))
                                         {
                                            devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                            }  
                     } 
       
       
       if (devexiste==false){
            
                        
                        teclado = new Scanner(System.in);



                    

                        System.out.println("- Menu de alta Controles -");    

                       


                        garajes.add(cl);


                        System.out.println(" Se ha añadido correctamente ");
                        System.out.println(" El tamaño del control es "+garajes.size());


                 



                    }
       
           System.out.println("¿Desea dar de alta Otra Carrera en Control ?");
           respuesta = teclado.nextLine();
       } while (respuesta.equalsIgnoreCase("S"));
        
        
    }
    
   
   
   //-------------------------Fin Garajes----------------------------
   
   public boolean SiExisteGaraje(ArrayList <Garajes> garajes,String idGaraje){
   
        boolean devexiste = false;
        for (int i1 = 0; i1 < garajes.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (garajes.get(i1).getIdGaraje().equals(idGaraje) )
                                         {
                                             devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
      
    public  void GarajesEdit(ArrayList <Garajes> garajes) throws IOException {
       
      String respuesta2 = "no";
      
      
   do { 
       
       Scanner teclado = new Scanner(System.in);
       
       GarajesFicheroVolcarArray("garajes",garajes);       
       ListarArrayGarajes(garajes);
       
       
       System.out.println("\nIntroduce Garaje a editar (Posicion)  ((-1 salir) : ");
       Integer IdPosicion = teclado.nextInt();      
      
       if(IdPosicion.equals(-1)){
           break;
       }
       
       
                 
               boolean devexiste = false;
             
               for(int i=0; i<garajes.size();i++){
                                    
                    if (i==IdPosicion){
                                        
                             
                            System.out.println("Posicion "+ Integer.toString(i)+"\t" +garajes.get(i).getIdGaraje()+"\t"+ garajes.get(i).getGarajeNombre());
                              
                          
       
       
                           System.out.println("Introduce el ID del coche : ");
                           teclado = new Scanner(System.in);
                           String CodigoGaraje = teclado.nextLine();      

                         

                           if(CodigoGaraje.equals("-1") ){
                               break;
                           }


                           System.out.println("Introduce el Nombre Garaje : ");
                           String CodigoCarrera = teclado.nextLine();

                            if(CodigoCarrera.equals("-1")){
                               break;
                           }


                           boolean valido = false; 
                           String GarajeTipo=null; 
                             do{

                           System.out.println("Introduce el tipo Garaje (S/E): ");
                           GarajeTipo = teclado.nextLine();


                           if(GarajeTipo.equals("-1")){
                               break;
                           }

                            if(GarajeTipo.toUpperCase().equals("S") || GarajeTipo.toUpperCase().equals("E")){
                               valido = true; 
                               GarajeTipo=GarajeTipo.toUpperCase();
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


                           Garajes cl = new Garajes(CodigoGaraje,CodigoCarrera);

                                            teclado = new Scanner(System.in);

                                                garajes.remove(i);
                                                garajes.add(cl);


                             System.out.println(" Se ha editado correctamente ");

                                
                                        
                    }        
               } 
       
       
       
           ListarArrayGarajes(garajes);
       
           System.out.println("¿Desea editar otro coche (S/N) ?");
           
           teclado = new Scanner(System.in);
           respuesta2 = teclado.nextLine();
           
           
           
           
       } while (respuesta2.equalsIgnoreCase("S"));
        
        
    
      }   
      

    

     
     
     public  void GarajeUpdate(ArrayList <Garajes> garajes) throws IOException {
       
      String respuesta = "no";
      
     do {
         
     
  
       Scanner teclado = new Scanner(System.in);
       
    
       System.out.println("Introduce el ID del coche : ");
       String CodigoGaraje = teclado.nextLine();      
      
       boolean retornoExiste = SiExisteGaraje(garajes,CodigoGaraje);
       
       if(CodigoGaraje.equals("-1") || retornoExiste==true){
           break;
       }
       
       
       System.out.println("Introduce el Nombre Garaje : ");
       String CodigoCarrera = teclado.nextLine();
       
        if(CodigoCarrera.equals("-1")){
           break;
       }
       
           boolean valido = false; 
               String GarajeTipo=null; 
                 do{

               System.out.println("Introduce el tipo Garaje (S/E): ");
               GarajeTipo = teclado.nextLine();


               if(GarajeTipo.equals("-1")){
                   break;
               }

                if(GarajeTipo.toUpperCase().equals("S") || GarajeTipo.toUpperCase().equals("E")){
                   valido = true; 
                   GarajeTipo=GarajeTipo.toUpperCase();
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
        
        
       Garajes cl = new Garajes(CodigoGaraje,CodigoCarrera);
       
      
      
                     boolean devexiste = false;
             
                        
                        teclado = new Scanner(System.in);



                    

                        System.out.println("- Menu de editar Garajes -");    

                      
                        garajes.add(cl);
                      

                        System.out.println(" Se ha editado correctamente ");
                 
                         break;
                  
     } while (true) ;
        
        
    }
   
   
   
    
    
    
    
    
    
}
