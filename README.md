# base-parent #

[![Build Status](https://travis-ci.org/hazendaz/base-parent.svg?branch=master)](https://travis-ci.org/hazendaz/base-parent)
[![Build Status](https://buildhive.cloudbees.com/job/hazendaz/job/base-parent/badge/icon)](https://buildhive.cloudbees.com/job/hazendaz/job/base-parent/)
[![Apache 2](http://img.shields.io/badge/license-Apache%202-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

![hazendaz](https://github.com/hazendaz/base-parent/blob/master/src/site/resources/images/hazendaz-banner.jpg)

See site page [here](http://hazendaz.github.io/base-parent/)

## Quick Start ##

If you quickly want to configure maven for most use cases, just download this project and run `mvn clean install`.

Requires Maven 3.2.3 or better.

After running `mvn clean install` against this project, simply add the parent to your pom.

```
<parent>
    <groupId>com.hazendaz</groupId>
    <artifactId>base-parent</artifactId>
    <version>5</version>
</parent>
```

This project contains only testing and configuration dependencies beyond maven plugin configurations.  Simply run
`mvn clean install` on your project and everything should build as expected.

## Introduction ##

Configuring maven for the first time can take a lot of work. This projects intent is to remove that barrier to usage.
This project handles majority of use cases when working with maven.  In the simplest of projects, this may mean
nothing more than including this parent pom and describing your project.

Support is provided for extensive `mvn site` providing user with extensive information regarding application.

Source code is formatted using eclipse source format style to ensure projects stay consistant in regards to spacing.
This is disabled by default.  To enable this functionality, simply build companion `build-tools` from hazendaz.

In order to enable compression or format profiles, copy resources from pom-resources folder to root of project.

## Installation ##

Launching the build requires Maven install - everything will be downloaded upon build.

Type:

    mvn clean install

And add parent to your pom.

```
<parent>
    <groupId>com.hazendaz</groupId>
    <artifactId>base-parent</artifactId>
    <version>5</version>
</parent>
```

Run `mvn clean install` against your own project

## Profiles ##

`checks` - Runs checkstyles, pmd, findbugs, jacoco, and nvd dependency scan.

`compression` - Runs compression against all contained html, css, and javascript.  Requires existance of compression.xml
file to activate.

`format` - Runs eclipse formatting using spaces rather than tabs and 120 rather than 80 character lines.  Requires
existance of format.xml file to activate.

`sort` - Runs a sort against your pom configuration helping to keep projects aligned.

`endorsed` - Pulls down webservices api overriding version contained with jdk6

`wsimport` - Runs wsimport goal.  This is mainly for example as additional configuration is required.

`tomcat` - Runs tomcat embedded war build against project.

`weblogic` - Deploys war out to weblogic instance.  Requires user defined weblogic instance and additional configuration.

## Version Plugin Consideration ##

Version plugin will fail if any POM is marked as Byte Order Mark is UTF-8 (BOM).
If this occurs, create a new POM and copy the contents over in order to fix.
For reference, this was a problem with [mybatis/mybatis-spring](https://github.com/mybatis/spring/commit/684da1f52c414f4de231e353fc1ef3a8ae4a9f4f).

