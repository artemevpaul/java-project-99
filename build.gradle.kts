import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
	java
	application
	//checkstyle
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
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

    // OpenAPI
    implementation(libs.springdocOpenapiUi)

	//Test
	testImplementation(libs.springBootStarterTest)
	testImplementation(libs.springSecurityTest)
	testImplementation(platform(libs.junitBom))
	testImplementation(libs.junitJupiter)
	testRuntimeOnly(libs.junitPlatformLauncher)


	//DB
	runtimeOnly(libs.h2)

}

tasks.test {
	useJUnitPlatform()
	testLogging {
		exceptionFormat = TestExceptionFormat.FULL
		events = setOf(
			TestLogEvent.FAILED,
			TestLogEvent.PASSED,
			TestLogEvent.SKIPPED
		)
		showStandardStreams = true
	}
}
