import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ModItems {
    public static final Item GLASS_SWORD = registerSword("glass_sword", 3, 20); // ガラス剣
    public static final Item COPPER_SWORD = registerSword("copper_sword", 7, 176); // 銅剣
    public static final Item PLUPA_SWORD = registerSword("plupa_sword", 10, 2500); // プルプァの剣
    public static final Item END_STONE_SWORD = registerSword("end_stone_sword", 8, 200); // エンドストーンの剣
    public static final Item NETHERITE_GREAT_SWORD = registerGreatSword("netherite_great_sword", 16, 0.8f, 2031); // ネザライト大剣
    public static final Item PLUPA_GREAT_SWORD = registerGreatSword("plupa_great_sword", 24, 0.76f, 3000); // プルプァの大剣

    private static Item registerSword(String name, int attackDamage, int durability) {
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
                return Ingredient.ofItems(Items.GLASS); // 修理素材
            }
        };

        return Registry.register(Registry.ITEM, new Identifier("more_sword_mod", name),
                new SwordItem(material, attackDamage, -2.4f, new Item.Settings().group(ItemGroup.COMBAT)));
    }

    private static Item registerGreatSword(String name, int attackDamage, float attackSpeed, int durability) {
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
                return Ingredient.ofItems(Items.NETHERITE_INGOT); // ネザライト大剣の修理素材
            }
        };

        return Registry.register(Registry.ITEM, new Identifier("more_sword_mod", name),
                new SwordItem(material, attackDamage, attackSpeed, new Item.Settings().group(ItemGroup.COMBAT)));
    }
}
