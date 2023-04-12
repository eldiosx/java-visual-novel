package application;

public class CadaverEP1 {

	public static int corpsegirl (int cadaver) {

	int intentos=0;
	//Cuando se seleccione el botón cambia el valor de la variable cadaver
	//Hacemos un while para que vuelva a la imagen inicial mientras no hayas investigado 4 veces
		while (intentos<=4) {
		//Botones
		// Cuando se pincha un botón la variable cadáver cambia de estado y pasa automáticamente al switch
		
			//Boton de: Inspeccionar Cuerpo
			//Boton de: Inspeccionar Sangre
			//Boton de: Inspeccionar Suelo
			//Boton de: Inspeccionar Sala
			//Boton de: Inspeccionar Cuchillo
			//Boton de: Inspeccionar Mano
			
			switch(cadaver) {
			case 1: //Inspeccionar Cuerpo
				System.out.println("Se trata de Nancy. Es compañera de clase de Helen y Marleene. Se ha mudado desde Colorado este septiembre y ha causado un gran revuelo entre los chicos del instituto. ");
				intentos=intentos++;
			case 2:	//Inspeccionar Sangre
				System.out.println("Hay mucha sangre, y el vestido está completamente manchado debido a las múltiples puñaladas que ha recibido la chica");
				intentos=intentos++;
			case 3:	//Inspeccionar Suelo
				System.out.println("No se ven pisadas, y está completamente manchado de sangre, quien lo hizo ha sido bastante cuidadoso con no dejar rastro");
				cadaver=0;
				intentos=intentos++;
			case 4: //Inspeccionar Sala
				System.out.println("Es la  cabaña de las chicas. En ella duermen también Helen y Marleene... El director va a tener que reubicarlas después de esto");
				cadaver=0;
				intentos=intentos++;
			case 5:	//Inspeccionar Cuchillo
				System.out.println("Parece el arma homicida. Es uno de los cuchillos de la cocina del campamento, de eso no hay duda.");
				cadaver=0;
				intentos=intentos++;
			case 6:	//Inspeccionar Mano
				System.out.println("Hay muestras de forcejeo, tiene una de las uñas rotas, probablemente haya conseguido arañar a su agresor.");
				cadaver=0;
				intentos=intentos++;
			default:
				System.out.println("Investiga la habitación para ver qué ha pasado");
			}
		}
		return intentos;

	}
}
