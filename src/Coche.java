public class Coche extends Thread implements Comparable<Coche> {
	
	private int metrosAvance;
	private int distanciaRecorrida;
	private Carrera carrera;
	
	public Coche(Carrera carrera, String nombre) {
			
			this.metrosAvance = 1 + (int)(50 * Math.random());;
			this.distanciaRecorrida = 0;
			this.carrera = carrera;
			this.setName(nombre);
			System.out.println("El coche "+nombre+" avanza "+metrosAvance+" metros cada vez.");
		}

	@Override
	public void run() {
		while (!carrera.getFinCarrera()) {
			
			distanciaRecorrida = distanciaRecorrida + metrosAvance;
			carrera.correr(distanciaRecorrida, this.getName());
						
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	@Override
	public int compareTo(Coche coche) {
		return Integer.valueOf(this.distanciaRecorrida).compareTo(coche.getDistanciaRecorrida());
	}

}
