
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


public class EventoCoche {
    
    
   

    public EventoCoche() {
    }

    
   
   
   //_________________________Coches_______________________________
    
    
    public  void CochesFicheroEscribir(String coches,ArrayList <Coches> cochesfichero) throws IOException {
        
        
        File file = new File(coches+".txt");
           if (file.exists()) {
                file.createNewFile();
            }
  
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < cochesfichero.size(); i++) {             
                  bw.write(cochesfichero.get(i).getIdCoche()+","+ cochesfichero.get(i).getCocheMarca()
                          +","+ cochesfichero.get(i).getCocheModelo()+","+cochesfichero.get(i).getCocheVelocidad()+","+cochesfichero.get(i).getIdGaraje()+","+cochesfichero.get(i).getIdCarrera()+"\n");                
           
            }    
           
           
            
            bw.close();
            
    }
    
     public  void CochesFicheroLeer(String coches) throws IOException {
   
           String currLine;
           
                    File file = new File(coches+".txt");
      if (file.exists()) {
 
           
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(coches+".txt"));
            
         while ((currLine = bufferedReader.readLine()) != null)
            {
                System.out.println(currLine);
            }
    
           }else{
          System.out.println("No existe fichero ");
      } 
         
         
         
    }
    
    public  ArrayList CochesFicheroVolcarArray(String cochesFile,ArrayList <Coches> coches) throws IOException {
   
                String    IdCoche1=null; 
                String    CocheMarca=null;
                String    CocheModelo=null; 
                String    CocheVelocidad=null;   
                String    CocheGaraje=null; 
                String    CocheCarrera=null;  
           String currLine;
           
            File file = new File(cochesFile+".txt");
           if (file.exists()==false) {
                file.createNewFile();
                 
            }else{
               if(file.length()==0){
                  
               }
           }
           
           
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(cochesFile+".txt"));
           int contador = 0;
      
         while ((currLine = bufferedReader.readLine()) != null)
            {
              //  System.out.println(currLine);
                
                String[] values = currLine.split(",");
            //recorremos el arrar de string
            for (int i = 0; i<values.length; i++) {
                //se obtiene el primer caracter de el arreglo de strings
                if (i==0){
                    IdCoche1 =values[i]; 
                }
                if (i==1){
                    CocheMarca=values[i]; 
                }
             
                
                if (i==2){
                    CocheModelo =values[i]; 
                }
                
                if (i==3){
                    CocheVelocidad =values[i]; 
                }
                
                
                 if (i==4){
                    CocheGaraje =values[i]; 
                }
                
                 if (i==5){
                    CocheCarrera =values[i]; 
                }
                
                
                
                
                
            }
              
                       
            
            
            Coches e = new Coches(IdCoche1,CocheMarca,CocheModelo, Integer.parseInt(CocheVelocidad),CocheGaraje,CocheGaraje);
                coches.add(e);
            }
    
         return coches;
         
    }
     
     public void ListarArrayCoches(ArrayList <Coches> coches) throws IOException{
    
         
       
       
        
         if(coches.size()==0){
         
          CochesFicheroVolcarArray("coches",coches);   
    
      }   
        
        
        
        
     if(coches!=null){



                                System.out.println("\t\tLista de coches");
                                
                                for(int i=0; i<coches.size();i++){
                                     
                                    System.out.println("\t\tPosicion "+ Integer.toString(i) +"\t IdCoche :"
                                            + coches.get(i).getIdCoche()+"\t Marca Coche :"+ coches.get(i).getCocheMarca()+"\t Velocidad :"+ coches.get(i).getCocheVelocidad()+
                                            "\t IdGaraje :"+ coches.get(i).getIdGaraje()+"\t IdCarrera :"+ coches.get(i).getIdCarrera());

                                }

                        

                    }
    
     if(coches.size()==0){
     
          System.out.println("Sin valores");
    
    
     }
     
     }
    
   
      public void BorrarArrayCoches(ArrayList <Coches> coches,Integer  posicioncontrolborrar) throws IOException{
       if(coches.size()==0){
         
          CochesFicheroVolcarArray("coches",coches);   
    
      }   
     if(coches!=null){

                               

                                System.out.println("\t\tLista de coches");
                                
                                for(int i=0; i<coches.size();i++){
                                    
                                    if (i== posicioncontrolborrar){
                                        
                                        coches.remove(i);
                                        
                                        System.out.println("\t\tBorrado registro :"+Integer.toString(i));
                                        System.out.println("\t\tNuevos valores  ");
                                               for(int i1=0; i1<coches.size();i1++){
                                     
                                                     System.out.println("\t\tPosicion "+ Integer.toString(i1) +"\t IdCoche :"
                                            + coches.get(i1).getIdCoche()+"\t Marca Coche :"+ coches.get(i1).getCocheMarca()+"\t Velocidad :"+ coches.get(i1).getCocheVelocidad()+
                                            "\t IdGaraje :"+ coches.get(i1).getIdGaraje()+"\t IdCarrera :"+ coches.get(i1).getIdCarrera());

                                                 }
                                        
                                        
                                        
                                    }
                                    
                                   
                                    
                                }

                        

                    }
    
     if(coches.size()==0){
     
          System.out.println("Sin valores");
    
    
     }
     
     }
     
     
   
   public  void Coches(ArrayList <Coches> coches,ArrayList <Carreras> carreras,ArrayList <Torneos> torneos,ArrayList <Garajes> garajes) throws IOException {
       
      String respuesta = "no";
        if(coches.size()==0){
         CochesFicheroVolcarArray("coches",coches);      
         
    
      }   
      
      
      do { 
       
         
        ListarArrayCoches(coches); 
          
          
          
       Scanner teclado = new Scanner(System.in);
       System.out.println("\nIntroduce el codigo de coche : ");
       String Codigocoche = teclado.nextLine();      
       
         boolean retornoExiste = SiExisteCoche(coches,Codigocoche);
       
       if(Codigocoche.equals("-1") || retornoExiste==true){
           break;
       }
       
       
       
       
       
       
       System.out.println("Introduce  Marca : ");
       String CodigoMarca = teclado.nextLine();
         if(Codigocoche.equals("-1") ){
           break;
       }
       
       
       
       System.out.println("Introduce  Modelo : ");
       String CodigoModelo = teclado.nextLine();
       
          if(CodigoModelo.equals("-1") ){
           break;
       }
       
       System.out.println("Introduce velocidad : ");
       Integer CodigoVelocidad = teclado.nextInt();
       
          if(CodigoVelocidad== -1  ){
           break;
       }
       
       
          
       new EventoGaraje().ListarArrayGarajes(garajes);
          
       System.out.println("Introduce  Garaje : ");
       teclado = new Scanner(System.in);
       String CodigoGaraje = teclado.nextLine();
    
          if(CodigoGaraje.equals("-1") ){
           break;
       }
       
       
      new EventoCarrera().ListarArrayCarreras(carreras);
    
        retornoExiste=false;
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
            //System.out.println("\nNo existe Carrera puedes darla de Alta ahora   : ");
           
            
            
            
            
       }
        
        
       
      
        
        
       
      } while (retornoExiste==false);  
       
           
     
        
        
       Coches cl = new Coches(Codigocoche,CodigoMarca,CodigoModelo,CodigoVelocidad,CodigoGaraje,CodigoCarrera);
       
       
     //  System.out.println("Compruebo si existe control : "+ cl.getIdCoche()+" con Nombre :"+cl.getCocheMarca());
     
                   if(coches!=null){




                                for(int i=0; i<coches.size();i++){

                                  //  System.out.println("recorro "+coches.get(i).getIdCoche()+"-"+ coches.get(i).getCocheMarca());

                                }

                        }else{
                            System.out.println("Sin valores");

                    }
   
       
                     boolean devexiste = false;
             
                    if(coches!=null){

                       //  System.out.println("Estoy dentro.....");
                         for (int i1 = 0; i1 < coches.size(); i1++) {
                             
                             
                 
                                        if (coches.get(i1).getIdCoche().equals(cl.getIdCoche()) && coches.get(i1).getCocheMarca().equals(cl.getCocheMarca()))
                                         {
                                            devexiste = true;  
                                             //System.out.println("Existe codigo incorporación no realizada " );
                                        }  
                                        
                                         if (coches.get(i1).getIdCoche().equals(cl.getIdCoche()))
                                         {
                                            devexiste = true;  
                                            ///ystem.out.println("Existe codigo incorporación no realizada " );
                                        }      
                                        
                                        
                            }  
                     } 
       
       
       if (devexiste==false){
            
                        
                        teclado = new Scanner(System.in);



                    

                    //    System.out.println("- Menu de alta Coches -");    

                       



                        coches.add(cl);

                         ListarArrayCoches(coches);
                        System.out.println(" Se ha añadido correctamente ");
                       // System.out.println(" El tamaño del control es "+coches.size());


                 



                    }
       
           System.out.println("¿Desea dar de alta otro coche ?");
           respuesta = teclado.nextLine();
       } while (respuesta.equalsIgnoreCase("S"));
        
        
    }
    public boolean SiExisteCoche(ArrayList <Coches> coches,String idCoche){
   
        boolean devexiste = false;
        for (int i1 = 0; i1 < coches.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (coches.get(i1).getIdCoche().equals(idCoche) )
                                         {
                                             devexiste = true;  
                                            // System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
    
    public Integer SiExisteCocheTipo(ArrayList <Coches> coches,String idCocheTipo){
   
        Integer devexiste = 0;
        for (int i1 = 0; i1 < coches.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (coches.get(i1).getIdCoche().equals(idCocheTipo) )
                                         {
                                            
                                             
                                             devexiste = devexiste+1;  
                                            // System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
    
    
    
      
    public  void CochesEdit(ArrayList <Coches> coches) throws IOException {
       
      String respuesta2 = "no";
      
      
   do { 
       
       Scanner teclado = new Scanner(System.in);
       
       CochesFicheroVolcarArray("coches",coches);       
       ListarArrayCoches(coches);
       
       
       System.out.println("\nIntroduce Coche a editar (Posicion)  ((-1 salir) : ");
       Integer IdPosicion = teclado.nextInt();      
      
       if(IdPosicion.equals(-1)){
           break;
       }
       
       
                 
               boolean devexiste = false;
             
               for(int i=0; i<coches.size();i++){
                                    
                    if (i==IdPosicion){
                                        
                             
                            System.out.println("Posicion "+ Integer.toString(i)+"\t" +coches.get(i).getIdCoche()+"\t"+ coches.get(i).getCocheMarca()+"\tEstado"+ coches.get(i).getCocheModelo());
                              
                          
       
       
                           System.out.println("Introduce el ID del coche : ");
                           teclado = new Scanner(System.in);
                           String CodigoCoche = teclado.nextLine();      

                         

                           if(CodigoCoche.equals("-1") ){
                               break;
                           }


                           System.out.println("Introduce el Nombre Coche : ");
                           String CodigoCarrera = teclado.nextLine();

                            if(CodigoCarrera.equals("-1")){
                               break;
                           }


                           boolean valido = false; 
                           String CocheTipo=null; 
                             do{

                           System.out.println("Introduce el tipo Coche (S/E): ");
                           CocheTipo = teclado.nextLine();


                           if(CocheTipo.equals("-1")){
                               break;
                           }

                            if(CocheTipo.toUpperCase().equals("S") || CocheTipo.toUpperCase().equals("E")){
                               valido = true; 
                               CocheTipo=CocheTipo.toUpperCase();
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


                           Coches cl = new Coches(CodigoCoche,CodigoCarrera,CocheTipo,CodigoActivo);

                                            teclado = new Scanner(System.in);

                                                coches.remove(i);
                                                coches.add(cl);


                             System.out.println(" Se ha editado correctamente ");

                                
                                        
                    }        
               } 
       
       
       
           ListarArrayCoches(coches);
       
           System.out.println("¿Desea editar otro coche (S/N) ?");
           
           teclado = new Scanner(System.in);
           respuesta2 = teclado.nextLine();
           
           
           
           
       } while (respuesta2.equalsIgnoreCase("S"));
        
        
    
      }   
      

    

     
     
     public  void CocheUpdate(ArrayList <Coches> coches) throws IOException {
       
      String respuesta = "no";
      
     do {
         
     
  
       Scanner teclado = new Scanner(System.in);
       
    
       System.out.println("Introduce el ID del coche : ");
       String CodigoCoche = teclado.nextLine();      
      
       boolean retornoExiste = SiExisteCoche(coches,CodigoCoche);
       
       if(CodigoCoche.equals("-1") || retornoExiste==true){
           break;
       }
       
       
       System.out.println("Introduce el Nombre Coche : ");
       String CodigoCarrera = teclado.nextLine();
       
        if(CodigoCarrera.equals("-1")){
           break;
       }
       
           boolean valido = false; 
               String CocheTipo=null; 
                 do{

               System.out.println("Introduce el tipo Coche (S/E): ");
               CocheTipo = teclado.nextLine();


               if(CocheTipo.equals("-1")){
                   break;
               }

                if(CocheTipo.toUpperCase().equals("S") || CocheTipo.toUpperCase().equals("E")){
                   valido = true; 
                   CocheTipo=CocheTipo.toUpperCase();
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
        
        
       Coches cl = new Coches(CodigoCoche,CodigoCarrera,CocheTipo,CodigoActivo);
       
      
      
                     boolean devexiste = false;
             
                        
                        teclado = new Scanner(System.in);



                    

                        System.out.println("- Menu de editar Coches -");    

                      
                        coches.add(cl);
                      

                        System.out.println(" Se ha editado correctamente ");
                 
                         break;
                  
     } while (true) ;
        
        
    }
   
   
   
    
    
    
    
    
    
}
