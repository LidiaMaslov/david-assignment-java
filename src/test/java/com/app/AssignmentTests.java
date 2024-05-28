package com.app;

import org.junit.Assert;
import org.junit.Test;

import com.app.navigation.Navigate;

public class AssignmentTests {

    @Test
    public void main() {
        Navigate nav = new Navigate();

        nav.goTo("/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true");
        nav.homePage((homePage) -> {
            homePage.desktopIcon("Settings").click();
        });

        nav.settingsPage((settingsPage) -> {
            settingsPage.clickMainMenu("Mail, Contacts, Calendars");
            settingsPage.clickSubMenu("Maggie Brown | Mail, Calendars, Notes");

            settingsPage.clickSubMenu("Account | mbrown@gmail.com");
            settingsPage.clickSubMenu("Advanced");
            /*
             * After refactoring may look like:
             * 
             * settingsPage.advancedPopup((advancedPopUp) -> {
             *     advancedPopUp.findToggle("Use SSL").toggleOn();
             *     String sslPort = advancedPoptUp.subMenu.findByName("Use SSL").text();
             *     Assert.assertTrue(sslPort, "993".equals(sslPort));
             * })
             */
            settingsPage.findToggle("Use SSL").toggleOn();
            String sslPort = settingsPage.getServerPort();
            Assert.assertTrue(sslPort, "993".equals(sslPort));

            settingsPage.clickTopButton("Account");
            settingsPage.clickTopButton("Done");

            settingsPage.clickMainMenu("Wi-Fi | Not Connected");
            settingsPage.clickSubMenu("CorpNet");

            settingsPage.enterPassword("@CorpNetWeRSecure!&");
            settingsPage.clickTopButton("Join");
        });

        nav.labPage((labPage) -> {
            labPage.clickDone();
            String score = labPage.getScoreReport();
            Assert.assertTrue("Wrong score: " + score, "Your Score: 1 of 1 (100%)".equals(score));
        });
    }
}