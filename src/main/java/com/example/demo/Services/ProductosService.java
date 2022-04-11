package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.Producto;

public interface ProductosService {
	void CrearProducto(Producto producto);
	Producto BuscarPorID(Long id);
	List<Producto> ListarProductos();
	void BorrarProducto(Long id);
	void ActualizarProducto(Long id, Producto producto);
}
