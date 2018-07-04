package controller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public final class ValidacaoController {
	
	
	public static boolean validarCPF(String CPF) {
		int digitoverificador1, digitoverificador2;
		 if (CPF.equals("00000000000") || CPF.equals("11111111111")
	                || CPF.equals("22222222222") || CPF.equals("33333333333")
	                || CPF.equals("44444444444") || CPF.equals("55555555555")
	                || CPF.equals("66666666666") || CPF.equals("77777777777")
	                || CPF.equals("88888888888") || CPF.equals("99999999999")
	                || (CPF.length() != 11)) {
	            return (false);
	        }else {
	        	int soma=0, valor;
	             for (int i = 0, peso = 10; i < 9; i++, peso--) {

	                 valor = Integer.parseInt(String.valueOf(CPF.charAt(i)));
	                 soma = soma + (valor * peso);
	             }
	             
	             digitoverificador1 = (soma * 10)%11;
	             
	             if(digitoverificador1 == 10 || digitoverificador1 == 11) digitoverificador1 = 0;
	             
	             soma = 0;
	             for (int i = 0, peso = 11; i < 10; i++, peso--) {

	                 valor = Integer.parseInt(String.valueOf(CPF.charAt(i)));
	                 soma = soma + (valor * peso);
	             }
	             
	             digitoverificador2 = (soma * 10)%11;
	             if(digitoverificador2 == 10 || digitoverificador2 == 11) digitoverificador2 = 0;
	             
	             
	             if(digitoverificador1 == Integer.parseInt(String.valueOf(CPF.charAt(9))) && digitoverificador2 == Integer.parseInt(String.valueOf(CPF.charAt(10)))) return true;
	             
	        }
		return false;
	}
	
	@SuppressWarnings("unused")
	public static boolean validaCEP(String CEP) {
		
		URLConnection urlConnection;
		try {
			URL cepurl = new URL("http://viacep.com.br/ws/"+CEP+"/json");
			urlConnection = cepurl.openConnection();

			InputStream inputstream = urlConnection.getInputStream();
			
			return true;
		} catch (IOException exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	public static List<String> getDadosbyCEP(String CEP) throws Exception {
		
		URL cepurl = new URL("http://viacep.com.br/ws/"+CEP+"/json");
		
		URLConnection urlConnection = cepurl.openConnection();
		try {
        InputStream inputstream = urlConnection.getInputStream();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, Charset.forName("UTF-8")));
        StringBuilder stringBuilder = new StringBuilder();
        bufferedreader.lines().forEach(line -> stringBuilder.append(line.trim()));
        
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobjeto = (JSONObject) jsonparser.parse(stringBuilder.toString());
		
		List<String> jsonValores = new ArrayList<String>();
		jsonValores.add(jsonobjeto.get("localidade").toString());
		jsonValores.add(jsonobjeto.get("bairro").toString());
		jsonValores.add(jsonobjeto.get("logradouro").toString());
		jsonValores.add(jsonobjeto.get("complemento").toString());
		jsonValores.add(jsonobjeto.get("uf").toString());	
		
		return jsonValores;
		
		}catch(FileNotFoundException exception) {
			exception.printStackTrace();
			return null;
		}

	}

}
