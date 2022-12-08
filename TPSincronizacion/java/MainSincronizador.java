import java.util.*;
import java.net.*;


public class MainSincronizador {
    
    public static void main(String[] args) throws Exception{
  
        Scanner scanner = new Scanner(System.in);
        ArrayList<RegistroMaquina> listaDeMaquinas = new ArrayList<RegistroMaquina>();
        RegistroMaquina[] arrayDeMaquinas;
        String opcion = "";
        InetAddress direccionMaquina;
        int puertoMaquina;
        
     
        while(!opcion.equals("0")){
            System.out.println("1 - Agregar máquina");
            System.out.println("2 - Sincronizar con algoritmo de Lamport");
            System.out.println("3 - Sincronizar con algoritmo de Berkeley");
            System.out.println("4 - Sincronizar con algoritmo de Cristian");
            System.out.println("0 - Salir");        
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextLine();
            
            switch(opcion) {
                
                
                case "1":
                    
                    System.out.print("Dirección de la máquina: ");
                    direccionMaquina = InetAddress.getByName(scanner.nextLine());
                    System.out.print("Puerto de la máquina: ");
                    puertoMaquina = Integer.parseInt(scanner.nextLine());
                    
                    
                    listaDeMaquinas.add(new RegistroMaquina(direccionMaquina, puertoMaquina));
                    System.out.println("La máquina ha sido agregada exitosamente.");
                    break;
                
            
                case "2":
                 
                    System.out.print("Tiempo de envío: ");
                    int tiempoDeEnvio = Integer.parseInt(scanner.nextLine());
                    
                 
                    arrayDeMaquinas = new RegistroMaquina[listaDeMaquinas.size()];
                    listaDeMaquinas.toArray(arrayDeMaquinas);
                    
           .
                    AlgoritmoDeLamport.SincronizarMaquinas(arrayDeMaquinas, tiempoDeEnvio);
                    System.out.println("Las máquinas han sido sincronizadas exitosamente.");
                    break;
                

                case "3":
                
                    arrayDeMaquinas = new RegistroMaquina[listaDeMaquinas.size()];
                    listaDeMaquinas.toArray(arrayDeMaquinas);
                    
                    //Sincroniza las máquinas y avisa al usuario que se logró
                    //correctamente.
                    AlgoritmoDeBerkeley.SincronizarMaquinas(arrayDeMaquinas);
                    System.out.println("Las máquinas han sido sincronizadas exitosamente.");
                    break;
                    
                case "4":
                    //Pide dirección y del servidor de tiempo puerto al usuario.
                    System.out.print("Dirección de la máquina: ");
                    direccionMaquina = InetAddress.getByName(scanner.nextLine());
                    System.out.print("Puerto de la máquina: ");
                    puertoMaquina = Integer.parseInt(scanner.nextLine());
                    
                    //Transforma el ArrayList en un array para recorrerlo más
                
                    arrayDeMaquinas = new RegistroMaquina[listaDeMaquinas.size()];
                    listaDeMaquinas.toArray(arrayDeMaquinas);
                    
                    //Sincroniza las máquinas y avisa al usuario que se logró
                  
                    AlgoritmoDeCristian.SincronizarMaquinas(arrayDeMaquinas, direccionMaquina, puertoMaquina);
                    System.out.println("Las máquinas han sido sincronizadas exitosamente.");
                    break;
                    
                case "0":
                    System.out.println("Hasta luego.");
                    break;
                    
                default:
                    System.out.println("La opción ingresada no existe. Intente nuevamente.");
                    break;
            }
        }
    }
}
