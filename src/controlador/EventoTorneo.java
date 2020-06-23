
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


public class EventoTorneo {
    
    
   

    public EventoTorneo() {
    }

    
    
    
     public  void TorneosFicheroEscribir(String torneos,ArrayList <Torneos> torneosfichero) throws IOException {
        
        
        File file = new File(torneos+".txt");
           if (file.exists()) {
                file.createNewFile();
            }
  
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < torneosfichero.size(); i++) {             
                  bw.write(torneosfichero.get(i).getIdTorneo()+","+ torneosfichero.get(i).getTorneoNombre()+","+ torneosfichero.get(i).getTorneoTipoCarrera()+","+ torneosfichero.get(i).getTorneoActivo()+"\n");                
            }    
           
            bw.close();
            
    }
    
    
    public  void TorneosFicheroLeer(String torneos) throws IOException {
   
           String currLine;
           
                    File file = new File(torneos+".txt");
      if (file.exists()) {
     
           
           BufferedReader bufferedReader = new BufferedReader(new FileReader(torneos+".txt"));
            
         while ((currLine = bufferedReader.readLine()) != null)
            {
                System.out.println(currLine);
            }
    
           }else{
          System.out.println("No existe fichero ");
      } 
         
         
    } 
    
      public  ArrayList TorneosFicheroVolcarArray(String torneosFile,ArrayList <Torneos> torneos) throws IOException {
   
                String    IdTorneo1=null; 
                String    TorneoNombre1=null;
                String    TorneoActivo1=null; 
                String    TorneoTipo1=null;  
                
                
                  File file = new File(torneosFile+".txt");
           if (file.exists()==false) {
                file.createNewFile();
                 
            }else{
               if(file.length()==0){
                  
               }
           }
                
                
                
                
          
        
           String currLine;
           BufferedReader bufferedReader = new BufferedReader(new FileReader(torneosFile+".txt"));
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
                    TorneoActivo1 =values[i]; 
                }
                
            }
              
            
            
               Torneos e = new Torneos(IdTorneo1,TorneoNombre1,TorneoTipo1, Integer.parseInt(TorneoActivo1));
                torneos.add(e);
                file.delete();
                
                
                
            }
    
         return torneos;
         
    }
     
     public void ListarArrayTorneos(ArrayList <Torneos> torneos) throws IOException{
    
    
     
      if(torneos.size()==0){
         
            TorneosFicheroVolcarArray("torneos",torneos);    
       
    
      }   
     
     
         
     if(torneos!=null){



                                System.out.println("\t\tLista de torneos\n");
                                
                                for(int i=0; i<torneos.size();i++){
                                     
                           

                                 System.out.println("\t\t"+"Linea: "+ Integer.toString(i)+"\t" +"Id del Torneo: "+
                                         torneos.get(i).getIdTorneo()+"\t"+"Nombre torneo :"+ torneos.get(i).getTorneoNombre()+"\t"+"Tipo:  "+ torneos.get(i).getTorneoTipoCarrera()+"\t"+"Estado - No activo(0)/Activo(1):  "+ torneos.get(i).getTorneoActivo());

                                
                                
                                
                                }

                        

                    }
    
     if(torneos.size()==0){
     
          System.out.println("\t\tSin valores");
    
    
     }
     
     }
    
   
      public void BorrarArrayTorneos(ArrayList <Torneos> torneos,Integer  posicioncontrolborrar) throws IOException{
    
              
         
      if(torneos.size()==0){
         
            TorneosFicheroVolcarArray("torneos",torneos);    
       
    
      }   
          
     if(torneos!=null){

                                

                                System.out.println("Lista de torneos");
                                
                                for(int i=0; i<torneos.size();i++){
                                    
                                    if (i== posicioncontrolborrar){
                                        
                                        torneos.remove(i);
                                        
                                        System.out.println("Borrado registro :"+Integer.toString(i));
                                        System.out.println("Nuevos valores  ");
                                               for(int i1=0; i1<torneos.size();i1++){
                                     
                                                   System.out.println("Posicion "+ Integer.toString(i1) +"  Valor Torneo :"+ torneos.get(i1).getIdTorneo()+" Valor carrera :"+ torneos.get(i1).getTorneoNombre());

                                                 }
                                        
                                        
                                        
                                    }
                                    
                                   
                                    
                                }

                        

                    }
    
     if(torneos.size()==0){
     
          System.out.println("Sin valores");
    
    
     }
     
     }
     
     
   public boolean SiExisteTorneo(ArrayList <Torneos> torneos,String idtorneo){
   
        boolean devexiste = false;
        for (int i1 = 0; i1 < torneos.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (torneos.get(i1).getIdTorneo().equals(idtorneo) )
                                         {
                                             devexiste = true;  
                                             //System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
   
   
    public boolean SiExisteTorneoMax(ArrayList <Torneos> torneos,String idtipo){
   
        boolean devexiste = false;
        int counttipo = 0;
        for (int i1 = 0; i1 < torneos.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (torneos.get(i1).getTorneoTipoCarrera().equals(idtipo.toUpperCase()) )
                                         {
                                             counttipo=counttipo+1;
                                             if(counttipo>0);
                                             devexiste = true;  
                                            
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
   
   
     public String SiExisteTorneoNombre(ArrayList <Torneos> torneos,String idtorneo){
   
        String devexiste=null ;
        for (int i1 = 0; i1 < torneos.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (torneos.get(i1).getIdTorneo().equals(idtorneo) )
                                         {
                                             devexiste = torneos.get(i1).getTorneoNombre();  
                                             //System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }
  
     
    public String SiExisteTorneoTipo(ArrayList <Torneos> torneos,String idtorneo){
   
        String devexiste=null ;
        for (int i1 = 0; i1 < torneos.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (torneos.get(i1).getIdTorneo().equals(idtorneo) )
                                         {
                                             devexiste = torneos.get(i1).getTorneoTipoCarrera();
                                             if(devexiste.equals("S")){
                                                 devexiste="Estandar";
                                             }else{
                                                 devexiste="Eliminación";
                                             }
                                             
                                             
                                             //System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }  
     
    public String SiExisteTorneoTipor(ArrayList <Torneos> torneos,String idtorneo){
   
        String devexiste="-1" ;
        for (int i1 = 0; i1 < torneos.size(); i1++) {
                             
                             
                 
                                        
                                        
                                         if (torneos.get(i1).getIdTorneo().equals(idtorneo) )
                                         {
                                             devexiste = torneos.get(i1).getTorneoTipoCarrera();
                                             if(devexiste.equals("S")){
                                                 
                                             }else{
                                                 devexiste="E";
                                             }
                                             
                                             
                                             //System.out.println("Existe codigo incorporación no realizada " );
                                        }         
                                        
                                        
                                        
                            }  
       
       
       return devexiste;
       
   }    
     
     
   
   public  void Torneos(ArrayList <Torneos> torneos) throws IOException {
       
      String respuesta = "no";
      
      
      if(torneos.size()==0){
         
            TorneosFicheroVolcarArray("torneos",torneos);    
       
    
      }   
      
      
      
   do { 
       
       Scanner teclado = new Scanner(System.in);
       
      
      ListarArrayTorneos(torneos);
       
       
       
       
       System.out.println("\nIntroduce el ID del torneo en Torneo:           -1/Salir");
       String CodigoTorneo = teclado.nextLine();      
      
       boolean retornoExiste = SiExisteTorneo(torneos,CodigoTorneo);
       
       if(CodigoTorneo.equals("-1") || retornoExiste==true){
           break;
       }
       
       
       System.out.println("Introduce el Nombre Torneo para Alta : ");
       String CodigoCarrera = teclado.nextLine();
       
        if(CodigoCarrera.equals("-1")){
           break;
       }
       
        
         boolean valido = false; 
       String TorneoTipo=null; 
         boolean retornoMax = false; 
     do{
        
       System.out.println("Introduce el tipo Torneo (S/E)*: ");
       TorneoTipo = teclado.nextLine();
       
       retornoMax = SiExisteTorneoMax(torneos,TorneoTipo);
       
       if (retornoMax==true) {
          System.out.println("Solo un Torneo por Tipo Max(1):  (-1/Salir)"); 
           TorneoTipo = teclado.nextLine();
          break;
       }
       
       
       if(TorneoTipo.equals("-1")){
           break;
       }
       
        if(TorneoTipo.toUpperCase().equals("S") || TorneoTipo.toUpperCase().equals("E")){
           valido = true; 
           TorneoTipo=TorneoTipo.toUpperCase();
       }
       
     }while(valido==false);
       
        if(TorneoTipo.equals("-1")){
           break;
       }
        
        
        
       valido = false; 
       Integer CodigoActivo=0; 
    
       
        if (retornoMax==false) {
   
       
        
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
        
        
       Torneos cl = new Torneos(CodigoTorneo,CodigoCarrera,TorneoTipo,CodigoActivo);
       
       
       //System.out.println("Compruebo si existe control : "+ cl.getIdTorneo()+" con Nombre :"+cl.getTorneoNombre());
     
                   if(torneos!=null){




                                for(int i=0; i<torneos.size();i++){

                                   // System.out.println("recorro "+torneos.get(i).getIdTorneo()+"-"+ torneos.get(i).getTorneoNombre());

                                }

                        }else{
                            System.out.println("\t\tSin valores");

                    }
   
       
                     boolean devexiste = false;
             
                    if(torneos!=null){

                        // System.out.println("Estoy dentro.....");
                         for (int i1 = 0; i1 < torneos.size(); i1++) {
                             
                             
                 
                                        if (torneos.get(i1).getIdTorneo().equals(cl.getIdTorneo()) && torneos.get(i1).getTorneoNombre().equals(cl.getTorneoNombre()))
                                         {
                                            devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }   
                                        
                                          if (torneos.get(i1).getIdTorneo().equals(cl.getIdTorneo()) )
                                         {
                                            devexiste = true;  
                                             System.out.println("Existe codigo incorporación no realizada " );
                                        }   
                                        
                                        
                                        
                            }  
                     } 
       
       
       if (devexiste==false){
            
                        
                        teclado = new Scanner(System.in);



                    

                     //   System.out.println("- Menu de alta Torneos -");    

                       



                        torneos.add(cl);


                        System.out.println(" Se ha añadido correctamente ");
                  //      System.out.println(" El tamaño del control es "+torneos.size());


                 



                    }
           ListarArrayTorneos(torneos);
           
            break;
       }    
           
           
           System.out.println("¿Desea dar de alta Otro  Torneo ?");
           respuesta = teclado.nextLine();
       } while (respuesta.equalsIgnoreCase("S"));
        
        
    }
   
    
     
    public  void TorneosEdit(ArrayList <Torneos> torneos) throws IOException {
       
      String respuesta2 = "no";
      
      
   do { 
       
       Scanner teclado = new Scanner(System.in);
       
       TorneosFicheroVolcarArray("torneos",torneos);       
       ListarArrayTorneos(torneos);
       
       
       System.out.println("\nIntroduce Torneo a editar (Posicion)  ((-1 salir) : ");
       Integer IdPosicion = teclado.nextInt();      
      
       if(IdPosicion.equals(-1)){
           break;
       }
       
       
                 
               boolean devexiste = false;
             
               for(int i=0; i<torneos.size();i++){
                                    
                    if (i==IdPosicion){
                                        
                             
                            System.out.println("Posicion "+ Integer.toString(i)+"\t" +torneos.get(i).getIdTorneo()+"\t"+ torneos.get(i).getTorneoNombre()+"\tEstado"+ torneos.get(i).getTorneoActivo());
                              
                          
       
       
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


                           Torneos cl = new Torneos(CodigoTorneo,CodigoCarrera,TorneoTipo,CodigoActivo);

                                            teclado = new Scanner(System.in);

                                                torneos.remove(i);
                                                torneos.add(cl);


                             System.out.println(" Se ha editado correctamente ");

                                
                                        
                    }        
               } 
       
       
       
           ListarArrayTorneos(torneos);
       
           System.out.println("¿Desea editar otro torneo (S/N) ?");
           
           teclado = new Scanner(System.in);
           respuesta2 = teclado.nextLine();
           
           
           
           
       } while (respuesta2.equalsIgnoreCase("S"));
        
        
    
      }   
      

    

     
     
     public  void TorneoUpdate(ArrayList <Torneos> torneos) throws IOException {
       
      String respuesta = "no";
      
     do {
         
     
  
       Scanner teclado = new Scanner(System.in);
       
    
       System.out.println("Introduce el ID del torneo : ");
       String CodigoTorneo = teclado.nextLine();      
      
       boolean retornoExiste = SiExisteTorneo(torneos,CodigoTorneo);
       
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
        
        
       Torneos cl = new Torneos(CodigoTorneo,CodigoCarrera,TorneoTipo,CodigoActivo);
       
      
      
                     boolean devexiste = false;
             
                        
                        teclado = new Scanner(System.in);



                    

                        System.out.println("- Menu de editar Torneos -");    

                      
                        torneos.add(cl);
                      

                        System.out.println(" Se ha editado correctamente ");
                 
                         break;
                  
     } while (true) ;
        
        
    }
   
    
  
    
     
   
   
   
   
    
    
}
