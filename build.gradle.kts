plugins {
    id("java")
}

group = "entity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Apache POI
    implementation("org.apache.poi:poi:5.2.3")
    implementation("org.apache.poi:poi-ooxml:5.2.3")
    implementation("org.apache.poi:poi-ooxml-full:5.2.3") // chứa các schema đầy đủ
    implementation("org.apache.xmlbeans:xmlbeans:5.1.1")

    // Commons
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("commons-io:commons-io:2.16.1")

    // JSON & JAXB
    implementation("jakarta.json:jakarta.json-api:2.1.3")
    implementation("jakarta.json.bind:jakarta.json.bind-api:3.0.1")
    implementation("org.eclipse.parsson:parsson:1.1.7")
    implementation("org.eclipse:yasson:3.0.4")
    implementation("org.glassfish.jaxb:jaxb-runtime:3.0.2")

    // Hibernate & DB Drivers
    implementation("org.hibernate:hibernate-core:6.0.2.Final")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.1")
    implementation("com.microsoft.sqlserver:mssql-jdbc:12.3.0.jre17-preview")
    implementation("com.microsoft.sqlserver:mssql-jdbc:12.4.2.jre11")


    // Servlet & Annotation API
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    annotationProcessor("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")

    // Faker & Lombok
    implementation("net.datafaker:datafaker:2.4.2")
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    // JUnit for testing
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")


    implementation("org.apache.logging.log4j:log4j-core:2.22.0")
    implementation("org.apache.logging.log4j:log4j-api:2.22.0")

}

tasks.test {
    useJUnitPlatform()
}
