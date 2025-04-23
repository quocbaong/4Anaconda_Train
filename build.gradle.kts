plugins {
    java
}

group = "entity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Thư viện Apache POI
    implementation("org.apache.poi:poi:5.2.3")
    implementation("org.apache.poi:poi-ooxml:5.2.3")
    implementation("org.apache.poi:poi-ooxml-schemas:4.1.2")
    implementation("org.apache.xmlbeans:xmlbeans:5.1.1")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("commons-io:commons-io:2.16.1")

    // Thư viện Hibernate và JDBC
    implementation("org.hibernate:hibernate-core:6.0.2.Final")
    implementation("org.glassfish.jaxb:jaxb-runtime:3.0.2")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.1")
    implementation("com.microsoft.sqlserver:mssql-jdbc:12.3.0.jre17-preview")
    implementation ("org.liquibase:liquibase-core:4.25.1")
    // Rõ ràng khai báo JPA 3.0
    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")

    // JSON và Jakarta APIs
    implementation("jakarta.json:jakarta.json-api:2.1.3")
    implementation("jakarta.json.bind:jakarta.json.bind-api:3.0.1")
    implementation("org.eclipse.parsson:parsson:1.1.7")
    implementation("org.eclipse:yasson:3.0.4")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")

    // Giao diện và các thư viện khác
    implementation("com.miglayout:miglayout-swing:11.0")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    annotationProcessor("jakarta.servlet:jakarta.servlet-api:6.0.0")
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
    implementation("net.datafaker:datafaker:2.4.2")

    // Test
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Thư viện giao diện và biểu đồ
    implementation("org.jfree:jfreechart:1.5.3")
    implementation("com.toedter:jcalendar:1.4")

    // Thư viện timingframework và AbsoluteLayout từ Maven Central
    implementation("net.java.dev.timingframework:timingframework:1.0")
    implementation("org.netbeans.external:AbsoluteLayout:RELEASE240")

    // Log4j2
    implementation("org.apache.logging.log4j:log4j-api:2.23.1")
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
}

tasks.test {
    useJUnitPlatform()
}