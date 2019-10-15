# Setup

1. Setup Gradle project

    ```shell
    mkdir helloworld
    cd !-1$:h
    gradle init --type java-library --dsl groovy --test-framework junit --project-name HelloWorld --package edu.dartmouth.bt.planon.helloworld.sx

    mkdir lib

    curl https://www.gitignore.io/api/java,macos,gradle,visualstudiocode > .gitignore
    echo ".vscode*" >> .gitignore
    ```

2. Add class dependencies to lib/
3. In gradle.build dependencies {} add class file references
    1. *EXAMPLE*: **compile files('lib/com.planonsoftware.ux.api.v1-2.2.1.0-1.jar')**
4. Change *Library.java to the desired class name
    1. *EXAMPLE*: **HelloWorld.java**
5. The class should implement IUserExtension and the executeUX() and getDescription() methods
    1. *EXAMPLE*:

        ```java
        package edu.dartmouth.bt.planon;

        import nl.planon.hades.userextension.uxinterface.*;

        public class HelloWorld implements IUserExtension {
            private String description = "This is the description that is shown to administrators in the Planon web client.";

            public HelloWorld() {}

            public void executeUX(IUXBusinessObject newBO,IUXBusinessObject oldBO, IUXContext context, String parameter) {
                // do stuff
            }

            public String getDescription() {
                return description;
            }
        }
        ```

6. Configure gradle to build the JAR and provide the required manifest information

    ```groovy
    jar {
        baseName = 'helloworld'
        version = '0.0.2'
        manifest {
            attributes (
                'Manifest-Version': '1.0',
                'Bundle-SymbolicName': 'Dartmouth-HelloWorld',
                'Planon-UserExtension': '1.0.0',
                'Planon-IUserExtension': 'edu.dartmouth.bt.planon.HelloWorld',
                'Import-Package': 'nl.planon.hades.userextension.uxinterface'
            )
        }
    }
    ```

7. Set your JDK path as needed using the **gradle.properties** file
    1. *EXAMPLE*: **org.gradle.java.home=/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/**
