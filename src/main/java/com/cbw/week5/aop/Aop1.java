package com.cbw.week5.aop;

/**
 * @author chenbowen
 * @date 2021/9/12 23:39
 */
public class Aop1 {

    public static void main(String[] args) {
        GameServicelmpl gameService = new GameServicelmpl();

        GameService proxy = GameProxy.getProxy(gameService);
        proxy.dota();
        proxy.lol();

    }
}
