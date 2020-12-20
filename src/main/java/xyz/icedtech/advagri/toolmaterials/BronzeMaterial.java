package xyz.icedtech.advagri.toolmaterials;

import xyz.icedtech.advagri.item.AdvAgriItems;

public class BronzeMaterial extends AdvAgriToolMaterials {

    public static final BronzeMaterial INSTANCE = new BronzeMaterial();

    public BronzeMaterial() {
        super.setDurability(350);
        super.setMiningSpeedMultiplier(6F);
        super.setAttackDamage(2F);
        super.setMineLevel(2);
        super.setEnchantability(8);
        super.setIngredient(AdvAgriItems.getInstance().BRONZE_INGOT);
    }
}
