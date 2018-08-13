package pro.npofsi.rmpescript.runtime.utils;

import org.mozilla.javascript.GeneratedClassLoader;

import java.io.File;

public class JavaClassLoader extends ClassLoader implements GeneratedClassLoader {
    public JavaClassLoader(ClassLoader parent, File cacheDirectory) {
    }

    @Override
    public Class<?> defineClass(String s, byte[] bytes) {
        return null;
    }

    @Override
    public void linkClass(Class<?> aClass) {

    }
}
