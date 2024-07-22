package de.schauderhaft.enumconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.List;

@SpringBootApplication
public class EnumConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnumConverterApplication.class, args);
	}




	@WritingConverter
	enum GenericEnumToIntegerConverter implements Converter<Enum, Integer> {
		INSTANCE;

		@Override
		public Integer convert(Enum source) {
			return source.ordinal();
		}
	}
	@ReadingConverter
	static class GenericIntegerToEnumConverter<E extends Enum<E>> implements Converter<Integer, E> {

		private final Class<E> type;

		static <F extends Enum<F>>  GenericIntegerToEnumConverter<F> of(Class<F> type){
			return new GenericIntegerToEnumConverter<>(type);
		}

		GenericIntegerToEnumConverter(Class<E> type) {
			this.type = type;
		}

		@Override
		public E convert(Integer source) {
			return type.getEnumConstants()[source];
		}
	}

	@Configuration
	class EnumConverterConfiguration extends AbstractJdbcConfiguration {
		@Override
		protected List<?> userConverters() {
			return List.of(GenericEnumToIntegerConverter.INSTANCE);
		}
	}

}
