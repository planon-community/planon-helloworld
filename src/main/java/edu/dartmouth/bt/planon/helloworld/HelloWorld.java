/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.dartmouth.bt.planon.helloworld;

import nl.planon.hades.userextension.uxinterface.*;

public class HelloWorld implements IUserExtension {
    public HelloWorld() {}

    public void executeUX(IUXBusinessObject aUXBO,IUXBusinessObject aOldUXBO, IUXContext aUXContext, String aParameter) {
        // do stuff
    }
    
    public String getDescription() {
        return "This User Extension sets the value of a free field on the business object.";
    }
}