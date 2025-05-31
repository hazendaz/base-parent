# base-parent #

[![Java CI](https://github.com/hazendaz/base-parent/workflows/Java%20CI/badge.svg)](https://github.com/hazendaz/base-parent/actions?query=workflow%3A%22Java+CI%22)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/com.github.hazendaz/base-parent/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.hazendaz/base-parent)
[![Apache 2](http://img.shields.io/badge/license-Apache%202-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

![hazendaz](src/site/resources/images/hazendaz-banner.jpg)

See site page [here](https://hazendaz.github.io/base-parent/)

## Quick Start ##

If you quickly want to configure maven for most use cases, just download this project and run `mvn clean install`.

Requires
- Maven 3.9.9 or better
- Java 17 or better
- Default target is java 11 but can be modified as needed by overriding it

After running `mvn clean install` against this project, simply add the parent to your pom.

```
<parent>
    <groupId>com.github.hazendaz</groupId>
    <artifactId>base-parent</artifactId>
    <version>53</version>
</parent>
```

This project contains only testing and configuration dependencies beyond maven plugin configurations.  Simply run
`mvn clean install` on your project and everything should build as expected.

## Introduction ##

Configuring maven for the first time can take a lot of work. This projects intent is to remove that barrier to usage.
This project handles majority of use cases when working with maven.  In the simplest of projects, this may mean
nothing more than including this parent pom and describing your project.

Support is provided for extensive `mvn site` providing user with extensive information regarding application.

Source code is formatted using eclipse source format style to ensure projects stay consistent in regards to spacing.
This is disabled by default.  To enable this functionality, simply build companion `build-tools` from hazendaz.

In order to enable compression or format profiles, copy resources from pom-resources folder to root of project.

## Installation ##

Launching the build requires Maven install - everything will download on build.

Type:

    mvn clean install

And add parent to your pom.

```
<parent>
    <groupId>com.github.hazendaz</groupId>
    <artifactId>base-parent</artifactId>
    <version>53</version>
</parent>
```

Run `mvn clean install` against your own project

## Profiles ##

`checks` - Runs checkstyles, pmd, findbugs, jacoco, and nvd dependency scan.

`compression` - Runs compression against all contained html, css, and javascript.  Requires existence of compression.xml
file to activate.

`eclipse` - Lifecycle mapping exclusions for eclipse.  Activated with existence of property m2e.version.

`format` - Runs eclipse formatting using spaces rather than tabs and 120 rather than 80 character lines.  Requires
existence of format.xml file to activate.

`jdk17on` - Adds compiler args to various add-exports and add-opens

`license-header` - Runs license java file tagging.  Requires existence of license.txt file to activate.

`release` - Runs gpg against deliverables when releasing not via release plugin such as during deploy.

`rewrite-junit` - Open rewrite recipe to rewrite from junit4 to junit5

`wsimport` - Runs wsimport goal.  This is mainly for example as additional configuration is required.

## Version Plugin Consideration ##

Version plugin will fail if any POM is marked as Byte Order Mark is UTF-8 (BOM).
If this occurs, create a new POM and copy the contents over in order to fix.
For reference, this was a problem with [mybatis/mybatis-spring](https://github.com/mybatis/spring/commit/684da1f52c414f4de231e353fc1ef3a8ae4a9f4f).

## Dependencies ##

Normally dependencies would not exist at this level.  The intent here is to include managed dependencies used during build phases.
In order to use any of these, you must define them within your own pom with appropriate scoping.

Dependencies are as follows:
- checker-qual
- error_prone_annotations
- hibernate-validator-annotation-processor
- j2objc-annotations
- lombok
- modernizer-maven-annotations
- spotbugs-annotations

## Plugin Management ##

Majority of plugins will perform on their own.  All managed plugins are listed here.

- build-helper-maven-plugin
- buildplan-maven-plugin
- coveralls-maven-plugin
- cyclonedx-maven-plugin
- dependency-check-maven
- find-and-replace-maven-plugin
- formatter-maven-plugin
- frontend-maven-plugin
- git-commit-id-maven-plugin
- htmlcompressor-maven-plugin
- impsort-maven-plugin
- jacoco-maven-plugin
- jandex-maven-plugin
- jaxws-maven-plugin
- jdepend-maven-plugin
- joinfaces-maven-plugin
- license-maven-plugin
- kotlin-maven-plugin
- lombok-maven-plugin
- makeself-maven-plugin
- maven-antrun-plugin
- maven-assembly-plugin
- maven-checkstyle-plugin
- maven-clean-plugin
- maven-compiler-plugin - useIncrementalCompilation set to false, See https://jira.codehaus.org/browse/MCOMPILER-209
- maven-dependency-plugin
- maven-deploy-plugin
- maven-enforcer-plugin
- maven-failsafe-plugin
- maven-gpg-plugin
- maven-install-plugin
- maven-jar-plugin
- maven-javadoc-plugin
- maven-jxr-plugin
- maven-pdf-plugin - currently issue prevents this from building much more than empty pdf
- maven-pmd-plugin
- maven-project-info-reports-plugin
- maven-release-plugin
- maven-resources-plugin
- maven-scm-plugin
- maven-site-plugin
- maven-source-plugin
- maven-surefire-plugin
- maven-surefire-report-plugin
- maven-war-plugin
- maven-wrapper-plugin
- modernizer-maven-plugin
- rewrite-maven-plugin
- smartsprites-maven-plugin
- sonar-maven-plugin
- sortpom-maven-plugin
- spotbugs-maven-plugin
- spotless-maven-plugin
- spring-boot-maven-plugin
- taglist-maven-plugin
- tidy-maven-plugin
- versions-maven-plugin
- wagon-maven-plugin
- whitespace-maven-plugin
- yuicompressor-maven-plugin

### More to come... ###
