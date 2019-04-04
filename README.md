# Botometer Java [![Build Status](https://build.fjobilabs.de/job/botometer-java/job/master/badge/icon)](https://build.fjobilabs.de/blue/organizations/jenkins/botometer-java)

Java library to detect Twitter bot accounts using the Botometer API. Botometer is a bot detection service for Twitter accounts developed by OSoMe. For more Information see [the website][botometer-website].

## Usage

```java
BotometerConfiguration config = new BotometerConfiguration()
    .botometerApiKey("Botometer-API-Key") // X-RapidAPI-Key
    .twitterConsumerKey("consumer-key")
    .twitterConsumerSecret("consumer-secret")
    .twitterAccessToken("access-token")
    .twitterAccessTokenSecret("access-token-secret").build();

Botometer botometer = new BotometerFactory(config).create();

AccountAnalysisResult result = botometer.analyzeAccount("TruthyBotOrNot");
```

## Setup

1. Add FJOBI Labs repository to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>fjobilabs-snapshots</id>
        <name>FJOBILabs Snapshots</name>
        <url>https://repo.fjobilabs.de/repository/maven-snapshots/</url>
    </repository>
    <repository>
        <id>fjobilabs-releases</id>
        <name>FJOBILabs Releases</name>
        <url>https://repo.fjobilabs.de/repository/maven-releases/</url>
    </repository>
</repositories>
```

2. Add dependecy:

```xml
<dependency>
    <groupId>de.fjobilabs.botometer</groupId>
    <artifactId>botometer-java</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## To be continued...

More details will follow soon.

## License

    Copyright 2019 FJOBI Labs Softwareentwicklung - Felix Jordan
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[botometer-website]: https://botometer.iuni.iu.edu