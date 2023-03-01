plugins {
    `java-library`
    `maven-publish`
    signing
}
/*
publishing {
    publications {
        create<MavenPublication>("maven") {
            repositories {
                maven {
                    credentials(PasswordCredentials::class)
                    val central = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                    val snapshots = "https://s01.oss.sonatype.org/content/repositories/snapshots/"

                    if (project.version.toString().endsWith("SNAPSHOT")) {
                        name = "SonatypeSnapshots"
                        setUrl(snapshots)
                    } else {
                        name = "OSSRH"
                        setUrl(central)
                    }
                }
            }
            from(components["java"])
            pom {
                url.set("https://github.com/MiniPlaceholders/MiniPlaceholders")
                licenses {
                    license {
                        name.set("GNU General Public License version 3 or later")
                        url.set("https://opensource.org/licenses/GPL-3.0")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/MiniPlaceholders/MiniPlaceholders.git")
                    developerConnection.set("scm:git:ssh://git@github.com/MiniPlaceholders/MiniPlaceholders.git")
                    url.set("https://github.com/MiniPlaceholders/MiniPlaceholders")
                }
                developers {
                    developer {
                        id.set("4drian3d")
                        name.set("Adrian Gonzales")
                        email.set("adriangonzalesval@gmail.com")
                    }
                }
                issueManagement {
                    name.set("GitHub")
                    url.set("https://github.com/MiniPlaceholders/MiniPlaceholders/issues")
                }
                ciManagement {
                    name.set("GitHub Actions")
                    url.set("https://github.com/MiniPlaceholders/MiniPlaceholders/actions")
                }
                name.set(project.name)
                description.set(project.description)
                url.set("https://github.com/MiniPlaceholders/MiniPlaceholders")
            }
        }
    }
}

signing {
    useGpgCmd()
    sign(configurations.archives.get())
    sign(publishing.publications["maven"])

}*/

java {
    withSourcesJar()
}