package com.bazar.service;

import com.bazar.model.Producto;
import com.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepo.deleteById(codigo_producto);
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return productoRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public Producto editProducto(Long codigo_producto, Producto nuevoProducto) {
        Producto producto = this.findProducto(codigo_producto);
        if(producto != null) {
            producto.setNombre(nuevoProducto.getNombre());
            producto.setMarca(nuevoProducto.getMarca());
            producto.setCosto(nuevoProducto.getCosto());
            producto.setCantidad_disponible(nuevoProducto.getCantidad_disponible());
            this.saveProducto(producto);
            return producto;
        }else return null;
    }

    @Override
    public List<Producto> getProductosCantMenorA5() {
        List<Producto> productos = this.getProductos();
        List<Producto> productosMenorCantidad = new ArrayList<>();

        for(Producto produ: productos){
            if(produ.getCantidad_disponible() < 5){
                productosMenorCantidad.add(produ);
            }
        }
        return productosMenorCantidad;
    }
}
