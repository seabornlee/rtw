package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ConstructorNotFound;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static java.util.Collections.emptyList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConstructorResolverTest {
    @Test
    public void should_resolve_default_constructor() throws NoSuchMethodException {
        ConstructorResolver resolver = new ConstructorResolver(String.class);
        Constructor constructor = resolver.resolve(emptyList());
        assertThat(constructor, is(String.class.getConstructor()));
    }

    @Test(expected = ConstructorNotFound.class)
    public void should_raise_exception_if_proper_constructor_not_found() {
        ConstructorResolver resolver = new ConstructorResolver(Integer.class);
        resolver.resolve(emptyList());
    }
}