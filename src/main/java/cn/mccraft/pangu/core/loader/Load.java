package cn.mccraft.pangu.core.loader;


import net.minecraftforge.fml.common.LoaderState;
import net.minecraftforge.fml.relauncher.Side;

import java.lang.annotation.*;

/**
 * A loader which can make auto invoke the annotated function
 * (must be visible to core) with this class. Your method's parent
 * class will be auto added into {@link Proxy#addLoader(Object)}.
 *
 * 使用了该注解的方法的类，将会在 PreInit 前自动执行 {@link Proxy#addLoader(Object)}。
 * 你的方法必须是是静态的或父类的实例已被存入 InstanceHolder 的类（即使用了 @AutoWired 的类）
 *
 * @author LasmGratel
 * @since 1.0.0.2
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Load {
    /**
     * Select which state we should invoke this method.
     * 执行该函数的 Forge 加载状态。
     */
    LoaderState value() default LoaderState.PREINITIALIZATION;

    /**
     * Select which side we should invoke this method.
     * If side is Side.CLIENT the method will be removed in server
     *
     * 执行该函数所需的平台，服务器或是客户端。
     * 如果设置为 CLIENT ，将会在服务端中被移除
     */
    Side side() default Side.SERVER;
}