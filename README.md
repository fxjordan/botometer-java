# Botometer Java [![Build Status](https://travis-ci.com/fxjordan/botometer-java.svg?branch=master)](https://travis-ci.com/fxjordan/botometer-java)

Java library to detect Twitter bot accounts using [Botometer by OSoMe](https://botometer.iuni.iu.edu). It uses the Botometer API available at [RapidAPI](https://rapidapi.com/OSoMe/api/botometer).

## Usage

```java
BotometerConfiguration config = new BotometerConfigurationBuilder()
    .botometerApiKey("Botometer-API-Key") // X-RapidAPI-Key
    .twitterConsumerKey("consumer-key")
    .twitterConsumerSecret("consumer-secret")
    .twitterAccessToken("access-token")
    .twitterAccessTokenSecret("access-token-secret").build();

Botometer botometer = new BotometerFactory(config).create();

AccountAnalysisResult result = botometer.analyzeAccount("TruthyBotOrNot");
```

## Setup

Add dependecy:

```xml
<dependency>
    <groupId>de.fjobilabs.botometer</groupId>
    <artifactId>botometer-java</artifactId>
    <version>0.1.1</version>
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
