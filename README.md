# JAX-RS Form-based Login Demo

This sample project demonstrates how you could use form-based login in JAX-RS on Open Liberty.

Most of the magic is done in the web.xml - it sets up the protected resources and the form-based login page. Additional
magic is the server.xml, Liberty's server config - it sets up the users and roles/groups.

There are two JAX-RS resources - one secure/protected and one that is not secure/protected. If you access the latter
resource without logging in, you will see the page but it will not know who you are - it will display a page with text
like "Hello (not-secured) null".

If you access the secure/protected resource, it will redirect you to the login page.  You can then enter valid
credentials (user1/pass1), and then it will redirect you back to the secure resource, where it will display
"Hello user1".  Now, if you go back to the unsecure resource, it will display "Hello (not-secured) user1".

Give this a try by building the sample and deploying it with:
```
mvn clean package liberty:run
```

Next open your browser to http://localhost:9080 and follow the instructions. Enjoy!