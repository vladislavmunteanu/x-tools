package com.x.tools.launcher.test

import org.junit.runner.Description
import org.junit.runner.notification.RunListener
import org.slf4j.LoggerFactory

class TestListener : RunListener() {

    private val logger = LoggerFactory.getLogger("ConfigurationTest")

    override fun testStarted(description: Description?) {

        logger.info(description?.methodName)

    }

}