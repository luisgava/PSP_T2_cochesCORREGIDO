
public class Carrera {
	
	private int distanciaCarrera;
	private boolean finCarrera;
	private static Object object = new Object();
	
	public Carrera() {
		this.distanciaCarrera = 1 + (int)(1000 * Math.random());;
		finCarrera = false;
		System.out.println("Distancia carrera: "+this.distanciaCarrera);
	}
	
	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}
	
	public boolean getFinCarrera() {
		return finCarrera;
	}
	
	public void correr(int distanciaRecorrida, String coche) {
		synchronized (object) {
			
			if (distanciaRecorrida >= distanciaCarrera) {
				finCarrera = true;
				//distanciaRecorrida = distanciaCarrera;
				System.out.println("El coche "+coche+" ha ganado la carrera ¡¡¡¡");
			}
			else {
				System.out.println("El coche "+coche+" lleva recorrida el "+
					distanciaRecorrida * 100 /distanciaCarrera+" % de la distancia");
			}
		}
	}

}
