package capitulo1;

import javax.enterprise.inject.Model;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

@Model
public class JugadorBean {

    private boolean muestraPrecio = false;
    private int precio = 60941937;
    private boolean muestraImagen = false;

    public void toggleIamgen(ValueChangeEvent event) {
        muestraImagen = !((Boolean) event.getNewValue()).booleanValue();
    }

    public void muestraPrecioMetodo(AjaxBehaviorEvent event) {
        muestraPrecio = true;
    }

    public void ocultaPrecio(AjaxBehaviorEvent event) {
        muestraPrecio = false;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isMuestraPrecio() {
        return muestraPrecio;
    }

    public void setMuestraPrecio(boolean muestraPrecio) {
        this.muestraPrecio = muestraPrecio;
    }

    public boolean isMuestraImagen() {
        return muestraImagen;
    }

    public void setMuestraImagen(boolean muestraImagen) {
        this.muestraImagen = muestraImagen;
    }
}
