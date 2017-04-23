
// TODO: Auto-generated Javadoc
/**
 * The Class dni.
 * @author Bryan
 * 
 * Esta clase es para añadir un dni y comprobar si es un dni real o esta
 * mal escrito (letra incorrecta)
 */
public class dni {

	/** The dni. */
	private int dni;
	
	/** The letra dni. */
	private String letraDni;

	
	// Constructor
	
	/**
	 * Instantiates a new dni.
	 *
	 * @param dni the dni
	 * @param letraDni the letra dni
	 */
	public dni(int dni, String letraDni) {

		this.dni = dni;
		this.letraDni = letraDni;

	}

	// Medotos
	
	/**
	 * Dni completo.
	 *
	 * @return dniCompleto
	 */
	public String dniCompleto(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.getDni()).append("-").append(this.setLetraDni(this.letraDni));
		return sb.toString();
	}
	
	/**
	 * Letra NIF.
	 *
	 * @return letra de DNI real
	 */
	private String letraNIF(){
		int numero = this.dni;
	    int res=numero%23;
	    String[] letrasNIF={"T", "R", "W", "A", "G", "M", "Y",
	                      "F", "P", "D", "X", "B", "N", "J", "Z",
	                      "S", "Q", "V", "H", "L", "C", "K", "E"};
	    return letrasNIF[res];
	}

	/**
	 * Valido.
	 *
	 * @param letra introducida por el usuario
	 * @return comprueba si es letra real
	 */
	private boolean valido(String letra){
		if (this.letraNIF() == letra) return true;
			else {
				return false;
			}
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * Gets the letra dni.
	 *
	 * @return the letra dni
	 */
	public String getLetraDni() {
		return letraDni;
	}

	/**
	 * Sets the letra dni.
	 *
	 * @param letraDni le pasamos la letra del dni
	 * @return si es correcto o no
	 */
	public String setLetraDni(String letraDni) {
		if (this.valido(this.letraDni) == true)
		return this.letraDni = letraDni;
		else throw new IllegalArgumentException("DNI erroneo");
	}
	
	
	
}
