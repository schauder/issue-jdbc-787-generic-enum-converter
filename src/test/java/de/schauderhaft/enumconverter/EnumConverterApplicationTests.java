package de.schauderhaft.enumconverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnumConverterApplicationTests {

	@Autowired EnumOwnerRepository enumOwnerRepository;

	@Test
	void contextLoads() {

		EnumOwner saved = enumOwnerRepository.save(new EnumOwner(null, Color.PINK, Direction.ACROSS));

	}

}
