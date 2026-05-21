rootProject.name = "hidden-secrets-gradle-plugin"

val hiddenSecretsVersion = providers.gradleProperty("version")
    .orElse("1.0.0")
    .get()

gradle.allprojects {
    group = "com.github.bytehubio"
    version = hiddenSecretsVersion
}
