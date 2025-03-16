package org.example;

import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;

@Slf4j
public class App {

    public static void main(String[] args) {
        Object notAnnotated = notAnnotated();
        Object nullableAnnotated = nullableAnnotated();
        // null check doesn't give compile error
        if (nullableAnnotated == null) {
            log.info("nullableAnnotated == null");
        } else {
            log.info("nullableAnnotated != null");
        }
        // gives compile error as @Nullable method result is dereferenced without null check
        log.info(nullableAnnotated.toString());
    }

    static Object notAnnotated() {
        // gives compile error as method has @NonNull return type by default
        return Math.random() < 0.5 ? null : new Object();
    }

    @Nullable
    static Object nullableAnnotated() {
        return Math.random() < 0.5 ? null : new Object();
    }
}
