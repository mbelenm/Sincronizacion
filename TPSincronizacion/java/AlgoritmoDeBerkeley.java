

//Esta clase se utiliza para sincronizar máquinas mediante el algoritmo de Berkeley.
public class AlgoritmoDeBerkeley {
    
    public static void SincronizarMaquinas(RegistroMaquina[] pListaDeMaquinas) throws Exception {
   
        int indiceActual = 0;
        int tiempoPromedio = 0;
        
       
        while(indiceActual < pListaDeMaquinas.length){
            RegistroMaquina maquinaActual = pListaDeMaquinas[indiceActual];
            
           
            tiempoPromedio += maquinaActual.ObtenerTiempoActual();
            indiceActual++;
        }
        
        
        tiempoPromedio = Math.round(tiempoPromedio / pListaDeMaquinas.length);
        
        
        indiceActual = 0;
        while(indiceActual < pListaDeMaquinas.length){
            RegistroMaquina maquinaActual = pListaDeMaquinas[indiceActual];
            maquinaActual.ActualizarTiempo(tiempoPromedio);
            indiceActual++;
        }
    }
}
