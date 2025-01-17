package Validators;

public class Rut {
	private String valor; // 12345678
	
	public Rut(String rut){
		if(isRut(rut)) {
			String rutWP = rut.replaceAll("[.]", "");
			valor = rutWP.substring(0, rutWP.length()-2);
		}
	}
	
	public String getRut() {
		// 12.345.678
		//  1.999.999
		int size = valor.length();
		String r1 = valor.substring(size-3);
		String r2 = valor.substring(size-6,size-3);
		String r3 = valor.substring(0,size-6);
		String rut = r3 + "." + r2 + "." + r1;
		return rut + "-" + getVerificador();
	}
	
	public String getVerificador() {
		final int[] serie = {2, 3, 4, 5, 6, 7};
		int result = 0;
		for(int i=valor.length()-1; i>=0; i--) {
			int digit = Integer.parseInt(valor.substring(i, i+1));
			int index = (valor.length()-1-i) % 6;
			result += digit * serie[index];
		}
		result = 11 - (result % 11);
		if(result == 11) { return "0"; }
		else if(result == 10) { return "k"; }
		else { return result + ""; }
	}
	
	private static boolean isRut(String rut) {
		String regex = "[1-9][0-9]?([.]?[0-9]{3}){2}[-][0-9kK]";
		return rut.matches(regex);
	}
	
}