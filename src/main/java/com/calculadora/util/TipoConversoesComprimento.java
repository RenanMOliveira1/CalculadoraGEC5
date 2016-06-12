package com.calculadora.util;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

/*
 * quil�metro (km), hect�metro (hm) e dec�metro (dam) e os subm�ltiplos s�o dec�metro (dm), cent�metro (cm) e mil�metro
 */
public enum TipoConversoesComprimento {
	QUILOMETRO("Quil�metro", SI.KILOMETER),
	HECTOMETRO("Hect�metro", SI.HECTO(SI.METER)),
	DECAMETRO("Dec�metro", SI.DEKA(SI.METER)),
	METRO("Metro", SI.METER),
	DECIMETRO("Dec�metro", SI.DECI(SI.METER)),
	CENTIMETRO("Cent�metro", SI.CENTIMETER),
	MILIMETRO("Mil�metro", SI.MILLIMETER);
	
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
