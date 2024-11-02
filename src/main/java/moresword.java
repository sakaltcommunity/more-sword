import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items; // Itemsをインポートする必要があります

public class ModItems {
    public static final Item GLASS_SWORD = registerSword("glass_sword", 3, 20, Items.GLASS); // ガラス剣
    public static final Item COPPER_SWORD = registerSword("copper_sword", 5, 120, Items.COPPER_INGOT); // 銅剣
    public static final Item PLUPA_SWORD = registerSword("plupa_sword", 10, 2500, Items.PURPUR_BLOCK); // プルプァの剣
    public static final Item END_STONE_SWORD = registerSword("end_stone_sword", 8, 200, Items.END_STONE); // エンドストーンの剣
    public static final Item NETHERITE_GREAT_SWORD = registerGreatSword("netherite_great_sword", 16, 0.8f, 2031, Items.NETHERITE_INGOT); // ネザライト大剣
    public static final Item PLUPA_GREAT_SWORD = registerGreatSword("plupa_great_sword", 24, 0.76f, 3000, Items.PURPUR_BLOCK); // プルプァの大剣

    private static Item registerSword(String name, int attackDamage, int durability, Item repairMaterial) {
        ToolMaterial material = new ToolMaterial() {
            @Override
            public int getDurability() {
                return durability;
            }
            @Override
            public float getMiningSpeedMultiplier() {
                return 1.0f; // 攻撃速度
            }
            @Override
            public float getAttackDamage() {
                return attackDamage;
            }
            @Override
            public int getMiningLevel() {
                return 1; // 掘れるブロックのレベル
            }
            @Override
            public int getEnchantability() {
                return 10; // エンチャントの確率
            }
            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems(repairMaterial); // 引数として渡された修理素材
            }
        };

        return Registry.register(Registry.ITEM, new Identifier("more_sword_mod", name),
                new SwordItem(material, attackDamage, -2.4f, new Item.Settings().group(ItemGroup.COMBAT)));
    }

    private static Item registerGreatSword(String name, int attackDamage, float attackSpeed, int durability, Item repairMaterial) {
        ToolMaterial material = new ToolMaterial() {
            @Override
            public int getDurability() {
                return durability;
            }
            @Override
            public float getMiningSpeedMultiplier() {
                return 1.0f; // 攻撃速度
            }
            @Override
            public float getAttackDamage() {
                return attackDamage;
            }
            @Override
            public int getMiningLevel() {
                return 1; // 掘れるブロックのレベル
            }
            @Override
            public int getEnchantability() {
                return 10; // エンチャントの確率
            }
            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems(repairMaterial); // 引数として渡された修理素材
            }
        };

        return Registry.register(Registry.ITEM, new Identifier("more_sword_mod", name),
                new SwordItem(material, attackDamage, attackSpeed, new Item.Settings().group(ItemGroup.COMBAT)));
    }
}
