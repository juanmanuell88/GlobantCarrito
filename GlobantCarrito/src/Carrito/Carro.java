package Carrito;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Carro {
        
	static Articulo a;
	static FormadePago fp;
	private static Scanner sc;

	
	
	public static void main(String[] args) {
	int descuento;
	int precio;
	int preciofinal = 0;
	int preciototal = 0;
		
	    a = new Articulo();
    	fp = new FormadePago();

		compra();	
	
	    precio =  (int) (a.getPrecio());
		
		if(fp.getFormadepago().equals("credito") )
		{
			descuento = (precio*10)/100; 
		    preciofinal = precio + descuento;
		    preciofinal =  preciofinal * a.getCantidad();
		}
	
		//menos de 100 pesos se considera articulo mas barato
		if(fp.getFormadepago().equals("paypal") && (a.getPrecio() < 100 ))
		{
			precio = 0;  
			preciofinal = preciofinal +  precio;
		
		} 
		
		if(fp.getFormadepago().equals("paypal") && (a.getPrecio() >= 100 ))
		{ 
			preciofinal = preciofinal +  precio;
			preciofinal =  preciofinal * a.getCantidad();
		} 
			
		
	
		//considera mayor a 2000 pesos articulos caros
		if(fp.getFormadepago().equals("efectivo") && (a.getPrecio() > 2000 ))
		{
			descuento = (precio*90)/100;  
		    preciofinal = precio - descuento; 
		    preciofinal =  preciofinal * a.getCantidad();
		   		
		}		
		
		if(fp.getFormadepago().equals("efectivo") && (a.getPrecio() <= 2000 ))
		{
			preciofinal = preciofinal +  precio;
			preciofinal =  preciofinal * a.getCantidad();			
		}		
				
		
		preciototal = preciototal + preciofinal;  
		precio = 0;
		descuento = 0;
		preciofinal=0;

		//falta hacer parte de reingresar un nuevo pedido digamos que pregunte
		  /*       String opc;
		         boolean bandera2=false;
		         while(!bandera2){
		        	 System.out.println ("Ingresar otro articulo al carro?");  
     	        	 System.out.println ("S / N"); 
		        	 opc = sc.next();
		        	 	if(opc.equals("s") ||opc.equals("S")){
		        	 		bandera2=true;
		        	 		compra();
						}
					} 
					
		         */
		
		System.out.println("Precio de compra final de la compra: "+preciototal);
		
	}


	     static void compra() {
	    	 
	    	 try {
	    		 
	    		 System.out.println("Nombre:");
	 			 String nombre=readString();
	 			 a.setNombre(nombre);
	 			 
	 			 System.out.println("Precio:");
	 			 int precio=readInt();
				 a.setPrecio(precio); 
				
				 System.out.println("cantidad:");
				 int cantidad=readInt();
				 a.setCantidad(cantidad);
				 
				 boolean bandera=false;
							 
					//credito, paypal, efectivo
				    bandera=false;
					String formadepago="";
					while(!bandera){
						System.out.println("Forma de Pago:");
						formadepago=readString();
						if(formadepago.equals("efectivo") ||formadepago.equals("paypal")||formadepago.equals("credito")){
							bandera=true;
						}
					}
					fp.setFormadepago(formadepago);
				
				 
	 			 
	    	 }catch (Exception e) {
	 			System.out.println("Error");
	 		}
		
	}

	     
//Metodos para  scanner float, int y string
		private static float readFloat() {
			Scanner sc = new Scanner(System.in);
			return sc.nextFloat();
		}


		private static int readInt() {
			sc = new Scanner(System.in);
			return sc.nextInt();
		}


		private static String readString() throws Exception {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
					return br.readLine();
				}
		}

	

