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
                        assertThat(context.getBean(Properties.class).getNested().getList())
                                .isNotNull()
                                .isEmpty());
    }

    @Test
    void mapShouldNotBeNull() {
        applicationContextRunner.run(
                context ->
                        assertThat(context.getBean(Properties.class).getNested().getMap())
                                .isNotNull()
                                .isEmpty());
    }


    @Test
    void mapShouldNotBeNullWithValues() {
        applicationContextRunner
                .withPropertyValues("test.nested.map.hello.map")
                .run(
                        context ->
                                assertThat(context.getBean(Properties.class).getNested().getMap())
                                        .isNotNull()
                                        .hasSize(1));
    }

    @Test
    void listShouldNotBeNullWithValues() {
        applicationContextRunner
                .withPropertyValues("test.nested.list[0]=list")
                .run(
                        context ->
                                assertThat(context.getBean(Properties.class).getNested().getList())
                                        .isNotNull()
                                        .hasSize(1));
    }
}
