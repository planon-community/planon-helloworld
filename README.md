# Setup

1. Setup Gradle project

    ```shell
    mkdir edu-dartmouth-bt-planon-helloworld
    cd !-1$:h
    gradle init

    mkdir lib

    curl https://www.gitignore.io/api/java,macos,gradle,visualstudiocode > .gitignore
    echo ".vscode*" >> .gitignore
    ```

2. Add class dependencies to lib/
3. In gradle.build dependencies {} add class file references
    1. *EXAMPLE*: **compile files('lib/com.planonsoftware.ux.api.v1-2.2.1.0-1.jar')**
