package mx.com.santander.hexagonalmodularmaven.compra.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.compra.mapper.CompraDtoMapper;
import mx.com.santander.hexagonalmodularmaven.compra.model.dto.CompraDto;
import mx.com.santander.hexagonalmodularmaven.compra.model.dto.command.CompraCreateCommand;
import mx.com.santander.hexagonalmodularmaven.compra.service.CompraCreateService;

@Component
@RequiredArgsConstructor
public class CompraCreateHandler {
    private final CompraCreateService compraCreateService;
    private final CompraDtoMapper compraDtoMapper;

    public CompraDto execute(CompraCreateCommand compraCreateCommand){
        return compraDtoMapper.toDto(compraCreateService.execute(compraCreateCommand));
    }

}
