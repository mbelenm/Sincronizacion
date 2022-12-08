import java.net.*;


//Esta clase representa a una computadora de un sistema distribuido cuyo reloj
//se ve afectado por algoritmos de sincronización.
public class Maquina {
    
    private int iSegundosActuales;
    public DatagramSocket iSocket;
    
  
    public Maquina(InetAddress pDireccion, int pPuerto, int pSegundosIniciales) throws Exception{
        iSocket = new DatagramSocket(pPuerto, pDireccion);
        iSegundosActuales = pSegundosIniciales;
    }
    
   
    public void NotificarTiempoActual(InetAddress pDireccion, int pPuerto) throws Exception{
      
        String datosAEnviar = Integer.toString(iSegundosActuales);
        DatagramPacket paqueteAEnviar = new DatagramPacket(datosAEnviar.getBytes(), datosAEnviar.length(), pDireccion, pPuerto);
        iSocket.send(paqueteAEnviar);
    }
    
  
    public int AvanzarTiempo() throws Exception{
     
        int MAXIMOS_MILISEGUNDOS = 1500;
        byte[] buffer = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
        String mensajeRecibido;
        
        int milisegundosActuales = (int) Math.round(MAXIMOS_MILISEGUNDOS * Math.random());
        

        try{
            iSocket.setSoTimeout(milisegundosActuales);
            iSocket.receive(paqueteRecibido);
            mensajeRecibido = new String(paqueteRecibido.getData()).trim();
            
            
            if (mensajeRecibido.equals("REPORTAR")) {
                NotificarTiempoActual(paqueteRecibido.getAddress(), paqueteRecibido.getPort());
            }
            
          
            else{
                iSegundosActuales = Integer.parseInt(mensajeRecibido);
            }
        }
        
      
        catch (SocketTimeoutException e){
            iSocket.setSoTimeout(0);
            iSegundosActuales++;
        }
        return iSegundosActuales;
    }
}
