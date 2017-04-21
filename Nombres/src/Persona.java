import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class Persona.
 */
public class Persona {
	
	/**
	 * The Enum Sexo.
	 */
	public static enum Sexo {
/** The hombre. */
HOMBRE,
/** The mujer. */
MUJER}
	
	/** The nombre. */
	private String nombre;
	
	/** The apellidos. */
	private String apellidos;
	
	/** The fecha nacimiento. */
	private Fecha fechaNacimiento;
	
	/** The sexo. */
	private Sexo sexo;
		
	/**
	 * Instantiates a new persona.
	 *
	 * @param nombre the nombre
	 * @param apellidos the apellidos
	 * @param fechaNacimiento the fecha nacimiento
	 * @param sexo the sexo
	 */
	public Persona(String nombre, String apellidos, String fechaNacimiento, Sexo sexo) {
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.fechaNacimiento = new Fecha(fechaNacimiento);
		this.sexo = sexo;
	}	
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = getValidName(nombre);
	}
	
	/**
	 * Gets the valid name.
	 *
	 * @param name the name
	 * @return the valid name
	 */
	private String getValidName(String name) {
		if(isValidName(name)) return capitalize(name);
		else return capitalize(composeValidName(name));
	}
	
	/**
	 * Checks if is valid name.
	 *
	 * @param name the name
	 * @return true, if is valid name
	 */
	public boolean isValidName(String name) {
		String regexp = "(\\s|^)jos[eé](\\s|$)|(\\s|^)mar[ií]?a(\\s|$)|(\\s|^)jes[uú]?s(\\s|$)";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}	
	
	/**
	 * Capitalize.
	 *
	 * @param name the name
	 * @return the string
	 */
	public String capitalize(String name) {
		char[] chars = name.toLowerCase().toCharArray();
		boolean setUpperCase = true;
		for(int i=0;i<chars.length;i++) {
			if(setUpperCase) {
				chars[i] = Character.toUpperCase(chars[i]);
				setUpperCase = false;
			}
			if(Character.isWhitespace(chars[i])) setUpperCase = true;
		}
		return String.valueOf(chars);
	}

	/**
	 * Compose valid name.
	 *
	 * @param name the name
	 * @return the string
	 */
	private String composeValidName(String name) {
		int option = randInt(0, 2);
		switch(option) {
		case 0:
			name+=" josé";
			break;
		case 1:
			name+=" maría";
			break;
		case 2:
			name+=" jesús";
			break;
		}
		return name;
	}
	
	/**
	 * Rand int.
	 *
	 * @param min the min
	 * @param max the max
	 * @return the int
	 */
	public int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = capitalize(apellidos);
	}
	
	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento.getFecha();
	}
	
	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento.setFecha(fechaNacimiento);
	}
	
	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public int getEdad() {
		return this.fechaNacimiento.calcularEdad();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ").append(this.getNombre()).append("\n")
			.append("Apellidos: ").append(this.getApellidos()).append("\n")
			.append("Fecha de nacimiento: ").append(this.fechaNacimiento.getFecha()).append("\n")
			.append("Edad: ").append(this.fechaNacimiento.calcularEdad()).append("\n")
			.append("Sexo: ").append(capitalize(this.sexo.toString())).append("\n");

		return sb.toString();
	}
}
