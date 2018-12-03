package com.x.tools.launcher.test

import com.x.tools.launcher.Launcher
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

class ConfigurationTest{

    private val launcher = Launcher()


    @Test
    fun testLogManager(){

        val loggerManager = launcher.loggerManager

        assertEquals("INFO",loggerManager.level)
        assertEquals("testFolder",loggerManager.folder)
        assertEquals("%d{yyyy-MM-dd HH:mm:ss} %-5p - %m%n",loggerManager.layout)

    }

}