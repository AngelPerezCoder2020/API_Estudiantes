package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Producto;
import com.example.demo.Services.ProductosService;

@RestController
@RequestMapping("/Productos")
public class ControllerPrincipal {
	@Autowired
	ProductosService productosservice;
	@GetMapping()
	public List<Producto> enlistar(){
		return productosservice.ListarProductos();
	}
	@GetMapping("/{id}")
	public Producto BuscarPorId(@PathVariable Long id) {
		return productosservice.BuscarPorID(id);
	}
	@PostMapping()
	public void CrearProducto(@RequestBody Producto producto) {
		productosservice.CrearProducto(producto);
	}
	@PutMapping("/{id}")
	public void ActualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
		productosservice.ActualizarProducto(id, producto);
	}
	@DeleteMapping("/{id}")
	public void EliminarProducto(@PathVariable Long id) {
		productosservice.BorrarProducto(id);
	}
}