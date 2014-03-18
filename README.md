# base-parent #

## Quick Start ##

If you quickly want to configure maven for most use cases, just download this project and run `mvn clean install`.

Requires Maven 3.0.4 or better.

After running `mvn clean install` against this project, simply add the parent to your pom.

```
<parent>
    <groupId>com.hazendaz</groupId>
    <artifactId>base-parent</artifactId>
    <version>1</version>
</parent>
```

This project contains only testing dependencies beyond maven plugin configurations.  Simply run `mvn clean install`
on your project and everything should build as expected.

## Introduction ##

Configuring maven for the first time can take a lot of work. This projects intent is to remove that barrier to usage.
This project handles majority of use cases when working with maven.  In the simplest of projects, this may mean
nothing more than including this parent pom and describing your project.

Support is provided for extensive `mvn site` providing user with extensive information regarding application.

Source code is formatted using eclipse source format style to ensure projects stay consistant in regards to spacing.
This is disabled by default.  To enable this functionality, simply build companion `build-tools` from hazendaz.

## Installation ##

Launching the build requires Maven install - everything will be downloaded upon build.

Type:

    mvn clean install

And add parent to your pom.

```
<parent>
    <groupId>com.hazendaz</groupId>
    <artifactId>base-parent</artifactId>
    <version>1</version>
</parent>
```

Run `mvn clean install` against your own project

## Profiles ##

`checks` - Runs checkstyles, pmd, findbugs, and jacoco.  Additionally, if you would like a sonar push when finished
simply uncomment sonar within this profile.

`compression` - Runs compression against all contained html, css, and javascript.  Requires existance of compression.xml
file to activate.

`format` - Runs eclipse formatting using spaces rather than tabs and 120 rather than 80 character lines.  Requires
existance of format.xml file to activate.

`sort` - Runs a sort against your pom configuration helping to keep projects aligned.

`endorsed` - Pulls down webservices api overriding version contained with jdk6

`wsimport` - Runs wsimport goal.  This is mainly for example as additional configuration is required.

`tomcat` - Runs tomcat embedded war build against project.

`weblogic` - Deploys war out to weblogic instance.  Requires user defined weblogic instance and additional configuration.



