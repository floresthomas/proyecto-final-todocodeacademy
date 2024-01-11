package com.thomas.proyectofinal.service;

import com.thomas.proyectofinal.dto.VentaDTO;
import com.thomas.proyectofinal.model.Producto;
import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();

    public void createProduct(Producto producto);

    public void deleteProduct(Long id);

    public Producto editProduct(Long codigo_producto, Producto producto);

    public Producto findById(Long id);

    public List<Producto> findByCantidadDisponible();

}
