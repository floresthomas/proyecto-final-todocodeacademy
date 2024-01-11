package com.thomas.proyectofinal.service;

import com.thomas.proyectofinal.dto.VentaDTO;
import com.thomas.proyectofinal.model.Producto;
import com.thomas.proyectofinal.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository prodRepository;

    @Override
    public List<Producto> getProductos() {
        return prodRepository.findAll();
    }

    @Override
    public void createProduct(Producto producto) {
        prodRepository.save(producto);
    }

    @Override
    public void deleteProduct(Long id) {
        prodRepository.deleteById(id);
    }

    @Override
    public Producto findById(Long id) {
        return prodRepository.findById(id).orElse(null);
    }

    @Override
    public Producto editProduct(Long codigo_producto, Producto producto) {
        Producto prod = this.findById(codigo_producto);

        prod.setNombre(producto.getNombre());
        prod.setMarca(producto.getMarca());
        prod.setCosto(producto.getCosto());
        prod.setCantidad_disponible(producto.getCantidad_disponible());

        return prodRepository.save(producto);
    }

    @Override
    public List<Producto> findByCantidadDisponible() {
        List<Producto> listaProductos = this.getProductos();
        List<Producto> listaProductosByCantidad = new ArrayList<Producto>();

        for (Producto prod : listaProductos) {
            if (prod.getCantidad_disponible() < 5) {
                listaProductosByCantidad.add(prod);
            }
        }

        return listaProductosByCantidad;
    }

}
