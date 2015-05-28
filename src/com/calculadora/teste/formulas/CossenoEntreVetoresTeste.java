// CossenoEntreVetoresTeste.java
// Testa a classe CossenoEntreVetores
package com.calculadora.teste.formulas;

// Para o teste, importa-se a classe CossenoEntreVetores
import com.calculadora.formulas.CossenoEntreVetores;

public class CossenoEntreVetoresTeste {

	public static void main(String[] args) {
		
		// Cria um objeto do tipo CossenoEntreVetores
		CossenoEntreVetores cossenoEntreVetores = new CossenoEntreVetores();
		
		double[] vetor1 = {3, 4, 0};
		double[] vetor2 = {4, 3, 0};
		
		// o termo final � utilizado pois � uma constante
		// representa o resultado do cosseno entre o vetor 1 e 2
		final double RESULTADO_ESPERADO = 0.96;
		
		// obt�m o valor de vetor1 e vetor2 no objeto do tipo CossenoEntreVetores criado
		cossenoEntreVetores.setVetor1(vetor1);
		cossenoEntreVetores.setVetor2(vetor2);
		
		// testa se o c�lculo resultou no n�mero esperado
		if (cossenoEntreVetores.calculaCosseno() == RESULTADO_ESPERADO)
			System.out.println("Teste realizado com sucesso!");
		else
			System.out.println("Sinto muito, nao deu certo :'(");
		
	}

} // T�rmino da classe
