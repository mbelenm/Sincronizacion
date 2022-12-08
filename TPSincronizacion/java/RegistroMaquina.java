import java.net.*;

public class RegistroMaquina {
    
    public InetAddress iDireccion;
    public int iPuerto;
    public DatagramSocket iSocket;
    

    public RegistroMaquina(InetAddress pDireccion, int pPuerto) throws Exception{
        iDireccion = pDireccion;
        iPuerto = pPuerto;
        iSocket = new DatagramSocket();
    }
    
.
    public int ObtenerTiempoActual() throws Exception {
      
        byte[] buffer = new byte[1024];
        String mensajeRecibido;
        String mensajeAEnviar = "REPORTAR";
        DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
        DatagramPacket paqueteAEnviar = new DatagramPacket(mensajeAEnviar.getBytes(), mensajeAEnviar.length(), iDireccion, iPuerto);
        
     
        iSocket.send(paqueteAEnviar);
        iSocket.receive(paqueteRecibido);
        
       
        mensajeRecibido = new String(paqueteRecibido.getData()).trim();
        return Integer.parseInt(mensajeRecibido);
    }
    
    public void ActualizarTiempo(int pNuevoTiempo) throws Exception {
      
       String mensajeAEnviar = Integer.toString(pNuevoTiempo);
       DatagramPacket paqueteAEnviar = new DatagramPacket(mensajeAEnviar.getBytes(), mensajeAEnviar.length(), iDireccion, iPuerto);
       
 
       iSocket.send(paqueteAEnviar);
    }
}
