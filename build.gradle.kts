plugins {
    id("java")
}

group = "org.historialaulas"
version = "1.0.0"

repositories {
    mavenCentral()
    maven { url = uri( "https://jitpack.io") }
}




dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
}