plugins {
    id("java")
}

group = "org.ukma"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":library-models"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("checkFileExists") {
    doLast {
        val file = File("${project.projectDir.absolutePath}/src/main/resources/storage.txt")
        if (file.exists()) {
            println("File already exists")
        } else {
            file.createNewFile()
            println("File created")
        }
    }
}

tasks.register("saveBooks") {
    dependsOn("checkFileExists")
    doLast {
        val sourceFile = file("${project.projectDir.absolutePath}/src/main/resources/template.txt")
        val destinationFile = file("${project.projectDir.absolutePath}/src/main/resources/storage.txt")
        if (destinationFile.length() == 0L){
            sourceFile.copyTo(destinationFile, true)
            println("Books have been saved to the file")
        } else {
            println("Books are already saved")
        }
    }
}

tasks.compileJava {
    dependsOn("saveBooks")
}