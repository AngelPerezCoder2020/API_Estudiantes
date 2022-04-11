package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.Producto;

@Service
public class ProductoServiceImp implements ProductosService{
	private static AtomicLong sequence = new AtomicLong();
	
	private List<Producto> listado;
	
	public ProductoServiceImp() {
		listado = new ArrayList<Producto>();
		listado.add(new Producto(sequence.incrementAndGet(),"Televisión","SONY","que se yo master",5000));
		listado.add(new Producto(sequence.incrementAndGet(),"Celular","SAMSUNG","que se yo master",1500));
		listado.add(new Producto(sequence.incrementAndGet(),"Radio","UBUNTU","que se yo master",500));
		listado.add(new Producto(sequence.incrementAndGet(),"Regrigerador","LiverPool","que se yo master",6000));
		listado.add(new Producto(sequence.incrementAndGet(),"Estufa","CASIO","que se yo master",3000));
		listado.add(new Producto(sequence.incrementAndGet(),"Tableta","ALCATEL","que se yo master",600));
	}
	
	@Override
	public void CrearProducto(Producto producto) {
		producto.setId(sequence.incrementAndGet());
		listado.add(producto);
	}

	@Override
	public List<Producto> ListarProductos() {
		return listado;
	}

	@Override
	public void BorrarProducto(Long id) {
		for(Producto a:listado) {
			if(a.getId()==id) {
				listado.remove(a);
			}
		}
	}

	@Override
	public void ActualizarProducto(Long id, Producto producto) {
		for(Producto a:listado) {
			if(a.getId()==id) {
				a.setDescripcion(producto.getDescripcion());
				a.setMarca(producto.getMarca());
				a.setNombre(producto.getNombre());
				a.setPrecio(producto.getPrecio());
			}
		}
	}

	@Override
	public Producto BuscarPorID(Long id) {
		for(Producto a:listado) {
			if(a.getId()==id) {
				return a;
			}
		}
		return null;
	}
}