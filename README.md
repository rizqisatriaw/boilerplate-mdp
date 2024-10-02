# compose-android-boilerplate

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-6200EE.svg?style=for-the-badge&logo=android&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Firebase](https://img.shields.io/badge/firebase-a08021?style=for-the-badge&logo=firebase&logoColor=ffcd34)

## Folder Structure
Here is the folder structure we have been using in this project
```
compose/
|- core
    |- common (as a folder constant, enum, extension, etc)
    |- di (as a folder for dependency injection)
|- data
    |- local (as a folder for local data source)
    |- remote (as a folder for remote data source)
    |- repository (as a folder for repository)
|- domain
    |- repository (as a folder for repository)
    |- usecase (as a folder for usecase or interactors in one feature / action)
|- presentation
    |- components (as a folder for reusable components)
    |- navigation (as a folder for handle of navigation)
    |- screens (as a folder wrap on one feature / activity and contains ui & viewmodel)
|- theme (as a folder for theme color, theme, type, etc)

```
## Dependencies
- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Retrofit](https://square.github.io/retrofit/)
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Room](https://developer.android.com/jetpack/androidx/releases/room)
- [Coil](https://coil-kt.github.io/coil/)
- [Accompanist](https://google.github.io/accompanist/)
- [Firebase](https://firebase.google.com/)
- [Gradle](https://gradle.org/)

## Naming
 [Naming](https://developer.android.com/kotlin/style-guide#naming)
#### Folder, Variable, Function
   use 'camelCase' for naming
#### File and Class
   use 'PascalCase' for naming

## Code Style
 [Code Style](https://developer.android.com/kotlin/style-guide)
### Constants
   use 'UPPER_SNAKE_CASE' for naming constants if String use GLOBAL_CONSTANT.string

## Git Workflow

This document outlines the different types of commits used in our project and provides guidelines
for each type.
example ```commit type (card_number): description```

### Commit Types

- FEAT
   Description: Commits that introduce new features or functionalities to the project. 
   Example: FEAT: Implement user profile customization feature

- BUILD
   Description: Commits related to the build system or external dependencies. 
   Example: BUILD: Update package dependencies

- CHORE
   Description: Commits related to maintenance or general housekeeping tasks.
   Example: CHORE: Clean up redundant code

- DOCS
   Description: Commits that involve documentation changes or updates.
   Example: DOCS: Update API documentation

- FIX
   Description: Commits related to bug fixes or issue resolutions in the project.
   Example: FIX: Resolve issue with user login

- REFACTOR
   Description: Commits that involve code refactoring or restructuring without changing external
   behavior.
   Example: REFACTOR: Simplify data processing logic

- STYLE
   Description: Commits that involve changes to the code style or formatting.
   Example: STYLE: Update code formatting





