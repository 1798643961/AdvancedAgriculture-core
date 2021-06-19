package tech.icedlab.advagri.item.armors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tech.icedlab.advagri.ModAta;
import tech.icedlab.advagri.groups.AdvAgriItemToolsAndArmorsGroup;


public class AdvAgriArmors {
    public static AdvAgriArmors thisAdvAgriArmors = new AdvAgriArmors();

    public static String modata = ModAta.ModID;
    public ArmorMaterial BAMBOO = new LeatherBambooMixedArmor();
    public ArmorMaterial LEATHER_BAMBOO_MIXED = new LeatherBambooMixedArmor();

    ///GENERATE

    //Bamboo armor
    public Item BAMBOO_HELMET;
    public Item BAMBOO_CHESTPLATE;
    public Item BAMBOO_LEGGINGS;
    public Item BAMBOO_BOOTS;

    //Leather-bamboo armor
    public Item LEATHER_BAMBOO_MIXED_HELMET;
    public Item LEATHER_BAMBOO_MIXED_CHESTPLATE;
    public Item LEATHER_BAMBOO_MIXED_LEGGINGS;
    public Item LEATHER_BAMBOO_MIXED_BOOTS;

    //Iron-bamboo armor
    public ArmorMaterial IRON_BAMBOO_MIXED = new IronBambooMixedArmor();
    public Item IRON_BAMBOO_MIXED_HELMET;
    public Item IRON_BAMBOO_MIXED_CHESTPLATE;
    public Item IRON_BAMBOO_MIXED_LEGGINGS;
    public Item IRON_BAMBOO_MIXED_BOOTS;

    ///GENERATE

    public static AdvAgriArmors getInstance() {
        return thisAdvAgriArmors;
    }

    private AdvAgriArmors() {

    }

    public void InitAllArmors() {
        BAMBOO_HELMET = FastAddTool(1, BAMBOO);
        BAMBOO_CHESTPLATE = FastAddTool(2, BAMBOO);
        BAMBOO_LEGGINGS = FastAddTool(3, BAMBOO);
        BAMBOO_BOOTS = FastAddTool(4, BAMBOO);

        LEATHER_BAMBOO_MIXED_HELMET = FastAddTool(1, LEATHER_BAMBOO_MIXED);
        LEATHER_BAMBOO_MIXED_CHESTPLATE = FastAddTool(2, LEATHER_BAMBOO_MIXED);
        LEATHER_BAMBOO_MIXED_LEGGINGS = FastAddTool(3, LEATHER_BAMBOO_MIXED);
        LEATHER_BAMBOO_MIXED_BOOTS = FastAddTool(4, LEATHER_BAMBOO_MIXED);

        IRON_BAMBOO_MIXED_HELMET = FastAddTool(1, IRON_BAMBOO_MIXED);
        IRON_BAMBOO_MIXED_CHESTPLATE = FastAddTool(2, IRON_BAMBOO_MIXED);
        IRON_BAMBOO_MIXED_LEGGINGS = FastAddTool(3, IRON_BAMBOO_MIXED);
        IRON_BAMBOO_MIXED_BOOTS = FastAddTool(4, IRON_BAMBOO_MIXED);
    }

    public void RegisteredArmors() {
        //Bamboo
        Registry.register(Registry.ITEM, new Identifier(modata, "bamboo_helmet"), BAMBOO_HELMET);
        Registry.register(Registry.ITEM, new Identifier(modata, "bamboo_chestplate"), BAMBOO_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(modata, "bamboo_leggings"), BAMBOO_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(modata, "bamboo_boots"), BAMBOO_BOOTS);

        //Leather-bamboo mixed armor
        Registry.register(Registry.ITEM, new Identifier(modata, "leather_bamboo_mixed_helmet"), LEATHER_BAMBOO_MIXED_HELMET);
        Registry.register(Registry.ITEM, new Identifier(modata, "leather_bamboo_mixed_chestplate"), LEATHER_BAMBOO_MIXED_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(modata, "leather_bamboo_mixed_leggings"), LEATHER_BAMBOO_MIXED_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(modata, "leather_bamboo_mixed_boots"), LEATHER_BAMBOO_MIXED_BOOTS);

        //Iron-Bamboo mixed armor
        Registry.register(Registry.ITEM, new Identifier(modata, "iron_bamboo_mixed_helmet"), IRON_BAMBOO_MIXED_HELMET);
        Registry.register(Registry.ITEM, new Identifier(modata, "iron_bamboo_mixed_chestplate"), IRON_BAMBOO_MIXED_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(modata, "iron_bamboo_mixed_leggings"), IRON_BAMBOO_MIXED_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(modata, "iron_bamboo_mixed_boots"), IRON_BAMBOO_MIXED_BOOTS);
    }


    public ArmorItem FastAddTool(Integer Where, ArmorMaterial ArmorMaterial) {
        switch (Where) {
            case 2:
                return new ArmorItem(ArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(AdvAgriItemToolsAndArmorsGroup.ITEM_GROUP));

            case 3:
                return new ArmorItem(ArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(AdvAgriItemToolsAndArmorsGroup.ITEM_GROUP));

            case 4:
                return new ArmorItem(ArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(AdvAgriItemToolsAndArmorsGroup.ITEM_GROUP));
            case 1:
            default:
                return new ArmorItem(ArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(AdvAgriItemToolsAndArmorsGroup.ITEM_GROUP));
        }
    }
}
