# AGENTS.md

## Repository Overview

**base-parent** is a Maven parent POM (`com.github.hazendaz:base-parent`) that provides pre-configured Maven build infrastructure for Java projects. It eliminates the boilerplate of setting up Maven plugins, enforcer rules, code quality checks, code formatting, site generation, and release tooling. Projects adopt it simply by declaring it as their `<parent>`.

- **Language:** Java (target: Java 11+; build requires Java 21+)
- **Build tool:** Maven (requires 3.9.16+)
- **License:** Apache-2.0
- **Published to:** Maven Central

## Project Structure

```
base-parent/
├── pom.xml                   # The parent POM — the primary artifact of this project
├── compression.xml           # Activates the compression profile (copy to child project root)
├── format.xml                # Activates the formatter profile (copy to child project root)
├── LICENSE_HEADER            # License header template used by the license-maven-plugin
├── renovate.json             # Renovate bot configuration for dependency updates
├── mvnw / mvnw.cmd           # Maven wrapper scripts
├── .mvn/
│   ├── extensions.xml        # Maven extensions (e.g. Nexus staging)
│   └── settings.xml          # Maven settings for CI/CD
├── pom-resources/            # Resource files users can copy into child projects
│   ├── pom.xml               # Example pom snippet
│   ├── format.xml            # Formatter profile activation file
│   ├── compression.xml       # Compression profile activation file
│   ├── siteUpdate.xml        # Site update configuration
│   └── wrapper.md            # Notes on Maven wrapper usage
├── src/
│   ├── it/                   # Integration tests (Maven Invoker plugin)
│   │   ├── basic/            # Basic integration test project
│   │   ├── site/             # Site generation integration test
│   │   └── settings.xml      # Invoker settings
│   └── site/                 # Maven site source (APT/Markdown docs, images)
└── .github/
    └── workflows/
        ├── ci.yaml                            # Main CI: unit tests across JDK/OS matrix
        ├── integration-test.yaml              # IT: Maven Invoker tests
        ├── integration-test-maven-4.0.0.yaml  # IT against Maven 4.x
        ├── sonatype.yaml                      # Publishes snapshots/releases to Maven Central
        └── cleanup.yaml                       # Cleans up stale resources
```

## Build Commands

```bash
# Install the parent POM locally
./mvnw clean install

# Run unit tests only (skip license check for local work)
./mvnw test --batch-mode -Dlicense.skip=true

# Run integration tests
./mvnw verify --batch-mode -Dlicense.skip=true -Prun-it

# Run with all quality checks (checkstyle, PMD, SpotBugs, JaCoCo, NVD scan)
./mvnw verify -Pchecks

# Generate the Maven site
./mvnw site
```

## Maven Profiles

| Profile | Activation | Purpose |
|---|---|---|
| `checks` | Manual (`-Pchecks`) | Checkstyle, PMD, SpotBugs, JaCoCo, NVD dependency scan |
| `compression` | Presence of `compression.xml` | Compresses HTML/CSS/JS resources |
| `eclipse` | `m2e.version` property present | Eclipse m2e lifecycle mapping exclusions |
| `format` | Presence of `format.xml` | Eclipse code formatter (120-char lines, spaces) |
| `license-header` | Presence of `license.txt` | Stamps Java files with license headers |
| `maven363` | Maven version = 3.6.3 | Support when using Maven 3.6 |
| `maven389` | Maven version = 3.8.9 | Support when using Maven 3.8 |
| `maven4` | Maven version = 4.0.0-rc-5 | Support when using Maven 4 |
| `release` | Manual (`-Prelease`) | GPG-signs artifacts during deploy |
| `rewrite-junit` | Manual | OpenRewrite recipe: JUnit 4 → JUnit 5 migration |
| `run-it` | Manual (`-Prun-it`) | Runs integration tests |
| `wsimport` | Manual | Runs `wsimport` for WSDL/JAX-WS code generation |

## CI Workflows

- **ci.yaml** — Runs `mvn test` on pushes and pull requests across JDK 25, 26, 27-ea, 28-ea on macOS, Ubuntu, and Windows.
- **integration-test.yaml** — Runs `mvn verify -Prun-it` (Maven Invoker tests) across JDK 25, 26, 27-ea on the same OS matrix.
- **integration-test-maven-4.0.0.yaml** — Same integration tests against Maven 4.
- **sonatype.yaml** — Deploys snapshots/releases to Maven Central via Sonatype.
- **cleanup.yaml** — Periodic cleanup of stale workflow runs or caches.

All workflows use `actions/checkout` and `actions/setup-java` (Temurin distribution) pinned to commit SHAs for security.

## Dependency and Plugin Update Policy

Dependency updates are managed by **Renovate** (`renovate.json`, `config:best-practices` preset). JDK 5-era artifacts are explicitly excluded. Do not manually bump dependency versions that Renovate already tracks — let Renovate open the PR instead.

## Coding Conventions

- **Java target:** 11 (configurable via `java.version` / `java.release.version` properties)
- **Code style:** Eclipse formatter, 120-character lines, spaces (not tabs). Enabled via the `format` profile when `format.xml` is present.
- **Import order:** managed by `impsort-maven-plugin`.
- **License header:** Apache-2.0 header on all Java source files, managed by `license-maven-plugin`. Skip locally with `-Dlicense.skip=true`.
- **POM encoding:** UTF-8 **without** BOM. BOM-encoded POMs will break the versions plugin.

## How to Use this Parent in Another Project

Add to your project's `pom.xml`:

```xml
<parent>
    <groupId>com.github.hazendaz</groupId>
    <artifactId>base-parent</artifactId>
    <version>60</version>
</parent>
```

To enable optional profiles, copy the corresponding activation files from `pom-resources/` to your project root:
- `format.xml` → enables the `format` profile
- `compression.xml` → enables the `compression` profile

## Contributing

1. Fork the repository and create a feature branch.
2. Run `./mvnw clean install` locally to verify the build passes.
3. Run integration tests with `./mvnw verify -Prun-it -Dlicense.skip=true`.
4. Open a pull request against the default branch. CI will run automatically.
5. For dependency bumps, prefer letting Renovate handle them automatically.

## Contact / Maintainers

- **Jeremy Landis** ([@hazendaz](https://github.com/hazendaz)) — architect and primary maintainer
- Issues: https://github.com/hazendaz/base-parent/issues
