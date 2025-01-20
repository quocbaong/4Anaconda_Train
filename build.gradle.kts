plugins {
    id("java")
}

group = "entity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hibernate:hibernate-core:6.0.2.Final")
    implementation("org.glassfish.jaxb:jaxb-runtime:3.0.2")
// https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client
    implementation ("org.mariadb.jdbc:mariadb-java-client:3.5.1")
// https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc
    implementation ("com.microsoft.sqlserver:mssql-jdbc:12.3.0.jre17-preview")
    implementation("jakarta.json:jakarta.json-api:2.1.3")
    implementation("jakarta.json.bind:jakarta.json.bind-api:3.0.1")
    implementation("org.eclipse.parsson:parsson:1.1.7")
    implementation("org.eclipse:yasson:3.0.4")
    // https://mvnrepository.com/artifact/jakarta.annotation/jakarta.annotation-api
    implementation ("jakarta.annotation:jakarta.annotation-api:2.1.1")

// https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api
    compileOnly ("jakarta.servlet:jakarta.servlet-api:6.0.0")
    annotationProcessor ("jakarta.servlet:jakarta.servlet-api:6.0.0")


    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
    implementation("net.datafaker:datafaker:2.4.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}