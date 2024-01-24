package com.lcbmasters.simpleui.Mod;

public class Mod {

    private final String name;
    private boolean enable;

    private int key;

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public Mod(String name, boolean enable) {
        this.name = name;
        this.enable = enable;
    }



    public String getName() {
        return name;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;

        if (enable) {
            enable();
        } else {
            disable();
        }

    }

    public void draw() {

    }

    public void update() {

    }

    public void render(float partialTicks) {

    }

    public void enable() {

    }

    public void disable() {

    }
}
