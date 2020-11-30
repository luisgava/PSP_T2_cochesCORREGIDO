import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws Exception {
		try {
			// se crea la carrera
			Carrera carrera = new Carrera();

			// se crean los coches
			final Coche coche1 = new Coche(carrera, "Opel");
			final Coche coche2 = new Coche(carrera, "Ford");
			final Coche coche3 = new Coche(carrera, "Seat");

			// arrancan
			coche1.start();
			coche2.start();
			coche3.start();

			// esperamos que terminen
			coche1.join();
			coche2.join();
			coche3.join();
			
			// tomamos los metros recorridos por cada coche y creamos el podium
			List<Coche> cocheList = new ArrayList();
			cocheList.add(coche1);
			cocheList.add(coche2);
			cocheList.add(coche3);
			
			Collections.sort(cocheList);
			
			System.out.println("--- PODIUM ----");
			System.out.println("ORO: "+cocheList.get(2).getName()+" con "+cocheList.get(2).getDistanciaRecorrida()+" m.");
			System.out.println("PLATA: "+cocheList.get(1).getName()+" con "+cocheList.get(1).getDistanciaRecorrida()+" m.");
			System.out.println("BRONCE: "+cocheList.get(0).getName()+" con "+cocheList.get(0).getDistanciaRecorrida()+" m.");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw e;
		}

	}

}
