package integrationTests.runner;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import integrationTests.tests.serveRest.login.tests.PostLoginTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(integrationTests.suites.AllSuites.class)
@Suite.SuiteClasses(
    {
        //Login
        PostLoginTest.class,


    }
)
public class AllSuites {

}
