package com.thomas.proyectofinal.service;

import com.thomas.proyectofinal.model.Venta;
import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();

    public void createVenta(Venta venta);

    public Venta findVentaById(Long codigo_venta);

    public Venta editVenta(Long codigo_venta, Venta venta);

    public void deleteVenta(Long codigo_venta);


}
