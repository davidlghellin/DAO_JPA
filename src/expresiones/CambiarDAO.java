/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresiones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author David López González
 */
public class CambiarDAO
{

    public static String cambiar(String tipo, String clase, String obj)
    {
        Pattern patronTipo = Pattern.compile("(TIPO)");
        Pattern patronClase = Pattern.compile("(CLASE)");
        Pattern patronTabla = Pattern.compile("(TCLASE)");
        Pattern patronObj = Pattern.compile("(obj)");
        String text = "public class CLASEDAO implements daoInterfaceCLASE\n"
                + "{\n"
                + "\n"
                + "	@Override\n"
                + "	public void alta(CLASE obj)\n"
                + "	{\n"
                + "		transaccion.begin();\n"
                + "		em.persist(obj);\n"
                + "		transaccion.commit();\n"
                + "	}\n"
                + "\n"
                + "	@Override\n"
                + "	public void baja(TIPO id)\n"
                + "	{\n"
                + "		transaccion.begin();\n"
                + "		CLASE obj = em.find(CLASE.class, id);\n"
                + "		em.remove(obj);\n"
                + "		transaccion.commit();\n"
                + "	}\n"
                + "\n"
                + "	@Override\n"
                + "	public void modificacion(CLASE obj)\n"
                + "	{\n"
                + "		transaccion.begin();\n"
                + "		em.merge(obj);\n"
                + "		transaccion.commit();\n"
                + "	}\n"
                + "\n"
                + "	@Override\n"
                + "	public CLASE consulta(TIPO id)\n"
                + "	{\n"
                + "		transaccion.begin();\n"
                + "		CLASE obj = em.find(CLASE.class, id);\n"
                + "		transaccion.commit();\n"
                + "		return obj;\n"
                + "	}\n"
                + "\n"
                + "	@Override\n"
                + "	public List<CLASE> consultaAll()\n"
                + "	{	\n"
                + "		Query query = em.createQuery(\"SELECT a FROM TCLASE a\", CLASE.class);\n"
                + "		transaccion.begin();\n"
                + "		List<CLASE> mis = query.getResultList();\n"
                + "		transaccion.commit();\n"
                + "		return mis;\n"
                + "	}\n"
                + "\n"
                + "	@Override\n"
                + "	public void cerrar(){em.close();}\n"
                + "\n"
                + "}";
        Matcher maTipo = patronTipo.matcher(text);
        text = maTipo.replaceAll(tipo);
        Matcher maClase = patronClase.matcher(text);
        text = maClase.replaceAll(clase);
        Matcher maObj = patronObj.matcher(text);
        text = maObj.replaceAll(obj);
       // Matcher maTabla = patronTabla.matcher(text);
        //text = maTabla.replaceAll(nombretabla);
        
        return text;
    }
}
