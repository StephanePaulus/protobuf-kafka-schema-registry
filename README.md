# protobuf-kafka-schema-registry


To create a working schema registry using protobuf,
we have to register reference protobuf files with both name and subject equal to the import statement, 
which also means that when we register those schemas the subject has to equal the import statement that will be used.

The following snippet is how it would look like to register 2 protobuf files, that can be sent on individual topics
and 1 of the proto includes the other proto. 

```
register{
      subject(IMPORT_STATEMENT, PATH_TO_PROTO_FILE}, "PROTOBUF")
      
      subject(TOPIC-value, PATH_TO_OTHER_PROTO_FILE}, "PROTOBUF")
     .addReference(IMPORT_STATEMENT,IMPORT_STATEMENT)
     
     subject(OTHER_TOPIC-value, PATH_TO_PROTO_FILE}, "PROTOBUF")
```

Are there ways to make this less verbose? 


## RUN test

in `teamA/build.gradle` you will have the broken schema defined and the working schema commented out.

1. docker-compose up should start kafka and a schema-registry
2. ./gradlew registerSchemasTask
3. ./gradlew build
4. ./gradlew bootRun ==> will fail, if you register the other schema with the different naming, it works. [you will need to delete the docker containers]
