
public class AlgoritmoDeLamport {
    
 
    static void SincronizarMaquinas(RegistroMaquina[] pListaDeMaquinas, int pTiempoDeEnvio) throws Exception {
        int indiceActual = 0;
        
       
        while(indiceActual < pListaDeMaquinas.length){
            RegistroMaquina maquinaActual = pListaDeMaquinas[indiceActual];
            
            if (maquinaActual.ObtenerTiempoActual() < pTiempoDeEnvio) {
                maquinaActual.ActualizarTiempo(pTiempoDeEnvio + 1);
            }
            pTiempoDeEnvio++;
            indiceActual++;
        }
    }
}
