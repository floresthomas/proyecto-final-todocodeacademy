package com.thomas.proyectofinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaDTO {

    private Long codigo_venta;
    private Double total;
    private Double cantidad_productos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaDTO() {
    }

    public VentaDTO(Long codigo_venta, Double total, Double cantidad_productos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_productos = cantidad_productos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

}
