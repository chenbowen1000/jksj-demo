package com.cbw.week5.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chenbowen
 * @date 2021/9/13 0:10
 */

public class GameProxy {

    private GameProxy(){

    }

    public static GameService getProxy(GameServicelmpl gameService){
        Object o = Proxy.newProxyInstance(gameService.getClass().getClassLoader(),
                gameService.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("前置");
                    method.invoke(gameService,args);
                    System.out.println("后置");
                    return null;
                }
        );
        return  (GameService)o;
    }
}
