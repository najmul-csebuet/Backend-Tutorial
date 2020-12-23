import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.11.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	kotlin("plugin.jpa") version "1.3.72"
	kotlin("kapt") version "1.4.10"
	idea
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

idea {
	module {
		val kaptMain = file("build/generated/source/kaptKotlin/main")
		sourceDirs.plusAssign(kaptMain)
		generatedSourceDirs.plusAssign(kaptMain)
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")

	//querydsl stuffs
	implementation("com.mysema.querydsl:querydsl-jpa:3.6.3")
	kapt("com.mysema.querydsl:querydsl-apt:3.6.3:jpa") // Magic happens here

	//implementation("com.querydsl:querydsl-jpa:4.3.1")
	//annotationProcessor("com.querydsl:querydsl-apt:4.3.1:jpa")
	//annotationProcessor("org.springframework.boot:spring-boot-starter-data-jpa")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}



tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
