plugins {
	java
	application
	//checkstyle
	id("org.springframework.boot") version "3.5.4"
	id("io.spring.dependency-management") version "1.1.7"
	alias(libs.plugins.lombok)

}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

application { mainClass.set("hexlet.code.AppApplication") }

repositories {
	mavenCentral()
}

dependencies {
	///Spring
	implementation(libs.springBootStarterWeb)
	implementation(libs.springBootStarterDataJpa)
	implementation(libs.springBootStarterValidation)
	implementation(libs.springBootStarterActuator)
	implementation(libs.springBootStarterSecurity)
	implementation(libs.springBootStarterOauth2ResourceServer)
	implementation(libs.springBootDevtools)
	implementation(libs.springBootConfigProcessor)

	// Utilities
	implementation(libs.jacksonDatabindNullable)
	implementation(libs.commonsLang3)
	implementation(libs.datafaker)
	implementation(libs.instancioJunit)
	implementation(libs.jsonunitAssertj)

	// MapStruct
	implementation(libs.mapstruct)
	annotationProcessor(libs.mapstructProcessor)

	//Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	//DB
	runtimeOnly(libs.h2)

}

tasks.withType<Test> {
	useJUnitPlatform()
}
