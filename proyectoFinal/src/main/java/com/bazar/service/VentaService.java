package com.bazar.service;

import com.bazar.dto.VentaClienteDTO;
import com.bazar.model.Producto;
import com.bazar.model.Venta;
import com.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public Venta editVenta(Long codigo_venta, Venta nuevaVenta) {
        Venta venta = this.findVenta(codigo_venta);
        if (venta != null) {
            venta.setFechaVenta(nuevaVenta.getFechaVenta());
            venta.setTotal(nuevaVenta.getTotal());
            venta.setLista_productos(nuevaVenta.getLista_productos());
            venta.setCliente(nuevaVenta.getCliente());
            this.saveVenta(venta);
            return venta;
        } else return null;
    }

    @Override
    public List<Producto> getProductosDeUnaVenta(Long codigo_venta) {
        Venta venta = this.findVenta(codigo_venta);
        return venta.getLista_productos();
    }

//    @Override
//    public List<Venta> findVentaPorFecha(LocalDate fechaVenta) {
//        return ventaRepo.findByFechaVenta(fechaVenta);
//    }


    public String ventasPorDia(LocalDate fechaConsulta) {
        List<Venta> listaVentas = this.getVentas();

        double totalProductos = 0;
        double ventasTotales = 0;

        for (Venta venta : listaVentas) {
            if (venta.getFechaVenta().isEqual(fechaConsulta)) {
                ventasTotales += venta.getTotal();
                for (Producto produ : venta.getLista_productos()) {
                    totalProductos += produ.getCosto();
                }
            }
        }

        if (totalProductos > 0) {
            return "El monto total de productos es de " + totalProductos + " con una cantidad de ventas totales de " + ventasTotales;
        }

        return "Las ventas suman un total de " + ventasTotales + " y sin productos";
    }

    public VentaClienteDTO clienteMayorVenta(){
        List<Venta> listaVentas = this.getVentas();

        if(listaVentas.isEmpty()) return null;


        VentaClienteDTO clienteConMayorVenta = new VentaClienteDTO();
        Double totalMayorDeVenta = listaVentas.get(0).getTotal();

        for(Venta venta: listaVentas){
            if(venta.getTotal() > totalMayorDeVenta){
                totalMayorDeVenta = venta.getTotal();
                clienteConMayorVenta.setCodigoVenta(venta.getCodigo_venta());
                clienteConMayorVenta.setTotal(venta.getTotal());
                clienteConMayorVenta.setCantidadProductos(venta.getLista_productos().size());
                clienteConMayorVenta.setNombreCliente(venta.getCliente().getNombre());
                clienteConMayorVenta.setApellidoCliente(venta.getCliente().getApellido());
            }
        }

        return clienteConMayorVenta;

    }


}
