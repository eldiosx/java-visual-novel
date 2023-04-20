package Trash;

import java.util.Scanner;

public class MurderMethods {
	
	 Scanner read= new Scanner (System.in);
     
     /*
      * Episodio 1. Imagen general con la hoguera y los 5 diálogos posibles
      */
     
     int cont=0;
     int personaje=0;
     boolean john=false;
     boolean travis=false;
     boolean marleene=false;
     boolean helen=false;
     boolean chan=false;
     
     while (cont <=3) {
     	
     	personaje= read.nextInt();
     	
     	switch (personaje)  {

			case 1:
				System.out.println("Dialogo de John");
			case 2:
				System.out.println("Dialogo de Travis");
			case 3:
				System.out.println("Dialogo de Marleene");
			case 4:
				System.out.println("Diálogo de Helen");
			case 5:
				System.out.println("Dialogo de Chan");
			default:
				System.out.println("Elige un personaje");
     	}

     }
}

     public void john () {
    /*
     * Diálogo de John
     * Llamada imagen de John
     * Llamada al dialogo de John
     * Llamada audio John
     */
    }
    
    
    
    public void travis () {
    /*
     * Diálogo de Travis
     * Llamada imagen de Travis
     * Llamada al dialogo de Travis
     * Llamada audio Travis
     */
    }
    
    
    
    public void marleene () {
    /*
     * Diálogo de Marleene
     * Llamada imagen de Marleene
     * Llamada al dialogo de Marleene
     * Llamada audio Marleene
     */
    	
    }
    
    
    
    public void helen () {
    /*
     * Diálogo de Helen
     * Llamada imagen de Helen
     * Llamada al dialogo de Helen
     * Llamada audio Helen
     */
    }
    
    
    
    public void chan () {
    /*
     * Diálogo de Chan
     * Llamada imagen de Helen
     * Llamada al dialogo de Helen
     * Llamada audio Helen
     */
    	
    }