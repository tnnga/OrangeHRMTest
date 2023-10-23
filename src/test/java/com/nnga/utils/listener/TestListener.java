package com.nnga.utils.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestListener implements ITestListener {
    @Override
    public void onFinish(ITestContext result) {

    }

    @Override
    public void onStart(ITestContext result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(": " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(": " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println();
        System.out.println(": " + result.getName());
    }

}
