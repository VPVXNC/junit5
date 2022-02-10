package com.ilyabogatskiy.junit;

import com.ilyabogatskiy.junit.service.UserServiceTest;
import org.junit.platform.engine.*;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.*;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

public class TestLauncher {

    public static void main(String[] args) {
        var launcher = LauncherFactory.create();
        //launcher.registerLauncherDiscoveryListeners();
        //launcher.registerTestExecutionListeners();
        var summaryGeneratingListener = new SummaryGeneratingListener();

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                //.selectors(DiscoverySelector.selectClass(UserServiceTest.class))
                .selectors(DiscoverySelectors.selectPackage("com.ilyabogatskiy.junit.service"))
                //        .listeners()
                                .build();
        launcher.execute(request, summaryGeneratingListener);

        try (var writer = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(writer);
        }
    }
}
