package com.calculadora.validacao;

import javafx.scene.control.TextField;

public class InputOnlyPolinomios extends TextField {
	
	public InputOnlyPolinomios() {
		
	}
	
	@Override
	public void replaceText(int start, int end, String text) {
		
		if (text.matches("[0-9]") || text.isEmpty()) {
			super.replaceText(start, end, text);
		} else if (text.contains(".") && end > 0) {
			super.replaceText(start, end, text);
		} else if (text.contains("x") && end > 0) {
			super.replaceText(start, end, text);
		} else if (text.contains("^") && end > 0) {
			super.replaceText(start, end, text);
		}
	}
	
	@Override
	public void replaceSelection(String replacement) {
		super.replaceSelection(replacement);
	}
}
