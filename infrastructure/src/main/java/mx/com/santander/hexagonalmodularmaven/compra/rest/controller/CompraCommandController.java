package mx.com.santander.hexagonalmodularmaven.compra.rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.compra.command.CompraCreateHandler;
import mx.com.santander.hexagonalmodularmaven.compra.model.dto.CompraDto;
import mx.com.santander.hexagonalmodularmaven.compra.model.dto.command.CompraCreateCommand;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraCommandController {

    private final CompraCreateHandler compraCreateHandler;


    @PostMapping()
    public CompraDto create(@RequestBody CompraCreateCommand compraCreateCommand){
        return compraCreateHandler.execute(compraCreateCommand);
    }

}
