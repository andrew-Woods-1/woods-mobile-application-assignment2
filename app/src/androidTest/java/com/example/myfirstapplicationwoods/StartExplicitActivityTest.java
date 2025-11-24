package com.example.myfirstapplicationwoods;


import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

    @LargeTest
    @RunWith(AndroidJUnit4.class)
    public class StartExplicitActivityTest {

        private static final int TIMEOUT = 5000;

        private UiDevice device;
        private String appPackageName;

        private static final String APP_LAUNCHER_LABEL = "My First Application Woods";

        private static final String START_BUTTON_TEXT = "Start Activity Explicitly";

        private static final String CHALLENGE_TEXT = "Device fragmentation";

        @Before
        public void setUp() {
            device = UiDevice.getInstance(
                    InstrumentationRegistry.getInstrumentation()
            );

            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            appPackageName = context.getPackageName();

            // Go to home screen
            device.pressHome();

            // Wait for the launcher
            String launcherPackage = device.getLauncherPackageName();
            assertNotNull("Launcher package is null", launcherPackage);
            device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), TIMEOUT);
        }

        @Test
        public void startExplicitActivity_showsChallengeText() {
            // 1) Start app from home screen by tapping launcher icon
            UiObject2 appIcon = device.wait(
                    Until.findObject(By.desc(APP_LAUNCHER_LABEL)),
                    TIMEOUT
            );

            if (appIcon == null) {
                // Some launchers use text instead of content desc
                appIcon = device.wait(
                        Until.findObject(By.text(APP_LAUNCHER_LABEL)),
                        TIMEOUT
                );
            }

            assertNotNull("App launcher icon not found – check APP_LAUNCHER_LABEL", appIcon);
            appIcon.click();

            // Wait for app to foreground
            device.wait(Until.hasObject(By.pkg(appPackageName).depth(0)), TIMEOUT);

            // 2) Click the “start activity explicitly” button
            UiObject2 startButton = device.wait(
                    Until.findObject(By.res(appPackageName, "btnExplicit")),
                    TIMEOUT
            );

            // If your test fails here, double-check START_BUTTON_TEXT matches exactly
            assertNotNull("Could not find start activity button", startButton);
            startButton.click();

            // 3) Verify the second activity shows one of the challenges
            UiObject2 challengeView = device.wait(
                    Until.findObject(By.textContains(CHALLENGE_TEXT)),
                    TIMEOUT
            );

            assertNotNull(
                    "Expected challenge text not found in second activity: " + CHALLENGE_TEXT,
                    challengeView
            );
        }
    }



