import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import org.springframework.boot.logging.logback.ColorConverter

import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.TRACE

def USER_HOME = System.getProperty("user.home")
def APP_NAME = "fgowki-api"
def LOG_FILE = "${USER_HOME}/logs/${APP_NAME}.log"
def FILE_NAME_PATTERN = "${APP_NAME}.%d{yyyy-MM-dd}.log"

scan("60 seconds")

context.name = "${APP_NAME}"
jmxConfigurator()

logger("org.springframework.web", INFO)
logger("com.springboot.in.action", TRACE)
logger("org.apache.velocity.runtime.log", INFO)

logger("com.github.fgowiki", INFO)

conversionRule("clr", ColorConverter)
appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern =  "%clr(%d{HH:mm:ss.SSS}){faint} %clr(%-5level) %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n"
        charset = Charset.forName("utf8")
    }
}

appender("dailyRollingFileAppender", RollingFileAppender) {
    file = "${LOG_FILE}"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${FILE_NAME_PATTERN}"
        maxHistory = 30
    }
    filter(ThresholdFilter) {
        level = TRACE
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg %n"
    }
}
//root(INFO, ["CONSOLE", "dailyRollingFileAppender"])
root(INFO, ["CONSOLE"])