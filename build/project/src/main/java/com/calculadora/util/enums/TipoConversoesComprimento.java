package com.calculadora.util.enums;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public enum TipoConversoesComprimento {
	QUILOMETRO("Quil�metro", SI.KILOMETER),
	HECTOMETRO("Hect�metro", SI.HECTO(SI.METER)),
	DECAMETRO("Dec�metro", SI.DEKA(SI.METER)),
	METRO("Metro", SI.METER),
	DECIMETRO("Dec�metro", SI.DECI(SI.METER)),
	CENTIMETRO("Cent�metro", SI.METER),
	MILIMETRO("Mil�metro", SI.METER),
	ANGSTROM("Angstrom", NonSI.ANGSTROM),
	UNID_ASTRONOMICA("Unidade Astron�mica", NonSI.ASTRONOMICAL_UNIT),
	PONSTOS_COMPUTADOR("Pontos de Computador", NonSI.COMPUTER_POINT),
	PES("P�s", NonSI.FOOT),
	POLEGADA("Polegada", NonSI.INCH),
	ANO_LUZ("Ano-Luz", NonSI.LIGHT_YEAR),
	MILHAS("Milhas", NonSI.MILE),
	MILHA_NAUTICA("Milhas N�uticas", NonSI.NAUTICAL_MILE),
	PARSEC("Parsec", NonSI.PARSEC),
	PIXEL("Pixel", NonSI.PIXEL),
	PONTO("Ponto", NonSI.POINT),
	JARDA("Jarda", NonSI.YARD);
	
	private String nome;
	private Unit<?> tipo;
	
	private TipoConversoesComprimento(String nome, Unit<?> tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Unit<?> getTipo() {
		return tipo;
	}
	
	public Unit<?> getTipo(String nome) {
		
		for (TipoConversoesComprimento t : TipoConversoesComprimento.values()) {
			if (t.getNome().equals(nome))
				return t.getTipo();
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}
