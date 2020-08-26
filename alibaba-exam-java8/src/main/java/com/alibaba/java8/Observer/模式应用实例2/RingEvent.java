package com.alibaba.java8.Observer.模式应用实例2;

import java.util.EventObject;

public class RingEvent extends EventObject {
    private boolean sound;    //true表示上课铃声,false表示下课铃声

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public RingEvent(Object source, Boolean sound) {
        super(source);
        this.sound = sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean getSound() {
        return this.sound;
    }
}
