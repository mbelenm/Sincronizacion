import java.net.InetAddress;
import java.util.Scanner;



public class MainMaquina {
    
    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        int segundosActuales = 0;
        
       
        System.out.print("La máquina funciona en la dirección: ");
        InetAddress direccionMaquina = InetAddress.getByName(scanner.nextLine());
        System.out.print("En el puerto: ");
        int puertoMaquina = Integer.parseInt(scanner.nextLine());
        Maquina maquinaActual = new Maquina(direccionMaquina, puertoMaquina, segundosActuales);
        System.out.println("La máquina está funcionando en el puerto "+puertoMaquina+" de la dirección "+direccionMaquina);
        
     
        while(true){
            segundosActuales = maquinaActual.AvanzarTiempo();
            System.out.println("Tiempo actual de la máquina: "+segundosActuales+" segundos");
        }
    }
}
