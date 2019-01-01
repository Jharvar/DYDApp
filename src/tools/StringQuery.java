package tools;

public class StringQuery {
	
//Constantes que referencian a las clausulas de la base de datos
public static final String SELECT ="SELECT ";
public static final String FROM =" FROM ";
public static final String INSERT_INTO ="INSERT INTO ";
public static final String UPDATE ="UPDATE ";
public static final String DELETE ="DELETE ";
public static final String DROP ="DROP ";
public static final String VALUES =" VALUES ";
public static final String SET =" SET ";
public static final String TABLE=" TABLE";
public static final String DATABASE=" DATABASE";
public static final String OPEN_PARENTESIS="('";
public static final String CLOSE_PARENTESIS="')";
//Array de todas las clausulas de la base de datos
public static final String[] stringsQuerysArray= {SELECT,INSERT_INTO,UPDATE,DELETE,DROP,TABLE,DATABASE,FROM,SET,VALUES};

/**
 * metodo que construye una Query de base de datos y la retorna.
 * @param prefix
 * @param query
 * @param subfix
 * @return String
 */
	public static String buildingQuery(String prefix,String query, String subfix) {
		String buildQuery="";
		for(int i =0; i< stringsQuerysArray.length; i++) {
			if(prefix.equalsIgnoreCase(INSERT_INTO)) {
				buildQuery+= prefix+subfix+OPEN_PARENTESIS+query+CLOSE_PARENTESIS;
			}else if(prefix.equalsIgnoreCase(SELECT)) {
				buildQuery+=prefix+query+subfix;
			}else if(prefix.equals(stringsQuerysArray[i])) {
				buildQuery+=prefix+subfix+query;
			}
		}
		return buildQuery;
	}
	
	

}
