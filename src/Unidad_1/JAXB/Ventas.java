
package Unidad_1.JAXB;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ventas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ventas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="venta" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="numventa" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="unidades"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                         &lt;maxExclusive value="100"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="nombrecliente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ventas", propOrder = {
    "venta"
})
public class Ventas {

    @XmlElement(required = true)
    protected List<Ventas.Venta> venta;

    /**
     * Gets the value of the venta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the venta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVenta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ventas.Venta }
     * 
     * 
     */
    public List<Ventas.Venta> getVenta() {
        if (venta == null) {
            venta = new ArrayList<Ventas.Venta>();
        }
        return this.venta;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="numventa" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="unidades"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *               &lt;maxExclusive value="100"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="nombrecliente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "numventa",
        "unidades",
        "nombrecliente",
        "fecha"
    })
    public static class Venta {

        @XmlElement(required = true)
        protected BigInteger numventa;
        protected int unidades;
        @XmlElement(required = true)
        protected String nombrecliente;
        @XmlElement(required = true)
        protected String fecha;

        /**
         * Obtiene el valor de la propiedad numventa.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNumventa() {
            return numventa;
        }

        /**
         * Define el valor de la propiedad numventa.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNumventa(BigInteger value) {
            this.numventa = value;
        }

        /**
         * Obtiene el valor de la propiedad unidades.
         * 
         */
        public int getUnidades() {
            return unidades;
        }

        /**
         * Define el valor de la propiedad unidades.
         * 
         */
        public void setUnidades(int value) {
            this.unidades = value;
        }

        /**
         * Obtiene el valor de la propiedad nombrecliente.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombrecliente() {
            return nombrecliente;
        }

        /**
         * Define el valor de la propiedad nombrecliente.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombrecliente(String value) {
            this.nombrecliente = value;
        }

        /**
         * Obtiene el valor de la propiedad fecha.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFecha() {
            return fecha;
        }

        /**
         * Define el valor de la propiedad fecha.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFecha(String value) {
            this.fecha = value;
        }

    }

}
