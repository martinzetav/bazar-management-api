package com.bazar.service;

import com.bazar.model.Producto;

import java.util.List;

public interface IProductoService{

    List<Producto> getProductos();

    void saveProducto(Producto producto);

    void deleteProducto(Long codigo_producto);

    Producto findProducto(Long codigo_producto);

    Producto editProducto(Long codigo_producto, Producto nuevoProducto);

    List<Producto> getProductosCantMenorA5();

}
