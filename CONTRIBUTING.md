
# Contributing

I am glad welcoming contributions to make this plugin better.

## Pre-Requisites

Jetbrains plugins are written in Java, so you need to have Java installed on your machine. 

This project requires a minimum of Java 11.

You also need a version of [InteliJ IdEA](https://www.jetbrains.com/idea/) to test the plugin. The free "Community edition" is supported and you can download from [here](https://www.jetbrains.com/idea/download). 

## Development

[Gradle]([Gradle Build Tool](https://gradle.org/)) is used as build tool as recommended by Jetbrains.

You can build the project using `./gradlew build`.

To start a sandboxed instance of your IDE with the plugin installed run: ```./gradlew :runIde```

Or you can use the provided "Run Configuration" to run it directly from your InteliJ IDE.

To learn more about how to develop Jetbrains plugins, please refer to [this](https://www.jetbrains.org/intellij/sdk/docs/tutorials/build_system.html) guide.

## Install your plugin locally

To test the final plugin distribution artifact, you can run:

```
./gradlew buildPlugin
``` 

This will create a new jar in the `build/distributions` folder with the bundled code.

You can then install your plugin in your Jetbrains IDE by following [this](https://www.jetbrains.com/help/idea/managing-plugins.html#install_plugin_from_disk) guide: 