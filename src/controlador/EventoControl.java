
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


public class EventoControl {
    
    
   

    public EventoControl() {
    }

     //_________________________Controles_______________________________
    
    
    public  void ControlesFicheroEscribir(String controles,ArrayList <Controles> controlesfichero) throws IOException {
        
        
        File file = new File(controles+".txt");
           if (file.exists()) {
                file.createNewFile();
            }
  
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < controlesfichero.size(); i++) {             
                  bw.write(controlesfichero.get(i).getIdControl()+","+ controlesfichero.get(i).getIdCarrera()+"\n");                
            }    
           
            bw.close();
            
    }
    
     public  void ControlesFicheroLeer(String controles) throws IOException {
   
           String currLine;
           
            File file = new File(controles+".txt");
      if (file.exists()) {
               
            
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(controles+".txt"));
            
         while ((currLine = bufferedReader.readLine()) != null)
            {
                System.out.println(currLine);
            }
    
      }else{
          System.out.println("No existe fichero ");
      } 
         
         
    }
    
    public  ArrayList ControlesFicheroVolcarArray(String controlesFile,ArrayList <Controles> controles) throws IOException {
   
           String     IdControl = null; 
           String     IdCarrera = null; 
           
          
           
           String currLine;
           
           
            File file = new File(controlesFile+".txt");
           if (file.exists()==false) {
                file.createNewFile();
                 
            }else{
               if(file.length()==0){
                  
               }
           }
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(controlesFile+".txt"));
           int contador = 0;
       
           
         while ((currLine = bufferedReader.readLine()) != null)
            {
               // System.out.println(currLine);
                
                String[] values = currLine.split(",");
            //recorremos el arrar de string
            for (int i = 0; i<values.length; i++) {
                //se obtiene el primer caracter de el arreglo de strings
                if (i==0){
                    IdControl=values[i]; 
                    
                }
                if (i==1){
                    IdCarrera =values[i]; 
                    
                }
             
            }
               
                //System.out.println("Recuperado Fichero del histórico");
                Controles e = new Controles(IdControl,IdCarrera);
                controles.add(e);
            }
    
         return controles;
         
    }
     
     public void ListarArrayControles(ArrayList <Controles> controles) throws IOException{
    
      if(controles.size()==0){
          ControlesFicheroVolcarArray("controles",controles);
         // System.out.println("Sin valores");
    
      }   
       
          
           System.out.println("\t\tLista de controles\n");
                                
                                for(int i=0; i<controles.size();i++){
                                     
                                   
                                    System.out.println("\t\tLinea : "+ Integer.toString(i) +"  IdControl :"+ controles.get(i).getIdControl()+" Idcarrera :"+ controles.get(i).getIdCarrera());
                                    

                                }
          
     
         
         
     
     
     }
    
   
      public void BorrarArrayControles(ArrayList <Controles> controles,Integer  posicioncontrolborrar) throws IOException{
    

      if(controles.size()==0){
     
           ControlesFicheroVolcarArray("controles",controles);
      }
    
     
           System.out.println("Lista de controles");
                                
                                for(int i=0; i<controles.size();i++){
                                    
                                    if (i== posicioncontrolborrar){
                                        
                                        controles.remove(i);
                                        
                                        System.out.println("Borrado registro :"+Integer.toString(i));
                                        //System.out.println("Nuevos valores  ");
                                               for(int i1=0; i1<controles.size();i1++){
                                     
                                                     System.out.println("Linea : "+ Integer.toString(i1) +"  IdControl :"+ controles.get(i1).getIdControl()+" Idcarrera :"+ controles.get(i1).getIdCarrera());

                                                 }
                                        
                                        
                                        
                                    }
                                    
                                   
                                    
                            

                        
      }     
          
    
    
     
     }
     
     
     
     
     
     
   
   public  void Controles(ArrayList <Controles> controles,ArrayList <Carreras> carreras,ArrayList <Torneos> torneos) throws IOException {
       
      String respuesta = "no";
      
      if(controles.size()==0){
          ControlesFicheroVolcarArray("controles",controles);
         
    
      }   
      
      
      do { 
        //ControlesFicheroVolcarArray("controles",controles);       
         ListarArrayControles(controles);
      
          
          
       Scanner teclado = new Scanner(System.in);
       
       System.out.println("\nIntroduce el codigo del Control para Alta   (-1 salir ) : ");
       String CodigoControl = teclado.nextLine();      
        if(CodigoControl.equals("-1") ){
           break;
       }
       
       new EventoCarrera().ListarArrayCarreras(carreras);
    
       boolean retornoExiste=false;
       String CodigoCarrera=null;
    do {     
       
       System.out.println("\nIntroduce el codigo de Carrera   para Alta  (-1 salir )  : ");
       
       CodigoCarrera = teclado.nextLine();
          if(CodigoCarrera.equals("-1") ){
           break;
       }
          
          
       retornoExiste=new EventoCarrera().SiExisteCarrera(carreras, CodigoCarrera);
      
       
        if(retornoExiste==false ){
            new EventoCarrera().Carreras(carreras, torneos);
            System.out.println("\nNo existe Carrera puedes darla de Alta ahora   : ");
           
            
            
            
            
       }
        
        
       
      
        
        
       
      } while (retornoExiste==false);  
       
       
       
        retornoExiste = SiExisteControl(controles,CodigoCarrera);
       
       if(CodigoCarrera.equals("-1") || retornoExiste==true){
           break;
       }
       
       
       
       Controles cl = new Controles(CodigoControl,CodigoCarrera);
       
       
    //   System.out.println("Compruebo si existe control : "+ cl.getIdCarrera() +" con esta carrera :"+cl.getIdControl());
     
                   if(controles!=null){




                                for(int i=0; i<controles.size();i++){

                                   // System.out.println("recorro "+controles.get(i).getIdControl()+"-"+ controles.get(i).getIdCarrera());

                                }

                        }else{
                            System.out.println("Sin valores");

                    }
   
       
                     boolean devexiste = false;
             
                    if(controles!=null){

                        // System.out.println("Estoy dentro.....");
                         for (int i1 = 0; i1 < controles.size(); i1++) {
                             
                             
                 
                                        if (controles.get(i1).getIdControl().equals(cl.getIdControl()) && controles.get(i1).getIdCarrera().equals(cl.getIdCarrera()))
                                         {
                                            devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                            }  
                     } 
       
       
       if (devexiste==false){
            
                        
                        teclado = new Scanner(System.in);



                    

                     //   System.out.println("- Menu de alta Controles -");    

                     //   System.out.println(" El valor de control es:" +cl.getIdControl());
                     //   System.out.println(" El valor es carrera es: " +cl.getIdCarrera());



                        controles.add(cl);


                        System.out.println(" Se ha añadido correctamente \n");
                     //   System.out.println(" El tamaño del control es "+controles.size());

                        ListarArrayControles(controles);
                 



                    }
       
           System.out.println("\n¿Desea dar de alta Otra Carrera en Control ?");
           respuesta = teclado.nextLine();
       } while (respuesta.equalsIgnoreCase("S"));
        
        
    }
   
   //__________________________Fin controles______________________________________
   
   public boolean SiExisteControl(ArrayList <Controles> controles,String idControl){
   
        boolean devexiste = false;
        for (int i1 = 0; i1 < controles.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (controles.get(i1).getIdCarrera().equals(idControl) )
                                         {
                                             devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
      
    public  void ControlesEdit(ArrayList <Controles> controles) throws IOException {
       
      String respuesta2 = "no";
      
      
   do { 
       
       Scanner teclado = new Scanner(System.in);
       
       ControlesFicheroVolcarArray("controles",controles);       
       ListarArrayControles(controles);
       
       
       System.out.println("\nIntroduce Control a editar (Posicion)  ((-1 salir) : ");
       Integer IdPosicion = teclado.nextInt();      
      
       if(IdPosicion.equals(-1)){
           break;
       }
       
       
                 
               boolean devexiste = false;
             
               for(int i=0; i<controles.size();i++){
                                    
                    if (i==IdPosicion){
                                        
                             
                            System.out.println("Posicion "+ Integer.toString(i)+"\t" +controles.get(i).getIdControl()+"\t"+ controles.get(i).getIdCarrera());
                              
                          
       
       
                           System.out.println("Introduce el ID del coche : ");
                           teclado = new Scanner(System.in);
                           String CodigoControl = teclado.nextLine();      

                         

                           if(CodigoControl.equals("-1") ){
                               break;
                           }


                           System.out.println("Introduce el Nombre Control : ");
                           String CodigoCarrera = teclado.nextLine();

                            if(CodigoCarrera.equals("-1")){
                               break;
                           }


                           boolean valido = false; 
                           String ControlTipo=null; 
                             do{

                           System.out.println("Introduce el tipo Control (S/E): ");
                           ControlTipo = teclado.nextLine();


                           if(ControlTipo.equals("-1")){
                               break;
                           }

                            if(ControlTipo.toUpperCase().equals("S") || ControlTipo.toUpperCase().equals("E")){
                               valido = true; 
                               ControlTipo=ControlTipo.toUpperCase();
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


                           Controles cl = new Controles(CodigoControl,CodigoCarrera);

                                            teclado = new Scanner(System.in);

                                                controles.remove(i);
                                                controles.add(cl);


                             System.out.println(" Se ha editado correctamente ");

                                
                                        
                    }        
               } 
       
       
       
           ListarArrayControles(controles);
       
           System.out.println("¿Desea editar otro coche (S/N) ?");
           
           teclado = new Scanner(System.in);
           respuesta2 = teclado.nextLine();
           
           
           
           
       } while (respuesta2.equalsIgnoreCase("S"));
        
        
    
      }   
      

    

     
     
     public  void ControlUpdate(ArrayList <Controles> controles) throws IOException {
       
      String respuesta = "no";
      
     do {
         
     
  
       Scanner teclado = new Scanner(System.in);
       
    
       System.out.println("Introduce el ID del coche : ");
       String CodigoControl = teclado.nextLine();      
      
       boolean retornoExiste = SiExisteControl(controles,CodigoControl);
       
       if(CodigoControl.equals("-1") || retornoExiste==true){
           break;
       }
       
       
       System.out.println("Introduce el Nombre Control : ");
       String CodigoCarrera = teclado.nextLine();
       
        if(CodigoCarrera.equals("-1")){
           break;
       }
       
           boolean valido = false; 
               String ControlTipo=null; 
                 do{

               System.out.println("Introduce el tipo Control (S/E): ");
               ControlTipo = teclado.nextLine();


               if(ControlTipo.equals("-1")){
                   break;
               }

                if(ControlTipo.toUpperCase().equals("S") || ControlTipo.toUpperCase().equals("E")){
                   valido = true; 
                   ControlTipo=ControlTipo.toUpperCase();
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
        
        
       Controles cl = new Controles(CodigoControl,CodigoCarrera);
       
      
      
                     boolean devexiste = false;
             
                        
                        teclado = new Scanner(System.in);



                    

                        System.out.println("- Menu de editar Controles -");    

                      
                        controles.add(cl);
                      

                        System.out.println(" Se ha editado correctamente ");
                 
                         break;
                  
     } while (true) ;
        
        
    }
   
   
   
    
    
    
    
    
    
    
}
