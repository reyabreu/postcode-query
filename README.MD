postcode-query
=================

This is a demo project that queries the free Postcode API for the UK. It presents concepts and approaches that are typically encountered in Enterprise application programming by teams of developers.
Besides console output, This demo app also includes sl4j console logging.

Using gradle for dependencies management, the following command is enough to obtain an executable jar :

    >gradlew build.

After a build, the executable jar is available on build/libs directory, allowing for command line execution. The application takes a single argument in the form of a valid postcode:

    >java -jar build/libs/postcode-query-0.0.1-SNAPSHOT.jar <postcode>
        
For any inquiries and/or suggestions please contact:
    
    Reynaldo Jose Abreu
    reyabreu@gmail.com

This code is provided as is.