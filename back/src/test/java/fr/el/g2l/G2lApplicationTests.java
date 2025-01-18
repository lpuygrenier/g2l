package fr.el.g2l;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class G2lApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void verifyModularity() {
		ApplicationModules.of(G2lApplication.class).verify();
	}
}
