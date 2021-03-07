# Email ETL

## Intro

This project serves to extract a newline-delimited list of emails from a text file, validating and sorting these emails
alphabetically based on their domains, and then writing them out to another text file, again newline-delimited.

## Assumptions

Several assumptions were made throughout development:

- Local email addresses are not permitted (i.e. localhost domain)
- Duplicate identical emails don't need to be de-duplicated
- If emails have identical domains, then a secondary sort is performed alphabetically by username
- Invalid emails are silently ignored/filtered
- User is not permitted to specify the same input and output file when running the application
- If an existing output file is specified, any existing contents will be wiped

## Next steps/potential improvements

If another use case were to present itself, Extractor, Transformer, and Loader interfaces could be extracted from the
current Email-specific implementations in order to facilitate additional data transformation.

## Getting started

### Dependencies

This project is compatible with Java JDK versions 14+. OpenJDK 15 is available for
download [here](https://adoptopenjdk.net/?variant=openjdk15).

This project has been set up using the Gradle wrapper, so you do not need to have Gradle installed on your CLI. Please
note that all commands specified throughout this guide assume a Unix-based system: if you're running Windows, please
utilize the `gradlew.bat` script rather than `./gradlew`. This project has not been tested on a Windows machine.

### Clean and build the project

```bash
./gradlew clean build
```

### Run all tests

```bash
./gradlew test
```

### Running the application

By default, this application will read from the provided `sampleInput.txt` file and generate a `sampleOutput.txt` file:

```bash
./gradlew run
```

If desired, an input and output file can be specified (note that both an input and output file must be specified, not
either/or):

```bash
./gradlew run --args="path/to/input.txt path/to/output.txt"
```
