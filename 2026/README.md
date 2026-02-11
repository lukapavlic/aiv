# Information Systems Architectures and Patterns

Examples from the course **"Information Systems Architectures and
Patterns" (Arhitekture IS in Vzorci)**, IPT UNI 2nd year.

See also: [Platforms to run the
examples](https://github.com/lukapavlic/platforms)

------------------------------------------------------------------------

## 2026 Examples Overview

This directory contains example projects for the **2026 edition** of the
course. These projects demonstrate basics of Enterprise Java (mostly Jakarta EE), and can alse serve as templates or starting points for advanced
exercises.

------------------------------------------------------------------------

## Projects

  -----------------------------------------------------------------------
  Project Folder                  Short Description
  ------------------------------- ---------------------------------------
  `00_JSF101`                     Basic JavaServer Faces (JSF) example
                                  project demonstrating the fundamentals
                                  of JSF web applications.

  `00_Java101`                    Introductory Java project showing core
                                  Java concepts used in the course (e.g.,
                                  classes, methods, packages, basic app
                                  structure).

  `mvnEmptyJsf`                   Minimal empty JSF project configured
                                  with Maven --- a skeleton to bootstrap
                                  JSF applications with standard Maven
                                  structure.

  `mvnTemplate`                   Maven template project with initial
                                  setup (POM files, directory layout)
                                  designed to be used as a starting point
                                  for new course examples and exercises.
  -----------------------------------------------------------------------

------------------------------------------------------------------------

## How to Use These Projects

Each project includes its own configuration and possibly its own build
instructions (typically inside a local `README.md`).

### General steps to run

1.  **Clone the repository:**

    ``` sh
    git clone https://github.com/lukapavlic/aiv.git
    cd aiv/2026
    ```

2.  **Enter a specific project:**

    ``` sh
    cd 00_JSF101
    ```

3.  **Build and run**

    -   If the project uses Maven:

        ``` sh
        mvn clean install
        mvn test
        ...
        ```

    -   If the project is Jakarta / Wildfly project:

        ``` sh
        mvn clean wildfly:dev
        ...
        ```

------------------------------------------------------------------------

## Notes

-   Some projects (like EE examples) require a Jakarta EE server to run. Wildfly 39 is a verified run.
-   Maven-based projects provide standard
    POM files to manage dependencies and build lifecycle.
