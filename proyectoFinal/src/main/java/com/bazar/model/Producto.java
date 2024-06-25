package com.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    @ManyToOne
    @JoinColumn(name = "codigo_venta")
    @JsonIgnore
    private Venta venta;

    @JsonIgnore
    public Venta getVenta() {
        return venta;
    }
    @JsonProperty
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
