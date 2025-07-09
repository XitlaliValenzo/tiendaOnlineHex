package mx.com.santander.hexagonalmodularmaven.producto.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.query.ProductoByIdHandler;
import mx.com.santander.hexagonalmodularmaven.producto.query.ProductoGetAllHandler;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoQueryController {

    private final ProductoGetAllHandler productoGetAllHandler;
	private final ProductoByIdHandler productoByIdHandler;

	@GetMapping
	public List<ProductoDto> getAll() {
		return productoGetAllHandler.execute();
	}

	@GetMapping("/{id}")
	public ProductoDto getById(@PathVariable("id") long id) {
		return productoByIdHandler.execute(id);
	}

}
