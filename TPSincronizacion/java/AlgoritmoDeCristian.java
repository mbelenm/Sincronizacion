import java.net.*;


public class AlgoritmoDeCristian {
    
    
    public static void SincronizarMaquinas(RegistroMaquina[] pListaDeMaquinas, InetAddress pDireccionServidor, int pPuertoServidor) throws Exception {
       
        int indiceActual = 0;
        int tiempoDeEspera;
        int tiempoDelServidor;
        byte[] buffer = new byte [1024];
        String mensajeAEnviar = "REPORTAR";
        DatagramPacket paqueteAEnviar = new DatagramPacket(mensajeAEnviar.getBytes(), mensajeAEnviar.length(), pDireccionServidor, pPuertoServidor);
        DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
        String mensajeRecibido;
        DatagramSocket socket = new DatagramSocket();
        

        while(indiceActual < pListaDeMaquinas.length){
            RegistroMaquina maquinaActual = pListaDeMaquinas[indiceActual];
            
      
            socket.send(paqueteAEnviar);
            
            
            tiempoDeEspera = 0;
            tiempoDelServidor = 0;
            while(tiempoDelServidor == 0){
                socket.setSoTimeout(1000);
                try{
                    socket.receive(paqueteRecibido);
                    socket.setSoTimeout(0);
                    mensajeRecibido = new String(paqueteRecibido.getData()).trim();
                    tiempoDelServidor = Integer.parseInt(mensajeRecibido);
                }
                catch (SocketTimeoutException e){
                    socket.setSoTimeout(0);
                    tiempoDeEspera++;
                }
            }
            
            
            maquinaActual.ActualizarTiempo(Math.round(tiempoDelServidor+(tiempoDeEspera/2)));
            indiceActual++;
        }
    }
}
