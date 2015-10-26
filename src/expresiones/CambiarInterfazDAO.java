/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresiones;

import java.util.regex.*;

/**
 *
 * @author David López González
 */
public class CambiarInterfazDAO
{

    public static String cambio(String entity, String tipo, String clase, String obj)
    {

        Pattern patronEntity = Pattern.compile("(XXX)");
        Pattern patronTipo = Pattern.compile("(TIPO)");
        Pattern patronClase = Pattern.compile("(CLASE)");
        Pattern patronObj = Pattern.compile("(obj)");
        String text = "public interface daoInterfaceCLASE\n"
                + "{\n"
                + "	static final EntityManagerFactory emf = Persistence\n"
                + "			.createEntityManagerFactory(\"XXX\");\n"
                + "	static final EntityManager em = emf.createEntityManager();\n"
                + "	static final EntityTransaction transaccion = em.getTransaction();\n"
                + "\n"
                + "	public void alta(CLASE obj);\n"
                + "	public void baja(TIPO id);\n"
                + "	public void modificacion(CLASE obj);\n"
                + "	public CLASE consulta(TIPO id);\n"
                + "	public List<CLASE> consultaAll();\n"
                + "\n"
                + "	public void cerrar();\n"
                + "}";
        Matcher maEntity = patronEntity.matcher(text);
        text = maEntity.replaceAll(entity);
        Matcher maTipo = patronTipo.matcher(text);
        text = maTipo.replaceAll(tipo);
        Matcher maClase = patronClase.matcher(text);
        text = maClase.replaceAll(clase);
        Matcher maObj = patronObj.matcher(text);
        text = maObj.replaceAll(obj);

        return text;
    }

}
