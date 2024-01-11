package com.thomas.proyectofinal.controller;

import com.thomas.proyectofinal.model.Producto;
import com.thomas.proyectofinal.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService prodService;

    @PostMapping("/productos/crear")
    public String createProducts(@RequestBody Producto producto) {
        prodService.createProduct(producto);
        return "Producto creado correctamente";
    }

    @GetMapping("/productos")
    public List<Producto> getProducts() {
        return prodService.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto getProductById(@PathVariable Long codigo_producto) {
        return prodService.findById(codigo_producto);
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProduct(@PathVariable Long codigo_producto) {
        prodService.deleteProduct(codigo_producto);
        return "Producto eliminado correctamente";
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProduct(@PathVariable Long codigo_producto, @RequestBody Producto producto) {
        return prodService.editProduct(codigo_producto, producto);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> productosByCantidadDisponible() {
        return prodService.findByCantidadDisponible();
    }

}
