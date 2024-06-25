package com.bazar.service;

import com.bazar.dto.VentaClienteDTO;
import com.bazar.model.Producto;
import com.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    List<Venta> getVentas();

    void saveVenta(Venta venta);

    void deleteVenta(Long codigo_venta);

    Venta findVenta(Long codigo_venta);

    Venta editVenta(Long codigo_venta, Venta nuevaVenta);

    List<Producto> getProductosDeUnaVenta(Long codigo_venta);

//    List<Venta> findVentaPorFecha(LocalDate fechaVenta);

    String ventasPorDia(LocalDate fechaConsulta);

    VentaClienteDTO clienteMayorVenta();
}
