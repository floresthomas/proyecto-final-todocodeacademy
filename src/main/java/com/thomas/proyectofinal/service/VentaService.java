package com.thomas.proyectofinal.service;

import com.thomas.proyectofinal.dto.VentaDTO;
import com.thomas.proyectofinal.model.Venta;
import com.thomas.proyectofinal.repository.IVentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void createVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public Venta findVentaById(Long codigo_venta) {
        return ventaRepository.findById(codigo_venta).orElse(null);
    }

    @Override
    public Venta editVenta(Long codigo_venta, Venta venta) {
        Venta ventaEncontrada = this.findVentaById(codigo_venta);

        ventaEncontrada.setFecha_venta(venta.getFecha_venta());
        ventaEncontrada.setListaProductos(venta.getListaProductos());
        ventaEncontrada.setUnCliente(venta.getUnCliente());
        ventaEncontrada.setTotal(venta.getTotal());

        return ventaRepository.save(ventaEncontrada);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepository.deleteById(codigo_venta);
    }


}
