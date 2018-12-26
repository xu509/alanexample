package com.xuningxin.ref;

import com.xuningxin.ref.ducks.Duck;
import com.xuningxin.ref.ducks.GreenheadDuck;
import com.xuningxin.ref.ducks.MachineDuck;
import com.xuningxin.ref.ducks.RedheadDuck;

/**
 * Created by xu509 on 2018/12/27.
 * 假设一个动物园，有很多种鸭子，能跳能叫
 *
 */
public class Zoo {

    Duck[] ducks = new Duck[3];

    public Zoo(){
        ducks[0] = new GreenheadDuck();
        ducks[1] = new MachineDuck();
        ducks[2] = new RedheadDuck();
    }

    public void openDuckArea(){
        for (Duck duck: ducks){
            duck.display();
            duck.fly();
            duck.quack();
        }
    }

}
