package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

@Entity //Indica a una clase de java que esta representando una tabla de nuestra BD.
//@Table: Recibe el nombre de la tabla a la cual esta mapeando la clase.
@Table(name = "productos") //Con esto java ya sabra que hablo de la tabla productos
public class Producto {

    //Es muy importante que no se use int -> sino por su objeot
    //no es buena practica declarar de esta manera id_Producto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Con esto decidimos que es la llave primaria -> java genera este valor de manera automatica
    @Column(name = "id_producto") //con esto indicamos que id_producto asi esta en nuestra tabla
    private Integer idProducto;

    //como no se cambia el nombre de la variable en la bd nombre, entonces no se pone nada
    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_ventas")
    private Double precioVenta;

    @Column(name = "cantidad-stock")
    private Integer cantidadStock;

    private Boolean estado;

    /*Se crea este nuevo atributo
    * Se le define su relacion entre las tablas: La clase producto esta relacionada con Categoria
    * Mediante esta relacion no vamos a insertar ni actualizar Cateogira, eso significa los dos atributos insertable y updatable
    * */
    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
