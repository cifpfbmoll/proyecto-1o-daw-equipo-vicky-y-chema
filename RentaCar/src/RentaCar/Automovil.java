/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

/**
 *
 * @author Chema
 */
public class Automovil {

    /*Atributos precioDia es Double para poder checkear si está a nulo*/
    private String matricula;
    private String marca;
    private String modelo;
    private Double precioDia;
    private String clase;

    /**
     * Constructor vacío
     */
    public Automovil() {

    }

    /**
     * Constructor con parametros
     *
     * @param matricula
     * @param marca
     * @param modelo
     * @param precioDia coste por dia de alquiler
     * @param clase categoria del vehiculo
     */
    public Automovil(String matricula, String marca, String modelo, double precioDia, String clase) {
        this.setMatricula(matricula);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPrecioDia(precioDia);
        this.setClase(clase);
    }

    /**
     * Constructor copia
     *
     * @param v1 Vehiculo recibido
     */
    public Automovil(Automovil v1) {
        this.setMatricula(v1.getMatricula());
        this.setMarca(v1.getMarca());
        this.setModelo(v1.getModelo());
        this.setPrecioDia(v1.getPrecioDia());
        this.setClase(v1.getClase());
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(Double precioDia) {
        this.precioDia = precioDia;
    }

    public static String selectAutomoviles() {
        return "SELECT *, CASE WHEN EXISTS (SELECT matricula FROM especificaciones_coches c WHERE c.matricula = v.matricula) THEN 'coche'" +
                "WHEN EXISTS (SELECT matricula FROM especificaciones_caravanas c WHERE c.matricula = v.matricula) THEN 'caravana'" +
                "WHEN EXISTS (SELECT matricula FROM especificaciones_motos c WHERE c.matricula = v.matricula) THEN 'moto'" +
                "end as tipo FROM vehiculos v;";
    }
}
