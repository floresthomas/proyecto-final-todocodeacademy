package com.thomas.proyectofinal.controller;

import com.thomas.proyectofinal.model.Venta;
import com.thomas.proyectofinal.service.VentaService;
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
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/ventas/crear")
    public String createVenta(@RequestBody Venta venta) {
        ventaService.createVenta(venta);
        return "Venta creada correctamente";
    }

    @GetMapping("/ventas")
    public List<Venta> getVenta() {
        return ventaService.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVentaById(@PathVariable Long codigo_venta) {
        return ventaService.findVentaById(codigo_venta);
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta) {
        ventaService.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editCliente(@PathVariable Long codigo_venta, Venta venta) {
        return ventaService.editVenta(codigo_venta, venta);
    }

}
