package com.cbw.week5.aop;

/**
 * @author chenbowen
 * @date 2021/9/13 0:12
 */
public class GameServicelmpl implements GameService{
    @Override
    public void lol() {
        System.out.println("打lol------");
    }

    @Override
    public void dota() {
        System.out.println("打dota--------");
    }
}
