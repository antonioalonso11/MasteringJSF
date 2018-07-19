package capitulo2;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import java.util.Map;
import java.util.logging.Logger;

@Model
public class Parametros {

    private Logger logger = Logger.getLogger(getClass().getName());

    private String nombre;

    public String parametrosAccion() {
        Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        logger.info(parametros.get("nombre"));
        return "parametros2";
    }

}
