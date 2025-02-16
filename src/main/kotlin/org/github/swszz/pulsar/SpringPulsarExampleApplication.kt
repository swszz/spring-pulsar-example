package org.github.swszz.pulsar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
internal class SpringPulsarExampleApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringPulsarExampleApplication>(*args)
        }
    }
}