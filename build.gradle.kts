plugins {
    id("java")
}

group = "org.historialaulas"
version = "1.0.0"

repositories {
    mavenCentral()
}



dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/org.apache.activemq/activemq-core
//    implementation("org.apache.activemq:activemq-core:5.7.0")
}

tasks.test {
    useJUnitPlatform()
}