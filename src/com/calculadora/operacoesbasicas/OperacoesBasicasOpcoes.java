/**
 * 
 */
package com.calculadora.operacoesbasicas;

/**
 * @author Tiago
 * 
 */
public enum OperacoesBasicasOpcoes {
	SOMA("Soma", 1), 
	SUBTRACAO("Subtra��o", 2), 
	MULTIPLICACAO("Multiplica��o", 3), 
	DIVISAO("Divis�o", 4), 
	SAIR("Sair", 0);
	
	private int opcao;
	private String nomeOperacao;
	
	OperacoesBasicasOpcoes(String nomeOperacao, int opcao) {
		this.opcao = opcao;
		this.nomeOperacao = nomeOperacao;
	}
	
	public String nomeOperacao() {
		return nomeOperacao;
	}
	
	public int getNumOpcao() {
		return opcao;
	}
}
