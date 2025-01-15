package com.lcbmasters.simpleui.Mod;

import com.lcbmasters.simpleui.Mod.draw.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModManager {
    private final List<Mod> mods = new ArrayList<>();

    public List<Mod> getMods() {
        return mods;
    }

    public List<Mod> getEnableMods() {
        return mods.stream().filter(Mod::isEnable).collect(Collectors.toList());
    }

    public void onKey(int key) {
        for (Mod enableMod : mods) {
            if (enableMod.getKey() == key) {
                enableMod.setEnable(!enableMod.isEnable());
            }
        }
    }

    public void load() {
        //Render
        mods.add(new ArmourMod());
        mods.add(new BiomeMod());
        mods.add(new BlockMod());
        mods.add(new ComboDisplayMod());
        mods.add(new CpsMod());
        mods.add(new DirectionMod());
        mods.add(new EffectMod());
        mods.add(new InventoryMod());
        mods.add(new FpsMod());
        mods.add(new MemoryMod());
        mods.add(new ReachDisplayMod());
        mods.add(new PingMod());
        mods.add(new PosMod());
        mods.add(new SelfAppearanceMod());
        mods.add(new SpeedMod());
        mods.add(new TimeMod());

    }

    public Mod getByName(String name) {
        for (Mod mod : mods) {
            if (name.equalsIgnoreCase(mod.getName())) {
                return mod;
            }
        }
        return null;
    }

    public Mod getByClass(Class<? extends Mod> modClass) {
        for (Mod mod : mods) {
            if (mod.getClass() == modClass) {
                return mod;
            }
        }
        return null;
    }
}
