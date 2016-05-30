package com.calculadora.service;

import java.math.BigDecimal;

import com.calculadora.util.TipoOperacao;

public interface OperacoesBasicasService {
	
	public BigDecimal calcular(BigDecimal valor1, BigDecimal valor2, TipoOperacao tipoOperacao);
	public BigDecimal calcularRaizQuadrada(BigDecimal valor);
}
