package com.pmapp;

import com.pmapp.persistence.entity.authEntities.RoleEntity;
import com.pmapp.persistence.entity.authEntities.RoleEnum;
import com.pmapp.persistence.entity.authEntities.UserEntity;
import com.pmapp.persistence.repository.auth.RoleRepository;
import com.pmapp.persistence.repository.auth.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

@SpringBootApplication
public class PmAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmAppServiceApplication.class, args);
	}



	@Bean
	CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			// Verificamos si los roles ya existen en la base de datos
			if (!roleRepository.findByRoleEnum(RoleEnum.ADMIN).isPresent()) {
				RoleEntity roleAdmin = RoleEntity.builder()
						.roleEnum(RoleEnum.ADMIN)
						.build();
				roleRepository.save(roleAdmin);
			}

			if (!roleRepository.findByRoleEnum(RoleEnum.USER).isPresent()) {
				RoleEntity roleUser = RoleEntity.builder()
						.roleEnum(RoleEnum.USER)
						.build();
				roleRepository.save(roleUser);
			}

			// Recuperamos los roles desde la base de datos
			RoleEntity savedRoleAdmin = roleRepository.findByRoleEnum(RoleEnum.ADMIN)
					.orElseThrow(() -> new RuntimeException("Role ADMIN no encontrado"));
			RoleEntity savedRoleUser = roleRepository.findByRoleEnum(RoleEnum.USER)
					.orElseThrow(() -> new RuntimeException("Role USER no encontrado"));

			// Verificamos si los usuarios ya existen en la base de datos antes de crearlos
			if (!userRepository.existsByUsername("admin")) {
				UserEntity adminUser = UserEntity.builder()
						.username("admin")
						.password(passwordEncoder.encode("admin"))
						.isEnable(true)
						.accountNoExpired(true)
						.accountNoLocked(true)
						.credentialNoExpired(true)
						.roles(Set.of(savedRoleAdmin))  //Asignamos rol de ADMIN
						.build();
				userRepository.save(adminUser);
			}

			if (!userRepository.existsByUsername("user")) {
				UserEntity regularUser = UserEntity.builder()
						.username("user")
						.password(passwordEncoder.encode("user"))
						.isEnable(true)
						.accountNoExpired(true)
						.accountNoLocked(true)
						.credentialNoExpired(true)
						.roles(Set.of(savedRoleUser))  // Asignamos rol de USER
						.build();
				userRepository.save(regularUser);
			}
		};
	}

}
