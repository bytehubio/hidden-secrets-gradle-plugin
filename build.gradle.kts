plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.2.1"
    `maven-publish`
}

repositories {
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") // Required by detekt
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.4.2")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.4.2")
    testImplementation("io.kotest:kotest-framework-datatest-jvm:5.4.2")
    testImplementation("junit:junit:4.13.2")
}

//java {
//    toolchain {
//        languageVersion.set(JavaLanguageVersion.of(11))
//    }
//}

gradlePlugin {
    website.set("https://github.com/bytehubio/hidden-secrets-gradle-plugin")
    vcsUrl.set("https://github.com/bytehubio/hidden-secrets-gradle-plugin.git")
    plugins {
        create("HiddenSecretsPlugin") {
            id = "com.bytehubio.hiddensecrets"
            displayName = "Hidden Secrets Plugin"
            description = "This plugin allows any Android developer to deeply hide secrets in its project."
            implementationClass = "com.klaxit.hiddensecrets.HiddenSecretsPlugin"
            tags.set(listOf("android", "hide", "secret", "key", "string", "obfuscate"))
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/bytehubio/hidden-secrets-gradle-plugin")
            credentials {
                username = findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

tasks.withType<Copy> {
    // Required by Gradle 7.0
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

tasks.withType<Test> {
    useJUnitPlatform()
}
