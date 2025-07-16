package uk.org.thehickses.functional;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CurryTest
{
    static record Person(String firstName, String secondName)
    {
        String name()
        {
            return "%s %s".formatted(firstName, secondName);
        }
    }

    @Test
    void testCurryUnaryFunction()
    {
        assertThat(Curry.of(Person::name, new Person("Joel", "Matthew"))
                .get()).isEqualTo("Joel Matthew");
    }

    @Test
    void testCurryBinaryFunctionFirst()
    {
        assertThat(Curry.ofFirst(Person::new, "Joel")
                .apply("Matthew")
                .name()).isEqualTo("Joel Matthew");
    }

    @Test
    void testCurryBinaryFunctionSecond()
    {
        assertThat(Curry.ofSecond(Person::new, "Matthew")
                .apply("Joel")
                .name()).isEqualTo("Joel Matthew");
    }

    @Test
    void testCurryBinaryFunctionBoth()
    {
        assertThat(Curry.ofBoth(Person::new, "Joel", "Matthew")
                .get()
                .name()).isEqualTo("Joel Matthew");
    }
}
