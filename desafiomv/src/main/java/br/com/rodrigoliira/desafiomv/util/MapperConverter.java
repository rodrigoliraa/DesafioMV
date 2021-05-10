package br.com.rodrigoliira.desafiomv.util;

import org.modelmapper.ModelMapper;

public class MapperConverter {
	
private static ModelMapper mapper = new ModelMapper();
	
	public static <O, D> D convertObject(O origin, Class<D> destination){
		return mapper.map(origin, destination);
	}

}
