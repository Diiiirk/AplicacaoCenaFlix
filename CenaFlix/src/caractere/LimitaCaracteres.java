package caractere;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author diego
 */
public class LimitaCaracteres extends PlainDocument{
	
	public enum TipoEntrada {
		NUMEROINTEIRO, NUMERODECIMAL, NOME, EMAIL, DATA, HORA;
	}
	
	private int quantidadeCaracteres;
	private TipoEntrada tipoEntrada;
	
	public LimitaCaracteres(int quantidadeCaracteres, TipoEntrada tipoEntrada) {
		this.quantidadeCaracteres = quantidadeCaracteres;
		this.tipoEntrada = tipoEntrada;
	}

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if(str == null || getLength() == quantidadeCaracteres) {
			return;
		}
		int totalCaracteres = getLength() + str.length();
		
		// filtro de caracteres
		String regex = "";
		switch(tipoEntrada) {
		
			case NUMEROINTEIRO: regex = "[^0-9]"; break;
			case NUMERODECIMAL: regex = "[^0-9,.]"; break;
			case NOME: regex = "[^\\p{IsLatin} ]"; break;
			case EMAIL: regex = "[^\\p{IsLatin}@.\\-_][^0-9]"; break;
			case DATA: regex = "[^0-9/]"; break;
                        case HORA: regex = "[^0-9:]"; break;
                        
		}
		str = str.replaceAll(regex, "");
		
		if(totalCaracteres <= quantidadeCaracteres) {
			super.insertString(offs, str, a);
		}else {
			String nova = str.substring(0, quantidadeCaracteres);
			super.insertString(offs, nova, a);
		}
	}
}