package com.craft4plus.custom.items;

public enum CustomMaterial {
    EMERALD_SWORD(1),
    ;

    private CustomMaterial(final int id) {
        CustomItemsSpawn.CustomItems.get(id);
    }

}