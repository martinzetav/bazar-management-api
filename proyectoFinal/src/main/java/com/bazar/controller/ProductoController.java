package com.bazar.controller;

import com.bazar.model.Producto;
import com.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productServ;

    @PostMapping("/crear")
    public String saveProducto(@RequestBody Producto producto){
        productServ.saveProducto(producto);
        return "Se creo el producto correctamente";
    }

    @GetMapping("/")
    @ResponseBody
    public List<Producto> getProductos(){
        return productServ.getProductos();
    }

    @GetMapping("/{codigo_producto}")
    @ResponseBody
    public Producto findProducto(@PathVariable Long codigo_producto){
        return productServ.findProducto(codigo_producto);
    }

    @DeleteMapping("/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        productServ.deleteProducto(codigo_producto);
        return "Se elimino el producto correctamente";
    }

    @PutMapping("/editar/{codigo_producto}")
    public String editProducto(@PathVariable Long codigo_producto, @RequestBody Producto nuevoProducto){
        if(productServ.editProducto(codigo_producto, nuevoProducto) != null) return "Se edito el producto correctamente";
        else return "No se encontro ningun producto con el codigo indicado";
    }

    @GetMapping("/falta_stock")
    @ResponseBody
    public List<Producto> getProductosCantMenorA5(){
        return productServ.getProductosCantMenorA5();
    }

}
