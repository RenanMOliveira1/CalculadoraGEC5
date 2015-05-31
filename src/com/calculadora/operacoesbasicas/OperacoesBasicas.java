package com.calculadora.operacoesbasicas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author Tiago
 *	Opera��es B�sicas de Soma, Multiplica��o, Subtra��o e Divis�o
 */

public class OperacoesBasicas {
	private BigDecimal valorA;
	private BigDecimal valorB;
	private BigDecimal resultado;
	
	//Gets e Sets para Leitura dos Valores
	public BigDecimal getValorA() {
		return valorA;
	}

	public void setValorA(BigDecimal valorA) {
		this.valorA = valorA;
	}


	public BigDecimal getValorB() {
		return valorB;
	}


	public void setValorB(BigDecimal valorB) {
		this.valorB = valorB;
	}

	public BigDecimal getResultado() {
		return resultado;
	}

	public void setResultado(BigDecimal resultado) {
		this.resultado = resultado;
	}
	
	//Leitura dos Valores, passando por par�metro os Dados como BigDecimal
	public void lerValores() {
		Scanner input = new Scanner(System.in);
		BigDecimal leituraValores;
		
		System.out.print("Entre com o Valor de A: ");
		leituraValores = new BigDecimal(input.nextLine());
		setValorA(leituraValores);
		System.out.print("Entre com o Valor de B: ");
		leituraValores = new BigDecimal(input.nextLine());
		setValorB(leituraValores);
	}
	
	//Opera��es, com retorno de um valor Double
	public double operacaodeSoma() {
		setResultado(getValorA().add(getValorB()));
		return (getResultado().doubleValue());
	}
	
	public double operacaodeSubtracao() {
		setResultado(getValorA().subtract(getValorB()));
		return (getResultado().doubleValue());
	}
	
	public double operacaodeMultiplicacao() {
		setResultado(getValorA().multiply(getValorB()));
		return (getResultado().doubleValue());
	}
	
	//Na Opera��o Divis�o, retorna o valor, com 2 casas decimais p�s v�rgula,
	//e arredondamento para cima, se n�o fizer isso, d� uma excess�o
	public double operacaodeDivisao() {
		setResultado(getValorA().divide(getValorB(),2,RoundingMode.UP));
		return (getResultado().doubleValue());
	}
	
	//M�todo para se recuperar o resultado direto em Double, sem a necessidade de conta
	public double getResultadoDouble() {
		return (getResultado().doubleValue());
	}
}
