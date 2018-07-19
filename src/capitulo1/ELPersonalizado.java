package capitulo1;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.PropertyNotFoundException;
import javax.el.PropertyNotWritableException;
import java.beans.FeatureDescriptor;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ELPersonalizado extends ELResolver{

    private Logger logger = Logger.getLogger(getClass().getName());
    private static final String PLAYERS = "atp";

    /**
     * Este es el método más importante de la clase ELResolver. La implementación de este método regresasras un objecto
     * del tipo ATP si la propiedad de la petición es nombrada atp
     * @param elContext Contextp para el lenguaje de expresión
     * @param base Base del lenguaje de expresión
     * @param property Propiedad del lenguaje de expresión
     * @return Lista con los elementos
     */
    @Override
    public Object getValue(ELContext elContext, Object base, Object property) {
        logger.log(Level.FINE,"Valor pasado : {0}", property);
        if (base == null && property.equals(PLAYERS)) {
            elContext.setPropertyResolved(true);
            return ATPMejores.recuperaLista();
        }
        return null;
    }

    /**
     * Este método identifica el tipo el más aceptable para nuestra propiedad. El alcance de este método está determinado
     * si se llama de forma segura al método setValue sin lanzar la excepción: ClassCastException. Desde que regresamos
     * una colección, podemos decir que el tipo general aceptable en List
     * @param elContext Contexto para el lenguaje de expresión
     * @param base Base del lenguaje de expresión
     * @param property Propiedad del lenguaje de expresión.
     * @return Tipo el cual proceso
     */
    @Override
    public Class<?> getType(ELContext elContext, Object base, Object property) {
        if(base != null) {
            return null;
        }
        if (property == null) {
            throw new PropertyNotFoundException("Parametro nulo con mensaje");
        }
        if (base == null && property.equals(PLAYERS)) {
            elContext.setPropertyResolved(true);
            return List.class;
        }
        return null;
    }

    /**
     * Este método trata de establecer el valor para una propiedad y base dados. Para variables de sólo lectura, tal
     * como atp, necesitas lanzar una excepción del tipo PropertyNotWritableException.
     * @param elContext Contexto para el lenguaje de expresión
     * @param base Base del lenguaje de expresión
     * @param property Propiedad del lenguaje de expresión.
     * @param value Valor a ser establecido
     */
    @Override
    public void setValue(ELContext elContext, Object base, Object property, Object value) {
        if (base != null) {
            return;
        }
        elContext.setPropertyResolved(false);
        if (property == null) {
            throw new PropertyNotFoundException("Propiedad no encontradp");
        }
        if (PLAYERS.equals(property)) {
            throw new PropertyNotWritableException((String) property);
        }
    }

    /**
     * Este método regresa true si la variable es de sólo lectura y false en otro caso. Para apt es de sólo lectura, la
     * implemetación es obvia. Este métod está directamente relacionado con setValue sin obtener
     * PropertyNotWritableException como respuesta
     * @param elContext
     * @param base
     * @param property
     * @return
     */
    @Override
    public boolean isReadOnly(ELContext elContext, Object base, Object property) {
        return true;
    }

    /**
     * Este método recupera un conjunto de Descritores a cerca de las variables o propiedades que pueden ser resueltas
     * para permitir el autocompletado
     * @param elContext Contexto para el leguaje de expresión
     * @param base Base para el lenguaje de expresión
     * @return
     */
    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext elContext, Object base) {
        FeatureDescriptor featureDescriptor = new FeatureDescriptor();
        return null;
    }

    /**
     * Este método regresa el tipo general que el resolver acepta
     * @param elContext Contexto para la propiedad
     * @param base Base para el lenguaje de expresión
     * @return
     */
    @Override
    public Class<?> getCommonPropertyType(ELContext elContext, Object base) {
        if (base != null) {
            return null;
        }
        return String.class;
    }
}
