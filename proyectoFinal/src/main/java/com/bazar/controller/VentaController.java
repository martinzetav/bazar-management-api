package com.bazar.controller;

import com.bazar.dto.VentaClienteDTO;
import com.bazar.model.Producto;
import com.bazar.model.Venta;
import com.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    @PostMapping("/crear")
    public String saveVenta(@RequestBody Venta venta){
        ventaServ.saveVenta(venta);
        return "Se creo la venta correctamente";
    }

    @GetMapping("/")
    @ResponseBody
    public List<Venta> getVentas(){
        return ventaServ.getVentas();
    }

    @GetMapping("/{codigo_venta}")
    @ResponseBody
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaServ.findVenta(codigo_venta);
    }

    @DeleteMapping("/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        ventaServ.deleteVenta(codigo_venta);
        return "Se elimino la venta correctamente";
    }

    @PutMapping("/editar/{codigo_venta}")
    public String editVenta(@PathVariable Long codigo_venta, @RequestBody Venta nuevaVenta){
        if(ventaServ.editVenta(codigo_venta, nuevaVenta) != null) return "Se edito la venta correctamente";
        else return "No se encontro ninguna venta con el codigo indicado";
    }

    @GetMapping("/productos/{codigo_venta}")
    @ResponseBody
    public List<Producto> getProductosDeVenta(@PathVariable Long codigo_venta){
        return ventaServ.getProductosDeUnaVenta(codigo_venta);
    }

    @GetMapping("/fecha/{fecha_venta}")
    public String ventaTotalPorFecha(@PathVariable LocalDate fecha_venta){
        return ventaServ.ventasPorDia(fecha_venta);
    }

    @GetMapping("/mayor_venta")
    @ResponseBody
    public ResponseEntity<?> getClienteConMayorVenta(){
        VentaClienteDTO vcDTO = ventaServ.clienteMayorVenta();
        if(vcDTO != null){
            return new ResponseEntity<>(vcDTO, HttpStatus.OK);
        }else return new ResponseEntity<>("No hay ningun cliente que tenga la mayor venta", HttpStatus.NOT_FOUND);
    }



}
