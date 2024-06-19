package dev.mukul.split_wise;

import dev.mukul.split_wise.service.command.registry.CommandRegistry;
import dev.mukul.split_wise.service.command.registry.RegisterUserCommand;
import dev.mukul.split_wise.service.command.registry.UpdateProfileCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseApplication implements CommandLineRunner {
	@Autowired
	private CommandRegistry commandRegistry;

	@Autowired
	RegisterUserCommand registerUserCommand;

	@Autowired
	UpdateProfileCommand updateProfileCommand;

	public static void main(String[] args) {
		SpringApplication.run(SplitWiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Registring commands...");

		commandRegistry.register(registerUserCommand);
		commandRegistry.register(updateProfileCommand);

		commandRegistry.execute("Register vinsmokesanji 003 namisswwaann");
		commandRegistry.execute("003 UpdateProfile robinchwan");

		//u1 UpdateProfile robinchwan

	}
}
