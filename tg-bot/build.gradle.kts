plugins {
    id("java")
}

group = "sim"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

//    implementation(project(":google-table"))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

//    implementation("org.json:json:20230227")
    implementation("org.telegram:telegrambots:6.5.0")
    implementation("org.telegram:telegrambotsextensions:6.5.0")
    implementation("org.projectlombok:lombok:1.18.26")
    implementation("org.springframework.boot:spring-boot-starter-web:3.0.4")
    implementation("org.telegram:telegrambots-spring-boot-starter:6.5.0")
//    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")

    implementation("org.slf4j:slf4j-api:2.0.7")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.7")
}

tasks.test {
    useJUnitPlatform()
}