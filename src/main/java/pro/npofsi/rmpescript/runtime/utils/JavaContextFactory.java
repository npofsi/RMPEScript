package pro.npofsi.rmpescript.runtime.utils;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.GeneratedClassLoader;

import java.io.File;

public class JavaContextFactory extends ContextFactory {
    private final File cacheDirectory;

    /**
     * Create a new_data factory. It will cache generated code in the given directory
     *
     * @param cacheDirectory the cache directory
     */
    public JavaContextFactory(File cacheDirectory) {
        this.cacheDirectory = cacheDirectory;
        initApplicationClassLoader(createClassLoader(JavaContextFactory.class.getClassLoader()));
    }

    /**
     * Create a ClassLoader which is able to deal with bytecode
     *
     * @param parent the parent of the create classloader
     * @return a new_data ClassLoader
     */
    @Override
    protected JavaClassLoader createClassLoader(ClassLoader parent) {
        return new JavaClassLoader(parent, cacheDirectory);
    }

    @Override
    protected void observeInstructionCount(Context cx, int instructionCount) {
        if (Thread.currentThread().isInterrupted()) {
            throw new IllegalThreadStateException();
        }
    }

    @Override
    protected Context makeContext() {
        Context cx = super.makeContext();
        cx.setInstructionObserverThreshold(10000);
        return cx;
    }
}
