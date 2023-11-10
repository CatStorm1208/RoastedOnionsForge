package de.catstorm.roastedonions;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused", "deprecation"})
@Mod("roastedonions")
public class roastedonions
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "roastedonions");

    public static final RegistryObject<Item> roastedonion = ITEMS.register("roastedonion",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(3.62f/20).build())));

    public static final RegistryObject<Item> blue_spandauer = ITEMS.register("blue_spandauer",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> red_spandauer = ITEMS.register("red_spandauer",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> golden_berries = ITEMS.register("golden_berries",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(11).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> raw_sausage = ITEMS.register("raw_sausage",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(3.62f/20).build())));

    public static final RegistryObject<Item> cooked_sausage = ITEMS.register("cooked_sausage",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(7.35f/20).build())));

    public static final RegistryObject<Item> hotdog = ITEMS.register("hotdog",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(9f/20).build())));

    public static final RegistryObject<Item> hotdog_with_ketchup = ITEMS.register("hotdog_with_ketchup",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(8).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> pig_fat = ITEMS.register("pig_fat",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                .food(new FoodProperties.Builder().nutrition(3).saturationMod(3.000001f/20).effect(new MobEffectInstance(MobEffects.CONFUSION, 1000, 4), 0.95f).build())));

    public static final RegistryObject<Item> pork_rind = ITEMS.register("pork_rind",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(4.694201f/20).effect(new MobEffectInstance(MobEffects.CONFUSION, 1000, 4), 0.69f).build())));

    public static final RegistryObject<Item> uncooked_klejner = ITEMS.register("uncooked_klejner",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> klejner = ITEMS.register("klejner",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(4.111111f/20).build())));

    public static final RegistryObject<Item> salmon_fillet = ITEMS.register("salmon_fillet",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(1).saturationMod(1f/20).build())));

    public static final RegistryObject<Item> smoked_salmon = ITEMS.register("smoked_salmon",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(4f/20).build())));

    public static final RegistryObject<Item> smorrebrod = ITEMS.register("smorrebrod",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(9).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> roe = ITEMS.register("roe",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4f/20).build())));

    public static final RegistryObject<Item> bread_with_roe = ITEMS.register("bread_with_roe",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(7f/20).build())));

    public roastedonions()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}