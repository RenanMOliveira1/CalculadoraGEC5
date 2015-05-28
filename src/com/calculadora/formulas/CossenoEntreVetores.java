// CossenoEntreVetores.java
// Faz a f�rmula do c�lculo do cosseno do �ngulo de dois vetores
package com.calculadora.formulas;

// importando a classe ModuloVetor para poder utilizar o m�todo calculaModuloVetor
import com.calculadora.vetores.ModuloVetor;
// importanto a classe ProdutoEscalar para poder utilizar o m�todo fazProduto
import com.calculadora.vetores.ProdutoEscalar;

//importando a classe Scanner para a leitura de dados
import java.util.Scanner;

// representa o c�lculo do cosseno entre dois vetores
public class CossenoEntreVetores {
	
	// o termo final � utilizado porque se trata de uma constante
	final int MAX_INDEX = 3;
	
	double resultado;
	
	double[] vetor1 = new double[MAX_INDEX];
	double[] vetor2 = new double[MAX_INDEX];
	
	Scanner input = new Scanner(System.in);
	
	
	
	// Obt�m o valor de vetor1
	public void setVetor1(double[] vetor1) {
		this.vetor1 = vetor1;
	}
	
	// retorna o valor de vetor1
	public double[] getVetor1() {
		return vetor1;
	}
	
	// Obt�m o valor de vetor2
	public void setVetor2(double[] vetor2) {
		this.vetor2 = vetor2;
	}
	
	// retorna o valor de vetor2
	public double[] getVetor2() {
		return vetor2;
	}
	
	// l� e retorna as tres coordenadas de um vetor 
	public double[] leVetor() {
		double[] vetor = new double[MAX_INDEX];
		
		for(int contador = 0; contador < MAX_INDEX; contador++){
			// para cada posi��o do vetor, uma coordenada diferente
			if(contador == 0) { System.out.printf("Entre com o valor de x: "); }
			if(contador == 1) { System.out.printf("Entre com o valor de y: "); }
			if(contador == 2) { System.out.printf("Entre com o valor de z: "); }
			
			vetor[contador] = input.nextDouble();
		} return vetor;
	}
	
	// calcula e retorna a f�rmula do cosseno = (U.V)/(|U|.|V|)
	public double calculaCosseno() {
		
		// cria dois objetos de ModuloVetor, um para cada vetor
		ModuloVetor moduloVetor1 = new ModuloVetor();
		ModuloVetor moduloVetor2 = new ModuloVetor();
		
		// cria um objeto de ProdutoEscalar 
		ProdutoEscalar produtoEscalar = new ProdutoEscalar();
		
		this.getVetor1();
		this.getVetor2();
		
		// (U.V)
		produtoEscalar.setVetor1(vetor1);
		produtoEscalar.setVetor2(vetor2);
		produtoEscalar.fazProduto();
		
		moduloVetor1.setVetor(vetor1);
		
		moduloVetor2.setVetor(vetor2);
		
		// Atribui a resultado a f�rmula do cosseno = (U.V)/(|U|.|V|)
		resultado = (produtoEscalar.getResult())/((moduloVetor2.calculaModulo()*(moduloVetor1.calculaModulo())));
		
		return resultado;
	}
	
	// printa o resultado do c�lculo na tela
	public void mostraCosseno() {
		System.out.println("O cosseno entre os vetores eh: " + resultado);
	}
	
	// insere dois vetores, calcula e mostra o cosseno do angulo entre eles
	public void cosseno() {
		
		System.out.println("Primeiro Vetor: ");
		this.setVetor1(this.leVetor());
		System.out.println("Segundo Vetor: ");
		this.setVetor2(this.leVetor());
		
		this.calculaCosseno();
		
		this.mostraCosseno();
		
	}
	
} // t�rmino da classe CossenoEntreVetores
