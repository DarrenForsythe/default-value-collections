package com.darrenforythe.propertiesmapdefault;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class PropertiesTest {

    private ApplicationContextRunner applicationContextRunner;

    @BeforeEach
    void setup() {
        applicationContextRunner =
                new ApplicationContextRunner()
                        .withConfiguration(AutoConfigurations.of(PropertiesConfiguration.class));
    }

    @Test
    void listShouldNotBeNull() {
        applicationContextRunner.run(
                context ->
                        assertThat(context.getBean(Properties.class).getNested().getStringList())
                                .isNotNull()
                                .isEmpty());
    }

    @Test
    void mapShouldNotBeNull() {
        applicationContextRunner.run(
                context ->
                        assertThat(
                                        context.getBean(Properties.class)
                                                .getNested()
                                                .getShouldNotBeNull())
                                .isNotNull()
                                .isEmpty());
    }
}
