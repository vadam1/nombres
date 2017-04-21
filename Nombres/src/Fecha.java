import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * la Clase Fecha.
 */
public class Fecha {
	
	/** el dia. */
	private int dia;
	
	/** el mes. */
	private int mes;
	
	/** el ano. */
	private int ano;
	
	/** la Constante FORMATOFECHA. */
	public static final String FORMATOFECHA = "dd/MM/yyyy";
	
	/** la Constante FORMATOMYSQL. */
	public static final String FORMATOMYSQL = "yyyy-MM-dd";

	
	/**
	 * Instancias a nueva fecha.
	 *
	 * @param fecha de fecha
	 */
	public Fecha(String fecha) {
		this.setFecha(fecha);
	}
	
	/**
	 * Comprueba formato fecha.
	 *
	 * @param fecha de fecha
	 * @return true, if successful
	 */
	private boolean compruebaFormatoFecha(String fecha) {
		String regex = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
		return fecha.matches(regex);
	}
	
	/**
	 * Comprueba validez fecha.
	 *
	 * @param fecha de fecha
	 * @return true, if successful
	 */
	private boolean compruebaValidezFecha(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATOFECHA);
		sdf.setLenient(false);
		boolean esValida = true;
		try {
			sdf.parse(fecha);
		} catch (ParseException e) {
			esValida = false;
		}
		return esValida;
	}
	
	/**
	 * Comprueba fecha.
	 *
	 * @param fecha de fecha
	 * @return true, if successful
	 */
	public boolean compruebaFecha(String fecha) {
		if(!compruebaFormatoFecha(fecha)) return false;
		else return compruebaValidezFecha(fecha);
	}
	
	/**
	 * Calcular edad.
	 *
	 * @return de int
	 */
	public int calcularEdad() {		
	    LocalDate ahora = LocalDate.now();
	    int anoFecha = this.getAno();
	    // Fecha no valida
	    if(anoFecha==0) return -1;
	    int mesFecha = this.getMes();
	    int diaFecha = this.getDia();
	    
	    int anoHoy = ahora.getYear();
	    int mesHoy = ahora.getMonthValue();
	    int diaHoy = ahora.getDayOfMonth();
	    
	    int edad = anoHoy - anoFecha;
	    if(mesHoy<mesFecha) edad--;
	    else if(mesHoy==mesFecha&&diaHoy<diaFecha) edad--;
		
	    return edad;
	}
	
	
	/**
	 * Sets de fecha.
	 *
	 * @param fecha de nueva fecha
	 */
	public void setFecha(String fecha) {
		int[] arrayFecha = this.obtenerArrayFecha(fecha);
		this.setDia(arrayFecha[0]);
		this.setMes(arrayFecha[1]);
		this.setAno(arrayFecha[2]);
	}
	
	/**
	 * Obtener array fecha.
	 *
	 * @param fecha de fecha
	 * @return de int[]
	 */
	private int[] obtenerArrayFecha(String fecha) {
		String[] arrayString = fecha.split("/");
		int[] arrayEntero = {0,0,0};
		if(this.compruebaFecha(fecha)) {
			for(int i=0;i<3;i++)
				arrayEntero[i] = Integer.parseInt(arrayString[i]);
		}
		return arrayEntero;
	}
	
	/**
	 * Gets de fecha formato my SQL.
	 *
	 * @return de fecha formato my SQL
	 */
	public String getFechaFormatoMySQL() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getAno()).append("-")
			.append(this.getMes()).append("-")
			.append(this.getDia());
		return sb.toString();
		
	}
	
	/**
	 * Gets de fecha.
	 *
	 * @return de fecha
	 */
	public String getFecha() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%02d", this.getDia())).append("/")
			.append(String.format("%02d", this.getMes())).append("/")
			.append(String.format("%04d",this.getAno()));
		return sb.toString();
	}

	/**
	 * Gets de dia.
	 *
	 * @return de dia
	 */
	public int getDia() {
		return dia;
	}
	
	/**
	 * Sets de dia.
	 *
	 * @param dia de nuevo dia
	 */
	private void setDia(int dia) {
		this.dia = dia;
	}
	
	/**
	 * Gets de mes.
	 *
	 * @return de mes
	 */
	public int getMes() {
		return mes;
	}
	
	/**
	 * Sets de mes.
	 *
	 * @param mes de new mes
	 */
	private void setMes(int mes) {
		this.mes = mes;
	}
	
	/**
	 * Gets de ano.
	 *
	 * @return de ano
	 */
	public int getAno() {
		return ano;
	}
	
	/**
	 * Sets de ano.
	 *
	 * @param ano the new ano
	 */
	private void setAno(int ano) {
		this.ano = ano;
	}
	
	/**
	 * Gets de formatofecha.
	 *
	 * @return de formatofecha
	 */
	public static String getFormatofecha() {
		return FORMATOFECHA;
	}
}
