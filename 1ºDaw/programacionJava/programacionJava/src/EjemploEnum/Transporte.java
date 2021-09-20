package EjemploEnum;

public enum Transporte {
COCHE(60),
CAMION(50),
AVION(600),
TREN(70),
BARCO(20);

public int velocidad;
Transporte(int s) {
	this.velocidad=s;
}

public int getVelocidad() {
	return this.velocidad;
}


}
