The code below is what needs to go in Constants.java within this directory:



package com.best.superteam.config;
```Java
public class Constants {
    // REPLACE THIS WITH YOUR OWN DATABASE PATH
    private static final String DB_PATH = "~/BestSuperTeam/database/bestsuperteam.db";    
    public static final String JDBC_URL = "jdbc:sqlite:"+DB_PATH;
}

```
