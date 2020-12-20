package xyz.icedtech.advagri.toolmaterials;

import xyz.icedtech.advagri.item.AdvAgriItems;

public class NickelMaterial extends AdvAgriToolMaterials {
    public static final NickelMaterial INSTANCE = new NickelMaterial();

    public NickelMaterial() {
        super.setDurability(0);
        super.setMiningSpeedMultiplier(0F);
        super.setAttackDamage(0F);
        super.setMineLevel(0);
        super.setEnchantability(0);
        super.setIngredient(AdvAgriItems.getInstance().NICKEL_INGOT);
    }
}
